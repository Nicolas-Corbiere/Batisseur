package carte.cartesPresente;

import carte.*;

/**Classe fille de la classe LesCartesPresentes.<br/>
 * Cette classe posséde en attribut les CartesPresente nécessaire (cartesBatimentsPresentes & cartesOuvriersPresentes) au partie du ModeDeJeu MoyenAge.
 * @see carte.cartesPresente.LesCartesPresentes
 * @see carte.cartesPresente.CartesPresente
 * @see modeDeJeu.ModeDeJeu
 */
public class LesCartesPresentesMoyenAge extends LesCartesPresentes
{
    private CartesPresente<CarteBatiment> cartesBatimentPresentes;
    private CartesPresente<CarteOuvrier> cartesOuvrierPresentes;

    /**
     * Constructeur LesCartesPresentesMoyenAge.<br/>
     * @param pileBatiment Pile de Carte Batiment qui sera associé à cartesBatimentsPresentes.
     * @param pileOuvrier Pile de Carte Ouvrier qui sera associé à cartesOuvriersPresentes.
     * @see carte.cartesPresente.CartesPresente
     */
    public LesCartesPresentesMoyenAge(PileDeCarte<CarteBatiment> pileBatiment, PileDeCarte<CarteOuvrier> pileOuvrier)
    {
        super();
        cartesBatimentPresentes = new CartesPresente<>(5, pileBatiment);
        cartesOuvrierPresentes = new CartesPresente<>(5, pileOuvrier);
    }

    /**
     * Constructeur de LesCartesPresentesMoyenAge
     */
    public LesCartesPresentesMoyenAge()
    {
        super();
    }

    /**
     * Lecture
     * @return CartePresente<CarteBatiment>
     */
    public CartesPresente<CarteBatiment> getCartesBatimentPresentes()
    {
        return cartesBatimentPresentes;
    }

    /**
     * Lecture
     * @return CartePresente<CarteBatiment>
     */
    public CartesPresente<CarteOuvrier> getCartesOuvrierPresentes()
    {
        return cartesOuvrierPresentes;
    }

    /**
     * Ecriture
     * @param cartesBatimentPresentes
     */
    public void setCartesBatimentPresentes(CartesPresente<CarteBatiment> cartesBatimentPresentes)
    {
        this.cartesBatimentPresentes = cartesBatimentPresentes;
    }

    /**
     * Ecriture
     * @param cartesOuvrierPresentes
     */
    public void setCartesOuvrierPresentes(CartesPresente<CarteOuvrier> cartesOuvrierPresentes)
    {
        this.cartesOuvrierPresentes = cartesOuvrierPresentes;
    }

    /**
     * Permet de retourner un objet CartesPresente avec son Typage de Carte.
     * @param classCarte parametre qui permettra d'indiquer le typage de carte d'un objet CartesPresente possède.
     * @param <T> Typage de Carte
     * @return Un Objet de la classe CartesPresente ou un null s'il ne trouve pas
     */
    @Override
    public <T extends Carte> CartesPresente<T> getCartesPresente(Class<T> classCarte)
    {
        if(classCarte.equals(CarteBatiment.class)) return (CartesPresente<T>) cartesBatimentPresentes;
        if(classCarte.equals(CarteOuvrier.class)) return (CartesPresente<T>) cartesOuvrierPresentes;
        return null;
    }

    /**
     * Permet de prendre une carte d'une CartesPresente avec son Typage
     * @param classCarte parametre qui permettra d'indiquer le typage de carte d'un objet CartesPresente possède.
     * @param index index de la carte à prendre dans un objet de la classe CartesPresente
     * @param <T> Typage de Carte
     * @return Un Objet de la Classe Carte selon le typage de Carte demandé ou sinon un null s'il trouve pas la CartesPresente correspondante ou la Carte demandé
     */
    @Override
    public <T extends Carte> T prendreCarte(Class<T> classCarte, int index)
    {
        if(classCarte.equals(CarteBatiment.class)) return (T) cartesBatimentPresentes.prendreCarte(index);
        if(classCarte.equals(CarteOuvrier.class)) return (T) cartesOuvrierPresentes.prendreCarte(index);
        return null;
    }

}
