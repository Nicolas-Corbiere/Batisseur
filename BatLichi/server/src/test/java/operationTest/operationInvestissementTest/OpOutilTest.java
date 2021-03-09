package operationTest.operationInvestissementTest;

import carte.*;
import carte.cartesPresente.CartesPresente;
import carte.factory.CarteFactoryAntiquite;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.Operation;
import operation.investissement.OpAchatOutil;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class OpOutilTest
{
    /**
     *
     */
    private final MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.160",42321),ModeDeJeu.Antiquite,true);
    private final LoggerTrace loggerTrace = new LoggerTrace();
    private final Identification Bob_Le_Bricoleur = new Identification("Bob Le Bricoleur");
    {
        moteurTMP.ajouterJoueur(Bob_Le_Bricoleur,1);
        moteurTMP.creationPartie();
    }
    private final CarteOutils carteOutils = moteurTMP.getCartePresente().getCartesPresente(CarteOutils.class).getCarte(0);

    /**
     *
     */
    @Test
    public void testAchatOutils()
    {
        CartesPresente<CarteOutils> outilsCartesPresente = moteurTMP.getCartePresente().getCartesPresente(CarteOutils.class);
        CarteOutils carteOutils = outilsCartesPresente.getCarte(0);

        int ecuAttendu = moteurTMP.getInventaireDuJoueur(Bob_Le_Bricoleur).getEcu() - 2;

        Operation operation = new OpAchatOutil(loggerTrace,Bob_Le_Bricoleur,outilsCartesPresente);
        operation.faireOperation(moteurTMP,Bob_Le_Bricoleur,null);

//        assertTrue(moteurTMP.getInventaireDuJoueur(Bob_Le_Bricoleur).getMainOutils().contains(carteOutils));
        assertEquals(ecuAttendu, moteurTMP.getInventaireDuJoueur(Bob_Le_Bricoleur).getEcu());
    }
}
