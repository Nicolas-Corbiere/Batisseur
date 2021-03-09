package argument;

import modeDeJeu.ModeDeJeu;

public class Arguments {
	
	// -- Attribut 

	private String[] tabArgs;
	private int argc;
	private boolean boolTrace = false;
	private boolean boolStat = false;
	
	private static final String argBoolTrace = "trace-";
	private static final String argBoolStat = "stat-";
	private static final String argMoyA = "moyena";
	private static final String argAnt = "antiq";
	private int nbPartie = 1;
	
	private static ModeDeJeu modeDeJeu = ModeDeJeu.MoyenAge;
	
	// -- Constructeur 
	
	/**
	 * 
	 * @param tabArgs Tableau de String 
	 */
	public Arguments(String[] tabArgs) {
		this.tabArgs = tabArgs;
		if(tabArgs != null) {
			argc = tabArgs.length;
		}
	}

	// -- Méthode

	
	/**
	 * permet d'analyser les argument qui ne sont pas des chiffres
	 * 
	 * @param str est la string a analyser
	 */
	public void analyseString(String str) {
		str = str.toLowerCase();
		if(str.equals(argBoolTrace+"true")) {
			boolTrace = true;
		}
		else if (str.equals(argBoolTrace+"false")) {
			boolTrace = false;
		}
		else if(str.equals(argBoolStat+"true")) {
			boolStat = true;
		}
		else if(str.equals(argBoolStat+"false")) {
			boolStat = false;
		}
		else if(str.equals(argMoyA)) {
			modeDeJeu = ModeDeJeu.MoyenAge;
		}
		else if(str.equals(argAnt)) {
			modeDeJeu = ModeDeJeu.Antiquite;
		}

	
	}
	
	/**
	 * permet d'analyser tout les arguments 
	 */
	public void analyseArgument() {
		
		if(tabArgs != null) {
			for(int i = 0; i < argc; i++ ) {
				if(tabArgs[i] != null ) {
					if(isDigit(tabArgs[i])) {
						analyseInt(tabArgs[i]);
					}
					else {
						analyseString(tabArgs[i]);
					}
				}
				
			}
		}
				
		
		
	}
	
	/**
	 * permet d'analyser les argument qui sont des chiffres
	 * 
	 * @param str est la string a analyser
	 */
	public void analyseInt(String str) {
		nbPartie = Integer.parseInt(str);
	}
	
	/**
	 * permet de vérifier si le string contient que des nombres
	 * 
	 * @param str le string qu'on analyse
	 * @return true si le string contient que des nombres
	 */
	public boolean isDigit(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	// -- Getter and Setter 
	
	public boolean isBoolTrace() {
		return boolTrace;
	}

	public void setBoolTrace(boolean boolTrace) {
		this.boolTrace = boolTrace;
	}

	public boolean isBoolStat() {
		return boolStat;
	}

	public void setBoolStat(boolean boolStat) {
		this.boolStat = boolStat;
	}

	public int getNbPartie() {
		return nbPartie;
	}

	public void setNbPartie(int nbPartie) {
		this.nbPartie = nbPartie;
	}

	public ModeDeJeu getModeDeJeu() {
		return modeDeJeu;
	}

	public void setModeDeJeu(ModeDeJeu modeDeJeu) {
		Arguments.modeDeJeu = modeDeJeu;
	}

}
