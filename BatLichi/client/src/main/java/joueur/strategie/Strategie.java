package joueur.strategie;

import carte.*;
import carte.GestionCarte.GestionCollectionCarte;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import joueur.Joueur;
import logger.LoggerTrace;
import mainJoueur.MainJoueur;
import operation.Operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 
 * @author Nicolas Corbiere
 *
 */
public abstract class Strategie {

	// -- Attribut 


	private int niveau;
	protected boolean PestSilencieux;
	protected Joueur joueur;

	// -- Constructeur

	/**
	 * Constructeur de Strategie
	 * @param niveau, niveau de la strategie
	 * @param PestSilencieux
	 */
	public Strategie(int niveau, boolean PestSilencieux)
	{
		this.niveau = niveau;
		this.PestSilencieux = PestSilencieux;
	}


	// -- Méthode

	/**
	 * Fonction qui permet de retourner le nombre d'Ecu qui manque pour affecter un Ouvrier sur un Chantier
	 *
	 * @return un nombre supérieur à 0
	 */
	public int ecuNecesaire()
	{
		int ecu;
		if (joueur.getMainOuvrier().isEmpty())
		{
			ecu = 10;
			return ecu;
		}
		else
		{
			ecu = joueur.getMainOuvrier().get(0).getEcu() - joueur.getEcu();
			return ecu;
		}
	}

	public abstract Operation appliqueStrategie(LesCartesPresentes lesCartesPresentes, InventaireJoueur inventaireJoueur, Identification moi, LoggerTrace logger);

	// -- Getter and Setter

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public boolean isPestSilencieux() {
		return PestSilencieux;
	}

	public void setPestSilencieux(boolean pestSilencieux) {
		PestSilencieux = pestSilencieux;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur)
	{
		if (this.joueur == null && joueur != null) this.joueur = joueur;
	}


	/**
	 * Fonction qui permet de donner l'indice d'une carte ouvrier non null
	 *
	 * @param ouvrier, Cartes ouvrier presentes
	 * @see carte.cartesPresente.CartesPresente
	 * @return indice supérieur ou égale à 0 (-1 si aucune carte ouvrier non null)
	 */
	public int carteOuvrierNonNull(CartesPresente<CarteOuvrier> ouvrier)
	{
		int i = 0;
		for (CarteOuvrier carte : ouvrier.lireCartes())
		{
			if (carte != null) {
				return i;
			}
			else {
				i++;
			}
		}
		return -1;
	}


