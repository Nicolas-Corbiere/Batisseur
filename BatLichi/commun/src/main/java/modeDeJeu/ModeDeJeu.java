package modeDeJeu;

public enum ModeDeJeu {
	
	MoyenAge(0),Antiquite(1);
	
	private int modeDeJeu ;  
    
    private ModeDeJeu(int modeDeJeu) {  
        this.modeDeJeu = modeDeJeu ;  
   }  
     
    public int getNumModeDeJeu() {  
        return  this.modeDeJeu ;  
   }  

}
