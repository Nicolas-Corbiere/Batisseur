package carte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarteMachine.class, name = "CarteMachine"),

})

/**
 * Classe fille de la classe CarteRessource representant une carte de batiment.
 * @see carte.CarteRessource
 * @author Alexandre Lemoine.
 */
public class CarteBatiment extends CarteRessource
{
    private int pointVictoire; //point de victoire recupere apres la construction
    private boolean batimentTerminé; // permet de voir si le chantier est en cours ou finie (a voir)
    private int[] ressourcesActuel;
    private ArrayList<CarteOuvrier> listeOuvrier = new ArrayList<>();

    /**
     * Constructeur CarteBatiment.
     * @param id represente l'identifiant de la carte en Integer.
     * @param nom represente le nom de la carte en String.
     * @param ecu represente le cout de la carte en ecue en Integer.
     * @param ressourcesNecessaire represente les ressources Necessaire la construction du batiment.
     * @param pointVictoire represente les points que les joueurs peuvent gagner lorsque ce batiment est finie.
     */
    public CarteBatiment(int id, String nom,int[] ressourcesNecessaire ,int ecu,int pointVictoire)
    {
        super(id, nom,ressourcesNecessaire,ecu);
        this.pointVictoire = pointVictoire;
        this.batimentTerminé = false;
        ressourcesActuel = new int[]{0,0,0,0};
    }

    /**
     *
     */
    public CarteBatiment()
    {
        super();
    }

    //----------------------------------------------- Methode Lecteur --------------------------------------------------

    /**
     * Permet de savoir si le batiment est en chantier.
     * @return vrai si le chantier est finie et faux si le chantier n'est pas finie.
     */
    public boolean isBatimentTerminé()
    {
        return batimentTerminé;
    }

    /**
     * retournes une tableau de Integer representant les ressources actuel du batiment qui lui permet d'etre construit.
     * @return les ressources que le batiment a pour se construire.
     */
    public int[] getRessourcesActuel()
    {
    	return ressourcesActuel;
    }

    /**
     * retournes un Integer representant une resssources actuel précise.
     * @param index permet de préciser la ressource.
     * @return la ressource précise que le batiment a pour se construire.
     */
    public int getRessourceActuel(int index)
    {
        return ressourcesActuel[index];
    }

    /**
     * Retourne les points de victoire qu'apporte le batiment.
     * @return les points de victoire.
     */
    public int getPointVictoire ()
    {
        return pointVictoire;
    }

    /**
     * Permet de savoir si le batiment est en chantier.
     * @return vrai si le chantier est finie et faux si le chantier n'est pas finie.
     */
    public boolean estBatimentTerminé()
    {
        return batimentTerminé;
    }

    //----------------------------------------------- Methode Ecriture -------------------------------------------------

    /**
     * permet de modifier l'attribut batimentTerminé.
     * @param batimentEnChantier Mettre un boolean.
     */
    public void setBatimentTerminé(boolean batimentEnChantier)
    {
        this.batimentTerminé = batimentEnChantier;
    }

    /**
     *
     * @param ressourcesActuel
     */
    public void setRessourcesActuel(int[] ressourcesActuel)
    {
        this.ressourcesActuel = ressourcesActuel;
    }

    /**
     *
     * @param pointVictoire
     */
    public void setPointVictoire(int pointVictoire)
    {
        this.pointVictoire = pointVictoire;
    }

    //-------------------------------------------------- Methode -------------------------------------------------------

    /**
     * ajoute les ressources pour savoir si le batiment est finie ou non.
     * @param ressourceAjouter Mettre un tableau de Integer representant les ressources.
     */
    public void ajouteRessource(int[] ressourceAjouter)
    {
        ressourceAjouter = Arrays.copyOf(ressourceAjouter, 4);
        for(int i =0; i<ressourcesActuel.length; i++)
        {
            ressourcesActuel[i]+=ressourceAjouter[i];
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<CarteOuvrier> supprimeToutOuvrier()
    {
        ArrayList<CarteOuvrier> carteOuvriers = (ArrayList<CarteOuvrier>) listeOuvrier.clone();
        listeOuvrier.clear();
        return carteOuvriers;
    }

    /**
     *
     * @param ouvrier
     */
    public void ajoutOuvrier(CarteOuvrier ouvrier)
    {
        listeOuvrier.add(ouvrier);
    }

    /**
     *
     * @return
     */
    public boolean estVide()
    {
        return listeOuvrier.isEmpty();
    }

    /**
     *
     * @param carteOuvrier
     * @return
     */
    public boolean containsOuvrier(CarteOuvrier carteOuvrier)
    {
        return listeOuvrier.contains(carteOuvrier);
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
        if (!(o instanceof CarteBatiment)) return false;

        CarteBatiment batiment = (CarteBatiment) o;
        return super.equals(o)
                && pointVictoire == batiment.pointVictoire;
    }

    /**
     * génére un hashCode en Integer selon les attributs fixe.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @return hashCode en Integer.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), pointVictoire);
    }


}











