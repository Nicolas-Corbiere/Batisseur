package joueur.strategie.strategieNiveau2;


import carte.CarteBatiment;
import carte.CarteEsclave;
import carte.CarteOutils;
import carte.CarteOuvrier;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import joueur.strategie.StrategieIntelligent;
import logger.LoggerTrace;
import mainJoueur.MainJoueur;
import operation.Operation;


public class StrategieMedium extends StrategieIntelligent {

    /**
     * Constructeur de StrategieMedium
     * @param PestSilencieux
     */
    public StrategieMedium(boolean PestSilencieux) {
        super(2, PestSilencieux);
    }



    /**
     * Operation qui permet de tirer un batiment pour Strategie Medium
     *
     * @param batiments, Cartes batiments presentes
     * @param index, un nombre aleatoire entre 0 et 4
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation tirerBatimentMedium(CartesPresente<CarteBatiment> batiments, int index,InventaireJoueur inventaireJoueur,Identification moi)
    {
        if (estMeilleurePointVictoirePresente(batiments) != null)
        {
            return getJoueur().affectationBatiment(batiments, PositionEstMeilleurePointVictoirePresente(batiments),inventaireJoueur,moi);
        }
        else if(!batiments.caseVide(index) && (index != -1)){
            return getJoueur().affectationBatiment(batiments, index,inventaireJoueur,moi);
        }
        else if(carteBatimentNonNull(batiments) != -1){
            return getJoueur().affectationBatiment(batiments, carteBatimentNonNull(batiments),inventaireJoueur,moi);
        }
        else{
            return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
        }
    }



    /**
     * Operation qui permet de tirer un ouvrier pour Strategie Medium
     *
     * @param ouvriers, Cartes ouvriers presentes
     * @param index, un nombre aleatoire entre 0 et 4
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation tirerOuvrierMedium(CartesPresente<CarteOuvrier> ouvriers, int index,InventaireJoueur inventaireJoueur,Identification moi)
    {
        int i = carteOuvrierNonNull(ouvriers);
        if(!ouvriers.caseVide(i)){
            return getJoueur().affectationOuvrier(ouvriers, estMeilleureRessource(ouvriers),inventaireJoueur,moi);
        }
        else if(!ouvriers.caseVide(index) && (index != -1))
        {
            return getJoueur().affectationOuvrier(ouvriers, index,inventaireJoueur,moi);
        }
        else if(carteOuvrierNonNull(ouvriers) != -1)
        {
            return getJoueur().affectationOuvrier(ouvriers, carteOuvrierNonNull(ouvriers),inventaireJoueur,moi);
        }
        else
        {
            return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
        }
    }


    /**
     * Operation qui permet de tirer un ouvrier pour Strategie Medium Antiquite
     *
     * @param ouvriers, Cartes ouvriers presentes
     * @param batiment, Carte Batiment
     * @param index, un nombre aleatoire entre 0 et 4
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation tirerOuvrierMediumAntiquite(CartesPresente<CarteOuvrier> ouvriers, CarteBatiment batiment, int index,InventaireJoueur inventaireJoueur,Identification moi)
    {
        int i = carteOuvrierNonNull(ouvriers);
        if(!ouvriers.caseVide(i)){
            return getJoueur().affectationOuvrier(ouvriers, positionMeilleureOuvrierPresentePourCarteBatiment(ouvriers, batiment),inventaireJoueur,moi);
        }
        else if(!ouvriers.caseVide(index) && (index != -1))
        {
            return getJoueur().affectationOuvrier(ouvriers, index,inventaireJoueur,moi);
        }
        else if(carteOuvrierNonNull(ouvriers) != -1)
        {
            return getJoueur().affectationOuvrier(ouvriers, carteOuvrierNonNull(ouvriers),inventaireJoueur,moi);
        }
        else
        {
            return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
        }
    }


    /**
     * Operation qui permet d'affecter un ouvrier à un batiment pour Strategie Medium
     *
     * @param carteBatiment, Carte Batiment
     * @param mainOuvrier, main ouvrier du joueur
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation affectationOuvrierBatimentMedium(CarteBatiment carteBatiment, MainJoueur<CarteOuvrier> mainOuvrier,InventaireJoueur inventaireJoueur,Identification moi)
    {

        int i = carteMainOuvrierNonNull(mainOuvrier);
        if(i != -1){

            if( ((mainOuvrier.getCarte(i).getEcu() - inventaireJoueur.getEcu()) > 0))
            {
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)> inventaireJoueur.getNbAction() && inventaireJoueur.getEcu()>5)
            {
                return getJoueur().achatNouvelleAction(moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)<= inventaireJoueur.getNbAction())
            {
                return getJoueur().affectationOuvrierBatiment(carteBatiment, mainOuvrier.getCarte(i),inventaireJoueur,moi);

            }
            else{
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
        }
        else{
            getJoueur().getLogger().afficheMessageErreur("Bloquer");
            return null;
        }
    }

    /**
     * Operation qui permet d'affecter un ouvrier à un batiment pour Strategie Medium Antiquite
     *
     * @param carteBatiment, Carte Batiment
     * @param mainOuvrier, main ouvrier du joueur
     * @param mainOutils, main outils du joueur
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation affectationOuvrierBatimentMediumAntiquite(CarteBatiment carteBatiment, MainJoueur<CarteOuvrier> mainOuvrier, MainJoueur<CarteOutils>mainOutils, InventaireJoueur inventaireJoueur, Identification moi)
    {

        int j = carteMainOuvrierNonNull(mainOuvrier);
        if(positionRentableOutil(mainOutils.getCarte(0),mainOuvrier)!= -1 && !(mainOuvrier.getCarte(positionRentableOutil(mainOutils.getCarte(0),mainOuvrier)) instanceof CarteEsclave) && mainOuvrier.getCarte(positionRentableOutil(mainOutils.getCarte(0),mainOuvrier)).getCarteOutilsAssigne()==null){
            if( ((mainOuvrier.getCarte(positionRentableOutil(mainOutils.getCarte(0),mainOuvrier)).getEcu() - inventaireJoueur.getEcu()) > 0))
            {
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)> inventaireJoueur.getNbAction() && inventaireJoueur.getEcu()>5)
            {
                return getJoueur().achatNouvelleAction(moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)<= inventaireJoueur.getNbAction())
            {
                return getJoueur().affectationOuvrierBatiment(carteBatiment, rentableOutil(mainOutils.getCarte(0),mainOuvrier), mainOutils.getCarte(0),inventaireJoueur,moi);
            }
            else{
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
        }
        else{
            if( ((mainOuvrier.getCarte(j).getEcu() - inventaireJoueur.getEcu()) > 0))
            {
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)> inventaireJoueur.getNbAction() && inventaireJoueur.getEcu()>5)
            {
                return getJoueur().achatNouvelleAction(moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)<= inventaireJoueur.getNbAction())
            {
                return getJoueur().affectationOuvrierBatiment(carteBatiment, mainOuvrier.getCarte(j), mainOutils.getCarte(0),inventaireJoueur,moi);
            }
            else{
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
        }

    }


    /**
     *
     * @param lesCartesPresentes, Ensemble des cartes presentes
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @param logger, Logger pour suivre le déroulement de la partie
     *
     */
    @Override
    public Operation appliqueStrategie(LesCartesPresentes lesCartesPresentes, InventaireJoueur inventaireJoueur, Identification moi, LoggerTrace logger) {
        return null;
    }
}
