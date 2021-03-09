package statistique;

//import joueur.Joueur;

import identification.Identification;
import logger.ColorConsole;
import logger.LoggerTrace;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class StatistiqueParties extends Statistique {
    private int nbParties = 0;
    public double[] tabRang = {0, 0, 0, 0};
    private String nom;
    private boolean afficherStats;

    private static LoggerTrace loger = new LoggerTrace(true, ColorConsole.BLACK);

    public StatistiqueParties(String Pnom, int nbParties) {
        super();
        afficherStats = true;
        nom = Pnom;
        this.nbParties = nbParties;
    }
    public static LoggerTrace getLoger() {
        return loger;
    }
    public int getNbParties() {
        return nbParties;
    }

    public void setNbParties(int value) {
        nbParties = value;
    }

    //----Constructeur----
    public StatistiqueParties(String Pnom, boolean PafficherStats){
        super();
        nom = Pnom;
        afficherStats = PafficherStats;
    }


    public static void affichageStatParties(HashMap<Identification, StatistiqueParties> stat){

        getLoger().afficheMessageTraceSansSaut("\n\nStatistique des parties");
    	
        String[] label = {
                "Label des moyennes          ",
                "Nombre de fois 1er          ",
                "Nombre de fois 2e           ",
                "Nombre de fois 3e           ",
                "Nombre de fois 4e           ",
                "Points : Bâtiments          ",
                "Points : Ecus               " ,
                "Actions : recruter          ",
                "Actions : ouvrir un Chantier",
                "Actions : travailler        ",
                "Actions : Ecus              ",
                "Acheter une action          ",
                "Ecus : Ouvriers             ",
                "Ecus : Batiment             "};

            for (int i = 0; i < label.length; i++) {
                getLoger().afficheMessageTraceSansSaut("\n" + label[i] + " | ");
                for (Identification unJoueur : stat.keySet()) {
                        String space = "";
                        String[] stats = StatistiqueParties.toStringStatsPartie(unJoueur,stat.get(unJoueur));
                        int nbChar = 2 + stats[i].length();
                        int nbCharRequis = 20;

                        if (nbChar < nbCharRequis) {
                            for (int j = 0; j < nbCharRequis - nbChar; j++) {
                                space += " ";
                            }
                        }
                    getLoger().afficheMessageTraceSansSaut(stats[i] + space + " | ");
                    }

                getLoger().afficheMessageTraceSansSaut("\n------------------------------------------------------------------------------------------------------------------------------------");
            }

    }
    /**
     * Méthode qui permet de d'avoir un tableau avec toutes les données Statistiques des parties pour le joueur.
     */
    public static String[] toStringStatsPartie(Identification id, StatistiqueParties stat) {
        DecimalFormat df = new DecimalFormat("##.00");
        String[] tabStatsPartie = { id.getNom(),String.valueOf(stat.tabRang[0]),
                String.valueOf(stat.tabRang[1]),String.valueOf(stat.tabRang[2]),
                String.valueOf(stat.tabRang[3]),
                String.valueOf(df.format(stat.getNbPointVictoireBatiment()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbPointVictoireEcu()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbPiocheOuvrier()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbPiocheBatiment()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbAffectation()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbPiocheEcu()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbAchatAction()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbEcuOuvrier()/stat.getNbParties())),
                String.valueOf(df.format(stat.getNbEcuBatiment()/stat.getNbParties())) };

        return tabStatsPartie;
    }
    public void addition(StatistiqueJoueur stat){
        setNbPointVictoireBatiment(getNbPointVictoireBatiment() + stat.getNbPointVictoireBatiment());
        setNbPointVictoireEcu(getNbPointVictoireEcu() + stat.getNbPointVictoireEcu());
        setNbPiocheOuvrier(getNbPiocheOuvrier() + stat.getNbPiocheOuvrier());
        setNbPiocheBatiment(getNbPiocheBatiment() + stat.getNbPiocheBatiment());
        setNbAffectation(getNbAffectation() + stat.getNbAffectation());
        setNbPiocheEcu(getNbPiocheEcu() + stat.getNbPiocheEcu());
        setNbAchatAction(getNbAchatAction() + stat.getNbAchatAction());
        setNbEcuOuvrier(getNbEcuOuvrier() + stat.getNbEcuOuvrier());
        setNbEcuBatiment(getNbEcuBatiment() + stat.getNbEcuBatiment());
        tabRang[stat.getRang()-1] += 1;
    }

}
