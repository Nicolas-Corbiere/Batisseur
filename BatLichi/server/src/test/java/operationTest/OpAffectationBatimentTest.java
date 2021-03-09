package operationTest;

import carte.Carte;
import carte.CarteBatiment;
import carte.CarteEmprunt;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import carte.cartesPresente.LesCartesPresentesMoyenAge;
import carte.factory.CarteFactoryAntiquite;
import carte.factory.CarteFactoryMoyenAge;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.OpAffectationBatiment;
import operation.Operation;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;
import statistique.StatistiqueJoueur;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class OpAffectationBatimentTest {

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
        CarteBatiment carteBatiment=moteurTMP.getCartePresente().getCartesPresente(CarteBatiment.class).getCarte(0);

        Operation operation= new OpAffectationBatiment(0,loggerTrace,Tennos);
        operation.faireOperation(moteurTMP,Tennos,statistiqueJoueur);

        assertTrue(moteurTMP.getInventaireDuJoueur(Tennos).getMainBatiment().contains(carteBatiment));
        assertFalse(moteurTMP.getCartePresente().getCartesPresente(CarteBatiment.class).lireCartes().contains(carteBatiment));

    }


    @Test
    public void testAffectationBatiment1(){
        int indexRandom=(new Random()).nextInt(moteurTMP.getCartePresente().getCartesPresente(CarteBatiment.class).taille());
        CarteBatiment carteBatiment=moteurTMP.getCartePresente().getCartesPresente(CarteBatiment.class).getCarte(indexRandom);

        Operation operation= new OpAffectationBatiment(indexRandom,loggerTrace,Tennos);
        operation.faireOperation(moteurTMP,Tennos,statistiqueJoueur);

        assertTrue(moteurTMP.getInventaireDuJoueur(Tennos).getMainBatiment().contains(carteBatiment));
        assertFalse(moteurTMP.getCartePresente().getCartesPresente(CarteBatiment.class).lireCartes().contains(carteBatiment));

    }
}
