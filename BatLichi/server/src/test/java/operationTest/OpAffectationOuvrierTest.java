package operationTest;


import carte.CarteOuvrier;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.OpAffectationOuvrier;
import operation.Operation;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;
import statistique.StatistiqueJoueur;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpAffectationOuvrierTest {
    private final MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.160",42321), ModeDeJeu.Antiquite,true);
    private final LoggerTrace loggerTrace = new LoggerTrace();
    private final StatistiqueJoueur statistiqueJoueur = new StatistiqueJoueur();
    private final Identification Tennos = new Identification("Tennos");
    {
        moteurTMP.ajouterJoueur(Tennos,1);
        moteurTMP.creationPartie();
    }
    private boolean trace = false;
    private boolean stat = false;


    @Test
    public void testAffectationBatiment(){
        CarteOuvrier carteOuvrier=moteurTMP.getCartePresente().getCartesPresente(CarteOuvrier.class).getCarte(0);

        Operation operation= new OpAffectationOuvrier(0,loggerTrace,Tennos);
        operation.faireOperation(moteurTMP,Tennos,statistiqueJoueur);

        assertTrue(moteurTMP.getInventaireDuJoueur(Tennos).getMainOuvrier().contains(carteOuvrier));
        assertFalse(moteurTMP.getCartePresente().getCartesPresente(CarteOuvrier.class).lireCartes().contains(carteOuvrier));

    }


    @Test
    public void testAffectationBatiment1(){
        int indexRandom=(new Random()).nextInt(moteurTMP.getCartePresente().getCartesPresente(CarteOuvrier.class).taille());
        CarteOuvrier carteOuvrier=moteurTMP.getCartePresente().getCartesPresente(CarteOuvrier.class).getCarte(indexRandom);

        Operation operation= new OpAffectationOuvrier(indexRandom,loggerTrace,Tennos);
        operation.faireOperation(moteurTMP,Tennos,statistiqueJoueur);

        assertTrue(moteurTMP.getInventaireDuJoueur(Tennos).getMainOuvrier().contains(carteOuvrier));
        assertFalse(moteurTMP.getCartePresente().getCartesPresente(CarteOuvrier.class).lireCartes().contains(carteOuvrier));

    }
}
