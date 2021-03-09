package operationTest.operationInvestissementTest;

import carte.CarteEsclave;
import carte.cartesPresente.CartesPresente;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.Operation;
import operation.investissement.OpAchatEsclave;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class OpAchatEsclaveTest
{

    private final MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.160",42321), ModeDeJeu.Antiquite,true);
    private final LoggerTrace loggerTrace = new LoggerTrace();
    private final Identification Dio = new Identification("Dio");
    {
        moteurTMP.ajouterJoueur(Dio,1);
        moteurTMP.creationPartie();
    }

    /**
     *
     */
    @Test
    public void testAchatEsclave()
    {
        CartesPresente<CarteEsclave> esclaveCartesPresente = moteurTMP.getCartePresente().getCartesPresente(CarteEsclave.class);

        CarteEsclave carteEsclave = esclaveCartesPresente.getCarte(0);
        int ecuAttendu = moteurTMP.getInventaireDuJoueur(Dio).getEcu() - 7;

        Operation operation = new OpAchatEsclave(loggerTrace,Dio,esclaveCartesPresente);
        operation.faireOperation(moteurTMP,Dio,null);

       // assertTrue(moteurTMP.getInventaireDuJoueur(Dio).getMainOuvrier().contains(carteEsclave));
        assertEquals(ecuAttendu, moteurTMP.getInventaireDuJoueur(Dio).getEcu());
    }
}
