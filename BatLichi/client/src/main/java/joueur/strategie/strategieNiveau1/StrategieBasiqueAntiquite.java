package joueur.strategie.strategieNiveau1;

import carte.*;
import carte.GestionCarte.GestionCollectionCarte;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import logger.LoggerTrace;
import mainJoueur.MainJoueur;
import operation.Operation;
import operation.investissement.OpAffranchirEsclave;
import operation.investissement.OpRembourserEmprunt;
import statistique.StatistiqueJoueur;

public class StrategieBasiqueAntiquite  extends StrategieBasique {

    /**
     * Constructeur de StrategieBasiqueAntiquite
     * @param PestSilencieux
     */
    public StrategieBasiqueAntiquite(boolean PestSilencieux) {
        super(PestSilencieux);
    }

    /**
     * Operation qui permet d'appliquer la strategie de StrategieBasiqueAntiquite
     *
     * @param lesCartesPresentes, Ensemble des cartes presentes
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @param loggerTrace, Logger pour suivre le déroulement de la partie
     * @return une Operation
     */
    @Override
    public Operation appliqueStrategie(LesCartesPresentes lesCartesPresentes, InventaireJoueur inventaireJoueur, Identification moi, LoggerTrace loggerTrace) {

        CartesPresente<CarteBatiment> batiments = lesCartesPresentes.getCartesPresente(CarteBatiment.class);
        CartesPresente<CarteOuvrier> ouvriers = lesCartesPresentes.getCartesPresente(CarteOuvrier.class);
        CartesPresente<CarteEsclave> esclaves = lesCartesPresentes.getCartesPresente(CarteEsclave.class);
        CartesPresente<CarteOutils> outils = lesCartesPresentes.getCartesPresente(CarteOutils.class);
        CartesPresente<CarteEmprunt> emprunts = lesCartesPresentes.getCartesPresente(CarteEmprunt.class);
        CartesPresente<CarteUniversite> universitees = lesCartesPresentes.getCartesPresente(CarteUniversite.class);
        MainJoueur<CarteOuvrier> mainOuvier= inventaireJoueur.getMainOuvrier();
        MainJoueur<CarteBatiment> mainBatiment = inventaireJoueur.getMainBatiment();
        MainJoueur<CarteOutils> mainOutils = inventaireJoueur.getMainOutils();
        MainJoueur<CarteEmprunt> mainEmprunt = inventaireJoueur.getMainEmprunt();
        CarteBatiment firstBatimant = null;
        int nb = nbAleatoire();
        firstBatimant = this.lirePremiereCarteBatiment(mainBatiment);
        int ouvMain = carteMainOuvrierNonNull(mainOuvier);

        if((GestionCollectionCarte.containsTypeCarte(mainOuvier, CarteEsclave.class))){
            if(inventaireJoueur.getEcu()>= 5){
                for(CarteOuvrier carte: mainOuvier.getCartes()){
                    if(carte instanceof CarteEsclave){
                        return new OpAffranchirEsclave(loggerTrace,moi,(CarteEsclave)carte);
                    }
                }
                return null;
            }
            else{
                return getJoueur().obtenirEcu(5-inventaireJoueur.getEcu(),inventaireJoueur,moi);
            }
        }
        else if(!(mainEmprunt.estVide())){
            if(inventaireJoueur.getEcu()>= 15){
                return new OpRembourserEmprunt(loggerTrace,moi, mainEmprunt.getCarte(0));
            }
            else{
                return getJoueur().obtenirEcu(15-inventaireJoueur.getEcu(),inventaireJoueur,moi);
            }

        }
        else if (!(batiments.vide()) && firstBatimant == null )
        {
            return this.tirerBatimentBasique(batiments, nb,inventaireJoueur,moi);
        }
        else if (inventaireJoueur.getMainOuvrier().estVide() && carteOuvrierNonNull(ouvriers) != -1)
        {
            return this.tirerOuvrierBasiqueAntiquite(ouvriers, firstBatimant, nb,inventaireJoueur,moi);
        }
        else if(inventaireJoueur.getEcu() < 7){
            return getJoueur().obtenirEcu(7-inventaireJoueur.getEcu(),inventaireJoueur,moi);
        }

        else if(!(universitees.vide()) && !(mainOuvier.estVide()) && !(inventaireJoueur.isInvestissementFait()) && inventaireJoueur.getMainOuvrier().getCarte(ouvMain).getCarteUniversiteAssigne()==null && !(inventaireJoueur.getMainOuvrier().getCarte(ouvMain) instanceof CarteEsclave ) && universitees.getCarte(0)!=null) {
            return this.tirerUniversiteBasique(loggerTrace,moi,universitees, mainOuvier.getCarte(ouvMain));
        }
        else if(!(outils.vide()) && mainOutils.estVide() && !(inventaireJoueur.isInvestissementFait()) && rentableOutil(outils.getCarte(0),mainOuvier) != null)
        {
            return this.tirerOutilsBasique(loggerTrace,moi,outils);
        }
        else if(!(emprunts.vide())&& mainEmprunt.estVide() && !(inventaireJoueur.isInvestissementFait()) && inventaireJoueur.getEcu()==0)
        {
            return this.tirerEmpruntBasique(loggerTrace,moi,emprunts);
        }
        else if (!(mainBatiment.estVide()) &&  !(firstBatimant.estBatimentTerminé()) && !(mainOuvier.estVide()))
        {
            if(!(mainOutils.estVide()))
            {
                return this.affectationOuvrierBatimentBasiqueAntiquite(firstBatimant,mainOuvier,mainOutils,inventaireJoueur,moi);
            }
            else{
                return this.affectationOuvrierBatimentBasique(firstBatimant,mainOuvier,inventaireJoueur,moi);
            }

        }
        else if(mainEmprunt.estVide() && !inventaireJoueur.isInvestissementFait() && getJoueur().getEcu() < 7 && !(emprunts.vide()))
        {
            return this.tirerEmpruntBasique(loggerTrace,moi,emprunts);
        }
        else if(getJoueur().getEcu() < 7){
            return getJoueur().obtenirEcu(7 - inventaireJoueur.getEcu(),inventaireJoueur,moi);
        }
        else if(!(outils.vide()) && !(inventaireJoueur.isInvestissementFait()) && inventaireJoueur.getEcu() >= 2)
        {
            return this.tirerOutilsBasique(loggerTrace,moi,outils);
        }
        else if(!(esclaves.vide()) && carteOuvrierNonNull(ouvriers) == -1 && inventaireJoueur.getEcu()>=7 && !(inventaireJoueur.isInvestissementFait())){
            return this.tirerEsclaveBasique(loggerTrace,moi,esclaves);
        }
        else {

            return getJoueur().obtenirEcu(10-inventaireJoueur.getEcu(),inventaireJoueur,moi);
        }

    }


