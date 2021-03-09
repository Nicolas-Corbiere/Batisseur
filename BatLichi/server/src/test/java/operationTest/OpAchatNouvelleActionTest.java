package operationTest;

import carte.CarteEmprunt;
import identification.Identification;
import logger.LoggerTrace;
import modeDeJeu.ModeDeJeu;
import operation.OpAchatNouvelleAction;
import operation.Operation;
import org.junit.jupiter.api.Test;
import partie.MoteurTMP;
import serveur.Serveur;
import statistique.StatistiqueJoueur;

import static org.junit.jupiter.api.Assertions.*;

public class OpAchatNouvelleActionTest {

    private final MoteurTMP moteurTMP = new MoteurTMP(new Serveur("192.168.1.160",42321), ModeDeJeu.Antiquite,true);
    private final LoggerTrace loggerTrace = new LoggerTrace();
    private final StatistiqueJoueur statistiqueJoueur=new StatistiqueJoueur();
    private final Identification moi = new Identification("Tennos");
    {
        moteurTMP.ajouterJoueur(moi,1);
        moteurTMP.creationPartie();
    }


    @Test
    public void testAchatNouvelleAction(){
        moteurTMP.getInventaireDuJoueur(moi).setNbAction(0);
        moteurTMP.getInventaireDuJoueur(moi).setEcu(10);

        int ecuAttendu= moteurTMP.getInventaireDuJoueur(moi).getEcu() - 5;

        Operation operation=new OpAchatNouvelleAction(loggerTrace,moi);
        operation.faireOperation(moteurTMP,moi,statistiqueJoueur);


        assertEquals(1,moteurTMP.getInventaireDuJoueur(moi).getNbAction());
        assertEquals(ecuAttendu,moteurTMP.getInventaireDuJoueur(moi).getEcu());
    }

    @Test
    public void testAchatNouvelleAction1(){
        moteurTMP.getInventaireDuJoueur(moi).setNbAction(0);
        moteurTMP.getInventaireDuJoueur(moi).setEcu(3);


        Operation operation=new OpAchatNouvelleAction(loggerTrace,moi);
        operation.faireOperation(moteurTMP,moi,statistiqueJoueur);


        assertEquals(0,moteurTMP.getInventaireDuJoueur(moi).getNbAction());
        assertEquals(3,moteurTMP.getInventaireDuJoueur(moi).getEcu());
    }
}
