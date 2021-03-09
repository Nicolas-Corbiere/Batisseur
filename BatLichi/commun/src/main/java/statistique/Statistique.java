package statistique;

import carte.CarteEmprunt;
import carte.CarteEsclave;
import carte.CarteOuvrier;

import java.util.ArrayList;

public class Statistique {


    //----Attributs----
    private double nbPointVictoireBatiment;        //Point de Victoire par les Batiments
    private double nbPointVictoireEcu;             //Point de Victoire par les Ecus
    private double nbPointVictoire;                //Addition des 2
    private double nbPiocheOuvrier;                //Nombre de fois où le joueur pioche un Ouvrier
    private double nbPiocheBatiment;               //Nombre de fois où le joueur pioche un Batiment
    private double nbAffectation;                  //Nombre de fois où un Ouvrier est affecté à un Batiment
    private double nbPiocheEcu;                    //Nombre de fois où le joueur pioche des Ecus
    private double nbAchatAction;                  //Nombre de fois où le joueur achete des Actions
    private double nbEcuOuvrier;                   //Nombre d'Ecus que le joueur dépense pour affecter ses Ouvriers
    private double nbEcuBatiment;                  //Nombre d'Ecus que le joueur récupère à la fin de son Batiment

    //----Constructeur----
    public Statistique(){
        nbPointVictoireBatiment = 0;
        nbPointVictoireEcu = 0;
        nbPiocheOuvrier = 0;
        nbPiocheBatiment = 0;
        nbAffectation = 0;
        nbPiocheEcu = 0;
        nbAchatAction = 0;
        nbEcuOuvrier = 0;
        nbEcuBatiment = 0;
    }

    //----Getter & Setter----
    public double getNbPointVictoireBatiment() {

        return nbPointVictoireBatiment;
    }

    public void setNbPointVictoireBatiment(double nbPointVictoireBatiment) {
        this.nbPointVictoireBatiment = nbPointVictoireBatiment;
    }

    public double getNbPiocheOuvrier() {

        return nbPiocheOuvrier;
    }

    public void setNbPiocheOuvrier(double nbPiocheOuvrier) {

        this.nbPiocheOuvrier = nbPiocheOuvrier;
    }

    public double getNbPiocheBatiment() {

        return nbPiocheBatiment;
    }

    public void setNbPiocheBatiment(double nbPiocheBatiment) {

        this.nbPiocheBatiment = nbPiocheBatiment;
    }

    public double getNbAffectation() {

        return nbAffectation;
    }

    public void setNbAffectation(double nbAffectation) {

        this.nbAffectation = nbAffectation;
    }

    public double getNbPointVictoireEcu() {

        return nbPointVictoireEcu;
    }

    public void setNbPointVictoireEcu(double nbPointVictoireEcu) {

        this.nbPointVictoireEcu = nbPointVictoireEcu;
    }

    public double calculeNbEcu(ArrayList<CarteOuvrier> mainOuvrier) {
        double ecuARetirer =0;
        for (Object carte : mainOuvrier){
            if( carte instanceof CarteEmprunt){
                ecuARetirer += 15;
            }
        }
        return ecuARetirer;
    }

    public void setNbPointVictoire(double nbPointVictoire) {
        this.nbPointVictoire = nbPointVictoire;
    }

    public double calculeNbPointVictoire(ArrayList<CarteOuvrier> mainOuvrier) {
        double points = getNbPointVictoireBatiment() + getNbPointVictoireEcu();
        for (Object carte : mainOuvrier){
            if( carte instanceof CarteEsclave){
                points -= 2;
            }
        }
        return points;
    }
    public double calculeNbPointVictoire() {
        double points = getNbPointVictoireBatiment() + getNbPointVictoireEcu();
        return points;
    }

    public double getNbPointVictoire() {
        return nbPointVictoire;
    }

    public double getNbPiocheEcu() {
        return nbPiocheEcu;
    }

    public void setNbPiocheEcu(double nbPiocheEcu) {
        this.nbPiocheEcu = nbPiocheEcu;
    }

    public double getNbAchatAction() {
        return nbAchatAction;
    }

    public void setNbAchatAction(double nbAchatAction) {
        this.nbAchatAction = nbAchatAction;
    }

    public double getNbEcuBatiment() {
        return nbEcuBatiment;
    }

    public void setNbEcuBatiment(double nbEcuBatiment) {
        this.nbEcuBatiment = nbEcuBatiment;
    }

    public double getNbEcuOuvrier() {
        return nbEcuOuvrier;
    }

    public void setNbEcuOuvrier(double nbEcuOuvrier) {
        this.nbEcuOuvrier = nbEcuOuvrier;
    }
}
