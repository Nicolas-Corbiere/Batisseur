package carte;

import java.util.Arrays;
import java.util.Objects;

/** Represente une carte (soit les données de base de la carte).
 * Elle est abstract!
 *
 * @author Alexandre Lemoine 
 *
 */


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarteEmprunt.class, name = "CarteEmprunt"),
        @JsonSubTypes.Type(value = CarteRessource.class, name = "CarteRessource"),
})

/**
 * Represente une carte (soit les données de base de la carte).
 * Elle est abstract, elle est instanciable via les classes filles de la classe!
 * @author Alexandre Lemoine.
 */
public abstract class Carte
{

    private int id; //identifiant de la carte
    private String nom; //nom de la carte (un meme nom peut etre possede par plusieurs cartes)
    private int ecu;

    /**
     * Constructeur de la Carte.
     * @param id represente l'identifiant de la carte en Integer.
     * @param nom represente le nom de la carte en String.
     * @param ecu represente le nombre ecue en Integer.
     */
    public Carte(int id, String nom, int ecu)
    {
        this.id=id;
        this.nom=nom;
        this.ecu = ecu;
    }

    /**
     * Constructeur de la Carte
     */
    public Carte() {

    }
    //----------------------------------------------- Methode Lecteur --------------------------------------------------

    /**
     * retourne l'identifiant de la carte.
     * @return l'identifiant de la carte.
     */
    public int getId()
    {
        return id;
    }

    /**
     * retourne le nom de la carte.
     * @return le nom de la carte.
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * retourne le nombre ecu de la carte.
     * @return le nombre d'ecu.
     */
    public int getEcu()
    {
        return ecu;
    }

    //---------------------------------------------- Methode Ecriture --------------------------------------------------

    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    /**
     *
     * @param ecu
     */
    public void setEcu(int ecu)
    {
        this.ecu = ecu;
    }

    //---------------------------------------------- Methode Override --------------------------------------------------

    /**
     * verifie que la carte posséde les meme attribut fixe de la carte.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Carte) || o==null) return false;
        Carte carte = (Carte) o;
        return id == carte.id
                && ecu == carte.ecu
                && nom.equals(carte.nom);
    }

    /**
     * génére un hashCode en Integer selon les attributs fixe.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @return hashCode en Integer.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(id, nom, ecu);
    }
}
