package partieTest;

//import joueur.StrategieBasique;
//import joueur.StrategieMedium;
//import joueur.Joueur;
import org.junit.jupiter.api.Test;
import partie.Partie;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGagant
{

	private boolean estSilencieuxTrace = false;
	private boolean estSilencieuxStat = false;
	/*
    @Test
    public void TestGagnantDePartie1()
    {
    	
    	

        boolean estSilencieux  = true;
        //creation des joueurs
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		

        listJoueur.get(0).setNbPointVictoireBat(0);
        listJoueur.get(1).setNbPointVictoireBat(5);
        listJoueur.get(2).setNbPointVictoireBat(10);

        Partie partie = new Partie(0, listJoueur, estSilencieux);

        partie.lancerPartie();


        assertEquals(true, partie.getGagnant().getNom().equals("Wilson"));

    }


    @Test
    public void TestGagnantDePartie2()
    {

        boolean estSilencieux  = true;

        //creation des joueurs
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));

        listJoueur.get(0).setNbPointVictoireBat(0);
        listJoueur.get(1).setNbPointVictoireBat(0);
        listJoueur.get(2).setNbPointVictoireBat(10);
        Partie partie = new Partie(0, listJoueur, estSilencieux);

        partie.lancerPartie();
        assertEquals(true, partie.getGagnant().getNom().equals("Wilson"));

    }


    @Test
    public void TestGagnantDePartie3()
    {

        boolean estSilencieux  = true;

        //creation des joueurs
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));

        listJoueur.get(0).setNbPointVictoireBat(5);
        listJoueur.get(1).setNbPointVictoireBat(15);
        listJoueur.get(2).setNbPointVictoireBat(10);
        Partie partie = new Partie(0, listJoueur, estSilencieux);

        partie.lancerPartie();
        assertEquals(true, partie.getGagnant().getNom().equals("Smith"));

    }


    @Test
    public void TestGagnantDePartie4()
    {

        boolean estSilencieux  = true;

        //creation des joueurs
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));

        listJoueur.get(0).setNbPointVictoireBat(15);
        listJoueur.get(1).setNbPointVictoireBat(15);
        listJoueur.get(2).setNbPointVictoireBat(15);
        Partie partie = new Partie(0, listJoueur, estSilencieux);

        partie.lancerPartie();
        assertEquals(true, partie.getGagnant().getNom().equals("John"));


    }*/

}
