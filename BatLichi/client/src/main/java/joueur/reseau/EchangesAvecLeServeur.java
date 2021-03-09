package joueur.reseau;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import carte.cartesPresente.LesCartesPresentesMoyenAge;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inventaire.InventaireJoueur;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import joueur.Client;
import joueur.vue.VueClient;
import logger.ColorConsole;
import logger.LoggerTrace;
import operation.Operation;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInput;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import message.Message;
import vue.Vue;

public class EchangesAvecLeServeur {

    private Client controleur;
    Socket connexion;
    ObjectMapper jackson;
    LoggerTrace logger = new LoggerTrace(true, ColorConsole.BLACK);
    /**
     *
     * @param url : adresse du serveur
     * @param ctrl
     */
    public EchangesAvecLeServeur(String url, Client ctrl) {
        setControleur(ctrl);

        jackson = new ObjectMapper();

        try {
            connexion = IO.socket(url);

            this.controleur.transfereMessage("on s'abonne à la connection / déconnection ");

            connexion.on("connect", new Emitter.Listener() {
                public void call(Object... objects) {
                    // déplacement du message dans Client/Controleur
                    // on s'identifie
                    controleur.apresConnexion();

                }
            });


            connexion.on("disconnect", new Emitter.Listener() {
                public void call(Object... objects) {
                    controleur.transfereMessage(" !! on est déconnecté !! ");
                    controleur.finPartie();

                }
            });


            this.controleur.transfereMessage("on s'abonne à fin du jeu ");
            connexion.on(Message.FIN, new Emitter.Listener() {
                @Override
                public void call(Object... objects) {
                    controleur.resultat((boolean)objects[0]);
                }
            });


            this.controleur.transfereMessage("on s'abonne à fin du jeu ");
            connexion.on(Message.FIN_Partie, new Emitter.Listener() {
                @Override
                public void call(Object... objects) {
                    controleur.resultatPartie((boolean)objects[0]);
                }
            });

            this.controleur.transfereMessage("on s'abonne aux demandes de jouer ");
            connexion.on(Message.DEMANDE_DE_JOUER, new Emitter.Listener() {
                @Override
                public void call(Object... objects) {

                    try{
                        InventaireJoueur inv = jackson.readValue( objects[0].toString(), InventaireJoueur.class);
                        jackson = new ObjectMapper();

                        LesCartesPresentes lesCartesPresentes = jackson.readValue(objects[1].toString(), LesCartesPresentes.class);

                        controleur.jouer(inv,lesCartesPresentes);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }

                }
            });
        } catch (URISyntaxException e) {
            controleur.signaleErreur(Arrays.toString(e.getStackTrace()));
        }
    }

    public void setControleur(Client controleur) {
        this.controleur = controleur;
    }

    public Client getControleur() {
        return controleur;
    }

    public void stop() {
        connexion.off("connect");
        connexion.off("disconnect");
        connexion.off(Message.FIN);

        // pour ne pas être sur le thread de SocketIO
        new Thread(new Runnable() {
            public void run() {
                connexion.disconnect();
                connexion.close();
                logger.afficheMessage("@todo >>>> c'est fini");
                // hack pour arrêter plus vite (sinon attente de plusieurs secondes)
               // System.exit(0);
            }
        }).start() ;
    }

    public void envoyerId(Object pj) {
        JSONObject pieceJointe = new JSONObject(pj);
        connexion.emit(Message.IDENTIFICATION, pieceJointe);
    }

    public void seConnecter() {
        connexion.connect();
    }

    public void envoyerActionChoisie(Object pj){
        try{
            String json = jackson.writeValueAsString(pj);
            logger.afficheMessage(json);
            Operation a = jackson.readValue(json,Operation.class);
            logger.afficheMessage(a.toString());

            connexion.emit(Message.JOUER_CETTE_ACTION,json);
        }
        catch (JsonProcessingException e){
            controleur.transfereMessage("erreur avec jackson...");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}