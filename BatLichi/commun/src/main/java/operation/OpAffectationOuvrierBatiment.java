package operation;

import carte.CarteBatiment;
import carte.CarteMachine;
import carte.CarteOutils;
import carte.CarteOuvrier;
import identification.Identification;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

import java.util.ArrayList;

public class OpAffectationOuvrierBatiment extends Operation {
    CarteOuvrier ouvrier;
    CarteBatiment batiment;
    CarteOutils outils;

    public CarteOutils getOutils()
    {
        return outils;
    }

    public void setOutils(CarteOutils outils)
    {
        this.outils = outils;
    }

    /**
     *
     * Opération qui permet au joueur d'attribuer un ouvrier à un bâtiment
     *
     * @param ouvrier qui seras attribué
     * @param batiment qui recevra un ouvrier
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     *
     */
    public OpAffectationOuvrierBatiment(CarteOuvrier ouvrier, CarteBatiment batiment, LoggerTrace logger, Identification id) {
        super(logger,id);
        this.ouvrier = ouvrier;
        this.batiment = batiment;
    }

    /**
     *
     * Opération qui permet au joueur d'attribuer un ouvrier à un bâtiment
     *
     * @param ouvrier qui seras attribué
     * @param outils outils qui seras équiper par l'ouvrier
     * @param batiment qui recevra un ouvrier
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     *
     */
    public OpAffectationOuvrierBatiment(CarteOuvrier ouvrier, CarteBatiment batiment, CarteOutils outils, LoggerTrace logger, Identification id)
    {
        super(logger,id);
        this.ouvrier = ouvrier;
        this.batiment = batiment;
        this.outils = outils;
    }

    /**
     *
     * Opération qui permet au joueur d'attribuer un ouvrier à un bâtiment
     *
     */
    public OpAffectationOuvrierBatiment() {
    }

    /**
     *
     * Permet au joueur d'attribuer un ouvrier à un bâtiment
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    @Override
    public void faireOperation(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        affectationOuvrierBatiment(moteur,joueur, statistiqueJoueur);
    }



    /**
     *
     * Permet au joueur d'attribuer un ouvrier à un bâtiment
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    public void affectationOuvrierBatiment(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur)
    {
        int nbActionNecessaire = nbActionNecessaire(moteur,joueur,moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment));

        //Si les actions nécessaires sont inférieures au nombre d'action du Joueur
        if(nbActionNecessaire > moteur.getInventaireDuJoueur(joueur).getNbAction())
        {
            getLogger().afficheMessageErreur("Pas assez d'action");
        	return; //Sortie forcé de la fonction
        }


        // Vérifie si l'ouvrier est bien dans notre main
        if (moteur.getInventaireDuJoueur(joueur).getMainOuvrier().contains(ouvrier)) {
            //Affectation de l'Ouvrier au Batiment
            moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment).ajoutOuvrier(ouvrier);

            //Affectation d'un outils
            if( outils != null && moteur.getInventaireDuJoueur(joueur).getMainOutils().contains(outils) && ouvrier.assignerCarteOutils(outils))
            {
                moteur.getInventaireDuJoueur(joueur).getMainOutils().enleverCarte(outils);
                getLogger().afficheMessageTrace(getNameJoueur() + "a affecté " + outils.getNom() + " a " + ouvrier.getNom());
            }

            //Suppression de l'Ouvrier dans la main
            moteur.getInventaireDuJoueur(joueur).getMainOuvrier().enleverCarte(ouvrier);

            //Ajout des Ressources de l'ouvrier au Ressources du Batiment
            moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment).ajouteRessource(ouvrier.getRessources());


            //Statistiques -> Pertes d'Ecus pour Affecter des ouvriers
            moteur.getInventaireDuJoueur(joueur).suppressionEcu(ouvrier.getEcu());
            //getInv().getStats().setNbEcuOuvrier(joueur.getStats().getNbEcuOuvrier() + ouvrier.getEcu());

            //Si on n'a pas demandé à avoir une partie silencieuse
            getLogger().afficheMessageTrace(getNameJoueur()+ " a affecté "
                    + ouvrier.getNom() + " a " + batiment.getNom());
            getLogger().BatimentMiseAJourRessource(moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment));
            moteur.getInventaireDuJoueur(joueur).addIdBatimentAffecter(batiment.getId());

            //Statistiques -> Nombre d'Affectation d'Ouvrier au Batiment
            statistiqueJoueur.ajouteUneAffectation(ouvrier);

        }

        //Si le Batiment est fini
        if(batimentEstFini( moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment)))
        {
            moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment).setBatimentTerminé(true);
            finDeChantier(moteur,joueur, moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment),statistiqueJoueur);

        }

        //Suppression des Actions utilisés
        utiliseAction(nbActionNecessaire, moteur.getInventaireDuJoueur(joueur));
    }


    /**
     * Fonction qui permet de vrifier si un batiùmnt est fini
     * @param leBatiment batiment que l'ont vérifie
     * @return true : si le batiment est fini
     */
    public boolean batimentEstFini(CarteBatiment leBatiment)
    {
        // Boucle sur 4 (Savoir, Pierre, Tuiles, Bois)
        for(int i = 0; i < 4; i++)
        {
            //Si la ressource du Batiment est supérieur au ressources actuel
            if(leBatiment.getRessources()[i] > leBatiment.getRessourcesActuel()[i])
            {
                return false;
            }
        }
        return true;
    }


