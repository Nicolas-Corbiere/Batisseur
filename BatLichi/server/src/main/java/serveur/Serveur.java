package serveur;

import application.Application;
import argument.Arguments;
import carte.CarteEmprunt;
import carte.CarteEsclave;
import carte.CarteOuvrier;
import carte.GestionCarte.GestionCollectionCarte;
import identification.Identification;
import logger.ColorConsole;
import logger.LoggerTrace;
import operation.Operation;
import modeDeJeu.ModeDeJeu;
import operation.investissement.OpAffranchirEsclave;
import operation.investissement.OpRembourserEmprunt;
import partie.MoteurTMP;
import reseau.*;
import vueServeur.VueServeur;
import java.awt.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class Serveur extends Application implements ReceptionDesMessages {
    private MoteurTMP moteur;
    private EnvoiDesMessages connexion;
    private static ModeDeJeu modeDeJeu;
    private static boolean affichageStat;
    private static boolean estSilencieux;
    private static int  nbPartie;

    /**
     * pour attendre la réponse ou la connexion de tou.te.s les joueur.se.s.
     */
    private Object synchroAttenteDebut = new Object();

    /**
     * pour stocker l'operation choisie : une seule variable, cela ne marche que pour des demandes séquentielles (on ne fait pas une autre demande tant qu'on n'a pas reçue la réponse
     */

    Operation operationChoisie;

    public static void main(String [] args) {


        Arguments arguments = new Arguments(args);

        arguments.analyseArgument();


        estSilencieux = arguments.isBoolTrace();
        affichageStat = arguments.isBoolStat();
        modeDeJeu = arguments.getModeDeJeu();
        nbPartie = arguments.getNbPartie();




        try{
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        Serveur serveur = new Serveur("127.0.0.1",10101);
        serveur.démarrer();
        serveur.lancerPartie();
    }

    public void lancerPartie(){

        getVue().afficheMessage("on attend que tout le monde soit la");

        synchronized (synchroAttenteDebut){
            try{
                synchroAttenteDebut.wait();
            }
            catch (InterruptedException e){
                getVue().afficheMessageErreur("on a été interrompu, on n'a pas pu attendre que tout le monde soit la");
            }
        }
        for (int i=0;i<nbPartie;i++) {

            getVue().afficheMessage("Partie numereau : " + i);

            int cpt=0;
            getVue().afficheMessage("on peut commencer la partie");

            Identification[] joueurs = getMoteur().getJoeurs();

            while (!moteur.getPartie().getFinie()) {

                if (moteur.estFinie()) {
                    //afficheScore();
                    moteur.getPartie().setFinie(true);

                    getVue().afficheMessage("\nFin de la partie");

                    moteur.getPartie().afficheStatistiques(moteur.getStat());
                    for (Identification joueur: moteur.getStatPartie().keySet()) {
                        moteur.getStatPartie().get(joueur).addition(moteur.getStat().get(joueur));
                    }
                    break;
                }
                faireUnTour(joueurs);
                cpt++;
                getVue().afficheMessage("Nombre de tour "+cpt);

            }
            finPartie();
            moteur.resetCarteInventaire();
            moteur.resetStat();
        }
        moteur.afficheStatistiquesPartie(moteur.getStatPartie());
        fin();
    }
    /**
     * pour faire un tour de jeu. Il y a une boucle for pour appeler chaque joueur
     *
     * @param joueurs
     */
    protected void faireUnTour(Identification[] joueurs){
        for (Identification j : joueurs){

            while(moteur.getInventaireDuJoueur(j).getNbAction()>0) {
                getConnexion().demandeAuJoueurDeJouer(moteur.getCartePresente(), j, getMoteur().getInventaireDuJoueur(j));
                getVue().afficheMessage("on attend que " + j + " donne son choix");
                synchronized (synchroAttenteDebut) {
                    try {
                        synchroAttenteDebut.wait();
                    } catch (InterruptedException e) {
                        getVue().afficheMessageErreur("on a été interrompu, on n'a pas pu attendre que " + j + " ait joué");
                    }
                }
                Operation operation = getEtResetActionChoisie();
                if (operation.verifier(getMoteur())) operation.faireOperation(getMoteur(), j, getMoteur().getStat().get(j));

            }
            moteur.getInventaireDuJoueur(j).resetIdBatimentAffecter();
            moteur.getInventaireDuJoueur(j).resetAction();
            moteur.getInventaireDuJoueur(j).resetInvestissement();
        }
    }


    public void décompteFinal(Identification[] joueurs) {
        if (modeDeJeu == ModeDeJeu.Antiquite) {
            for (Identification j : joueurs) {
                Operation ope = null;
                do {
                    moteur.getInventaireDuJoueur(j).setNbAction(100);
                    ope = faireDecompteFinal(j);
                    if (ope instanceof OpAffranchirEsclave || ope instanceof OpRembourserEmprunt) {
                        ope.faireOperation(moteur,j, moteur.getStat().get(j));
                        moteur.getInventaireDuJoueur(j).resetInvestissement();
                    }
                }
                while (ope != null);

            }

            for (Identification j : joueurs) {
                double nbPointsMalus = calculNbEscalve(j);
                nbPointsMalus += (calculNbEmprunt(j) * 2);
                moteur.getInventaireDuJoueur(j).setPoints((int) (moteur.getInventaireDuJoueur(j).getPoints() - nbPointsMalus));
            }

        }
    }


    public double calculNbEscalve(Identification joueur) {
        double nbEsclaveNonAffranchi = 0;
        for (CarteOuvrier ouvrier : moteur.getInventaireDuJoueur(joueur).getMainOuvrier().getCartes()) {
            if(ouvrier instanceof CarteEsclave) {
                nbEsclaveNonAffranchi++;
            }

        }
        return nbEsclaveNonAffranchi;
    }

    public double calculNbEmprunt(Identification joueur) {
        return moteur.getInventaireDuJoueur(joueur).getMainEmprunt().getCartes().size();
    }

    public Operation faireDecompteFinal(Identification joueur) {

        //POUR ESCLAVE
        if(GestionCollectionCarte.containsTypeCarte(moteur.getInventaireDuJoueur(joueur).getMainOuvrier(), CarteEsclave.class)){
            for(CarteOuvrier carte: moteur.getInventaireDuJoueur(joueur).getMainOuvrier().getCartes()){
                if(carte instanceof CarteEsclave && moteur.getInventaireDuJoueur(joueur).getEcu()>= 5){
                    return new OpAffranchirEsclave(new LoggerTrace(estSilencieux, ColorConsole.BLACK),joueur, (CarteEsclave) carte);
                }
            }
        }

        //POUR EMPRUNT
        if(!(moteur.getInventaireDuJoueur(joueur).getMainEmprunt().estVide())){
            for(CarteEmprunt carte: moteur.getInventaireDuJoueur(joueur).getMainEmprunt().getCartes()){
                if(moteur.getInventaireDuJoueur(joueur).getEcu()>= 15){
                    return new OpRembourserEmprunt(new LoggerTrace(estSilencieux, ColorConsole.BLACK),joueur, carte);
                }
            }
        }
        return null;
    }




    public Serveur(String ip, int port) {
        setVue(new VueServeur());
        setMoteur(new MoteurTMP(this,modeDeJeu,estSilencieux));
        setConnexion(new EchangesAvecLeClient(ip, port, this));
    }

    public void démarrer() {

            moteur.creationPartie();
            getConnexion().permettreConnexion();

    }


    public boolean nouveauJoueur(identification.Identification id) {
        boolean resultat =  moteur.ajouterJoueur(id,nbPartie);
        String msg = "Acceptation de ";
        if (! resultat) msg = "Refus de ";
        getVue().afficheMessage(msg+id);

        synchronized (synchroAttenteDebut){
            if(getMoteur().estPartieComplete()){
                getVue().afficheMessageErreur("on notifie...");
                synchroAttenteDebut.notify();
            }
        }



        return resultat;
    }

    private void fin() {

        getVue().afficheMessage("etat final : ");
        getConnexion().envoyerSignalFin(getMoteur().getGagnant());
    }

    private void finPartie() {

        getVue().afficheMessage("\nFin de partie ");
        getConnexion().envoyerSignalFinPartie(getMoteur().getGagnant());
    }



    /**
     * adaptation de la liaison vue - application avec la liaison connexion - serveur
     * @param msg le message à afficher
     */

    public void transfereMsg(String msg) {
        transfereMessage(msg);
    }

    @Override
    public void transfereAction(Operation operation) {
        operationChoisie=operation;
        synchronized (synchroAttenteDebut){
            getVue().afficheMessageErreur("on notifie... la réception de la 'action " + operation);
            synchroAttenteDebut.notify();
        }
    }


    protected Operation getEtResetActionChoisie(){
        Operation resultat = operationChoisie;
        operationChoisie=null;
        return resultat;
    }


    public void setConnexion(EnvoiDesMessages connexion) {
        this.connexion = connexion;
    }

    public EnvoiDesMessages getConnexion() {
        return connexion;
    }

    public void setMoteur(MoteurTMP moteur){
        this.moteur=moteur;
    }
    public MoteurTMP getMoteur(){
       return moteur;
    }
 

}