	/**
	 * Fonction qui permet de donner l'indice d'une carte ouvrier non null
	 *
	 * @param ouvrier, Liste de notre main carte ouvrier
	 * @return indice supérieur ou égale à 0 (-1 si aucune carte ouvrier dans notre main non null)
	 */
	public int carteMainOuvrierNonNull(MainJoueur<CarteOuvrier> ouvrier)
	{
		for(int i=0; i<ouvrier.nombreCartes();i++){
			if(ouvrier.getCarte(i)!=null){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Fonction qui permet de donner l'indice d'une carte batiment non null
	 *
	 * @param batiment, Cartes Batiment Presentes
	 * @see carte.cartesPresente.CartesPresente
	 * @return indice supérieur ou égale à 0 (-1 si aucune carte batiment non null)
	 */
	public int carteBatimentNonNull(CartesPresente<CarteBatiment> batiment)
	{
		int i = 0;
		for (CarteBatiment carte : batiment.lireCartes())
		{
			if (carte != null){
				return i;
			}
			else{
				i++;
			}
		}
		return -1;
	}


	/**
	 * Détermine le nombre d'action nécessaire pour faire une affectation d'un ouvrier à un bâtiment
	 * @param batiment, Carte batiment
	 * @param inventaireJoueur, Inventaire du joueur
	 * @return un chiffre supérieur ou égale à 1
	 */
	public int actionsNecessaire(CarteBatiment batiment,InventaireJoueur inventaireJoueur)
	{
		ArrayList<Integer> indexBatiment = inventaireJoueur.getIdBatimentAffecter();
		int redondance = 1;

		//Pour chaque Batiment dans la Collection qui est affecter
		for (Integer unBatiment : indexBatiment)
		{
			//Si le Batiment est dans la Liste
			if(unBatiment == batiment.getId()){
				redondance++;
			}
		}
		return redondance;
	}

	/**
	 * @return un chiffre aléatoire entre 0 et 4
	 */
	public int nbAleatoire()
	{
		Random random = new Random();
		int nombre = random.nextInt(4);
		return nombre;
	}

	/**
	 * @return la premiere carte batiment dans notre main
	 */
	protected CarteBatiment lirePremiereCarteBatiment(MainJoueur<CarteBatiment> mainBatimentJoueur)
	{
		if( mainBatimentJoueur.estVide() ){
			return null;
		}
		else{
			return mainBatimentJoueur.getCarte(0);
		}

	}



	/**
	 * @param cartePresente, Tableau de carte batiment visibles
	 * @return -> la position d'une carteBatiment presente qui a 3 ressource de chaque maximun
	 */
	public int tirerBatimentAdapte(CartesPresente<CarteBatiment> cartePresente)
	{
		int indice = 0;
		for (CarteBatiment carte : cartePresente.lireCartes())
		{
			if (carte != null && carte.getRessources()[0] < 4 && carte.getRessources()[1] < 4 && carte.getRessources()[2] < 4 && carte.getRessources()[3] < 4)
			{
				return indice;
			}
			indice++;
		}
		return -1;
	}


	/**
	 * Permet de trouver la carte ouvrier la plus avantageuse(rentable) si nous voulons affecter la carte universite à un ouvrier
	 * @param carteUniversite, Carte universite
	 * @return une carte Ouvrier (null si aucune carte rentable)
	 */
	public CarteOuvrier rentableUniv(CarteUniversite carteUniversite)
	{
		int ecare = 0;
		CarteOuvrier carte = null;
		for(CarteOuvrier carteOuvrier : getJoueur().getMainOuvrier())
		{
			if(carteOuvrier!=null && carteOuvrier.getCarteUniversiteAssigne()==null && !(carteOuvrier instanceof CarteEsclave))
			{
				for(int i = 0; i < 4; i++)
				{

					int ecareRessource = carteUniversite.getRessource(i) - carteOuvrier.getRessource(i);
					if(ecareRessource>=2 && ecareRessource > ecare)
					{
						ecare = ecareRessource;
						carte = carteOuvrier;
					}
				}
			}
		}
		return carte;
	}

	/**
	 * Permet de trouver la carte ouvrier dans notre main qui est la plus avantageuse(rentable) si nous voulons affecter la carte outil à un ouvrier
	 * @param carteOutils, Carte Outils
	 * @return une carte Ouvrier (null si aucune carte rentable)
	 */
	public CarteOuvrier rentableOutil(CarteOutils carteOutils,MainJoueur<CarteOuvrier> mainJoueur)
	{
		int ecare = 0;
		CarteOuvrier carte = null;
		for(CarteOuvrier carteOuvrier : mainJoueur.getCartes())
		{
			if(carteOuvrier!=null && !(carteOuvrier instanceof CarteEsclave))
			{
				for(int i = 0; i < 4; i++)
				{

					int ecareRessource = carteOutils.getRessource(i) - carteOuvrier.getRessource(i);
					if(ecareRessource > ecare)
					{
						ecare = ecareRessource;
						carte = carteOuvrier;
					}
				}
			}
		}
		return carte;
	}

	/**
	 * Permet de trouver la position de la carte ouvrier dans notre main qui est la plus avantageuse(rentable) si nous voulons affecter la carte outil à un ouvrier
	 * @param carteOutils, Carte Outils
	 * @return un indice supérieur ou égale à 0 (-1 si aucune carte rentable)
	 */
	public int positionRentableOutil(CarteOutils carteOutils,MainJoueur<CarteOuvrier> mainJoueur)
	{
		int ecare = 0;
		int indice = -1;
		int result = -1;
		for(CarteOuvrier carteOuvrier : mainJoueur.getCartes())
		{
			if(carteOuvrier!=null && !(carteOuvrier instanceof CarteEsclave))
			{
				indice++;
				for(int i = 0; i < 4; i++)
				{

					int ecareRessource = carteOutils.getRessource(i) - carteOuvrier.getRessource(i);
					if(ecareRessource>=2 && ecareRessource > ecare)
					{
						ecare = ecareRessource;
						result = indice;
					}
				}
			}
			else{
				indice++;
			}
		}
		return result;
	}



	/**
	 * Permet de retourner la position de la carte Ouvrier la plus adapte par rapport a notre batiment et donc ne pas prendre une carte trop eleve pour ce que nous avons réellement besoin en terme de ressources
	 * @param ouvrier , Cartes ouvrier Presentes
	 * @see carte.cartesPresente.CartesPresente
	 * @param batiment , Carte batiment
	 * @return un indice supérieur ou égale à 0
	 */
	public int positionMeilleureOuvrierPresentePourCarteBatiment(CartesPresente<CarteOuvrier> ouvrier,CarteBatiment batiment)
	{
		int ressourceBatiment[] = batiment.getRessources();
		int ressourceBatimentActuelle[]=batiment.getRessourcesActuel();

		ArrayList<CarteOuvrier> ouvrierCarte = ouvrier.lireCartes();

		CarteOuvrier tableauPierreOuvrier[]=new CarteOuvrier[ouvrier.taille()];
		CarteOuvrier tableauBoisOuvrier[]=new CarteOuvrier[ouvrier.taille()];
		CarteOuvrier tableauSavoirOuvrier[]=new CarteOuvrier[ouvrier.taille()];
		CarteOuvrier tableauTuileOuvrier[]=new CarteOuvrier[ouvrier.taille()];

		CarteOuvrier recuperation;

		if(ressourceBatiment[0]-ressourceBatimentActuelle[0]>0)
		{
			GestionCollectionCarte.removeAllNullCarte(ouvrierCarte);
			int y=0;
			while(!ouvrierCarte.isEmpty())
			{
				recuperation=ressourceAdapteOuvrierPresente(ouvrierCarte ,batiment, StrategieIntelligent.Pierre);
				tableauPierreOuvrier[y]=recuperation;
				ouvrierCarte.remove(recuperation);
				y++;
			}
		}


		if(ressourceBatiment[1]-ressourceBatimentActuelle[1]>0)
		{
			ouvrierCarte = ouvrier.lireCartes();
			GestionCollectionCarte.removeAllNullCarte(ouvrierCarte);
			int y=0;
			while(!ouvrierCarte.isEmpty())
			{
				recuperation=ressourceAdapteOuvrierPresente(ouvrierCarte,batiment, StrategieIntelligent.Bois);
				tableauBoisOuvrier[y]=recuperation;
				ouvrierCarte.remove(recuperation);
				y++;
			}
		}

		if(ressourceBatiment[2]-ressourceBatimentActuelle[2]>0)
		{
			ouvrierCarte = ouvrier.lireCartes();
			GestionCollectionCarte.removeAllNullCarte(ouvrierCarte);
			int y=0;
			while(!ouvrierCarte.isEmpty())
			{
				recuperation=ressourceAdapteOuvrierPresente(ouvrierCarte,batiment, StrategieIntelligent.Savoir);
				tableauSavoirOuvrier[y]=recuperation;
				ouvrierCarte.remove(recuperation);
				y++;
			}
		}

		if(ressourceBatiment[3]-ressourceBatimentActuelle[3]>0)
		{
			ouvrierCarte = ouvrier.lireCartes();
			GestionCollectionCarte.removeAllNullCarte(ouvrierCarte);
			int y=0;
			while(!ouvrierCarte.isEmpty())
			{
				recuperation=ressourceAdapteOuvrierPresente(ouvrierCarte,batiment, StrategieIntelligent.Tuile);
				tableauTuileOuvrier[y]=recuperation;
				ouvrierCarte.remove(recuperation);
				y++;
			}
		}

		//Classement des CartesOuvriers selon le score le plus petit
		int scoreMin = 100000;
		CarteOuvrier meilleurCarteOuvrier = null;

		for(CarteOuvrier carteOuvrier : ouvrier.lireCartes())
		{
			if(carteOuvrier!=null)
			{
				int score = 0;
				for(int index = 0; index < ouvrier.taille(); index++)
				{
					if (tableauPierreOuvrier[index] != null && carteOuvrier != null && tableauPierreOuvrier[index].equals(carteOuvrier))
					{
						score += index;
					}
					if (tableauBoisOuvrier[index] != null && carteOuvrier != null && tableauBoisOuvrier[index].equals(carteOuvrier))
					{
						score += index;
					}
					if (tableauSavoirOuvrier[index] != null && carteOuvrier != null && tableauSavoirOuvrier[index].equals(carteOuvrier))
					{
						score += index;
					}
					if (tableauTuileOuvrier[index] != null && carteOuvrier != null && tableauTuileOuvrier[index].equals(carteOuvrier))
					{
						score += index;
					}
				}

				if(meilleurCarteOuvrier==null)
				{
					scoreMin=score;
					meilleurCarteOuvrier=carteOuvrier;
				}
				else if(scoreMin>score)
				{
					scoreMin=score;
					meilleurCarteOuvrier=carteOuvrier;
				}
			}
		}

		//recherche de l'index
		for(int position = 0; position<ouvrier.taille(); position++)
		{
			if(ouvrier.getCarte(position)!=null && ouvrier.getCarte(position).equals(meilleurCarteOuvrier)) return position;
		}

		return 0;
	}


	/**
	 *
	 * Permet de trouver la carte ouvrier la plus adapté à la carte Batiment qu'il possède en fonction de la ressource correspondant à l'indice
	 * 	( Permettant ainsi de ne pas gacher une carte ouvrier qui pourrait être plus utile pour une autre carte batiment qui necessitera encore plus de la ressource correspondant à l'indice)
	 * @param ouvrier, Liste de CarteOuvrier qui correspond aux cartes Ouvrier Presentées
	 * @param batiment, CarteBatiment qui correspond aux cartes batiments de notre main
	 * @param indice, 0 = Pierre / 1 = Bois / 2 = Savoir / 3 = Tuile
	 *
	 * @return une carte ouvrier
	 */
	public CarteOuvrier ressourceAdapteOuvrierPresente(ArrayList<CarteOuvrier> ouvrier, CarteBatiment batiment, int indice)
	{
		CarteOuvrier meilleure = null;
		for(int i = 0; meilleure==null && i<ouvrier.size(); i++)
		{
			meilleure = ouvrier.get(i);
			if(meilleure == null)
			{
				ouvrier.remove(i);
			}
		}
		int ressourceNecessaire = batiment.getRessources()[indice];
		int plusProche = 10000;

		for (CarteOuvrier carteOuv : ouvrier)
		{

			int diff = ressourceNecessaire - carteOuv.getRessources()[indice];

			if(carteOuv==null)
			{

			}
			else if(carteOuv!=null && carteOuv.getRessources()[indice] >= ressourceNecessaire)
			{
				plusProche = diff;
				meilleure = carteOuv;
			}
			else if(diff < plusProche)
			{
				plusProche = diff;
				meilleure = carteOuv;
			}
		}
		return meilleure;
	}



	/**
	 * Permet de trouver l'indice de la carte ouvrier qui a le plus de Ressource en général.
	 * @param ouvrier, Cartes Ouvrier Presentes
	 * @see carte.cartesPresente.CartesPresente
	 * @return un indice supérieur ou égale à 0
	 */
	public int estMeilleureRessource(CartesPresente<CarteOuvrier> ouvrier) {

		int meilleure = 0;
		int result = 0;

		for (int c = 0; c < ouvrier.taille(); c++)
		{
			int cumul = 0;
			for (int i = 0; i < 4; i++)
			{
				if(!ouvrier.caseVide(c))
				{
					cumul += ouvrier.getCarte(c).getRessource(i);
				}
			}

			if(cumul>meilleure)
			{
				meilleure=cumul;
				result = c;
			}
		}

		return result;
	}

}
