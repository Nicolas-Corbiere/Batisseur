package carte;

import java.util.Objects;

/**Classes filles de la classe Carte representant un emprunt qu'un joueur affectuer en prennant la carte.
 * @see carte.Carte
 * @author Rethers Mathieu.
 */
public class CarteEmprunt extends Carte
{
    public static final int coutEcuRembourser = 15;

    private int ecuRembource;
    private int pointVictoire;

    /**
     * @param id represente l'identifiant de la carte en Integer.
     */
    public CarteEmprunt(int id)
    {
        super(id, "Emprunt", 10);
        ecuRembource = 15;
        pointVictoire = 2;
    }

    /**
     *
     */
    public CarteEmprunt()
    {
        super();
    }

    //----------------------------------------------- Methode Lecteur --------------------------------------------------

    /**
     * Retourne le nombre d'ecu que le joueur doit rembourser.
     * @return nombre d'ecu a rembourser.
     */
    public int getEcuRembource()
    {
        return ecuRembource;
    }

    /**
     * Retourne le nombre le nombre de points de victoire que le joueur risque de perdre s'il remboursepas.
     * @return nombre de points de victoire que la carte emprunt peut faire perdre.
     */
    public int getPointVictoire()
    {
        return pointVictoire;
    }

    //---------------------------------------------- Methode Lecteur ---------------------------------------------------

    /**
     *
     * @param ecuRembource
     */
    public void setEcuRembource(int ecuRembource)
    {
        this.ecuRembource = ecuRembource;
    }

    /**
     *
     * @param pointVictoire
     */
    public void setPointVictoire(int pointVictoire)
    {
        this.pointVictoire = pointVictoire;
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
        if (!(o instanceof CarteEmprunt)) return false;
        CarteEmprunt that = (CarteEmprunt) o;
        return super.equals(o)
                && ecuRembource == that.ecuRembource
                && pointVictoire == that.pointVictoire;
    }

    /**
     * génére un hashCode en Integer selon les attributs fixe.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @return hashCode en Integer.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), ecuRembource, pointVictoire);
    }
}
