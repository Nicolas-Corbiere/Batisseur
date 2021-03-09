package carteTest;

import carte.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCarteMachine
{

    @Test
    public void TestEquals0()
    {
        CarteMachine carte0 = new CarteMachine(1, "Machine", new int[]{0,1,0,1}, 1, CarteRessource.RessourceBois,3);
        CarteMachine carte1 = new CarteMachine(1, "Machine", new int[]{0,1,0,1}, 1, CarteRessource.RessourceBois,3);

        assertTrue(carte0.equals(carte1));
    }

    @Test
    public void TestEquals1()
    {
        CarteMachine carte0 = new CarteMachine(1, "Machine", new int[]{0,1,0,1}, 1, CarteRessource.RessourceBois,3);
        CarteMachine carte1 = new CarteMachine(2, "Machine", new int[]{0,1,0,1}, 1, CarteRessource.RessourceBois,3);

        assertFalse(carte0.equals(carte1));
    }

    @Test
    public void TestEquals2()
    {
        CarteMachine carte0 = new CarteMachine(1, "Machine", new int[]{0,1,0,1}, 1, CarteRessource.RessourceBois,3);
        CarteBatiment carte1 = new CarteBatiment(1, "Machine", new int[]{0,1,0,1}, 0, 1);

        assertFalse(carte0.equals(carte1));
    }

    @Test
    public void TestEquals3()
    {
        CarteBatiment carte0 = new CarteMachine(1, "Machine", new int[]{0,1,0,1}, 1,CarteRessource.RessourceBois,3);
        CarteMachine carte1 = new CarteMachine(2, "Machine", new int[]{0,1,0,1}, 1,CarteRessource.RessourceBois,3);

        assertFalse(carte0.equals(carte1));
    }

    @Test
    public void TestConvertToCarteOuvrier()
    {
        CarteMachine carteMachine = new CarteMachine(1, "Machine", new int[]{0,1,0,1}, 1,CarteRessource.RessourceBois, 3);
        CarteOuvrier carteOuvrier = new CarteOuvrier(1,"Machine", new int[]{0,3,0,0}, 0);

        assertTrue(carteOuvrier.equals(carteMachine.getOtherVesionCarte()));
    }
}
