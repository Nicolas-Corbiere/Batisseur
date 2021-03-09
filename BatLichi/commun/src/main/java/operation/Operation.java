package operation;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import identification.Identification;
import inventaire.InventaireJoueur;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import statistique.StatistiqueJoueur;
import operation.investissement.OperationInvestissement;


/**
 *
 * @author Lisa Deslandes and Nicolas Corbiere
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OpAffectationBatiment.class, name = "OpAffectationBatiment"),
        @JsonSubTypes.Type(value = OpAchatNouvelleAction.class, name = "OpAchatNouvelleAction"),
        @JsonSubTypes.Type(value = OpAffectationOuvrier.class, name = "OpAffectationOuvrier"),
        @JsonSubTypes.Type(value = OpAffectationOuvrierBatiment.class, name = "OpAffectationOuvrierBatiment"),
        @JsonSubTypes.Type(value = OpObtenirEcu.class, name = "OpObtenirEcu"),
        @JsonSubTypes.Type(value = OperationInvestissement.class, name = "OperationInvestissement"),
})
abstract public class Operation {
    private LoggerTrace logger;
    private Identification id;

    /**
     *
     * Opération qui permet au joueur d'indiquer l'action qu'il veux effectuer
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     *
     */
    public Operation (LoggerTrace logger,Identification id){

        this.logger = logger;
        this.id = id;
    }

    /**
     *
     * Opération qui permet au joueur d'indiquer l'action qu'il veux effectuer
     *
     */
    public Operation() {
    }


    /**
     * Méthode qui permet d'enlever un nombre d'action.
     *
     * @param nbAction : Nombre d'Action que l'on veut enlever au joueur
     */
    public void utiliseAction( int nbAction,InventaireJoueur inv) {
        inv.suppressionAction(nbAction);
    }

    /**
     * permet l'execution d'une operation
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     */
    public abstract void faireOperation(MoteurDeJeu moteur, Identification joueur, StatistiqueJoueur statistiqueJoueur);

    public boolean verifier(MoteurDeJeu moteur){
        return true;
    }

    public LoggerTrace getLogger() {
        return logger;
    }

    @JsonIgnore
    public String getNameJoueur() {
        return id.getNom();
    }


    public void setLogger(LoggerTrace logger) {
        this.logger = logger;
    }

    public Identification getId() {
        return id;
    }

    public void setId(Identification id) {
        this.id = id;
    }





}
