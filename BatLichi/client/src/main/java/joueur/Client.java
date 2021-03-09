package joueur;


import application.Application;
import argument.Arguments;
import carte.cartesPresente.LesCartesPresentes;
import com.github.javafaker.Faker;
import identification.Identification;
import inventaire.InventaireJoueur;
import joueur.reseau.EchangesAvecLeServeur;
import joueur.strategie.Strategie;
import joueur.strategie.strategieNiveau1.StrategieBasique;
import joueur.strategie.strategieNiveau1.StrategieBasiqueAntiquite;
import joueur.strategie.strategieNiveau1.StrategieBasiqueMoyenAge;
import joueur.strategie.strategieNiveau2.StrategieMediumAntiquite;
import joueur.strategie.strategieNiveau3.StrategieHardAntiquite;
import joueur.vue.VueClient;
import logger.ColorConsole;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.Operation;
import strategieFactory.StrategieAntiquite;
import strategieFactory.StrategieFactory;
import strategieFactory.StrategieMoyenAge;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Client extends Application {



    private static ModeDeJeu modeDeJeu;
    private static boolean estSilencieux;
    private static boolean affichageStat;

    private Identification identification;
    private EchangesAvecLeServeur connexion;
    private Strategie strategie;
    private LesCartesPresentes lesCartesPresentes;
    private Joueur joueur;
    private static LoggerTrace logger;

    public static void main(String [] args) {

        logger = new LoggerTrace(true, ColorConsole.BLACK);

        Arguments arguments = new Arguments(args);

        arguments.analyseArgument();
        estSilencieux = arguments.isBoolTrace();
        affichageStat = arguments.isBoolStat();
        modeDeJeu = arguments.getModeDeJeu();

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Faker nameFaker = new Faker();

        Strategie s;

        int random = nameFaker.random().nextInt(100);
        String name=nameFaker.harryPotter().character();
        // TODO: supp ligne 61 a 64
        //random = 70; // permet d'avoit que des medium
        if(modeDeJeu==ModeDeJeu.Antiquite){

            StrategieFactory factoryS = new StrategieAntiquite();
 

            if (random < 50 ) {
                s = factoryS.getBasique(estSilencieux);
                name+=" (b)";
            }
            else if(random < 80) {
                s = factoryS.getMedium(estSilencieux);
                name+=" (m)";
            }
            else {
                s = factoryS.getHard(estSilencieux);
                name += " (h)";
            }
        }

        else{

            StrategieFactory factoryS = new StrategieMoyenAge();

            if (random < 50 ) {
                s = factoryS.getBasique(estSilencieux);
                name+=" (b)";
            }
            else if(random < 80) {
                s = factoryS.getMedium(estSilencieux);
                name+=" (m)";
            }
            else {
                s = factoryS.getHard(estSilencieux);
                name += " (h)";
            }
        }


        Client client = new Client(name ,s);
        client.rejoindreUnePartie();
    }


    /**
     * Constructeur de Client
     * @param nom, nom du client
     * @param strategie, strategie du client
     */
    public Client(String nom, Strategie strategie) {
        setIdentification(new Identification(nom));
        setVue(new VueClient(this));
        setStrategie(strategie);
        setConnexion(new EchangesAvecLeServeur("http://127.0.0.1:10101", this));
        joueur=new Joueur(nom,true,true);
        joueur.ajouteStrategie(strategie);
    }

    public Client(String nom) {
        this(nom, new StrategieBasiqueAntiquite(estSilencieux));
    }


    /**
     * Methode qui permet d'indiquer une attente de déconnexion
     */
    public void rejoindreUnePartie() {
        getVue().afficheMessage("en attente de déconnexion");
        getConnexion().seConnecter();
    }



    /**
     * Methode qui permet de transfere un message grâce a la methode afficheMessage()
     * @param msg, le message
     */
    public void transfereMessage(String msg) {
        getVue().afficheMessage(msg);
    }

    /**
     * Methode qui permet de signaler une erreur grâce a la methode afficheMessageErreur()
     * @param err, l'erreur
     */
    public void signaleErreur(String err) {
        getVue().afficheMessageErreur(err);
    }

    /**
     * Methode qui permet d'indiquer une connexion établie
     */
    public void apresConnexion() {
        getVue().afficheMessage("on est connecté ! et on s'identifie ");
        this.connexion.envoyerId(getIdentification());
    }

    /**
     * Methode qui permet d'indiquer une fin de partie
     */
    public void finPartie() {
        getVue().finit();
        getConnexion().stop();
    }


    /**
     * Methode qui permet d'appeler la methode finPartie() qui permet d'indiquer un fin de partie
     * @param gagné, true :si gagné / False : si perdu
     */
    public void resultat(boolean gagné) {

        finPartie();

    }

    /**
     * Methode qui permet d'indiquer une fin de partie, et de dire c'est gagné ou perdu
     * @param gagné, true :si gagné / False : si perdu
     */
    public void resultatPartie(boolean gagné) {
        getVue().afficheMessage(" C'est fini ");

        if (gagné) getVue().afficheMessage("j'ai gagné");
        else getVue().afficheMessage("j'ai perdu");

    }

    /**
     *
     * @param inventaireJoueur, inventaire du joueur
     * @param lesCartesPresentes, L'ensemble des cartes presentes
     */
    public void jouer(InventaireJoueur inventaireJoueur,LesCartesPresentes lesCartesPresentes) {
        getVue().afficheMessage("c'est à moi de jouer "+inventaireJoueur);
       // getConnexion().envoyerActionChoisie(null);
        Operation actionChoisie = joueur.jouer( lesCartesPresentes,inventaireJoueur, getIdentification());
        getVue().afficheMessage("je joue "+actionChoisie);
        getConnexion().envoyerActionChoisie(actionChoisie);
    }



    /********* méthodes pour les propriétés **********/

    public ModeDeJeu getModeDeJeu() {
        return modeDeJeu;
    }

    public static void setModeDeJeu(ModeDeJeu modeDeJeu) {
        Client.modeDeJeu = modeDeJeu;
    }

    public static boolean isEstSilencieux() {
        return estSilencieux;
    }

    public static void setEstSilencieux(boolean estSilencieux) {
        Client.estSilencieux = estSilencieux;
    }

    public static boolean isAffichageStat() {
        return affichageStat;
    }

    public static void setAffichageStat(boolean affichageStat) {
        Client.affichageStat = affichageStat;
    }

    public LesCartesPresentes getLesCartesPresentes() {
        return lesCartesPresentes;
    }

    public void setLesCartesPresentes(LesCartesPresentes lesCartesPresentes) {
        this.lesCartesPresentes = lesCartesPresentes;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public void setConnexion(EchangesAvecLeServeur connexion) {
        this.connexion = connexion;
    }

    public EchangesAvecLeServeur getConnexion() {
        return connexion;
    }



    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public Strategie getStrategie() {
        return strategie;
    }

}