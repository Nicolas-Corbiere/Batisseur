package vueServeur;

import logger.ColorConsole;
import logger.LoggerTrace;
import vue.Vue;


public class VueServeur implements Vue {
    private LoggerTrace logger;
    public VueServeur() {
        logger=new LoggerTrace(true, ColorConsole.BLUE);
    }


    public void afficheMessage(String msg) {
        logger.afficheMessage("Serveur>"+msg);
    }


    public void finit() {

        logger.afficheMessage("Serveur> on s'arrête !");
    }

    public void afficheMessageErreur(String s) {
        logger.afficheMessageErreur("Serveur>"+s);
    }
}