    /**
     * Operation qui permet de tirer une carte esclave
     * @param loggerTrace, Logger pour suivre le déroulement de la partie
     * @param moi, Identification du joueur
     * @param esclaves, Cartes esclaves présentes
     * @return une Operation
     */
    protected Operation tirerEsclaveBasique(LoggerTrace loggerTrace, Identification moi,CartesPresente<CarteEsclave> esclaves)
    {
        return getJoueur().achatEsclave(loggerTrace,moi,esclaves);
    }

    /**
     * Operation qui permet de tirer une carte outil
     * @param loggerTrace, Logger pour suivre le déroulement de la partie
     * @param moi, Identification du joueur
     * @param outils, Cartes outils présentes
     * @return une Operation
     */
    protected Operation tirerOutilsBasique(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteOutils> outils)
    {
        return getJoueur().achatOutils(loggerTrace,moi,outils);
    }

    /**
     * Operation qui permet de tirer une carte emprunt
     * @param loggerTrace, Logger pour suivre le déroulement de la partie
     * @param moi, Identification du joueur
     * @param emprunt, Cartes emprunts présentes
     * @return une Operation
     */
    protected Operation tirerEmpruntBasique(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteEmprunt> emprunt)
    {
        return getJoueur().prendreEmprunt(loggerTrace,moi,emprunt);
    }

    /**
     * Operation qui permet de tirer une carte universite
     * @param loggerTrace, Logger pour suivre le déroulement de la partie
     * @param moi, Identification du joueur
     * @param universite, Cartes universitees présentes
     * @return une Operation
     */
    protected Operation tirerUniversiteBasique(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteUniversite> universite, CarteOuvrier ouvrier)
    {
        return getJoueur().instruireOuvrier(loggerTrace,moi,universite, ouvrier);
    }

}



