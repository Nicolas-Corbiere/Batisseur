package partieTest;

import carte.CarteBatiment;
import carte.CarteOuvrier;

import org.junit.jupiter.api.Test;
import partie.Partie;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRemplirCarte
{
	/*
	private boolean estSilencieuxTrace = false;
	private boolean estSilencieuxStat = false;

    @Test
    public void TestRemplirCarteBatimentsPresent1()
    {
        boolean estSilencieux = true;

        int y = 0;
	        
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));	
        
        CarteBatiment[] carte;
        Partie partie = new Partie(0, listJoueur, estSilencieux);
        partie.remplirCarteBatimentsPresent();
        carte = partie.getCarteBatimentsPresente();

        for (int i = 0; i < 5; i++) {
            if (carte[i] != null) {
                y += 1;
            } else {
                y += 0;
            }
        }
        assertEquals(5, y);
    }


    @Test
    public void TestRemplirCarteBatimentsPresent2()
    {
        boolean estSilencieux = true;

        int y=0;
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		
        CarteBatiment[] carte;
        Partie partie = new Partie(0, listJoueur, estSilencieux);
        partie.remplirCarteBatimentsPresent();
        carte = partie.getCarteBatimentsPresente();

        carte[0]=null;
        for(int i=0; i<5;i++){
            if (carte[i] != null){
                y+=1;
            }
            else{
                y+=0;
            }
        }
        assertEquals(4,y);

    }


    @Test
    public void TestRemplirCarteOuvriesPresent1()
    {
        boolean estSilencieux = true;

        int y = 0;
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		
        CarteOuvrier[] carte;
        Partie partie = new Partie(0, listJoueur, estSilencieux);
        partie.remplirCarteBatimentsPresent();
        carte = partie.getCarteOuvriersPresente();

        for (int i = 0; i < 5; i++) {
            if (carte[i] != null) {
                y += 1;
            } else {
                y += 0;
            }
        }
        assertEquals(5, y);
    }

    @Test
    public void TestRemplirCarteOuvriesPresent2()
    {
        boolean estSilencieux = true;

        int y=0;
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur> ();
        
		listJoueur.add(new Joueur("John", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Smith", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Wilson", estSilencieuxTrace, estSilencieuxStat));
		listJoueur.add(new Joueur("Kevin", estSilencieuxTrace, estSilencieuxStat));
		
		listJoueur.get(0).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(1).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(2).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		listJoueur.get(3).ajouteStrategie(new StrategieBasique(estSilencieuxTrace));
		
        CarteOuvrier[] carte;
        Partie partie = new Partie(0, listJoueur, estSilencieux);
        partie.remplirCarteOuvriersPresent();
        carte = partie.getCarteOuvriersPresente();

        carte[0]=null;
        for(int i=0; i<5;i++){
            if (carte[i] != null){
                y+=1;
            }
            else{
                y+=0;
            }
        }
        assertEquals(4,y);

    }
*/
}
