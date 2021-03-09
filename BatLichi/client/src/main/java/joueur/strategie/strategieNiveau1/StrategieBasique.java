package joueur.strategie.strategieNiveau1;

import carte.CarteBatiment;
import carte.CarteEsclave;
import carte.CarteOutils;
import carte.CarteOuvrier;
import carte.cartesPresente.CartesPresente;
import identification.Identification;
import inventaire.InventaireJoueur;
import joueur.strategie.Strategie;
import mainJoueur.MainBatimentJoueur;
import mainJoueur.MainJoueur;
import operation.Operation;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class StrategieBasique extends Strategie {



    /**
     * Constructeur de StrategieBasique
     * @param PestSilencieux
     */
    public StrategieBasique(boolean PestSilencieux)
    {
        super(1, PestSilencieux);
        //this.choixNbCarte = 3; // Pourra mettre un alea (difficulté aleatoire)
    }

    /**
     * Permet de trouver la position d'une carteBatiment presente qui au maximum à 3 pour chaque ressource
     * @param cartePresente, Cartes batiment presentes
     * @see carte.cartesPresente.CartesPresente
     * @return un indice supérieur ou égale à 0 (-1 si aucune carte trouvé)
     */
    public int tirerBatimentAdapte(CartesPresente<CarteBatiment> cartePresente)
    {
        int indice = 0;
        for (CarteBatiment carte : cartePresente.lireCartes())
        {
            if (carte!= null && carte.getRessources()[0] < 4 && carte.getRessources()[1] < 4 && carte.getRessources()[2] < 4 && carte.getRessources()[3] < 4)
            {
                return indice;
            }
                indice++;


        }
        return -1;
    }

    /**
     * Operation qui permet de tirer un batiment pour Strategie Basique
     *
     * @param batiments, Cartes batiments presentes
     * @param index, un nombre aleatoire entre 0 et 4
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation tirerBatimentBasique(CartesPresente<CarteBatiment> batiments, int index, InventaireJoueur inventaireJoueur,Identification moi)
    {
        if (tirerBatimentAdapte(batiments) != -1)
        {
            return getJoueur().affectationBatiment(batiments, tirerBatimentAdapte(batiments),inventaireJoueur,moi);
        }
        else if((batiments.getCarte(index) != null) && (index != -1)){
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
     * Operation qui permet de tirer un ouvrier pour Strategie Basique
     *
     * @param ouvriers, Cartes ouvriers presentes
     * @param index, un nombre aleatoire entre 0 et 4
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation tirerOuvrierBasique(CartesPresente<CarteOuvrier> ouvriers, int index,InventaireJoueur inventaireJoueur,Identification moi)
    {
        if((ouvriers.getCarte(index) != null) && (index != -1))
        {
            return getJoueur().affectationOuvrier(ouvriers,index, inventaireJoueur, moi);
        }
        else if(carteOuvrierNonNull(ouvriers) != -1)
        {
            return getJoueur().affectationOuvrier(ouvriers, carteOuvrierNonNull(ouvriers), inventaireJoueur, moi);
        }
        else
        {
            return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
        }
    }

    /**
     * Operation qui permet de tirer un ouvrier pour Strategie Basique Antiquite
     *
     * @param ouvriers, Cartes ouvriers presentes
     * @param batiment, Carte Batiment
     * @param index, un nombre aleatoire entre 0 et 4
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation tirerOuvrierBasiqueAntiquite(CartesPresente<CarteOuvrier> ouvriers, CarteBatiment batiment, int index,InventaireJoueur inventaireJoueur,Identification moi)
    {
        int i = carteOuvrierNonNull(ouvriers);
        if(!ouvriers.caseVide(i)){
            return getJoueur().affectationOuvrier(ouvriers, positionMeilleureOuvrierPresentePourCarteBatiment(ouvriers, batiment),inventaireJoueur,moi );
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
     * Operation qui permet d'affecter un ouvrier à un batiment pour Strategie Basique
     *
     * @param carteBatiment, Carte Batiment
     * @param ouvrierMainJoueur, main ouvrier du joueur
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation affectationOuvrierBatimentBasique(CarteBatiment carteBatiment,MainJoueur<CarteOuvrier> ouvrierMainJoueur,InventaireJoueur inventaireJoueur,Identification moi)
    {

        int i = carteMainOuvrierNonNull(ouvrierMainJoueur);
        if(i != -1){

            if( ((ouvrierMainJoueur.getCarte(i).getEcu() - inventaireJoueur.getEcu()) > 0))
            {
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)> inventaireJoueur.getNbAction() && inventaireJoueur.getEcu()>5)
            {
                return getJoueur().achatNouvelleAction(moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)<= inventaireJoueur.getNbAction())
            {
                return getJoueur().affectationOuvrierBatiment(carteBatiment, ouvrierMainJoueur.getCarte(i),inventaireJoueur,moi);

            }
            else{
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
        }
        else{
            return null;
        }
    }


    /**
     * Operation qui permet d'affecter un ouvrier à un batiment pour Strategie Basique Antiquite
     *
     * @param carteBatiment, Carte Batiment
     * @param ouvrierMainJoueur, main ouvrier du joueur
     * @param carteOutilsMainJoueur, main outils du joueur
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @return une Operation
     */
    protected Operation affectationOuvrierBatimentBasiqueAntiquite(CarteBatiment carteBatiment, MainJoueur<CarteOuvrier> ouvrierMainJoueur, MainJoueur<CarteOutils> carteOutilsMainJoueur, InventaireJoueur inventaireJoueur, Identification moi)
    {


        int j = carteMainOuvrierNonNull(ouvrierMainJoueur);

        if(positionRentableOutil(carteOutilsMainJoueur.getCarte(0),ouvrierMainJoueur)!= -1 && !(ouvrierMainJoueur.getCarte(positionRentableOutil(carteOutilsMainJoueur.getCarte(0),ouvrierMainJoueur)) instanceof CarteEsclave) && ouvrierMainJoueur.getCarte(positionRentableOutil(carteOutilsMainJoueur.getCarte(0),ouvrierMainJoueur)).getCarteOutilsAssigne()==null){
            if( ((ouvrierMainJoueur.getCarte(positionRentableOutil(carteOutilsMainJoueur.getCarte(0),ouvrierMainJoueur)).getEcu() - inventaireJoueur.getEcu()) > 0))
            {
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)> inventaireJoueur.getNbAction() && inventaireJoueur.getEcu()>5)
            {
                return getJoueur().achatNouvelleAction(moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)<= inventaireJoueur.getNbAction())
            {
                return getJoueur().affectationOuvrierBatiment(carteBatiment, rentableOutil(carteOutilsMainJoueur.getCarte(0),ouvrierMainJoueur), carteOutilsMainJoueur.getCarte(0),inventaireJoueur,moi);
            }
            else{
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
        }
        else{
            if( ((inventaireJoueur.getMainOuvrier().getCarte(j).getEcu() - inventaireJoueur.getEcu()) > 0))
            {
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)> inventaireJoueur.getNbAction() && inventaireJoueur.getEcu()>5)
            {
                return getJoueur().achatNouvelleAction(moi);
            }
            else if(actionsNecessaire(carteBatiment,inventaireJoueur)<= inventaireJoueur.getNbAction())
            {
                return getJoueur().affectationOuvrierBatiment(carteBatiment, ouvrierMainJoueur.getCarte(j),inventaireJoueur,moi);
            }
            else{
                return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
            }
        }

    }

}
