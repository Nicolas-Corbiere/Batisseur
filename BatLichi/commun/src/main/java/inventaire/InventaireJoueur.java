package inventaire;

import carte.*;
import mainJoueur.MainBatimentJoueur;
import mainJoueur.MainJoueur;

import java.awt.*;
import java.util.ArrayList;

public class InventaireJoueur {
    private static final int nbActionMax = 3;

    private int points;

    private int nbAction;
    private int ecu;
    private boolean investissementFait = false;

    private final ArrayList<Integer> idBatimentAffecter = new ArrayList<Integer>(); //Liste de tous les Batiments qui ont été affectés

    //Les mains
    private final MainJoueur<CarteOuvrier> mainOuvrier = new MainJoueur<CarteOuvrier>();
    private final MainJoueur<CarteEmprunt> mainEmprunt = new MainJoueur<CarteEmprunt>();
    private final MainJoueur<CarteOutils> mainOutils = new MainJoueur<CarteOutils>();
    private final MainJoueur<CarteBatiment> mainBatiment = new MainJoueur<CarteBatiment>();


    //-------------------------------------------------- Constructeur ------------------------------------------------------
    public InventaireJoueur(int points, int ecu,int nbAction) {
        setPoints(points);
        setNbAction(nbAction);
        setEcu(ecu);
    }

    public InventaireJoueur(){}

//----------------------------------------------------- Getter ---------------------------------------------------------

    public int getPoints() {
        return points;
    }

    public int getNbAction() {
        return nbAction;
    }

    public int getEcu() {
        return ecu;
    }

    public ArrayList<Integer> getIdBatimentAffecter()
    {
        return idBatimentAffecter;
    }

    public MainJoueur<CarteOuvrier> getMainOuvrier() {
        return mainOuvrier;
    }

    public MainJoueur<CarteEmprunt> getMainEmprunt() {
        return mainEmprunt;
    }

    public MainJoueur<CarteOutils> getMainOutils() {
        return mainOutils;
    }

    public MainJoueur<CarteBatiment> getMainBatiment() {
        return mainBatiment;
    }

    public static int getNbActionMax() {
        return nbActionMax;
    }
//----------------------------------------------------- Setter ---------------------------------------------------------

    public void setPoints(int points) {
        this.points = points;
    }
    public void resetNbAction(){
        this.nbAction=nbActionMax;
    }
    public void setEcu(int ecu){
        this.ecu=ecu;
    }

    public boolean isInvestissementFait() {
        return investissementFait;
    }

    public void setInvestissementFait(boolean investissementFait) {
        this.investissementFait = investissementFait;
    }

    public void setNbAction(int nbAction){
        this.nbAction=nbAction;
    }

//------------------------------------------------------ Methodes ------------------------------------------------------

    public void investissementFait() {
        investissementFait = true;
    }

    public void resetInvestissement() {
        investissementFait = false;
    }

    public void ajoutAction(int nbActionAjoute) {
        nbAction += nbActionAjoute;
    }

    public boolean suppressionAction(int nbActionSupprime) {
        if (nbActionSupprime > nbAction || nbActionSupprime > nbActionMax || nbAction <= 0) return false;
        nbAction -= nbActionSupprime;
        return true;
    }

    public void ajoutEcu(int ecuAjoute) {
        ecu += ecuAjoute;
    }

    public boolean suppressionEcu(int ecuSupprime) {
        if (ecu <= 0 || ecuSupprime > ecu) return false;
        ecu -= ecuSupprime;
        return true;
    }

    public <E extends Carte> boolean ajouterCarte(E carte) {
        if (carte instanceof CarteOuvrier) return mainOuvrier.ajoutCarte((CarteOuvrier) carte);
        if (carte instanceof CarteEmprunt) return mainEmprunt.ajoutCarte((CarteEmprunt) carte);
        if (carte instanceof CarteOutils) return mainOutils.ajoutCarte((CarteOutils) carte);
        if (carte instanceof CarteBatiment) return mainBatiment.ajoutCarte((CarteBatiment) carte);
        return false;
    }

    public void resetAction() {
        nbAction = nbActionMax;
    }

    public void addIdBatimentAffecter(int index)
    {
        idBatimentAffecter.add(index);
    }

    public void resetIdBatimentAffecter()
    {
        idBatimentAffecter.clear();
    }

    public void resetInventaire(){
         mainOuvrier.resetMainJoueur();
        mainEmprunt.resetMainJoueur();
        mainOutils.resetMainJoueur();
        mainBatiment.resetMainJoueur();
        setEcu(25);
        resetAction();
        resetIdBatimentAffecter();
        setPoints(0);
        investissementFait=false;
    }
}
