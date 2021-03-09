package operation;


import identification.Identification;
import inventaire.InventaireJoueur;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;

public class OpObtenirEcu extends Operation {

    private int ecuNecesaire;

    /**
     *
     * Opération qui permet au joueur d'échanger des ecus contre des actions
     *
     * @param ecuNecesaire nombre d'ecu que l'on souhaite
     * @param inv inventaire du joueur
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     */
    public OpObtenirEcu(int ecuNecesaire, InventaireJoueur inv, LoggerTrace logger, Identification id) {
        super(logger, id);
        this.ecuNecesaire = ecuNecesaire;
    }

    /**
     *
     * Opération qui permet au joueur d'échanger des ecus contre des actions
     *
     */
    public OpObtenirEcu() {
    }

    /**
     *
     * Méthode qui permet au joueur d'obtenir les ecus qui lui manque contre des actions
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    @Override
    public void faireOperation(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        obtenirEcu(moteur,joueur, statistiqueJoueur);
    }

    /**
     *
     * Méthode qui permet au joueur d'obtenir les ecus qui lui manque contre des actions
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    public void obtenirEcu(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur){
        int ecuRecup = 0;           //Nombre d'Ecu que l'on récupère
        int actionAUtiliser = 0;    //Nombre d'Action que l'on va utiliser

        //Si le joueur à 3 Actions ou plus
        if(moteur.getInventaireDuJoueur(joueur).getNbAction() >= 3){
            if(ecuNecesaire == 1){
                ecuRecup = 1;
                actionAUtiliser =1;
            }
            else if( (ecuNecesaire == 2) || ((ecuNecesaire) == 3)){
                ecuRecup = 3;
                actionAUtiliser = 2;
            }
            else if(ecuNecesaire > 3){
                ecuRecup = 6;
                actionAUtiliser = 3;
            }
        }
        //Si le nombre d'Action est égal à 2
        else if(moteur.getInventaireDuJoueur(joueur).getNbAction() == 2){
            if(ecuNecesaire == 1){
                ecuRecup = 1;
                actionAUtiliser = 1 ;
            }
            else if( ecuNecesaire > 1){
                ecuRecup = 3;
                actionAUtiliser = 2;
            }
        }
        //Si le nombre d'Action est égal à 1
        else if(moteur.getInventaireDuJoueur(joueur).getNbAction() == 1){
            ecuRecup = 1;
            actionAUtiliser = 1;
        }

        //Gain d'Ecu
        moteur.getInventaireDuJoueur(joueur).ajoutEcu(ecuRecup);

        //Utilisation des Actions
        utiliseAction(actionAUtiliser, moteur.getInventaireDuJoueur(joueur));

        //Si on n'a pas demandé à avoir une partie silencieuse
        getLogger().afficheMessageTrace(getNameJoueur()+ " a pris "
                + ecuRecup + " contre " + actionAUtiliser + " actions");


        //Statistiques -> Nombre de fois que le Joueur à Piocher des Ecus
        //joueur.getStats().setNbPiocheEcu(joueur.getStats().getNbPiocheEcu() + ecuRecup);
        statistiqueJoueur.ajouteDesEcus(ecuRecup);
    }

    public int getEcuNecesaire() {
        return ecuNecesaire;
    }

    public void setEcuNecesaire(int ecuNecesaire) {
        this.ecuNecesaire = ecuNecesaire;
    }





}
