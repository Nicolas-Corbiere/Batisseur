package operation;

import carte.CarteBatiment;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpAffectationBatiment extends Operation {
	int indice;

    /**
     *
     * Opération qui permet au joueur de tiré une carte batiment
     *
     * @param indice de la carte que l'on veut tiré
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     */
    public OpAffectationBatiment(int indice, LoggerTrace logger, Identification id){
        super(logger,id);
        this.indice = indice;
    }


    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     *
     * Opération qui permet au joueur de tiré une carte batiment
     *
     */
    public OpAffectationBatiment() {
    }

    /**
     * Permet au joueur de tiré une carte
     */

    /**
     * Permet d'effectuer l'operation pour tirer une carte batiment
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    public void affectationBatiment(MoteurDeJeu moteur,Identification joueur, StatistiqueJoueur statistiqueJoueur){
    	CarteBatiment batiment = moteur.getBatimentPresent(indice);

        //j'insère la carte batiment que j'ai choisi dans ma liste de cartes batiment.
		moteur.getInventaireDuJoueur(joueur).getMainBatiment().ajoutCarte(batiment);


        //Pour pouvoir tracer la partie
        getLogger().afficheMessageTrace(getNameJoueur()+ " a pioché la carte bâtiment : Nom : "+
                batiment.getNom()+", Point de Victoire : "+batiment.getPointVictoire());

        //Statistiques -> Nombre de fois que le Joueur a pioché un Batiment
        //joueur.getStats().setNbPiocheBatiment(joueur.getStats().getNbPiocheBatiment() + 1);
        statistiqueJoueur.ajouteUnAffectationBatiment();


        //Utilsation d'une Action
        utiliseAction(1, moteur.getInventaireDuJoueur(joueur));
        
    }
    @Override
    public void faireOperation(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
    	affectationBatiment(moteur,joueur, statistiqueJoueur);
	}
}
