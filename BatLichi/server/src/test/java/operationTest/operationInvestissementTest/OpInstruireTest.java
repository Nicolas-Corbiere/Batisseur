package operationTest.operationInvestissementTest;

import carte.CarteOuvrier;
import carte.CarteUniversite;
import carte.factory.CarteFactoryAntiquite;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.Operation;
import operation.investissement.OpInstruire;
import org.junit.jupiter.api.*;
import partie.MoteurTMP;
import serveur.Serveur;

import static org.junit.jupiter.api.Assertions.*;

public class OpInstruireTest
{
    private final MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.160",42321),ModeDeJeu.Antiquite,true);
    private final LoggerTrace loggerTrace = new LoggerTrace();
    private final Identification Kira = new Identification("Kira");
    {
        moteurTMP.ajouterJoueur(Kira,1);
        moteurTMP.creationPartie();
    }


    /**
     * Verifie si l'ouvrier a été instruit
     */
    @Test
    public void instruire()
    {
        moteurTMP.getInventaireDuJoueur(Kira).getMainOuvrier().ajoutCartes(new CarteFactoryAntiquite().creeCartesOuvrier());

        CarteUniversite carteUniversiteAssigne = moteurTMP.getPartie().getLesCartesPresentes().getCartesPresente(CarteUniversite.class).getCarte(0);
        CarteOuvrier carteOuvrier = moteurTMP.getInventaireDuJoueur(Kira).getMainOuvrier().getCarte(1);

        assertNotEquals(carteUniversiteAssigne, carteOuvrier.getCarteUniversiteAssigne());

        Operation operation = new OpInstruire(loggerTrace,Kira,null,carteOuvrier);
        operation.faireOperation(moteurTMP,Kira,null);

        assertEquals(carteUniversiteAssigne, carteOuvrier.getCarteUniversiteAssigne());
        OpInvestissementTest.investissementFait(moteurTMP,Kira);
    }

    /**
     * Verifie si l'esclave n'a pas été instruit
     */
    @Test
    public void instruireEsclave()
    {
        moteurTMP.getInventaireDuJoueur(Kira).getMainOuvrier().ajoutCartes(new CarteFactoryAntiquite().creeCartesOuvrier());

        CarteUniversite carteUniversiteAssigne = moteurTMP.getPartie().getLesCartesPresentes().getCartesPresente(CarteUniversite.class).getCarte(0);
        CarteOuvrier carteOuvrier = moteurTMP.getInventaireDuJoueur(Kira).getMainOuvrier().getCarte(0);

        assertNotEquals(carteUniversiteAssigne, carteOuvrier.getCarteUniversiteAssigne());

        Operation operation = new OpInstruire(loggerTrace,Kira,null,carteOuvrier);
        operation.faireOperation(moteurTMP,Kira,null);

        assertEquals(null, carteOuvrier.getCarteUniversiteAssigne());
        OpInvestissementTest.investissementNonFait(moteurTMP,Kira);
    }

}
