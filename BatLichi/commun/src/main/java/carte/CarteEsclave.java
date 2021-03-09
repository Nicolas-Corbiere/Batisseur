package carte;

import java.util.Objects;

/**Classe fille de la classe CarteOuvrier representant une carte ouvrier spécial qui est en fait un esclave.<br/>
 * Un esclave peut etre affranchi afin de devenir un ouvrier classique.
 * @see carte.CarteOuvrier
 * Cette carte aillant l'interface IConvertionCarte peut retourner une n'autre type de carte.
 * @see carte.IConvertionCarte
 * @author Rethers Mathieu.
 */
public class CarteEsclave extends CarteOuvrier implements IConvertionCarte<CarteOuvrier>
{
    public static final int coutPoint = 1;
    public static final int coutAffranchie = 5;
    public static final int ecuAchat = 7;

    private CarteOuvrier versionCarteEsclaveAffranchi;

    public CarteEsclave(int id, String nom, int[] ressourcesProduit)
    {
        super(id, nom, ressourcesProduit, 0);
        versionCarteEsclaveAffranchi = new CarteOuvrier(this.getId(), "Affranchi", this.getRessources(), 4);
    }

    public CarteEsclave()
    {
        super();
    }


    //----------------------------------------------- Methode Lecteur --------------------------------------------------

    /**
     *
     * @return
     */
    public CarteOuvrier getVersionCarteEsclaveAffranchi()
    {
        return versionCarteEsclaveAffranchi;
    }

    //---------------------------------------------- Methode Ecriture --------------------------------------------------

    /**
     *
     * @param versionCarteEsclaveAffranchi
     */
    public void setVersionCarteEsclaveAffranchi(CarteOuvrier versionCarteEsclaveAffranchi)
    {
        this.versionCarteEsclaveAffranchi = versionCarteEsclaveAffranchi;
    }

    //----------------------------------------------- Methode Override -------------------------------------------------

    /**
     * Retourne une nouvelle version de la carteEsclave en carteOuvrier.
     * @return carte.CarteOuvrier
     */
    @Override
    public CarteOuvrier getOtherVesionCarte()
    {
        return versionCarteEsclaveAffranchi;
    }

    /**
     *
     * @param version
     */
    @Override
    public void setOtherVesionCarte(CarteOuvrier version)
    {
        versionCarteEsclaveAffranchi = version;
    }

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
        if (!(o instanceof CarteEsclave)) return false;
        CarteEsclave that = (CarteEsclave) o;
        return super.equals(o) && versionCarteEsclaveAffranchi.equals(that.getVersionCarteEsclaveAffranchi());
    }

    /**
     * génére un hashCode en Integer selon les attributs fixe.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html">Object</a>
     * @return hashCode en Integer.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), versionCarteEsclaveAffranchi);
    }
}
