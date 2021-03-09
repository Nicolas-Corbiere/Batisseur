package reseau;


import identification.Identification;
import operation.Operation;

public interface ReceptionDesMessages {
    boolean nouveauJoueur(Identification id) ;

    void transfereMsg(String msg);

    void transfereAction(Operation operation);

}
