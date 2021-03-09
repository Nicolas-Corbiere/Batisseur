package argument;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import modeDeJeu.ModeDeJeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestArguments {
	
	private String[] args;
	
	private static final String argMoyA = "moyena";
	private static final String argAnt = "antiq";
	
	/**
	 * permet de créer un nouveau tableau d'aguments avant chaque test 
	 */
	@BeforeEach
	void constructionArgs() {
		args = new String[5];
	}
	
	/**
	 * test si l'argument est vide
	 */

	@Test
	void ArgumentVoid() {
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(argu.getNbPartie(), 1);
		assertFalse(argu.isBoolStat());
		assertFalse(argu.isBoolTrace());
		assertEquals(ModeDeJeu.MoyenAge.getNumModeDeJeu(), argu.getModeDeJeu().getNumModeDeJeu());

	}
	
	/**
	 * test pour 10 partie et les deux argument en "true"
	 */

	@Test
	void Argument1() {
		args[0] = "10";
		args[1] = "trace-true";
		args[2] = "stat-true";
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(argu.getNbPartie(), 10);
		assertTrue(argu.isBoolStat());
		assertTrue(argu.isBoolTrace());
	}
	
	/**
	 * test pour 10 partie et les deux argument en "false"
	 */

	@Test
	void Argument2() {
		args[0] = "10";
		args[1] = "trace-false";
		args[2] = "stat-false";
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(argu.getNbPartie(), 10);
		assertFalse(argu.isBoolStat());
		assertFalse(argu.isBoolTrace());
	}
	
	/**
	 * test pour 100 partie et un argument en "false" et un en "true" avec des variation de majuscule/minuscule
	 */

	@Test
	void Argument4() {
		args[0] = "100";
		args[1] = "trace-FalSe";
		args[2] = "stat-TRUE";
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(argu.getNbPartie(), 100);
		assertFalse(argu.isBoolTrace());
		assertTrue(argu.isBoolStat());
	}

	/**
	 * test pour 100 partie et un argument en "false" et un en "true" avec des variation de majuscule/minuscule
	 */

	@Test
	void Argument5() {
		args[0] = "100";
		args[1] = "trace-falSe";
		args[2] = "stat-Truue";
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(argu.getNbPartie(), 100);
		assertFalse(argu.isBoolTrace());
		assertFalse(argu.isBoolStat());
	}

	/**
	 * test pour 100 partie et un argument en "false" et un arguùent invalide avec des variation de majuscule/minuscule
	 */

	@Test
	void Argument6() {
		args[0] = "100";
		args[1] = "trace-falSe";
		args[2] = "stat-testtest";
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(argu.getNbPartie(), 100);
		assertFalse(argu.isBoolTrace());
		assertFalse(argu.isBoolStat());
	}

	
	/**
	 * test pour le mode de jeu MoyA
	 */

	@Test
	void ArgumentModeDeJeuMa() {
		args[0] = argMoyA;
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(ModeDeJeu.MoyenAge.getNumModeDeJeu(), argu.getModeDeJeu().getNumModeDeJeu());
	}


	/**
	 * test pour le mode de jeu Ant
	 */

	@Test
	void ArgumentModeDeJeuAnt() {
		args[0] = argAnt;
		Arguments argu = new Arguments(args); 
		argu.analyseArgument();
		
		assertEquals(ModeDeJeu.Antiquite.getNumModeDeJeu(), argu.getModeDeJeu().getNumModeDeJeu());
	}
	
	
	
	

}
