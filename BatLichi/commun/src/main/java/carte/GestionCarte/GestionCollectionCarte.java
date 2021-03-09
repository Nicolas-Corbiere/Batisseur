package carte.GestionCarte;

import carte.*;
import mainJoueur.MainJoueur;

import java.util.*;

/**
 * Classe possédant seulement des methodes statisque qui gérer des Collections ou des tableaux de Carte.
 * @author Alcaraz Yannick & Rethers Mathieu.
 */
public class GestionCollectionCarte
{
    /**
    * Supprime tout les null present dans la collection.
    * @param collection Collection dont on va supprimer les nulls.
    * @param <T> Typage de Carte.
    */
    public static <T extends Carte> void removeAllNullCarte(Collection<? extends T> collection)
    {

        while(collection.remove(null)) { }
    }


    /**
     * Compte le nombre de fois la carte est presente dans la collection.
     * @param collection Collection dont on regarde les elements.
     * @param carte Carte a regarder.
     * @param <T> Typage de Carte.
     * @return le nombre Carte dans la collection.
     */
    public static <T extends Carte> int countCarte(Collection<? extends T> collection, T carte)
    {
        int count = 0;
        for(T aCarte : collection)
        {
            if(carte.hashCode() == aCarte.hashCode()) count++;
        }
        return count;
    }

    /**
     * Compte le nombre de fois la carte est presente dans le tableau.
     * @param collection Tableau dont on regarde les elements.
     * @param carte Carte a regarder.
     * @param <T> Typage de Carte.
     * @return le nombre Carte dans la collection.
     */
    public static <T extends Carte> int countCarte(T[] collection, T carte)
    {
        int count = 0;
        for(T aCarte : collection)
        {
            if(carte.hashCode() == aCarte.hashCode()) count++;
        }
        return count;
    }

    /**
     * Retourne vrai si la collection contient un Objet de class type.
     * @param collection la collection à lire.
     * @param type La Class a trouver.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html">Class<T>.</></a>
     * @param <T> Typage de la Carte selon la collection.
     * @param <E> Typage de la Carte selon la Class à chercher.
     * @return vrai s'il y un Objet de cette classe sinon faux.
     */

    public static <T extends Carte, E extends Carte> boolean containsTypeCarte(MainJoueur<? extends T> collection, Class<E> type)
    {
        for(T carte : collection.getCartes())

        {
            if(carte.getClass() == type)return true;
        }
        return false;
    }
}
