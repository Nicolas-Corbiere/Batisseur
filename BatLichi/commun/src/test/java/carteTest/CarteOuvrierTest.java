package carteTest;

import carte.CarteEsclave;
import carte.CarteOutils;
import carte.CarteOuvrier;
import carte.CarteUniversite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarteOuvrierTest
{

    @Test
    public void instruireOuvrier0()
    {
        CarteOuvrier carteOuvrier = new CarteOuvrier(0,"",new int[0],0);
        CarteUniversite carteUniversite = new CarteUniversite(1,"", new int[0], 0);

        assertTrue(carteOuvrier.assigneCarteUniversite(carteUniversite));
        assertFalse(carteOuvrier.assigneCarteUniversite(carteUniversite));
    }

    @Test
    public void instruireOuvrier1()
    {
        CarteOuvrier carteOuvrier = new CarteEsclave(0,"",new int[0]);
        CarteUniversite carteUniversite = new CarteUniversite(1,"", new int[0], 0);

        assertFalse(carteOuvrier.assigneCarteUniversite(carteUniversite));
    }

    @Test
    public void instruireOuvrier2()
    {
        CarteOuvrier carteOuvrier = new CarteOuvrier(0,"",new int[0],0);
        CarteUniversite carteUniversite = new CarteUniversite(1,"", new int[0], 0);

        assertFalse(carteOuvrier.assigneCarteUniversite(null));
        assertTrue(carteOuvrier.assigneCarteUniversite(carteUniversite));
    }

    @Test
    public void assigneOutils0()
    {
        CarteOuvrier carteOuvrier = new CarteOuvrier(0,"",new int[0],0);
        CarteOutils carteOutils = new CarteOutils(1,"",new int[0]);

        assertFalse(carteOuvrier.assignerCarteOutils(null));
        assertTrue(carteOuvrier.assignerCarteOutils(carteOutils));
    }

    @Test
    public void assigneOutils1()
    {
        CarteOuvrier carteOuvrier = new CarteOuvrier(0,"",new int[0],0);
        CarteOutils carteOutils = new CarteOutils(1,"",new int[0]);

        assertTrue(carteOuvrier.assignerCarteOutils(carteOutils));
        assertFalse(carteOuvrier.assignerCarteOutils(carteOutils));
    }

    @Test
    public void assigneOutils2()
    {
        CarteOuvrier carteOuvrier = new CarteEsclave(0,"",new int[0]);
        CarteOutils carteOutils = new CarteOutils(1,"",new int[0]);

        assertFalse(carteOuvrier.assignerCarteOutils(carteOutils));
    }
}
