package operation;

import carte.CarteOuvrier;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;


public class OpAffectationOuvrier extends Operation {
    int indice;


    /**
     * Opération qui permet au joueur de tiré une carte ouvrier
     *
     * @param indice de la carte que l'on veut tiré
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     */
    public OpAffectationOuvrier(int indice, LoggerTrace logger, Identification id){
        super(logger,id);
        this.indice = indice;
    }

    /**
     * Opération qui permet au joueur de tiré une carte ouvrier
     *
     */
    public OpAffectationOuvrier() {
    }

    /**
     * Permet au joueur de tiré une carte ouvrier
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    public void affectationOuvrier(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
    	CarteOuvrier ouvrier = moteur.getOuvrierPresent(indice);

        // Pour pouvoir tracer la partie
        if (ouvrier == null){
            getLogger().afficheMessageTrace(getNameJoueur()+ " a pioché la carte ouvrier");
        } else {
            getLogger().afficheMessageTrace(getNameJoueur() + " a pioché la carte ouvrier. NOM : "
                    + ouvrier.getNom());
        }

        // j'insère la carte batiment que j'ai choisi dans ma liste de cartes batiment.
        moteur.getInventaireDuJoueur(joueur).getMainOuvrier().ajoutCarte(ouvrier);

        //Statistiques
        statistiqueJoueur.ajouteUnAffectationOuvrier();

        // J'indique que j'ai réalisé une action
        utiliseAction(1, moteur.getInventaireDuJoueur(joueur));

    }

    /**
     * Permet au joueur de tiré une carte ouvrier
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    @Override
    public void faireOperation(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        affectationOuvrier(moteur,joueur, statistiqueJoueur);
    }


    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


}
