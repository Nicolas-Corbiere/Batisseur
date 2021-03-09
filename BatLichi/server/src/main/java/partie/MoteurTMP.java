package partie;

import carte.*;
import carte.cartesPresente.LesCartesPresentes;
import com.fasterxml.jackson.annotation.JsonCreator;
import identification.Identification;
import inventaire.InventaireJoueur;
import modeDeJeu.ModeDeJeu;
import moteurDeJeu.MoteurDeJeu;
import serveur.Serveur;
import statistique.StatistiqueJoueur;
import statistique.StatistiqueParties;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static statistique.StatistiqueParties.affichageStatParties;

public class MoteurTMP implements MoteurDeJeu {

    private HashMap<Identification, InventaireJoueur>inventaires = new HashMap<Identification, InventaireJoueur>();
    private HashMap<Identification, StatistiqueJoueur>stat = new HashMap<Identification, StatistiqueJoueur>();
    private HashMap<Identification, StatistiqueParties>statPartie = new HashMap<Identification, StatistiqueParties>();

    public static int getNbMaxJoueur() {
        return NB_MAX_JOUEUR;
    }

    //ArrayList<Identification> joueurs = new ArrayList<>();
    static final int NB_MAX_JOUEUR = 4;
    SecureRandom random=new SecureRandom();
    private static final int pointPourGagner = 17; // normalement égal a 17
    private Identification gagnant; 
    private Partie partie;
    private ModeDeJeu modeDeJeu;
    private boolean estSilencieux;

    public MoteurTMP(Serveur serveur, ModeDeJeu modeDeJeu,boolean estSilencieux) {
        this.modeDeJeu=modeDeJeu;
        this.estSilencieux=estSilencieux;
    }

    public boolean ajouterJoueur(Identification id, int nbParties) {
        Set joueurs = inventaires.keySet();
        if((joueurs.size() < NB_MAX_JOUEUR) && (! joueurs.contains(id))){
            inventaires.put(id,new InventaireJoueur(0,25,3));
            stat.put(id, new StatistiqueJoueur());
            statPartie.put(id, new StatistiqueParties(id.getNom(),nbParties));
            return true;
        }
        return false;
    }

    public boolean estPartieComplete(){
        Set joueurs = inventaires.keySet();
        return (joueurs.size() >= NB_MAX_JOUEUR);
    }

    public boolean estPartieFinie(){
        Set joueurs = inventaires.keySet();
        return (joueurs.size() >= NB_MAX_JOUEUR);
    }

    public HashMap<Identification, StatistiqueJoueur> getStat() {
        return stat;
    }

    //TODO: PB ICI
    public Identification getGagnant(){
        if (estPartieFinie()) {
            return gagnant;
        }
        else return null;
    }

    public void creationPartie(){
        partie = new Partie(modeDeJeu,estSilencieux,inventaires);
    }

    public LesCartesPresentes getCartePresente(){
        return partie.getLesCartesPresentes();
    }

    @Override
    public InventaireJoueur getInventaireDuJoueur(Identification joueur) {
        return inventaires.get(joueur);
    }

    @Override
    public Random getGenerateurNombreAleatoire() {
        return random;
    }

    @Override
    public CarteBatiment getBatimentPresent(int indice) {
        return getCartePresente().getCartesPresente(CarteBatiment.class).prendreCarte(indice);
    }

    @Override
    public CarteUniversite getUniversitePresent(){
        return getCartePresente().getCartesPresente(CarteUniversite.class).prendreCarte(0);
    }

    @Override
    public CarteOutils getOutilsPresent() {
        return getCartePresente().getCartesPresente(CarteOutils.class).prendreCarte(0);
    }

    @Override
    public CarteEsclave getEsclavePresent() {
        return getCartePresente().getCartesPresente(CarteEsclave.class).prendreCarte(0);
    }

    @Override
    public CarteEmprunt getEmpruntPresent() {
        return getCartePresente().getCartesPresente(CarteEmprunt.class).prendreCarte(0);
    }

    @Override
    public CarteOuvrier getOuvrierPresent(int indice) {
        return getCartePresente().getCartesPresente(CarteOuvrier.class).prendreCarte(indice);
    }

    public Identification[] getJoeurs(){
        Set joueurs = inventaires.keySet();
        Identification[] resultat = new Identification[joueurs.size()];
        return inventaires.keySet().toArray(resultat);
    }

    public HashMap<Identification, StatistiqueParties> getStatPartie() {
        return statPartie;
    }

    public Partie getPartie() {
        return partie;
    }
    /**
     * parcours de la list de joueur pour voir si un joueur a obtenue le nombre de
     * point nécéssaire
     *
     * @return vrais si le nombre de points nécessaire est atteint
     */
    public boolean estFinie() {
        double max = 0;
        for (Map.Entry<Identification, InventaireJoueur> joueur :inventaires.entrySet()) {
            if (joueur.getValue().getPoints() > max) {
                max = joueur.getValue().getPoints();
            }
        }
        if(max >= pointPourGagner){
        gagnant = calculGagnant();
        return true;
        }
        return false;

    }
    public Identification calculGagnant(){
        double max = -1;
        Identification res = null;


        for (Map.Entry<Identification, InventaireJoueur> joueur :inventaires.entrySet()) {
            int pointEcu = joueur.getValue().getEcu() / 10;

            if (pointEcu > 0) {
                stat.get(joueur.getKey()).ajouteDesPointsEcus(pointEcu);
                //joueur.getValue().getStats().setNbPointVictoireEcu(joueur.getStats().getNbPointVictoireEcu() + pointEcu);
                joueur.getValue().setPoints(joueur.getValue().getPoints()+pointEcu);
                joueur.getValue().suppressionEcu(pointEcu * 10);
            }
            if (joueur.getValue().getPoints() > max) {
                max = joueur.getValue().getPoints();
                res = joueur.getKey();
            }

        }
        return res;
    }

    public void resetCarteInventaire(){
        partie = new Partie(modeDeJeu,estSilencieux,inventaires);
        for(Map.Entry<Identification,InventaireJoueur> entry: inventaires.entrySet()){
            entry.getValue().resetInventaire();
        }
    }
    public void resetStat(){
        for(Map.Entry<Identification,StatistiqueJoueur> entry: stat.entrySet()){
            entry.getValue().resetStat();
        }
    }
    public void afficheStatistiquesPartie(HashMap<Identification, StatistiqueParties> stat) {
        affichageStatParties(stat);
    }

}
