package carte;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Represente une pile de carte.</br>
 * C'est une class generique qui (apres instenciation) accepte seulement la class filles choisi de la class Carte.
 * @author Alexandre Lemoine (associé : Rethers Mathieu and Nicolas Corbier).
 * @param <E> Typage de Carte.
 */
public class PileDeCarte <E extends Carte>
{
    private ArrayList<E> pileDeCarte;

    /**
     *
     */
    public PileDeCarte()
    {

    }

    /**
     * Constructeur de PileDeCarte.<br/>
     * Mélange les cartes automatiquement.
     * @param listeCarte collection de cartes.
     */
    public PileDeCarte(Collection<E> listeCarte)
    {
        this.pileDeCarte=new ArrayList<>(listeCarte);
        // methode qui permet de melanger la carte
        Collections.shuffle(pileDeCarte);
    }

    /**
     * Constructeur de PileDeCarte.<br/>
     * Mélange les cartes automatiquement.
     * @param listesCarte un ensemble de collections de cartes.
     */
    public PileDeCarte(ArrayList<? extends E>... listesCarte)
    {
        this.pileDeCarte= new ArrayList<E>();
        for (ArrayList<? extends E> pile: listesCarte)
        {
            pileDeCarte.addAll(pile);
        }
        // methode qui permet de melanger la carte
        Collections.shuffle(pileDeCarte);
    }

    //------------------------------------------------ Méthodes Lecteur ------------------------------------------------

    /**
     *
     * @return
     */
    public ArrayList<E> getPileDeCarte()
    {
        return pileDeCarte;
    }

    //------------------------------------------------- Méthodes Ecriture ----------------------------------------------

    /**
     *
     * @param pileDeCarte
     */
    public void setPileDeCarte(ArrayList<E> pileDeCarte)
    {
        this.pileDeCarte = pileDeCarte;
    }

    //---------------------------------------------------- Méthodes ----------------------------------------------------

    /**
     * Retourne la premiere et la supprime de la pile.
     * @return null s'il y a plus de carte ou une Carte.
     */
    public E prendrePremiereCarte()
    {
        if(pileDeCarte.isEmpty()) return null;

        E carte = pileDeCarte.get(0);
        pileDeCarte.remove(0);

        return carte;

    }

    /**
     * Retourne vrai ou faux si la pile est vide.
     * @return vrai s'il est vide sinon faux.
     */
    public boolean estVide()
    {
        return pileDeCarte.isEmpty();
    }

    /**
     * Retourne le nombre de carte dans la pile.
     * @return le nombre de carte dans la pile.
     */
    public int longueurArray()
    {
        return pileDeCarte.size();
    }

    //------------------------------------------------- Méthodes Override ----------------------------------------------

    /**
     * verifie que la carte posséde les meme attribut fixe de la carte.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @param o
     * @return boolean.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof PileDeCarte)) return false;
        PileDeCarte<?> that = (PileDeCarte<?>) o;
        return pileDeCarte.equals(that.pileDeCarte);
    }

    /**
     * génére un hashCode en Integer selon les attributs fixe.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @return hashCode en Integer.
     */

    @Override
    public int hashCode()
    {
        return Objects.hash(pileDeCarte);
    }
}
