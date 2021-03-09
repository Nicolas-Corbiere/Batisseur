package joueur;

import carte.*;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import joueur.strategie.Strategie;
import logger.ColorConsole;
import logger.LoggerTrace;
import operation.*;
import operation.investissement.*;
import statistique.StatistiqueJoueur;
import statistique.StatistiqueParties;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Lisa Deslandes and Yannick Alcaraz
 *
 */

/**
 * Represente un joueur
 */

public class Joueur
{
	//----Attributs----
	private String nom;									//Nom du Joueur
	private HashMap<CarteBatiment, ArrayList<CarteOuvrier>> mainBatiment = 	//Collection de cartes Batiment (sa main)
			new HashMap<CarteBatiment, ArrayList<CarteOuvrier>>();
	private ArrayList<CarteOuvrier> mainOuvrier;		//Collection de cartes Ouvrier (sa main)
	private int nbAction;								//Nombre d'action qu'à le joueur
	private StatistiqueJoueur statsJoueur;				//Les Statistiques du Joueur
	private StatistiqueParties statsPartie;
	private int rang;									//Son rang à la fin de la partie
	private boolean estSilencieux;						//Défini si le joueur dit ce qu'il fait
	private int ecu;									//Nombre d'Ecus possedait par le Joueur
	private ArrayList<Integer> idBatimentAffecter = 	//Liste de tous les Batiments qui ont été affectés
			new ArrayList<Integer>();
	private boolean afficherStats;						//Défini si les stats devront être afficher
	private Strategie strat;
	private LoggerTrace logger;
	private static int id = 0;
	private String colorConsole;


	//----Constructeur----


	/**
	 * Constructeur de Joueur
	 * @param Pnom, nom du joueur
	 * @param estSilencieux
	 * @param afficherStats, True : si nous voulons afficher les stats / False : si nous ne voulons pas afficher les stats
	 */
	public Joueur(String Pnom, boolean estSilencieux, boolean afficherStats)
	{
		nom = Pnom;
		nbAction = 3;
		mainOuvrier = new ArrayList<CarteOuvrier>();
		statsJoueur = new StatistiqueJoueur();
		statsPartie = new StatistiqueParties(Pnom, afficherStats);
		this.estSilencieux = estSilencieux;
		ecu = 25;
		this.afficherStats = afficherStats;
		selectColor();
		this.logger = new LoggerTrace(estSilencieux, colorConsole);
		id++;

	}

	/**
	 * Methode permettant de mettre des couleurs dans la console
	 */
	public void selectColor() {
		if(id == 0) {
			colorConsole = ColorConsole.YELLOW;
		}
		else if(id == 1) {
			colorConsole = ColorConsole.BLUE;
		}
		else if(id == 2) {
			colorConsole = ColorConsole.GREEN;
		}
		if(id == 3) {
			colorConsole = ColorConsole.PURPLE;
		}
		else {
			colorConsole = ColorConsole.BLACK;
		}
	}
	//----Getter & Setter----
	public String getNom()	{
		return nom;
	}

	public ArrayList<CarteOuvrier> getMainOuvrier()	{
		return mainOuvrier;
	}

