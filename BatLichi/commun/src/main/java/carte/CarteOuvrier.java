package carte;

/**Classe fille de la class carte qui represente un apprentie ou ouvrier
 *
 * @author Alexandre Lemoine 
 *
 */
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarteEsclave.class, name = "CarteEsclave"),
})

/**Classe fille de la classe carteRessource qui represente un ouvrier qui sera affecter selon le joueur à un chantier.
 * @see carte.CarteRessource
 * @author Alexandre Lemoine & Rethers Mathieu.
 */
public class CarteOuvrier extends CarteRessource
{
    private CarteUniversite carteUniversiteAssigne;
    private CarteOutils carteOutilsAssigne;

    /**
     * Constructeur de la CarteOuvrier.
     * @param id represente l'identifiant de la carte en Integer.
     * @param nom represente le nom de la carte en String.
     * @param ecu represente le cout d'ecue en Integer que le joueur doit pour l'obtenir.
     * @param ressourcesProduit represente le nombre de ressources qu'il produit pour un chantier.
     */
    public CarteOuvrier(int id, String nom, int[] ressourcesProduit, int ecu)
    {
        super(id,nom,ressourcesProduit,ecu);
        carteUniversiteAssigne = null;
        carteOutilsAssigne=null;
    }

    /**
     * Constructeur de la CarteOuvrier
     */
    public CarteOuvrier()
    {
        super();
    }

    //----------------------------------------------- Methode Ecriture --------------------------------------------------

    /**
     * Permet de s'avoir si l'ouvrier est instruit ou non et de savoir dans qu'elle université.
     * @see carte.CarteUniversite
     * @return null s'il n'est pas instruit ou une CarteUniversite s'il est instruit.
     */
    public CarteUniversite getCarteUniversiteAssigne()
    {
        return carteUniversiteAssigne;
    }

    /**
     * Permet de savoir si l'ouvrier posséde un outils et de s'avoir lequel.
     * @see carte.CarteOutils
     * @return null s'il a pas de carteOutils ou une CarteOutils s'il en a un.
     */
    public CarteOutils getCarteOutilsAssigne()
    {
        return carteOutilsAssigne;
    }

    //------------------------------------------------- Methode Lecture -----------------------------------------------

    /**
     *
     * @param carteOutilsAssigne
     */
    public void setCarteOutilsAssigne(CarteOutils carteOutilsAssigne)
    {
        this.carteOutilsAssigne = carteOutilsAssigne;
    }

    /***
     *
     * @param carteUniversiteAssigne
     */
    public void setCarteUniversiteAssigne(CarteUniversite carteUniversiteAssigne)
    {
        this.carteUniversiteAssigne = carteUniversiteAssigne;
    }

    //----------------------------------------------------- Methode ----------------------------------------------------

    /**
     * instruit l'ouvrier.
     * @param carteUniversite carteUniversite qui permettra d'instruire l'ouvrier.
     * @return vrai si la carteUniversite est assigné ou faux s'il est pas assigné.
     */
    public boolean assigneCarteUniversite(CarteUniversite carteUniversite)
    {
        if(!(this instanceof CarteEsclave) && carteUniversite!=null && this.carteUniversiteAssigne==null)
        {
            carteUniversiteAssigne = carteUniversite;
            return true;
        }
        return false;
    }

    /**
     * assigne un outils à l'ouvrier.
     * @param carteOutils carteOutils qui sera attribué à l'ouvrier.
     * @return vrai si la carteOutils est assigné ou faux s'il est pas assigné.
     */
    public boolean assignerCarteOutils(CarteOutils carteOutils)
    {
        if(!(this instanceof CarteEsclave) && carteOutils!=null && this.carteOutilsAssigne==null)
        {
            carteOutilsAssigne = carteOutils;
            return true;
        }
        return false;
    }

    /**
     * désassigne la carteOutils de l'ouvrier et le retourne.
     * @return la carteOutils désassigner.
     */
    public CarteOutils desassignerCarteOutils()
    {
        CarteOutils carteOutils = carteOutilsAssigne;
        carteOutilsAssigne = null;
        return carteOutils;
    }

    //---------------------------------------------- Methode Override --------------------------------------------------

    /**
     * Retourne un tableau Integer des ressources.
     * @see carte.CarteRessource
     * Prend en compte la CarteUniversite & la CarteOutils.
     * @return le tableau des ressources.
     */
    @Override
    public int[] getRessources()
    {
        return carteUniversiteAssigne==null && carteOutilsAssigne==null ? super.getRessources() : new int[]
                {
                        this.getRessource(CarteRessource.RessourcePierre),
                        this.getRessource(CarteRessource.RessourceBois),
                        this.getRessource(CarteRessource.RessourceSavoir),
                        this.getRessource(CarteRessource.RessourceTuile)
                };
    }

    /**
     * Retourne un Integer d'un ressource precise.
     * @see carte.CarteRessource
     * Prend en compte la CarteUniversite & la CarteOutils.
     * @param index de la ressource precise.
     * @return une ressource precise.
     */
    @Override
    public int getRessource(int index)
    {
        int ressourceUniversitaire = carteUniversiteAssigne==null ? super.getRessource(index) : Math.max(carteUniversiteAssigne.getRessource(index), super.getRessource(index));
        int ressourceOutils = carteOutilsAssigne==null ? 0 : carteOutilsAssigne.getRessource(index);
        return ressourceUniversitaire + ressourceOutils;
    }

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
        if (!(o instanceof CarteOuvrier)) return false;
        CarteOuvrier that = (CarteOuvrier) o;
        return super.equals(o) && Objects.equals(carteOutilsAssigne, that.carteOutilsAssigne) && Objects.equals(carteUniversiteAssigne, that.carteUniversiteAssigne);
    }

    /**
     * génére un hashCode en Integer selon les attributs fixe.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @return hashCode en Integer.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), carteUniversiteAssigne, carteOutilsAssigne);
    }
}
