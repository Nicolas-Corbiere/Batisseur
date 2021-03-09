package operation.investissement;

import carte.CarteEsclave;
import carte.cartesPresente.CartesPresente;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpAchatEsclave extends OperationInvestissement {

    private CartesPresente<CarteEsclave> esclave;

    /**
     *
     * Operation qui permet au joueur d'acheter un esclave
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     */
    public OpAchatEsclave(LoggerTrace logger, Identification id,CartesPresente<CarteEsclave> esclave) {
        super(logger, id);
        this.esclave = esclave;
    }

    /**
     *
     * Operation qui permet au joueur d'acheter un esclave
     *
     */
    public OpAchatEsclave() {
        super(null,null);
    }

    /**
     * Permet d'effectuer l'operation d'investissement d'achat d'un esclave
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperationInvestissement(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        // si un investissement à déjà était fait, je ne fait rien
        if(!moteur.getInventaireDuJoueur(joueur).isInvestissementFait() && moteur.getInventaireDuJoueur(joueur).getEcu() >= 7) {
            //moteur.getInventaireDuJoueur(joueur).getMainOuvrier().ajoutCarte(moteur.getEsclavePresent());
            moteur.getEsclavePresent();
            //remove carte esclave de carte presente
            moteur.getInventaireDuJoueur(joueur).suppressionEcu(7);
            utiliseAction(1,moteur.getInventaireDuJoueur(joueur));
            investissementFait(moteur.getInventaireDuJoueur(joueur));

            getLogger().afficheMessageTrace(joueur.getNom() + " a pioché une carte esclave ");

        }
        else{
            getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas piocher une carte esclave");
        }
    }

    public CartesPresente<CarteEsclave> getEsclave() {
        return esclave;
    }

    public void setEsclave(CartesPresente<CarteEsclave> esclave) {
        this.esclave = esclave;
    }
}
