package operation.investissement;

import carte.CarteEmprunt;
import carte.cartesPresente.CartesPresente;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpEmprunt extends OperationInvestissement {


    private CartesPresente<CarteEmprunt>  carteEmprunt;

    /**
     * Operation qui permet au joueur de faire un emprunt
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     * @param carteEmprunt pile de carte emprunt
     */
    public OpEmprunt(LoggerTrace logger, Identification id, CartesPresente<CarteEmprunt> carteEmprunt) {
        super(logger, id);
        this.carteEmprunt = carteEmprunt;
    }

    /**
     * Operation qui permet au joueur de faire un emprunt
     *
     */
    public OpEmprunt() {
        super(null, null);
    }


    /**
     * Permet d'effectuer l'operation d'investissement 'faire un emprunt'
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperationInvestissement(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        // si un investissement à déjà était fait, je ne fait rien
        if(!moteur.getInventaireDuJoueur(joueur).isInvestissementFait() && moteur.getInventaireDuJoueur(joueur).getEcu() > 10) {
            moteur.getInventaireDuJoueur(joueur).getMainEmprunt().ajoutCarte(carteEmprunt.prendreCarte(0));
            moteur.getInventaireDuJoueur(joueur).ajoutEcu(10);
            getLogger().afficheMessageTrace(joueur.getNom() + " a pioché une carte emprunt (" + (moteur.getInventaireDuJoueur(joueur).getEcu() - 10) +
                    "-->" + moteur.getInventaireDuJoueur(joueur).getEcu() + ")");
            utiliseAction(1,moteur.getInventaireDuJoueur(joueur));
            moteur.getInventaireDuJoueur(joueur).investissementFait();
        }
        else{
            getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas faire d'enprunt");
        }
    }

    public CartesPresente<CarteEmprunt> getCarteEmprunt() {
        return carteEmprunt;
    }

    public void setCarteEmprunt(CartesPresente<CarteEmprunt> carteEmprunt) {
        this.carteEmprunt = carteEmprunt;
    }
}

