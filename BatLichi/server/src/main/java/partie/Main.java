package partie;


import argument.Arguments;
import modeDeJeu.ModeDeJeu;

/**
 * 
 * @author Nicolas Corbiere
 *
 */
public class Main
{
    public static void main(String[] args)
    {
    	//creation des joueurs
    	int i;
    	
    	Arguments arguments = new Arguments(args);
    	
    	arguments.analyseArgument();

    	boolean estSilencieuxTrace = arguments.isBoolTrace();
    	boolean estSilencieuxStat = arguments.isBoolStat();
    	
    	ModeDeJeu modeDeJeu = arguments.getModeDeJeu();
    	int nbPartie = arguments.getNbPartie();
    	

		/*ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();

		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));


    	for(i =0; i < nbPartie; i++) {
			StatistiqueParties.setNbParties();


			Partie partie = new Partie(i,modeDeJeu,listJoueur, estSilencieuxTrace);
        	partie.lancerPartie();

    	}
    	StatistiqueParties.affichageStatParties(listJoueur);
*/
    	
    }
}
