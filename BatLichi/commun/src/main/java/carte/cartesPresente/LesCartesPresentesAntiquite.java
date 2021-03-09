package carte.cartesPresente;

import carte.*;

/**Classe fille de la classe LesCartesPresentesMoyenAge.<br/>
 * Cette classe posséde en attribut les CartesPresente nécessaire (cartesBatimentsPresentes, cartesOuvriersPresentes, carteEmpruntPresente, carteEsclavePresente, carteUniversitePresente, carteOutilsCartesPresente) au partie du ModeDeJeu Antiquité.
 * @see carte.cartesPresente.LesCartesPresentes
 * @see carte.cartesPresente.LesCartesPresentesMoyenAge
 * @see carte.cartesPresente.CartesPresente
 * @see modeDeJeu.ModeDeJeu
 */
public class LesCartesPresentesAntiquite extends LesCartesPresentesMoyenAge
{
    private CartesPresente<CarteEmprunt> carteEmpruntPresente;
    private CartesPresente<CarteEsclave> carteEsclavePresente;
    private CartesPresente<CarteUniversite> carteUniversitePresente;
    private CartesPresente<CarteOutils> carteOutilsCartesPresente;

    /**
     * Constructeur de LesCartesPresentesAntiquite
     */
    public LesCartesPresentesAntiquite()
    {
        super();
    }

    /**
     * Constructeur de LesCartesPresentesAntique
     * @param pileBatiment Pile de Carte Batiment qui sera associé à cartesBatimentsPresentes.
     * @param pileOuvrier Pile de Carte Ouvrier qui sera associé à cartesOuvriersPresentes.
     * @param pileEmprunt Pile de Carte Emprunt qui sera associé à carteEmpruntPresente.
     * @param pileEsclave Pile de Carte Esclave qui sera associé à carteEsclavePresente.
     * @param pileUniversite Pile de Carte Université qui sera associé à carteUniversitePresente.
     * @param pileOutils Pile de Carte Outils qui sera associé à carteOutilsCartesPresente.
     */
    public LesCartesPresentesAntiquite(PileDeCarte<CarteBatiment> pileBatiment, PileDeCarte<CarteOuvrier> pileOuvrier, PileDeCarte<CarteEmprunt> pileEmprunt, PileDeCarte<CarteEsclave> pileEsclave, PileDeCarte<CarteUniversite> pileUniversite, PileDeCarte<CarteOutils> pileOutils)
    {
        super(pileBatiment, pileOuvrier);
        carteEmpruntPresente = new CartesPresente<>(1, pileEmprunt);
        carteEsclavePresente = new CartesPresente<>(1, pileEsclave);
        carteUniversitePresente = new CartesPresente<>(1, pileUniversite);
        carteOutilsCartesPresente = new CartesPresente<>(1, pileOutils);
    }

    /**
     * Lecture de CartesPresente de CarteEmprunt
     * @return CartePresente/<CarteEmprunt>
     */
    public CartesPresente<CarteEmprunt> getCarteEmpruntPresente()
    {
        return carteEmpruntPresente;
    }

    /**
     * Ecriture de CartePresente de CarteEmprunt
     * @param carteEmpruntPresente
     */
    public void setCarteEmpruntPresente(CartesPresente<CarteEmprunt> carteEmpruntPresente)
    {
        this.carteEmpruntPresente = carteEmpruntPresente;
    }

    /**
     * Lecture de CartesPresente de CarteEsclave
     * @return CartePresente/<CarteEsclave>
     */
    public CartesPresente<CarteEsclave> getCarteEsclavePresente()
    {
        return carteEsclavePresente;
    }

    /**
     * Ecriture de CartePresente de CarteEmprunt
     * @param carteEsclavePresente
     */
    public void setCarteEsclavePresente(CartesPresente<CarteEsclave> carteEsclavePresente)
    {
        this.carteEsclavePresente = carteEsclavePresente;
    }

    /**
     * Lecture de CartesPresente de CarteUniversite
     * @return CartePresente/<CarteUniversite>
     */
    public CartesPresente<CarteUniversite> getCarteUniversitePresente()
    {
        return carteUniversitePresente;
    }

    /**
     * Ecriture de CartePresente de CarteEmprunt
     * @param carteUniversitePresente
     */
    public void setCarteUniversitePresente(CartesPresente<CarteUniversite> carteUniversitePresente)
    {
        this.carteUniversitePresente = carteUniversitePresente;
    }

    /**
     * Lecture de CartesPresente de CarteOutils
     * @return CartePresente/<CarteOutils>
     */
    public CartesPresente<CarteOutils> getCarteOutilsCartesPresente()
    {
        return carteOutilsCartesPresente;
    }

    /**
     * Ecriture de CartePresente de CarteEmprunt
     * @param carteOutilsCartesPresente
     */
    public void setCarteOutilsCartesPresente(CartesPresente<CarteOutils> carteOutilsCartesPresente)
    {
        this.carteOutilsCartesPresente = carteOutilsCartesPresente;
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
        if(classCarte.equals(CarteEmprunt.class)) return (CartesPresente<T>) carteEmpruntPresente;
        if(classCarte.equals(CarteEsclave.class)) return (CartesPresente<T>) carteEsclavePresente;
        if(classCarte.equals(CarteUniversite.class)) return (CartesPresente<T>) carteUniversitePresente;
        if(classCarte.equals(CarteOutils.class)) return (CartesPresente<T>) carteOutilsCartesPresente;
        return super.getCartesPresente(classCarte);
    }

    /**
     * Permet de retourner un objet CartesPresente avec son Typage de Carte.
     * @param classCarte parametre qui permettra d'indiquer le typage de carte d'un objet CartesPresente possède.
     * @param <T> Typage de Carte
     * @return Un Objet de la classe CartesPresente ou un null s'il ne trouve pas
     */
    @Override
    public <T extends Carte> T prendreCarte(Class<T> classCarte, int index)
    {
        if(classCarte.equals(CarteEmprunt.class)) return (T) carteEmpruntPresente.prendreCarte(index);
        if(classCarte.equals(CarteEsclave.class)) return (T) carteEsclavePresente.prendreCarte(index);
        if(classCarte.equals(CarteUniversite.class)) return (T) carteUniversitePresente.prendreCarte(index);
        if(classCarte.equals(CarteOutils.class)) return (T) carteOutilsCartesPresente.prendreCarte(index);
        return super.prendreCarte(classCarte, index);
    }
}
