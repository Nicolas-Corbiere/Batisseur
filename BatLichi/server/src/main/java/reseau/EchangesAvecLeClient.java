package reseau;

import carte.cartesPresente.LesCartesPresentes;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.corundumstudio.socketio.listener.ExceptionListenerAdapter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import identification.Identification;
import inventaire.InventaireJoueur;
import io.netty.channel.ChannelHandlerContext;
import logger.ColorConsole;
import logger.LoggerTrace;
import message.Message;
import operation.Operation;
import modeDeJeu.ModeDeJeu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EchangesAvecLeClient implements EnvoiDesMessages{
    SocketIOServer serveur;
    ReceptionDesMessages controleur;
    private HashMap<Identification, SocketIOClient> map;
    private LoggerTrace logger = new LoggerTrace(true, ColorConsole.BLACK);

    private SocketIOClient echange;

    Object synchro = new Object();
    boolean enFonctionnement = true;

    ObjectMapper jackson = new ObjectMapper();

    ModeDeJeu modeDeJeu;

    public EchangesAvecLeClient(String ip, int port, ReceptionDesMessages ctrl) {
        controleur = ctrl;

        map = new HashMap<Identification, SocketIOClient>();
        Configuration config = new Configuration();
        config.setHostname(ip);
        config.setPort(port);

        // pour éviter un message d'erreur inutile... on attrape l'info sur DisconnectListener
        config.setExceptionListener(new ExceptionListenerAdapter() {
            @Override
            public void onDisconnectException(Exception e, SocketIOClient client) {
                // pour éviter un message d'erreur inutile... on attrape l'info sur DisconnectListener
            }
            @Override
            public boolean exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
                return true;
            }
        });


        setServeur(new SocketIOServer(config));

        getServeur().addConnectListener(new ConnectListener() {
            public void onConnect(SocketIOClient socketIOClient) {
                controleur.transfereMsg("connexion de "+socketIOClient.getRemoteAddress());
            }
        });

        getServeur().addDisconnectListener(new DisconnectListener() {
            public void onDisconnect(SocketIOClient socketIOClient) {
                synchronized (synchro) {
                    if (enFonctionnement&& (getServeur().getAllClients().size() == 0)) {
                        controleur.transfereMsg("tous sont déconnectés");
                       arrêter();
                    }
                }
            }
        });


        // réception d'une identification
        serveur.addEventListener(Message.IDENTIFICATION, Identification.class, new DataListener<Identification>() {
            public void onData(SocketIOClient socketIOClient, Identification identification, AckRequest ackRequest) throws Exception {
                synchronized (synchro) {
                    // un seul message ici à la fois
                    if (controleur.nouveauJoueur(identification)) {
                        map.put(identification, socketIOClient);
                    }
                    else {
                        // todo...
                    }
                }
            }
        });


        serveur.addEventListener(Message.JOUER_CETTE_ACTION, String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient socketIOClient, String operation, AckRequest ackRequest) {
                synchronized (synchro){
                    Operation a = null;
                    try {
                        a = jackson.readValue(operation, Operation.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    logger.afficheMessage(operation);
                    controleur.transfereAction(a);
            }
        }
    });


    }


    public void envoyerMessage(Identification leClient, String message, Object... attachement) {
        map.get(leClient).sendEvent(message, attachement);
    }

    public void arrêter() {
        enFonctionnement=false;
        controleur.transfereMsg("fin du serveur - début");
        for(SocketIOClient c : map.values()) c.disconnect();


        controleur.transfereMsg("fin du serveur - désabonnement");
        getServeur().removeAllListeners("identification");


        controleur.transfereMsg("fin du serveur - stop");
        new Thread(new Runnable() {
            public void run() {
                getServeur().stop(); // à faire sur un autre thread que sur le thread de SocketIO
                controleur.transfereMsg("fin du serveur - fin");

            }
        }).start();

    }




    public void permettreConnexion() {
        getServeur().start();
    }

    @Override
    public void envoyerSignalFin(Identification gagnant) {
        // tout le monde a gagné.
        //getServeur().getBroadcastOperations().sendEvent(Message.FIN, true);
        for(Map.Entry<Identification, SocketIOClient> j:map.entrySet()){
            j.getValue().sendEvent(Message.FIN, j.getKey().equals(gagnant));
        }
    }

    @Override
    public void envoyerSignalFinPartie(Identification gagnant) {
        // tout le monde a gagné.
        //getServeur().getBroadcastOperations().sendEvent(Message.FIN, true);
        for(Map.Entry<Identification, SocketIOClient> j:map.entrySet()){
            j.getValue().sendEvent(Message.FIN_Partie, j.getKey().equals(gagnant));
        }
    }

    @Override
    public void demandeAuJoueurDeJouer(LesCartesPresentes lesCartesPresentes, Identification j, InventaireJoueur inventaireDuJoueur) {
        if(map.containsKey(j)){
            controleur.transfereMsg("envoie de la demande de jouer a"+j);
            try {
                map.get(j).sendEvent(Message.DEMANDE_DE_JOUER, inventaireDuJoueur,jackson.writeValueAsString(lesCartesPresentes));//,new CarteBatiment(12,"l'écurie",new int[]{0,3,1,3},14,3)
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }



    /******** pour les propriétés ************/
    public void setServeur(SocketIOServer serveur) {
        this.serveur = serveur;
    }

    public SocketIOServer getServeur() {
        return serveur;
    }
}
