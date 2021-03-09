package partie;

import carte.*;
import carte.cartesPresente.LesCartesPresentes;
import carte.cartesPresente.LesCartesPresentesAntiquite;
import carte.cartesPresente.LesCartesPresentesMoyenAge;
import carte.factory.CarteFactoryAntiquite;
import carte.factory.CarteFactoryMoyenAge;
import carte.factory.ICarteFactory;
import identification.Identification;
//import joueur.Joueur;
import inventaire.InventaireJoueur;
import modeDeJeu.ModeDeJeu;
import nommage.Nommage;
import statistique.StatistiqueJoueur;
import statistique.StatistiqueParties;

import java.util.*;

import static statistique.StatistiqueJoueur.afficheStatisqueJoueur;
import static statistique.StatistiqueJoueur.definitionRang;
import static statistique.StatistiqueParties.affichageStatParties;

/**
 * 
 * @author Mathieu Rethers and Nicolas Corbiere
 *
 */

public class Partie {

//--------------------------------------------------- Attributs --------------------------------------------------------


	public void setFinie(boolean finie) {
		this.finie = finie;
	}

	private boolean finie;
	private final boolean estSilencieux;
	private ModeDeJeu modeDeJeu;
	private HashMap<Identification,Integer>joueurs;
	private static final String[] StringClassement = {"premier","deuxième", "troisième", "quatrième" };



	// Les Piles De Cartes
	private PileDeCarte<CarteBatiment> pileCarteBatiment;
	private PileDeCarte<CarteOuvrier> pileCarteOuvrier;
	private PileDeCarte<CarteEmprunt> pileCarteEmprunt;
	private PileDeCarte<CarteEsclave> pileCarteEsclave;
	private PileDeCarte<CarteUniversite> pileCarteUniversite;
	private PileDeCarte<CarteOutils> pileCarteOutils;

	// Les Cartes Présentés
	private LesCartesPresentes lesCartesPresentes;

	// Bot ou plusieurs

	//ArrayList<Joueur> listJoueur;
	ArrayList<CarteBatiment> listCarteBati;

	
//---------------------------------------------------- Construteur -----------------------------------------------------
	
	public Partie(boolean estSilencieux, HashMap<Identification, InventaireJoueur> inventaire)
	{

		this.finie = false;

		this.estSilencieux = estSilencieux;
		CarteFactoryMoyenAge carteMA = new CarteFactoryMoyenAge();
		new Nommage().creatNommageMoyenAge();

		ArrayList<CarteOuvrier> apprentis = carteMA.creeCarteApprentis();
		for(Map.Entry<Identification, InventaireJoueur> unJoueur: inventaire.entrySet())
		{
			inventaire.get(unJoueur.getKey()).ajouterCarte(apprentis.get(0));
			apprentis.remove(0);
		}

		//Création des piles
		pileCarteBatiment = new PileDeCarte<CarteBatiment>(carteMA.creeCartesBatimant(), carteMA.creeCarteMachine());
		pileCarteOuvrier = new PileDeCarte<CarteOuvrier>(carteMA.creeCartesOuvrier(),apprentis);

		//Création des cartes presentes
		lesCartesPresentes = new LesCartesPresentesMoyenAge(pileCarteBatiment, pileCarteOuvrier);

	}

	public Partie(ModeDeJeu modeDeJeu, boolean estSilencieux,HashMap<Identification, InventaireJoueur> inventaire)
	{

		this.finie = false;
		//this.listJoueur = listJoueur;
		this.estSilencieux = estSilencieux;
		this.modeDeJeu = modeDeJeu;

		if(this.modeDeJeu == ModeDeJeu.MoyenAge)
		{
			new Nommage().creatNommageMoyenAge();
			CarteFactoryMoyenAge carteMA = new CarteFactoryMoyenAge();
			ArrayList<CarteOuvrier> apprentis = carteMA.creeCarteApprentis();
			for(Map.Entry<Identification, InventaireJoueur> unJoueur: inventaire.entrySet())
			{
				inventaire.get(unJoueur.getKey()).ajouterCarte(apprentis.get(0));
				apprentis.remove(0);
			}
			pileCarteBatiment 	= new PileDeCarte<CarteBatiment>(carteMA.creeCartesBatimant(), carteMA.creeCarteMachine());
			pileCarteOuvrier 	= new PileDeCarte<CarteOuvrier>(carteMA.creeCartesOuvrier(),apprentis);

			lesCartesPresentes 	= new LesCartesPresentesMoyenAge(pileCarteBatiment,pileCarteOuvrier);
		}
		else if(this.modeDeJeu == ModeDeJeu.Antiquite)
		{
			ICarteFactory carteA = new CarteFactoryAntiquite();
			new Nommage().creatNommageAntiquité();

			pileCarteBatiment 	= new PileDeCarte<CarteBatiment>(carteA.creeCartesBatimant(), carteA.creeCarteMachine());
			pileCarteOuvrier 	= new PileDeCarte<CarteOuvrier>(carteA.creeCartesOuvrier(), carteA.creeCarteEsclave());
			pileCarteEmprunt 	= new PileDeCarte<CarteEmprunt>(carteA.creeCarteEmprunts());
			pileCarteEsclave 	= new PileDeCarte<CarteEsclave>(carteA.creeCarteEsclave());
			pileCarteUniversite = new PileDeCarte<CarteUniversite>(carteA.creeCartesUniversite());
			pileCarteOutils 	= new PileDeCarte<CarteOutils>(carteA.creeCarteOutils());
			for(Map.Entry<Identification, InventaireJoueur> unJoueur: inventaire.entrySet())
			{
				inventaire.get(unJoueur.getKey()).ajouterCarte(pileCarteEsclave.prendrePremiereCarte());
			}
			lesCartesPresentes = new LesCartesPresentesAntiquite(pileCarteBatiment,pileCarteOuvrier,pileCarteEmprunt,pileCarteEsclave,pileCarteUniversite,pileCarteOutils);
		}
	}

//---------------------------------------------------- Méthodes --------------------------------------------------------


	public LesCartesPresentes getLesCartesPresentes(){
		return lesCartesPresentes;
	}


	/**
	 * Affichage des statistique
	 * @param stat
	 */
	public void afficheStatistiques( HashMap<Identification, StatistiqueJoueur> stat) {
		definitionRang(stat);
		afficheStatisqueJoueur(stat);
	}

	// -- Getter and Setter

	/*public Joueur getGagnant() {
		return gagnant;
	}*/

	public ModeDeJeu getModeDeJeu() {
		return modeDeJeu;
	}

	public void setModeDeJeu(ModeDeJeu modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}


	public boolean getFinie() {
		return finie;
	}

	public boolean isEstSilencieux() {
		return estSilencieux;
	}

	
	
}
