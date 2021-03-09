package operationTest.operationInvestissementTest;

import identification.Identification;
import partie.MoteurTMP;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class OpInvestissementTest
{
    /**
     *
     * @param moteur
     * @param idJoueur
     */
    public static void investissementFait(MoteurTMP moteur, Identification idJoueur)
    {
        assertTrue(moteur.getInventaireDuJoueur(idJoueur).isInvestissementFait());
    }

    /**
     *
     * @param moteur
     * @param idJoueur
     */
    public static void investissementNonFait(MoteurTMP moteur, Identification idJoueur)
    {
        assertFalse(moteur.getInventaireDuJoueur(idJoueur).isInvestissementFait());
    }
}
