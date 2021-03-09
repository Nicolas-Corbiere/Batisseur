package mainJoueurTest;

import carte.Carte;
import carte.CarteEmprunt;
import mainJoueur.MainJoueur;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainJoueurTest
{
    /*
    @Test
    public void testAjoutCarte0()
    {
        MainJoueur mainJoueur = new MainJoueur();
        assertTrue(mainJoueur.ajoutCarte(new CarteEmprunt(0)));
    }

    @Test
    public void testAjoutCarte1()
    {
        MainJoueur mainJoueur = new MainJoueur();
        assertTrue(mainJoueur.ajoutCarte(new CarteEmprunt(0)));
        assertFalse(mainJoueur.ajoutCarte(new CarteEmprunt(0)));
    }

    @Test
    public void testAjoutCartes0()
    {
        MainJoueur mainJoueur = new MainJoueur();
        assertTrue(mainJoueur.ajoutCartes(new CarteEmprunt(0), new CarteEmprunt(1)));
        assertFalse(mainJoueur.ajoutCartes(new CarteEmprunt(0), new CarteEmprunt(1)));
    }

    @Test
    public void testAjoutCartes1()
    {
        MainJoueur mainJoueur = new MainJoueur();
        assertTrue(mainJoueur.ajoutCartes(new CarteEmprunt(0), new CarteEmprunt(1)));
        assertTrue(mainJoueur.ajoutCartes(new CarteEmprunt(0), new CarteEmprunt(2)));
    }

    @Test
    public void testAjoutCartes2()
    {
        ArrayList<Carte> arrayList = new ArrayList<>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1)));
        MainJoueur mainJoueur = new MainJoueur();
        assertTrue(mainJoueur.ajoutCartes(arrayList));
        assertFalse(mainJoueur.ajoutCartes(arrayList));
    }

    @Test
    public void testEnleverCarte0()
    {
        CarteEmprunt carte = new CarteEmprunt(0);
        MainJoueur mainJoueur = new MainJoueur();
        assertFalse(mainJoueur.enleverCarte(carte));
    }

    @Test
    public void testEnleverCarte1()
    {
        CarteEmprunt carte = new CarteEmprunt(0);
        MainJoueur mainJoueur = new MainJoueur();
        mainJoueur.ajoutCarte(carte);
        assertTrue(mainJoueur.enleverCarte(carte));
    }

    @Test
    public void testEnleverCartes0()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur();
        mainJoueur.ajoutCartes(cartes);
        assertTrue(mainJoueur.enleverCartes(cartes));
    }

    @Test
    public void testEnleverCartes1()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur();
        assertFalse(mainJoueur.enleverCartes(cartes));
    }

    @Test
    public void testEnleverCartes2()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur(cartes);
        assertTrue(mainJoueur.enleverCartes(new CarteEmprunt(0), new CarteEmprunt(2)));
    }

    @Test
    public void testContains()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur(cartes);
        assertTrue(mainJoueur.contains(cartes.get(0)));
        assertTrue(mainJoueur.contains(new CarteEmprunt(1)));
        assertFalse(mainJoueur.contains(new CarteEmprunt(3)));
    }

    @Test
    public void testSize()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur(cartes);
        assertEquals(3, mainJoueur.nombreCartes());
    }

    @Test
    public void testGetCarte()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur(cartes);
        assertEquals(new CarteEmprunt(0), mainJoueur.getCarte(0));
    }

    @Test
    public void testSearchIndex()
    {
        ArrayList<Carte> cartes = new ArrayList<Carte>(Arrays.asList(new CarteEmprunt(0), new CarteEmprunt(1), new CarteEmprunt(2)));
        MainJoueur mainJoueur = new MainJoueur(cartes);
        //Comparésont par l'objet
        assertEquals(cartes.get(1), mainJoueur.getCarte(mainJoueur.searchIndex(cartes.get(1))));
    }

     */
}