	public void setMainOuvrier(ArrayList<CarteOuvrier> mainOuvrier){
		this.mainOuvrier = mainOuvrier;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public int getNbAction(){
		return nbAction;
	}

	public void setNbAction(int action){
		this.nbAction = action;
	}

	public HashMap<CarteBatiment, ArrayList<CarteOuvrier>> getMainBatiment(){
		return mainBatiment;
	}

	public void setMainBatiment(HashMap<CarteBatiment, ArrayList<CarteOuvrier>> mainBatiment){
		this.mainBatiment = mainBatiment;
	}

	public int getRang(){
		return rang;
	}

	public int setRang(int rang){
		return this.rang = rang;
	}

	public boolean isEstSilencieux(){
		return estSilencieux;
	}

	public int getEcu(){
		return ecu;
	}

	public void setEcu(int ecu)	{
		this.ecu = ecu;
	}

	public ArrayList<Integer> getIdBatimentAffecter(){
		return idBatimentAffecter;
	}

	public void setIdBatimentAffecter(ArrayList<Integer> idBatimentAffecter) {
		this.idBatimentAffecter = idBatimentAffecter;
	}

	public double getNbPointVictoire(){
		return statsJoueur.getNbPointVictoireBatiment() + statsJoueur.getNbPointVictoireEcu();
	}

	public void setNbPointVictoire(int nbPointVictoire){
		this.statsJoueur.setNbPointVictoire(nbPointVictoire);
	}

	public void setNbPointVictoireBat(int nbPointVictoire){
		this.statsJoueur.setNbPointVictoireBatiment(nbPointVictoire);
	}

	public void setNbPointVictoireEcu(int nbPointVictoire){
		this.statsJoueur.setNbPointVictoireEcu(nbPointVictoire);
	}

	public StatistiqueJoueur getStats()	{
		return statsJoueur;
	}

	public StatistiqueParties getStatsPartie() {
		return statsPartie;
	}

	public boolean isAfficherStats() {
		return afficherStats;
	}

	public LoggerTrace getLogger() {
		return logger;
	}


	//----Méthodes & Fonctions----

	/**
	 * Operation qui permet de mettre un ouvrier dans notre liste d'ouvrier
	 *
	 * @param tabOuvrier, Cartes ouvriers presentes
	 * @param indice, Indice de la carte souhaiter
	 * @param inventaireJoueur, inventaire du joueur
	 * @param moi, identification du joueur
	 * @return une Operation
	 */
	public Operation affectationOuvrier(CartesPresente<CarteOuvrier> tabOuvrier, int indice,InventaireJoueur inventaireJoueur,Identification moi)
	{
		return new OpAffectationOuvrier(indice,logger,moi);
	}

	/**
	 * Operation qui permet de mettre un batiment dans notre liste de batiment
	 *
	 * @param tabBatiment , Carte Batiment Presentes
	 * @param indice , Indice de la carte batiment souhaité
	 * @param inventaireJoueur, inventaire du joueur
	 * @param moi, identification du joueur
	 *
	 * @return une Operation
	 */
	public Operation affectationBatiment(CartesPresente<CarteBatiment> tabBatiment,int indice,InventaireJoueur inventaireJoueur,Identification moi)
	{
		return new OpAffectationBatiment(indice ,logger,moi);
	}

	/**
	 * Operation qui permet d'affecter un ouvrier à un batiment afin de pouvoir terminer un chantier
	 *
	 * @param batiment , Carte Batiment auquel on veut affecter un Ouvrier
	 * @param ouvrier , Ouvrier qu'on veut affecter à un Batiment
	 * @param inventaireJoueur, inventaire du joueur
	 * @param moi, identification du joueur
	 *
	 * @return une Operation
	 */
	public Operation affectationOuvrierBatiment(CarteBatiment batiment,CarteOuvrier ouvrier,InventaireJoueur inventaireJoueur,Identification moi)
	{
		return new OpAffectationOuvrierBatiment(ouvrier,batiment,logger,moi);
	}


	/**
	 * Operation qui permet d'affecter un ouvrier à un batiment afin de pouvoir terminer un chantier à l'aide d'un outil
	 *
	 * @param batiment , Carte Batiment auquel on veut affecter un Ouvrier
	 * @param ouvrier , Ouvrier qu'on veut affecter à un Batiment
	 * @param outils, Carte outils
	 * @param inventaireJoueur, inventaire du joueur
	 * @param moi, identification du joueur
	 *
	 * @return une Operation
	 */
	public Operation affectationOuvrierBatiment(CarteBatiment batiment, CarteOuvrier ouvrier, CarteOutils outils,InventaireJoueur inventaireJoueur,Identification moi)
	{
		return new OpAffectationOuvrierBatiment(ouvrier,batiment,outils,logger,moi);
	}


	/**
	 * Operation qui permet à un Joueur d'acheter une Action
	 * @param identification, identification du joueur
	 * @return une Operation
	 */
	public Operation achatNouvelleAction(Identification identification){

		return new OpAchatNouvelleAction(logger,identification);
	}

	/**
	 * Operation qui permet à un Joueur de récupérer un nombre d'Ecu
	 *
	 * @param ecuNecessaire, Nombre d'Ecu qui manque pour affecter un Ouvrier
	 *
	 * @return une Operation
	 */
	public Operation obtenirEcu(int ecuNecessaire, InventaireJoueur inventaireJoueur, Identification moi)
	{
		return new OpObtenirEcu(ecuNecessaire, inventaireJoueur, logger, moi);
	}

	/**
	 * Operation qui permet de jouer son tour
	 *
	 * @param lesCartesPresentes , CartesPresente
	 *
	 * @return une Opération
	 */
	public Operation jouer(LesCartesPresentes lesCartesPresentes, InventaireJoueur inventaireJoueur, Identification moi) {
		return strat.appliqueStrategie(lesCartesPresentes, inventaireJoueur,moi,logger);
	}


	/**
	 * Méthode qui permet de d'avoir un tableau avec toutes les données Statistiques.
	 */
	public String[] toStringStats() {
		String[] tabStatsJoueur = { getNom(), String.valueOf(rang) + "(" + String.valueOf(statsJoueur.calculeNbPointVictoire(getMainOuvrier())) + ")" ,
				String.valueOf(statsJoueur.getNbPointVictoireBatiment()),
				String.valueOf(statsJoueur.getNbPointVictoireEcu()), String.valueOf(statsJoueur.getNbPiocheOuvrier()),
				String.valueOf(statsJoueur.getNbPiocheBatiment()), String.valueOf(statsJoueur.getNbAffectation()),
				String.valueOf(statsJoueur.getNbPiocheEcu()), String.valueOf(statsJoueur.getNbAchatAction()),
				String.valueOf(statsJoueur.getNbEcuOuvrier()), String.valueOf(statsJoueur.getNbEcuBatiment()) };

		return tabStatsJoueur;
	}

	/**
	 * Permet de mettre à zero l'id qui nous indique combien d'ouvrier on été affectés sur un même batiment
	 */
	public void resetIdBatimentAffecter(){
		idBatimentAffecter = new ArrayList<Integer>();
	}

	/**
	 * Permet d'augmenter la valeur de l'id qui nous indique combien d'ouvrier on été affectés sur un même batiment
	 */
	public void addIdBatimentAffecter(int index){
		idBatimentAffecter.add(index);
	}


	/**
	 * Permet d'ajouter une strategie a un joueur
	 * @param strat, la strategie
	 */
	public void ajouteStrategie(Strategie strat) {
		this.strat = strat;
		strat.setJoueur(this);
	}

	/**
	 * Addition de valeur d'attributs utiles aux statistiques
	 */
	public void addition(){
		getStatsPartie().setNbPointVictoireBatiment(getStatsPartie().getNbPointVictoireBatiment() + getStats().getNbPointVictoireBatiment());
		getStatsPartie().setNbPointVictoireEcu(getStatsPartie().getNbPointVictoireEcu() + getStats().getNbPointVictoireEcu());
		getStatsPartie().setNbPiocheOuvrier(getStatsPartie().getNbPiocheOuvrier() + getStats().getNbPiocheOuvrier());
		getStatsPartie().setNbPiocheBatiment(getStatsPartie().getNbPiocheBatiment() + getStats().getNbPiocheBatiment());
		getStatsPartie().setNbAffectation(getStatsPartie().getNbAffectation() + getStats().getNbAffectation());
		getStatsPartie().setNbPiocheEcu(getStatsPartie().getNbPiocheEcu() + getStats().getNbPiocheEcu());
		getStatsPartie().setNbAchatAction(getStatsPartie().getNbAchatAction() + getStats().getNbAchatAction());
		getStatsPartie().setNbEcuOuvrier(getStatsPartie().getNbEcuOuvrier() + getStats().getNbEcuOuvrier());
		getStatsPartie().setNbEcuBatiment(getStatsPartie().getNbEcuBatiment() + getStats().getNbEcuBatiment());
		getStatsPartie().tabRang[getRang()-1] += 1;

	}

	/**
	 * Remise à zéro des valeurs d'attributs utiles aux statistiques
	 */
	public void reset(){
		this.statsJoueur = new StatistiqueJoueur(/*afficherStats*/);
		this.setEcu(25);
		this.setRang(0);
		this.mainBatiment = new HashMap<CarteBatiment, ArrayList<CarteOuvrier>>();
		this.mainOuvrier = new ArrayList<CarteOuvrier>();
	}

	/**
	 * Operation qui permet à un Joueur d'acheter un esclave
	 * @param loggerTrace, Logger de tracabilité
	 * @param moi, identification du joueur
	 * @param esclave, Cartes esclaves presentes
	 * @return une Operation
	 */
	public Operation achatEsclave(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteEsclave> esclave) {
		return new OpAchatEsclave(loggerTrace,moi,esclave);
	}

	/**
	 * Operation qui permet à un Joueur d'affranchir un esclave
	 * @param loggerTrace, Logger de tracabilité
	 * @param moi, identification du joueur
	 * @param esclave, Cartes esclaves presentes
	 * @return une Operation
	 */
	public Operation affranchirEsclave(LoggerTrace loggerTrace,Identification moi,CarteEsclave esclave) {
		return new OpAffranchirEsclave(loggerTrace,moi,esclave);
	}

	/**
	 * Operation qui permet à un Joueur d'acheter un outil
	 * @param loggerTrace, Logger de tracabilité
	 * @param moi, identification du joueur
	 * @param outils, Cartes outils presentes
	 * @return une Operation
	 */
	public Operation achatOutils(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteOutils> outils) {
		return new OpAchatOutil(loggerTrace,moi,outils);
	}

	/**
	 * Operation qui permet à un Joueur d'acheter un emprunt
	 * @param loggerTrace, Logger de tracabilité
	 * @param moi, identification du joueur
	 * @param emprunt, Cartes emprunts presentes
	 * @return une Operation
	 */
	public Operation prendreEmprunt(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteEmprunt> emprunt) {
		return new OpEmprunt(loggerTrace,moi,emprunt);
	}

	/**
	 * Operation qui permet à un Joueur de rembourser un emprunt
	 * @param loggerTrace, Logger de tracabilité
	 * @param moi, identification du joueur
	 * @param emprunt, Cartes emprunt
	 * @return une Operation
	 */
	public Operation rembourserEmprunt(LoggerTrace loggerTrace,Identification moi,CarteEmprunt emprunt) {
		return new OpRembourserEmprunt(loggerTrace,moi,emprunt);
	}

	/**
	 * Operation qui permet à un Joueur d'instruire un ouvrier à l'aide d'une carte université
	 * @param loggerTrace, Logger de tracabilité
	 * @param moi, identification du joueur
	 * @param cartesUniversité, Cartes Universitées presentes
	 * @return une Operation
	 */
	public Operation instruireOuvrier(LoggerTrace loggerTrace,Identification moi,CartesPresente<CarteUniversite> cartesUniversité, CarteOuvrier ouvrier) {
		return new OpInstruire(loggerTrace,moi,cartesUniversité, ouvrier);
	}

}
