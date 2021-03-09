package moteurDeJeu;

import carte.*;
import identification.Identification;
import inventaire.InventaireJoueur;

import java.util.Random;

public interface MoteurDeJeu {

    public InventaireJoueur getInventaireDuJoueur(Identification joueur);

    public Random getGenerateurNombreAleatoire();

    public CarteBatiment getBatimentPresent(int indice);

    public CarteOuvrier getOuvrierPresent(int indice);

    public CarteUniversite getUniversitePresent();

    public CarteOutils getOutilsPresent();

    public CarteEsclave getEsclavePresent();

    public CarteEmprunt getEmpruntPresent();
}
