package reseau;

import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import modeDeJeu.ModeDeJeu;

public interface EnvoiDesMessages {
    void permettreConnexion();

    void envoyerSignalFin(Identification gagnant);

    void envoyerSignalFinPartie(Identification gagnant);

    void demandeAuJoueurDeJouer(LesCartesPresentes lesCartesPresentes, Identification j, InventaireJoueur inventaireDuJoueur);

}