    /**
     * Méthode qui permet de remettre les ouvriers et outils dans la main du joueur et ajoute les points de victoire gagné.
     * si le batiment est une machine, on le convertie en ouvrier.
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param leBatiment qui est fini
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    private void finDeChantier(MoteurDeJeu moteur,Identification joueur,CarteBatiment leBatiment, StatistiqueJoueur statistiqueJoueur) {


        //Si le Betiment est terminé
        if (leBatiment.estBatimentTerminé())
        {
            //Statistiques -> Points de Victoire Batiment
            //joueur.getStats().setNbPointVictoireBatiment(joueur.getStats().getNbPointVictoireBatiment() + batiment.getPointVictoire());

            moteur.getInventaireDuJoueur(joueur).setPoints(moteur.getInventaireDuJoueur(joueur).getPoints()+leBatiment.getPointVictoire());
            ArrayList<CarteOuvrier> listeOuv = moteur.getInventaireDuJoueur(joueur).getMainBatiment().getCarte(batiment).supprimeToutOuvrier();


            //Pour chaque Ouvrier affecté au Batiment
            //Les Ouvriers retournent dans la Main Ouvrier
            getLogger().afficheMessage("Fin de chantier, le joueur recupère les ouvriers suivant : ");
            for (CarteOuvrier ouvrier: listeOuv ) {
                getLogger().afficheMessage(ouvrier.getNom());
                moteur.getInventaireDuJoueur(joueur).getMainOuvrier().ajoutCarte(ouvrier);
            }

            //Apelle de la method carteMachineAllerDansMainOuvrier
            carteMachineAllerDansMainOuvrier(leBatiment,moteur,joueur);


            //On supprime le Batiment de la Main Batiment
            moteur.getInventaireDuJoueur(joueur).getMainBatiment().enleverCarte(leBatiment);

            getLogger().afficheMessageTrace(getNameJoueur()+ " a fini le chantier du "
                    + leBatiment.getNom() + ". Il a gagné " + leBatiment.getPointVictoire() + " points");

            //Gain d'Ecu par la fin de Chantier du Batiment
            moteur.getInventaireDuJoueur(joueur).ajoutEcu(leBatiment.getEcu());

            //Statistiques -> Gain d'Ecu
            //joueur.getStats().setNbEcuBatiment(joueur.getStats().getNbEcuBatiment() + batiment.getEcu());
            statistiqueJoueur.ajouteDesPointsBatiments(batiment);
        }
    }


    /**
     * Fonction qui permet de savoir combien d'action on a besoin pour effectuer une affectation
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param leBatiment batiment a vérifier
     * @return redondance : Nombre d'action à utiliser
     */
    public int nbActionNecessaire(MoteurDeJeu moteur,Identification joueur,CarteBatiment leBatiment){
        ArrayList<Integer> indexBatiment = moteur.getInventaireDuJoueur(joueur).getIdBatimentAffecter();
        int redondance = 1;

        //Pour chaque Batiment dans la Collection qui est affecter
        for (Integer unBatiment : indexBatiment) {

            //Si le Batiment est dans la Liste
            if(unBatiment == leBatiment.getId()){
                redondance++;
            }
        }
        return redondance;
    }

    /**
     * Fonction qui permet de mettre dans la main ouvrier du joueur la version de carte Ouvrier du batiment (Machine),
     * si et seulement si le batiment est une carteMachine et si elle est terminé
     *
     * @param batiment a transformer
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     */
    public void carteMachineAllerDansMainOuvrier(CarteBatiment batiment,MoteurDeJeu moteur,Identification joueur)
    {
        if(batiment instanceof CarteMachine)
        {
            moteur.getInventaireDuJoueur(joueur).getMainOuvrier().ajoutCarte( ((CarteMachine) batiment).getOtherVesionCarte() );
        }
    }


    public CarteOuvrier getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(CarteOuvrier ouvrier) {
        this.ouvrier = ouvrier;
    }

    public CarteBatiment getBatiment() {
        return batiment;
    }

    public void setBatiment(CarteBatiment batiment) {
        this.batiment = batiment;
    }
    

}
