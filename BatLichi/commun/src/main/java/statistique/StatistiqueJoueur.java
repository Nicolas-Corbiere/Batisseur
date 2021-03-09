package statistique;

//import joueur.Joueur;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import identification.Identification;
import logger.ColorConsole;
import logger.LoggerTrace;

import java.lang.reflect.Array;
import java.util.*;
import java.util.HashMap;


public class StatistiqueJoueur<donnees> extends Statistique{

    private static LoggerTrace loger = new LoggerTrace(true,ColorConsole.BLACK);


    int rang;
    //----Constructeur----
    public StatistiqueJoueur(){
        super();
        rang =0;
    }

    public static LoggerTrace getLoger() {
        return loger;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public static void afficheStatisqueJoueur(HashMap<Identification, StatistiqueJoueur> stat) {
        String[] label = {
                "Label                       ",
                "Résultat de la partie       ",
                "Points : Bâtiments          ",
                "Points : Ecus               ",
                "Actions : recruter          ",
                "Actions : ouvrir un Chantier",
                "Actions : travailler        ",
                "Actions : Ecus              ",
                "Acheter une action          ",
                "Ecus : Ouvriers             ",
                "Ecus : Batiment             "};
        //int afficher = 0;


        /*
        for (Identification unJoueur:listJoueur) {
            if(unJoueur.isAfficherStats()){
                afficher ++;
            }
        }*/

        //if(afficher != 0) {
            for (int i = 0; i < label.length; i++) {
                getLoger().afficheMessageTraceSansSaut("\n" + label[i] + " | ");
                for (Identification unJoueur : stat.keySet()) {
                        String space = "";
                        String[] stats = toStringStats(unJoueur, stat.get(unJoueur));
                        int nbChar = 2 + stats[i].length();
                        int nbCharRequis = 20;
                    if(nbChar < nbCharRequis){
                            for (int j = 0; j < nbCharRequis - nbChar; j++) {
                                space += " ";
                            }
                    }
                    getLoger().afficheMessageTraceSansSaut(stats[i] +space+ " | ");

                }
                getLoger().afficheMessageTraceSansSaut("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        //}
        getLoger().afficheMessageTraceSansSaut("\n");

    }

    public static String[] toStringStats(Identification id, StatistiqueJoueur stat){
        String[] donnees = {id.getNom(),
                String.valueOf(stat.getRang()) + "(" + String.valueOf(stat.calculeNbPointVictoire()) + ")" ,
                    String.valueOf(stat.getNbPointVictoireBatiment()),
                    String.valueOf(stat.getNbPointVictoireEcu()), String.valueOf(stat.getNbPiocheOuvrier()),
                    String.valueOf(stat.getNbPiocheBatiment()), String.valueOf(stat.getNbAffectation()),
                    String.valueOf(stat.getNbPiocheEcu()), String.valueOf(stat.getNbAchatAction()),
                    String.valueOf(stat.getNbEcuOuvrier()), String.valueOf(stat.getNbEcuBatiment()) };

        return donnees;
    }
    public void ajouteUnAffectationBatiment(){
        setNbPiocheBatiment(getNbPiocheBatiment() +1);
    }
    public void ajouteUnAffectationOuvrier(){
        setNbPiocheOuvrier(getNbPiocheOuvrier() +1);
    }
    public void ajouteDesEcus(int nbEcus){
        setNbPiocheEcu(getNbPiocheEcu() + nbEcus);
    }
    public void ajouteUneAffectation(CarteOuvrier ouvrier){
        setNbAffectation(getNbAffectation() +1);
        setNbEcuOuvrier(getNbEcuOuvrier() + ouvrier.getEcu());
    }
    public void ajouteDesPointsBatiments(CarteBatiment batiment){
        setNbPointVictoireBatiment(getNbPointVictoireBatiment() + batiment.getPointVictoire());
        setNbEcuBatiment(getNbEcuBatiment() + batiment.getEcu());
    }
    public void ajouteDesPointsEcus(int pointEcu){
        setNbPointVictoireEcu(getNbPointVictoireEcu() + pointEcu);
    }

    public void ajouterUnAchatAction(){
        setNbAchatAction(getNbAchatAction()+1);
    }
    public void resetStat(){
        setNbPointVictoireBatiment(0);
        setNbPointVictoireEcu(0);
        setNbPiocheOuvrier(0);
        setNbPiocheBatiment(0);
        setNbAffectation(0);
        setNbPiocheEcu(0);
        setNbAchatAction(0);
        setNbEcuOuvrier(0);
        setNbEcuBatiment(0);
    }

    public static void definitionRang(HashMap<Identification, StatistiqueJoueur> stat){
        int rang = 4;
            int i = 0;
            int[] points = new int[stat.size()];
            for (Identification joueur : stat.keySet()) {
                points[i] = (int) stat.get(joueur).calculeNbPointVictoire();
                i++;
            }

            Arrays.sort(points);
            int j = 0;
            while(rang != 0) {
                for (Identification joueur : stat.keySet()) {
                    if(j == 4){
                        break;
                    }
                    if (stat.get(joueur).calculeNbPointVictoire() == points[j]) {
                        stat.get(joueur).setRang(rang);
                        getLoger().afficheMessageErreur("J'ai mis le rang " + rang + " a " + joueur.getNom() + " car il a " + stat.get(joueur).calculeNbPointVictoire());

                        rang = rang - 1;
                        j++;
                    }
                }
            }
    }
}
