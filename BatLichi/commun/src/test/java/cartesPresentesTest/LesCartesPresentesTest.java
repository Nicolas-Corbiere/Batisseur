package cartesPresentesTest;

import carte.*;
import carte.cartesPresente.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LesCartesPresentesTest
{
    @Test
    public void testLesCartesPresentesMoyenAge()
    {
        ArrayList<CarteBatiment> arrayBat = new ArrayList<>();
        arrayBat.add(new CarteBatiment(0,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(1,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(2,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(3,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(4,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(5,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(6,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(7,"",new int[0],0,0));

        ArrayList<CarteOuvrier> arrayOuv = new ArrayList<>();
        arrayOuv.add(new CarteOuvrier(0,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(1,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(2,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(3,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(4,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(5,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(6,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(7,"",new int[0],0));

        PileDeCarte<CarteBatiment> pileBatiment = new PileDeCarte<>(arrayBat);
        PileDeCarte<CarteOuvrier> pileOuvrier = new PileDeCarte<>(arrayOuv);

        assertEquals(arrayBat.size(), pileBatiment.longueurArray());
        assertEquals(arrayOuv.size(), pileOuvrier.longueurArray());

        LesCartesPresentes cartesPresentes = new LesCartesPresentesMoyenAge(pileBatiment, pileOuvrier);

        CartesPresente<CarteBatiment> batimentCartesPresente;
        CartesPresente<CarteOuvrier> ouvrierCartesPresente;
        assertTrue(null!=(batimentCartesPresente = cartesPresentes.getCartesPresente(CarteBatiment.class)));
        assertTrue(null!=(ouvrierCartesPresente = cartesPresentes.getCartesPresente(CarteOuvrier.class)));
        assertTrue(null==(cartesPresentes.getCartesPresente(CarteOutils.class)));

        testCartesPresente(batimentCartesPresente);
        testCartesPresente(ouvrierCartesPresente);

        assertTrue(arrayBat.size() > pileBatiment.longueurArray());
        assertTrue(arrayOuv.size() > pileOuvrier.longueurArray());

    }

    @Test
    public void testLesCartesPresentesAntiquite()
    {
        ArrayList<CarteBatiment> arrayBat = new ArrayList<>();
        arrayBat.add(new CarteBatiment(0,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(1,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(2,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(3,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(4,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(5,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(6,"",new int[0],0,0));
        arrayBat.add(new CarteBatiment(7,"",new int[0],0,0));

        ArrayList<CarteOuvrier> arrayOuv = new ArrayList<>();
        arrayOuv.add(new CarteOuvrier(0,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(1,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(2,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(3,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(4,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(5,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(6,"",new int[0],0));
        arrayOuv.add(new CarteOuvrier(7,"",new int[0],0));

        ArrayList<CarteEmprunt> arrayEmprunt = new ArrayList<>();
        arrayEmprunt.add(new CarteEmprunt(0));
        arrayEmprunt.add(new CarteEmprunt(1));
        arrayEmprunt.add(new CarteEmprunt(2));
        arrayEmprunt.add(new CarteEmprunt(3));

        ArrayList<CarteEsclave> arrayEsclave = new ArrayList<>();
        arrayEsclave.add(new CarteEsclave(0,"",new int[0]));
        arrayEsclave.add(new CarteEsclave(1,"",new int[0]));
        arrayEsclave.add(new CarteEsclave(2,"",new int[0]));
        arrayEsclave.add(new CarteEsclave(3,"",new int[0]));

        ArrayList<CarteUniversite> arrayUniversite = new ArrayList<>();
        arrayUniversite.add(new CarteUniversite(0,"",new int[0],0));
        arrayUniversite.add(new CarteUniversite(1,"",new int[0],0));
        arrayUniversite.add(new CarteUniversite(2,"",new int[0],0));
        arrayUniversite.add(new CarteUniversite(3,"",new int[0],0));

        ArrayList<CarteOutils> arrayOutils = new ArrayList<>();
        arrayOutils.add(new CarteOutils(0,"",new int[0]));
        arrayOutils.add(new CarteOutils(1,"",new int[0]));
        arrayOutils.add(new CarteOutils(2,"",new int[0]));
        arrayOutils.add(new CarteOutils(3,"",new int[0]));

        PileDeCarte<CarteBatiment> pileBatiment = new PileDeCarte<>(arrayBat);
        PileDeCarte<CarteOuvrier> pileOuvrier = new PileDeCarte<>(arrayOuv);
        PileDeCarte<CarteEmprunt> pileEmprunt = new PileDeCarte<>(arrayEmprunt);
        PileDeCarte<CarteEsclave> pileEsclave = new PileDeCarte<>(arrayEsclave);
        PileDeCarte<CarteUniversite> pileUniversite = new PileDeCarte<>(arrayUniversite);
        PileDeCarte<CarteOutils> pileOutils = new PileDeCarte<>(arrayOutils);

        assertEquals(arrayBat.size(), pileBatiment.longueurArray());
        assertEquals(arrayOuv.size(), pileOuvrier.longueurArray());
        assertEquals(arrayEmprunt.size(), pileEmprunt.longueurArray());
        assertEquals(arrayEsclave.size(), pileEsclave.longueurArray());
        assertEquals(arrayUniversite.size(), pileUniversite.longueurArray());
        assertEquals(arrayOutils.size(), pileOutils.longueurArray());

        LesCartesPresentes cartesPresentes = new LesCartesPresentesAntiquite(pileBatiment, pileOuvrier, pileEmprunt, pileEsclave, pileUniversite, pileOutils);

        CartesPresente<CarteBatiment> batimentCartesPresente;
        CartesPresente<CarteOuvrier> ouvrierCartesPresente;
        CartesPresente<CarteEmprunt> empruntCartesPresente;
        CartesPresente<CarteEsclave> esclaveCartesPresente;
        CartesPresente<CarteUniversite> universiteCartesPresente;
        CartesPresente<CarteOutils> outilsCartesPresente;

        assertTrue(null!=(batimentCartesPresente = cartesPresentes.getCartesPresente(CarteBatiment.class)));
        assertTrue(null!=(ouvrierCartesPresente = cartesPresentes.getCartesPresente(CarteOuvrier.class)));
        assertTrue(null!=(empruntCartesPresente = cartesPresentes.getCartesPresente(CarteEmprunt.class)));
        assertTrue(null!=(esclaveCartesPresente = cartesPresentes.getCartesPresente(CarteEsclave.class)));
        assertTrue(null!=(universiteCartesPresente = cartesPresentes.getCartesPresente(CarteUniversite.class)));
        assertTrue(null!=(outilsCartesPresente = cartesPresentes.getCartesPresente(CarteOutils.class)));

        testCartesPresente(batimentCartesPresente);
        testCartesPresente(ouvrierCartesPresente);
        testCartesPresente(empruntCartesPresente);
        testCartesPresente(esclaveCartesPresente);
        testCartesPresente(universiteCartesPresente);
        testCartesPresente(outilsCartesPresente);

        assertTrue(arrayBat.size() > pileBatiment.longueurArray());
        assertTrue(arrayOuv.size() > pileOuvrier.longueurArray());
        assertTrue(arrayEmprunt.size() > pileEmprunt.longueurArray());
        assertTrue(arrayEsclave.size() > pileEsclave.longueurArray());
        assertTrue(arrayUniversite.size() > pileUniversite.longueurArray());
        assertTrue(arrayOutils.size() > pileOutils.longueurArray());

    }

    public <T extends Carte> void testCartesPresente(CartesPresente<T> cartesPresente)
    {

        assertFalse(cartesPresente.placeVide());

        for(int i = 0; i < cartesPresente.taille(); i++)
        {
            T carteLu = cartesPresente.getCarte(i);
            T cartePris = cartesPresente.prendreCarte(i);

            assertEquals(carteLu, cartePris);
            assertNotEquals(carteLu = cartesPresente.getCarte(i), cartePris);
        }
    }
}
