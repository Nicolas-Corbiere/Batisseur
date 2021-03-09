package operationTest;

import carte.Carte;
import carte.CarteBatiment;
import carte.CarteOutils;
import carte.CarteOuvrier;
import carte.factory.CarteFactoryAntiquite;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.OpAffectationOuvrierBatiment;
import operation.Operation;
import operationTest.operationInvestissementTest.OpInvestissementTest;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;
import statistique.StatistiqueJoueur;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OpAffectationOuvrierBatimentTest
{
    private final CarteFactoryAntiquite factory = new CarteFactoryAntiquite();
    private final ArrayList<CarteOutils> listeCarteOutils = factory.creeCarteOutils();
    private final ArrayList<CarteOuvrier> listeCarteOuvrier = factory.creeCartesOuvrier();
    private final ArrayList<CarteBatiment> listeCarteBatiment = factory.creeCartesBatimant();
    private final LoggerTrace logger = new LoggerTrace();
    private final StatistiqueJoueur statistiqueJoueur = new StatistiqueJoueur();
    private boolean trace = false;
    private boolean stat = false;

    @Test
    public void affectationCarteOuvrierBatiment()
    {

        Identification bot = new Identification("Picard");
        MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.45", 48), ModeDeJeu.Antiquite, trace);
        moteurTMP.ajouterJoueur(bot,0);
        moteurTMP.getInventaireDuJoueur(bot).getMainBatiment().ajoutCartes(listeCarteBatiment);
        moteurTMP.getInventaireDuJoueur(bot).getMainOuvrier().ajoutCartes(listeCarteOuvrier);

        CarteOuvrier carteOuvrier = moteurTMP.getInventaireDuJoueur(bot).getMainOuvrier().getCarte(0);
        CarteBatiment carteBatiment = moteurTMP.getInventaireDuJoueur(bot).getMainBatiment().getCarte(0);

        Operation operation = new OpAffectationOuvrierBatiment(carteOuvrier,carteBatiment,logger,bot);
        operation.faireOperation(moteurTMP,bot,statistiqueJoueur);

        OpInvestissementTest.investissementNonFait(moteurTMP,bot);

        assertTrue(moteurTMP.getInventaireDuJoueur(bot).getMainBatiment().getCarte(carteBatiment).containsOuvrier(carteOuvrier));

    }

    @Test
    public void affectationCarteOuvrierBatimentAvecOutils()
    {

        Identification bot = new Identification("Picard");
        MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.45", 48), ModeDeJeu.Antiquite, trace);
        moteurTMP.ajouterJoueur(bot,0);
        moteurTMP.getInventaireDuJoueur(bot).getMainOuvrier().ajoutCartes(listeCarteOuvrier);
        moteurTMP.getInventaireDuJoueur(bot).getMainBatiment().ajoutCartes(listeCarteBatiment);
        moteurTMP.getInventaireDuJoueur(bot).getMainOutils().ajoutCartes(listeCarteOutils);

        CarteOuvrier carteOuvrier = moteurTMP.getInventaireDuJoueur(bot).getMainOuvrier().getCarte(0);
        CarteOutils carteOutils = moteurTMP.getInventaireDuJoueur(bot).getMainOutils().getCarte(0);
        CarteBatiment carteBatiment = moteurTMP.getInventaireDuJoueur(bot).getMainBatiment().getCarte(0);

        Operation operation = new OpAffectationOuvrierBatiment(carteOuvrier,carteBatiment,carteOutils,logger,bot);
        operation.faireOperation(moteurTMP,bot,statistiqueJoueur);

        OpInvestissementTest.investissementNonFait(moteurTMP,bot);

        assertTrue(moteurTMP.getInventaireDuJoueur(bot).getMainBatiment().getCarte(carteBatiment).containsOuvrier(carteOuvrier));
        assertEquals(carteOutils, carteOuvrier.getCarteOutilsAssigne());

    }
}
