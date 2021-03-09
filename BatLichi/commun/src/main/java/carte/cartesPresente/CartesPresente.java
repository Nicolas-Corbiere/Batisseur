package carte.cartesPresente;

import carte.Carte;
import carte.PileDeCarte;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Carte.class, name = "Carte"),
})

/**Represente les Cartes qui sont proposé dans la partie afin que les joueurs puissent regarder, choisir et prendre une carte.<br/>
 * Un Objet PileDeCarte doit etre associé afin que CartesPresente puissent ce repmlir.
 * @see carte.PileDeCarte
 * @param <E> Typage des Cartes.
 */
public class CartesPresente<E extends Carte>
{
    private Carte[] cartes;
    private PileDeCarte<E> pileDeCarte;

    /**
     * Represente les Cartes qui sont proposé dans la partie afin que les joueurs puissent regarder, choisir et prendre une carte.<br/>
     * Un Objet PileDeCarte doit etre associé afin que CartesPresente puissent ce repmlir.
     * @see carte.PileDeCarte
     * @param pileDeCarte Pile De Carte.
     */
    public CartesPresente(int nombreCarteMaximum, PileDeCarte<E> pileDeCarte)
    {
        cartes = new Carte[nombreCarteMaximum];
        this.pileDeCarte = pileDeCarte;
        this.remplir();
    }

    /**
     * Constructeur de CartesPresente
     */
    public  CartesPresente()
    {

    }

    //------------------------------------------------- Methode Lecteur ------------------------------------------------

    /**
     * Lecture tableau de carte
     * @return
     */
    public Carte[] getCartes()
    {
        return cartes;
    }

    /**
     * Lecture de la pile de carte
     * @return
     */
    public PileDeCarte<E> getPileDeCarte()
    {
        return pileDeCarte;
    }

    //------------------------------------------------- Methode Ecriture -----------------------------------------------

    /**
     * Ecriture tableau de carte
     * @param cartes
     */
    public void setCartes(Carte[] cartes)
    {
        this.cartes = cartes;
    }

    /**
     * Ecriture PileDeCarte
     * @param pileDeCarte
     */
    public void setPileDeCarte(PileDeCarte<E> pileDeCarte)
    {
        this.pileDeCarte = pileDeCarte;
    }

    //-------------------------------------------------- Methode -------------------------------------------------------

    /**
     * retourne le nombre de carte que l'objet peut présenté.
     * @return le nombre de carte que l'objet peut présenté.
     */
    public int taille()
    {
        return cartes.length;
    }

    /**
     * retourne une ArrayList des cartes presenté. <u>Permet seulement de lire!</u>
     * @return une ArrayList.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html">ArrayList</a>
     */
    public ArrayList<E> lireCartes()
    {
        ArrayList<E> lesCartes = new ArrayList<E>();
        for(Carte o : cartes)
        {
            lesCartes.add((E) o);
        }
        return lesCartes;
    }

    /**
     * retourne une carte afin de pouvoir le lire. <u>Permet seulement de lire!</u>
     * @param index index de la carte a lire.
     * @return une carte.
     */
    public E getCarte(int index)
    {
        return (E) cartes[index];
    }

    /**
     * retourne une carte et supprime la carte de l'objet CartePresente.<br/>
     * <u>Cette methode recharge l'Objet de carte toute seul!</u>
     * @param index index de la carte a prendre.
     * @return une carte.
     */
    public E prendreCarte(int index)
    {
        E carte = (E) cartes[index];
        cartes[index] = pileDeCarte.prendrePremiereCarte();
        return carte;
    }

    /**
     * Permet de savoir si selon l'index la carte est null.
     * @param index index de la carte a prendre.
     * @return vrai si null sinon faux.
     */
    public boolean caseVide(int index)
    {
        return getCarte(index)==null;
    }

    /**
     * Permet de savoir toutes les cartes sont null.
     * @return vrai si il y a que des nulls.
     */
    public boolean vide()
    {
        for(Carte o : cartes)
        {
            if(o!=null) return false;
        }
        return true;
    }


    /**
     * Permet de savoir si la CartesPresente posséde une ou plusieurs place vide
     * @return
     */
    public boolean placeVide()
    {
        for(Carte o : cartes)
        {
            if(o == null) return true;
        }
        return false;
    }

    /**
     * Permet de savoir s'il y a au moins des nulls.
     * @return vrai si il a au moins un null.
     */
    public void remplir()
    {
        for(int i = 0; i < cartes.length; i++)
        {
            if(cartes[i]==null) cartes[i]=pileDeCarte.prendrePremiereCarte();
        }
    }


}
