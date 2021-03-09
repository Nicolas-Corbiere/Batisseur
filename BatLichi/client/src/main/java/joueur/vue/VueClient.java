package joueur.vue;

import joueur.Client;
import logger.ColorConsole;
import logger.LoggerTrace;
import vue.Vue;

public class VueClient implements Vue {

    private final Client client;
    private LoggerTrace logger;

    /**
     * Constructeur de VueClient
     * @param client
     */
    public VueClient(Client client) {
        this.client = client;
        logger = new LoggerTrace(true, ColorConsole.BLACK);
        client.setVue(this);

    }

    /**
     * Methode qui permet d'afficher un message
     * @param msg, le message
     */
    public void afficheMessage(String msg) {
        logger.afficheMessage(client.getIdentification()+"> "+msg);
    }


    /**
     * Methode qui permet d'indiquer une déconnexion
     */
    public void finit() {
        logger.afficheMessage(client.getIdentification()+"> on est déconnecté !");
    }

    /**
     * Methode qui permet d'afficher un message d'erreur
     * @param s, le message
     */
    public void afficheMessageErreur(String s) {
        logger.afficheMessageErreur(client.getIdentification()+"> "+s);
    }
}