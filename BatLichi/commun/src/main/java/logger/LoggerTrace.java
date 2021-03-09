package logger;

import nommage.Nommage;
import carte.CarteBatiment;

public class LoggerTrace extends SimpleLogger{

    private String color;

    public LoggerTrace(boolean afficheTrace, String color) {
        super(afficheTrace);
        this.color = color;
    }

    public void afficheMessageTrace(String msg){
        if(afficheTrace){
            System.out.println(color + msg);
        }
    }
    public void afficheMessageTraceSansSaut(String msg){
        if(afficheTrace){
            System.out.printf(color + msg);
        }
    }

    /**
     * Permet d'afficher l'état des ressources du batiment
     *
     * @param batiment qui est a afficher
     */
    public void BatimentMiseAJourRessource(CarteBatiment batiment){
        if(afficheTrace) {
            System.out.println("------------------------------------------------------------");
            System.out.printf(Nommage.PIERRE + " -> " + batiment.getRessourceActuel(0) + "/" + batiment.getRessource(0) + " | ");
            System.out.printf(Nommage.BOIS + " -> " + batiment.getRessourceActuel(1) + "/" + batiment.getRessource(1) + " | ");
            System.out.printf(Nommage.SAVOIR + " -> " + batiment.getRessourceActuel(2) + "/" + batiment.getRessource(2) + " | ");
            System.out.printf(Nommage.TUILE + " -> " + batiment.getRessourceActuel(3) + "/" + batiment.getRessource(3) + " | ");
            System.out.println("\n------------------------------------------------------------");
        }
    }
    public LoggerTrace() {
        super(false);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
