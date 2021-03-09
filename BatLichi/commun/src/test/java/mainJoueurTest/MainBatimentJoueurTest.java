package mainJoueurTest;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import mainJoueur.MainBatimentJoueur;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class MainBatimentJoueurTest
{
/*
    private static final ArrayList<CarteBatiment> carteBatiments = new ArrayList<CarteBatiment>(Arrays.asList(
            new CarteBatiment(0,"",new int[0],0,0),
            new CarteBatiment(1,"",new int[0],0,0),
            new CarteBatiment(2,"",new int[0],0,0)
    ));

    private static final ArrayList<CarteOuvrier> carteOuvriers = new ArrayList<CarteOuvrier>(Arrays.asList(
            new CarteOuvrier(0,"",new int[0],0),
            new CarteOuvrier(1,"",new int[0],0),
            new CarteOuvrier(2,"",new int[0],0),
            new CarteOuvrier(3,"",new int[0],0)
    ));

    @Test
    public void testAjoutCarte0()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertTrue(mainBatimentJoueur.ajoutCarte(carteBatiments.get(0)));
    }

    @Test
    public void testAjoutCarte1()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertTrue(mainBatimentJoueur.ajoutCarte(carteBatiments.get(0)));
        assertTrue(mainBatimentJoueur.ajoutCarte(carteBatiments.get(1)));
    }

    @Test
    public void testAjoutCarte2()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertTrue(mainBatimentJoueur.ajoutCarte(carteBatiments.get(0)));
        assertFalse(mainBatimentJoueur.ajoutCarte(carteBatiments.get(0)));
    }

    @Test
    public void testAjoutCartes0()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertTrue(mainBatimentJoueur.ajoutCartes(carteBatiments.get(0), carteBatiments.get(1)));
    }

    @Test
    public void testAjoutCartes1()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertTrue(mainBatimentJoueur.ajoutCartes(carteBatiments.get(0), carteBatiments.get(0), carteBatiments.get(1),carteBatiments.get(2)));
    }

    @Test
    public void testAjoutCartes2()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertTrue(mainBatimentJoueur.ajoutCartes(carteBatiments));
    }

    @Test
    public void testEnleverCarte0()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.enleverCarte(carteBatiments.get(1)));
    }

    @Test
    public void testEnleverCarte1()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertFalse(mainBatimentJoueur.enleverCarte(carteBatiments.get(1)));
    }

    @Test
    public void testEnleverCartes0()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.enleverCartes(carteBatiments.get(1), carteBatiments.get(0)));
    }

    @Test
    public void testEnleverCartes1()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.enleverCartes(carteBatiments));
    }

    @Test
    public void testEnleverCartes2()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur();
        assertFalse(mainBatimentJoueur.enleverCartes(carteBatiments));
    }

    @Test
    public void testContains()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.contains(carteBatiments.get(2)));
    }

    @Test
    public void testSize()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertEquals(carteBatiments.size(), mainBatimentJoueur.nombreCartes());
    }

    @Test
    public void testGetCarte()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertEquals(carteBatiments.get(1), mainBatimentJoueur.getCarte(carteBatiments.get(1)));
    }

    @Test
    public void testSearchIndex()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertEquals(carteBatiments.get(1), mainBatimentJoueur.getCarte(mainBatimentJoueur.getCarte(carteBatiments.get(1))));
    }

    @Test
    public void testAjoutCarteOuvrier0()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.ajoutCarteOuvrier(carteBatiments.get(0), carteOuvriers.get(0)));
    }

    @Test
    public void testAjoutCarteOuvrier1()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        mainBatimentJoueur.ajoutCarteOuvrier(carteBatiments.get(0), carteOuvriers.get(0));
        assertFalse(mainBatimentJoueur.ajoutCarteOuvrier(carteBatiments.get(0), carteOuvriers.get(0)));
    }

    @Test
    public void testAjoutCarteOuvriers0()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.ajoutCartesOuvriers(carteBatiments.get(0), carteOuvriers.get(0), carteOuvriers.get(1)));
    }

    @Test
    public void testAjoutCarteOuvriers1()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        assertTrue(mainBatimentJoueur.ajoutCartesOuvriers(carteBatiments.get(0), carteOuvriers));
    }

    @Test
    public void testAjoutCarteOuvriers2()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        mainBatimentJoueur.ajoutCartesOuvriers(carteBatiments.get(0), carteOuvriers);
        assertFalse(mainBatimentJoueur.ajoutCartesOuvriers(carteBatiments.get(0), carteOuvriers));
    }

    @Test
    public void testRemoveCarteOuvrier()
    {
        MainBatimentJoueur mainBatimentJoueur = new MainBatimentJoueur(carteBatiments);
        mainBatimentJoueur.ajoutCartesOuvriers(carteBatiments.get(1), carteOuvriers);
        assertEquals(new HashSet<CarteOuvrier>(carteOuvriers), new HashSet<CarteOuvrier>(mainBatimentJoueur.removeOuvriers(carteBatiments.get(1))));
    }

 */
}
