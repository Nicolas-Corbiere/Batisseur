package operationTest.operationInvestissementTest;

import carte.CarteEmprunt;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.Operation;
import operation.investissement.OpEmprunt;
import operation.investissement.OpRembourserEmprunt;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class OpEmpruntTest
{
    private final MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.160",42321),ModeDeJeu.Antiquite,true);
    private final LoggerTrace loggerTrace = new LoggerTrace();
    private final Identification Tennos = new Identification("Tennos");
    {
        moteurTMP.ajouterJoueur(Tennos,1);
        moteurTMP.creationPartie();
    }
    private final CarteEmprunt carteEmprunt = moteurTMP.getPartie().getLesCartesPresentes().getCartesPresente(CarteEmprunt.class).getCarte(0);

    /**
     * Test ajout des cartes emprunts dans la main et l'ajout des ecus
     */
    @Test
    public void faireEmprunt()
    {
        int ecuAttendu = carteEmprunt.getEcu() + moteurTMP.getInventaireDuJoueur(Tennos).getEcu();

        Operation operation = new OpEmprunt(loggerTrace, Tennos,moteurTMP.getPartie().getLesCartesPresentes().getCartesPresente(CarteEmprunt.class));
        operation.faireOperation(moteurTMP, Tennos,null);

        assertTrue(moteurTMP.getInventaireDuJoueur(Tennos).getMainEmprunt().contains(carteEmprunt));
        assertEquals(ecuAttendu, moteurTMP.getInventaireDuJoueur(Tennos).getEcu());
    }

    /**
     * Test la suppression des cartes emprunts dans la main et la soustraction des ecus
     */
    @Test
    public void rembourserEmprunt()
    {
        int ecuAttendu = moteurTMP.getInventaireDuJoueur(Tennos).getEcu() - CarteEmprunt.coutEcuRembourser;

        Operation operation = new OpRembourserEmprunt(loggerTrace, Tennos, carteEmprunt);
        operation.faireOperation(moteurTMP,Tennos,null);

        assertFalse(moteurTMP.getInventaireDuJoueur(Tennos).getMainEmprunt().contains(carteEmprunt));
        assertEquals(ecuAttendu, moteurTMP.getInventaireDuJoueur(Tennos).getEcu());
    }
}
