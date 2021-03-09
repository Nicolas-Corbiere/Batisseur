package operation.investissement;

import carte.CarteEmprunt;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpRembourserEmprunt extends OperationInvestissement {

    private CarteEmprunt carteEmprunt;

    /**
     * Operation qui permet au joueur de rembourser un emprunt
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     *
     */
    public OpRembourserEmprunt(LoggerTrace logger, Identification id, CarteEmprunt carteEmprunt) {
        super(logger, id);
        this.carteEmprunt = carteEmprunt;
    }

    public OpRembourserEmprunt() {
        super(null,null);
    }

    public CarteEmprunt getCarteEmprunt() {
        return carteEmprunt;
    }

    public void setCarteEmprunt(CarteEmprunt carteEmprunt) {
        this.carteEmprunt = carteEmprunt;
    }

    /**
     * Permet d'effectuer l'operation d'investissement 'rembourser un emprunt'
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperationInvestissement(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {

        if(moteur.getInventaireDuJoueur(joueur).getNbAction() >= 1 && moteur.getInventaireDuJoueur(joueur).getEcu() >= 15 ) {
            //moteur.getInventaireDuJoueur(joueur).getMainEmprunt().enleverCarte(carteEmprunt);
            moteur.getEmpruntPresent();
            moteur.getInventaireDuJoueur(joueur).suppressionEcu(15);
            // rembourser un emprunt n'est pas une action !
            investissementFait(moteur.getInventaireDuJoueur(joueur));
            getLogger().afficheMessageTrace(joueur.getNom() + " a rembourser un emprunt");

        }
        else{
            getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas rembourser son emprunt");
        }

    }
}
