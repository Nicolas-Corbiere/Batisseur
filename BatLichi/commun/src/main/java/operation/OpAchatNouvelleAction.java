package operation;


import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpAchatNouvelleAction extends Operation{

	/**
	 *  Operation qui permets au joueur de payer une action contre 5 écus
	 *
	 * @param logger le logger issue du joueur
	 * @param id identification du joueur
	 */
    public OpAchatNouvelleAction(LoggerTrace logger, Identification id) {
        super(logger,id);
    }

	/**
	 *  Operation qui permets au joueur de payer une action contre 5 écus
	 *
	 */
	public OpAchatNouvelleAction() {

	}

	/**
	 * Permet d'effectuer l'operation d'achat de nouvele action contre 5 écus
	 *
	 * @param moteur moteur de jeu
	 * @param joueur identification du joueur
	 * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
	 *
	 */
	@Override
	public void faireOperation(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
		achatNouvelleAction(moteur, joueur, statistiqueJoueur);
	}

	/**
	 * Permet d'effectuer l'operation d'achat de nouvele action contre 5 écus
	 *
	 * @param moteur moteur de jeu
	 * @param joueur identification du joueur
	 * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
	 */
    public void achatNouvelleAction(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur){

        if(moteur.getInventaireDuJoueur(joueur).getEcu() >= 5){
			moteur.getInventaireDuJoueur(joueur).ajoutAction(1);
			moteur.getInventaireDuJoueur(joueur).suppressionEcu(5);
			getLogger().afficheMessageErreur(joueur.getNom()+ " a acheter une action, il a "+ moteur.getInventaireDuJoueur(joueur).getNbAction() + " actions.");
			statistiqueJoueur.ajouterUnAchatAction();
        }else{
			getLogger().afficheMessageErreur(joueur.getNom()+ " ne peut pas acheter une action : pas assez d'écu");
        }
    }

}
