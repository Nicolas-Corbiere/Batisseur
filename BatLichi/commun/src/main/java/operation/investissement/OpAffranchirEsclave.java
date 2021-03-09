package operation.investissement;

import carte.CarteEsclave;
import carte.CarteOuvrier;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpAffranchirEsclave extends OperationInvestissement {


    private CarteEsclave esclave;

    /**
     * Operation qui permet au joueur d'affranchir un esclave
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     * @param esclave esclave qu'on afranchi
     */
    public OpAffranchirEsclave(LoggerTrace logger, Identification id, CarteEsclave esclave) {
        super(logger, id);
        this.esclave = esclave;
    }

    public OpAffranchirEsclave() {
        super(null,null);
    }

    public CarteEsclave getEsclave() {
        return esclave;
    }

    public void setEsclave(CarteEsclave esclave) {
        this.esclave = esclave;
    }

    /**
     * Permet d'effectuer l'operation d'investissement d'affranchir un esclave
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperationInvestissement(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        // si un investissement à déjà était fait, je ne fait rien
        if(moteur.getInventaireDuJoueur(joueur).getEcu() >= 5)
        {
            CarteOuvrier esclaveAff = esclave.getOtherVesionCarte();
            moteur.getInventaireDuJoueur(joueur).getMainOuvrier().enleverCarte(esclave);
            moteur.getInventaireDuJoueur(joueur).getMainOuvrier().ajoutCarte(esclaveAff);
            moteur.getInventaireDuJoueur(joueur).suppressionEcu(5);
            utiliseAction(1,moteur.getInventaireDuJoueur(joueur));
            getLogger().afficheMessageTrace(joueur.getNom()+ " a affranchi un esclave");

        }
        else{
            getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut paaas affranchir son esclave");
        }
    }
}
