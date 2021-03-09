package joueur.strategie;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import carte.GestionCarte.GestionCollectionCarte;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import operation.Operation;

import java.util.ArrayList;
import java.util.Map;


public abstract class StrategieIntelligent extends Strategie{

    public static final int Pierre = 0;
    public static final int Bois = 1;
    public static final int Savoir = 2;
    public static final int Tuile = 3;

    /**
     * Constructeur de StrategieIntelligent
     * @param niveau, niveau de la strategie
     * @param PestSilencieux
     */
    public StrategieIntelligent(int niveau, boolean PestSilencieux) {
		super(niveau, PestSilencieux);
	}


//----------------------PRESENTE-------------------------------------

    /**
     * Permet de trouver la carte batiment presente qui a le plus de point de victoire
     * @param batiment, Cartes Batiment Presentes
     * @see carte.cartesPresente.CartesPresente
     * @return une carte Batiment
     */
    public CarteBatiment estMeilleurePointVictoirePresente(CartesPresente<CarteBatiment> batiment) {

        int j = carteBatimentNonNull(batiment);
        CarteBatiment meilleure = batiment.getCarte(j);
        int int_meilleure = batiment.getCarte(j).getPointVictoire();
        for (CarteBatiment carte : batiment.lireCartes()) {
            if (carte != null && carte.getPointVictoire() > int_meilleure) {
                meilleure = carte;
                int_meilleure=meilleure.getPointVictoire();
            }
        }
        return meilleure;
    }



    /**
     * Permet de trouver la position de la carte batiment presente qui a le plus de point de victoire
     * @param batiment, tableau CarteBatiment qui correspond aux cartes batiments presenté
     * @see carte.cartesPresente.CartesPresente
     * @return --> indice supérieur ou égale à 0
     */
    public int PositionEstMeilleurePointVictoirePresente(CartesPresente<CarteBatiment> batiment)
    {
        int i = 0;
        int positionMeilleur = 0;
        int int_meilleure = 0;

        for (CarteBatiment carte : batiment.lireCartes())
        {

            if (carte != null && carte.getPointVictoire() > int_meilleure)
            {
                int_meilleure = carte.getPointVictoire();
                positionMeilleur = i;
            }
            i++;

        }

        return positionMeilleur;


    }
//---------------RESSOURCES-------------------

    /**
     * Permet de trouver l'indice de la carte ouvrier qui a le plus de Ressource en général.
     * @param ouvrier, Cartes Ouvrier Presentes
     * @see carte.cartesPresente.CartesPresente
     * @return un indice supérieur ou égale à 0
     */
    public int estMeilleureRessource(CartesPresente<CarteOuvrier> ouvrier) {

        int meilleure = 0;
        int result = 0;

        for (int c = 0; c < ouvrier.taille(); c++)
        {
            int cumul = 0;
            for (int i = 0; i < 4; i++)
            {
                if(!ouvrier.caseVide(c))
                {
                    cumul += ouvrier.getCarte(c).getRessource(i);
                }
            }

            if(cumul>meilleure)
            {
                meilleure=cumul;
                result = c;
            }
        }

        return result;
    }

}
