package operation.investissement;

import carte.CarteOuvrier;
import carte.CarteUniversite;
import carte.cartesPresente.CartesPresente;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpInstruire extends OperationInvestissement{

    CartesPresente<CarteUniversite> cartesUniversité;
    CarteOuvrier ouvrier;


    /**
     *
     * Operation qui permet au joueur d'instruire un ouvrier
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     * @param cartesUniversité carte université qui à était tirer par le joueur
     * @param ouvrier qui vas être instruit
     *
     */
    public OpInstruire(LoggerTrace logger, Identification id, CartesPresente<CarteUniversite> cartesUniversité, CarteOuvrier ouvrier) {
        super(logger, id);
        this.cartesUniversité = cartesUniversité;
        this.ouvrier = ouvrier;
    }

    /**
     *
     * Operation qui permet au joueur d'instruire un ouvrier
     *
     */
    public OpInstruire() {
        super(null, null);

    }

    /**
     * Permet d'effectuer l'operation d'investissement 'instruire ouvrier'
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperationInvestissement(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        if(!moteur.getInventaireDuJoueur(joueur).isInvestissementFait() && moteur.getInventaireDuJoueur(joueur).getEcu() >= 7 )
        {
            if(ouvrier.assigneCarteUniversite(moteur.getUniversitePresent()))
            {

                moteur.getInventaireDuJoueur(joueur).suppressionEcu(7);
                utiliseAction(1,moteur.getInventaireDuJoueur(joueur));
                moteur.getInventaireDuJoueur(joueur).investissementFait();
                getLogger().afficheMessageTrace(joueur.getNom() + " a pioché une carte universite et l'a affecté à son ouvrier");
            }
            else{
                getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas instruire");

            }

        }
        else{
            getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas piocher la carte investissement");

        }
    }

    public CartesPresente<CarteUniversite> getCartesUniversité() {
        return cartesUniversité;
    }

    public void setCartesUniversité(CartesPresente<CarteUniversite> cartesUniversité) {
        this.cartesUniversité = cartesUniversité;
    }

    public CarteOuvrier getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(CarteOuvrier ouvrier) {
        this.ouvrier = ouvrier;
    }
}
