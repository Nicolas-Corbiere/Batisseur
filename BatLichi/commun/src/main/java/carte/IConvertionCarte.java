package carte;

/**Interface qui permet de convertir une carte.
 * @param <E> Typage de Carte.
 */
public interface IConvertionCarte<E extends Carte>
{
    /**
     * Retourne une Carte selon le Typage E.
     * @return une carte.
     */
    public E getOtherVesionCarte();

    /**
     *
     * @param version
     */
    void setOtherVesionCarte(E version);
}
