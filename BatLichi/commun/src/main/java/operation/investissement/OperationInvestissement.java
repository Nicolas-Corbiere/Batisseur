package operation.investissement;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import identification.Identification;
import inventaire.InventaireJoueur;
import logger.LoggerTrace;
import moteurDeJeu.MoteurDeJeu;
import operation.Operation;
import statistique.StatistiqueJoueur;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OpAchatEsclave.class, name = "OpAchatEsclave"),
        @JsonSubTypes.Type(value = OpAchatOutil.class, name = "OpAchatOutil"),
        @JsonSubTypes.Type(value = OpAffranchirEsclave.class, name = "OpAffranchirEsclave"),
        @JsonSubTypes.Type(value = OpEmprunt.class, name = "OpEmprunt"),
        @JsonSubTypes.Type(value = OpInstruire.class, name = "OpInstruire"),
        @JsonSubTypes.Type(value = OpRembourserEmprunt.class, name = "OpRembourserEmprunt"),
})
abstract public class OperationInvestissement extends Operation {


    /**
     * Opération investissement qui permet au joueur d'indiquer l'operation qu'il veux effectuer
     * Ces operations sont propre au mode de jeu de l'antiquiter
     *
     * @param logger le logger issue du joueur
     * @param id identification du joueur
     *
     */
    public OperationInvestissement(LoggerTrace logger, Identification id) {
        super(logger,id);
    }

    /**
     * Permet d'effectuer l'operation d'investissement
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     * @param statistiqueJoueur stat du joueur qui vas être incrémenter lorsque l'on vas effectuer l'operation
     *
     */
    @Override
    public void faireOperation(MoteurDeJeu moteur,Identification joueur, StatistiqueJoueur statistiqueJoueur) {
        faireOperationInvestissement(moteur,joueur, statistiqueJoueur);
    }


    /**
     * Permet d'effectuer l'operation d'investissement
     *
     * @param moteur moteur de jeu
     * @param joueur identification du joueur
     */
    abstract public void faireOperationInvestissement(MoteurDeJeu moteur,Identification joueur, StatistiqueJoueur statistiqueJoueur);



    /**
     * est appeller lorsqu'une action est faite, aDejaEtaitFait devien true
     */
    public void investissementFait(InventaireJoueur inv) {
        inv.investissementFait();
    }

    /**
     * est appeller à la fin d'un tour, aDejaEtaitFait devien false
     */
    public boolean getADejaEtaitFait(InventaireJoueur inv) {
        return (inv.isInvestissementFait());
    }


}
