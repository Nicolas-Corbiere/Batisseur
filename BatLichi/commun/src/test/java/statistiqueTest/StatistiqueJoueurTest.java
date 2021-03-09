package statistiqueTest;



import org.junit.jupiter.api.Test;
import statistique.StatistiqueJoueur;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatistiqueJoueurTest
{

    @Test
    public void TestInstanciationStatistique()
    {
        StatistiqueJoueur stat = new StatistiqueJoueur();
        assertEquals(0, stat.getNbAffectation());
        assertEquals(0, stat.getNbPiocheBatiment());
        assertEquals(0, stat.getNbPiocheOuvrier());
        assertEquals(0, stat.getNbPointVictoireBatiment());
        assertEquals(0, stat.getNbPointVictoireEcu());
    }
/*
    @Test
    public void TestInstanciationStatistiqueBotBasique()
    {
    	Joueur bot = new Joueur("Yannick", false, false);
        StrategieHard stratHard = new StrategieHard(false);
		bot.ajouteStrategie(stratHard);
		
		StatistiqueJoueur stat = bot.getStats();
        assertEquals(0, stat.getNbAffectation());
        assertEquals(0, stat.getNbPiocheBatiment());
        assertEquals(0, stat.getNbPiocheOuvrier());
        assertEquals(0, stat.getNbPointVictoireBatiment());
        assertEquals(0, stat.getNbPointVictoireEcu());
    }

 */
}
