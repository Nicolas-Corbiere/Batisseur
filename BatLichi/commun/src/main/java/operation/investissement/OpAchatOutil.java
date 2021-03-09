package operation.investissement;

import carte.CarteOutils;
import carte.cartesPresente.CartesPresente;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpAchatOutil extends OperationInvestissement{

    private CartesPresente<CarteOutils> outils;

    /**
     * Operation qui permet au joueur d'acheter un outils
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     * @param outils pile de carte outils
     */
    public OpAchatOutil(LoggerTrace logger, Identification id, CartesPresente<CarteOutils> outils) {
        super(logger, id);
        this.outils = outils;
    }

    /**
     * Operation qui permet au joueur d'acheter un outils
     *
     */
    public OpAchatOutil() {
        super(null, null);
    }

    /**
     * Permet d'effectuer l'operation d'investissement d'achat d'un outils
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperationInvestissement(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        // si un investissement à déjà était fait, je ne fait rien
        if(!moteur.getInventaireDuJoueur(joueur).isInvestissementFait() && moteur.getInventaireDuJoueur(joueur).getEcu() >= 2 ) {
            //moteur.getInventaireDuJoueur(joueur).getMainOutils().ajoutCarte(moteur.getOutilsPresent());
            moteur.getOutilsPresent();
            moteur.getInventaireDuJoueur(joueur).suppressionEcu(2);
            utiliseAction(1,moteur.getInventaireDuJoueur(joueur));
            investissementFait(moteur.getInventaireDuJoueur(joueur));

            getLogger().afficheMessageTrace(joueur.getNom() + " a pioché une carte outils");
        }
        else{
            getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas piocher une carte outils");

        }
    }

    public CartesPresente<CarteOutils> getOutils() {
        return outils;
    }

    public void setOutils(CartesPresente<CarteOutils> outils) {
        this.outils = outils;
    }
}
