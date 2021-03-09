package joueur.strategie.strategieNiveau3;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import carte.cartesPresente.CartesPresente;
import carte.cartesPresente.LesCartesPresentes;
import identification.Identification;
import inventaire.InventaireJoueur;
import logger.LoggerTrace;
import mainJoueur.MainJoueur;
import operation.Operation;

public class StrategieHardMoyenAge extends StrategieHard{
    /**
     * Constructeur de StrategieHardMoyenAge
     * @param PestSilencieux
     */
    public StrategieHardMoyenAge(boolean PestSilencieux)
    {
        super(PestSilencieux);
    }

    /**
     * Operation qui permet d'appliquer la strategie de StrategieHardMoyenAge
     *
     * @param lesCartesPresentes, Ensemble des cartes presentes
     * @param inventaireJoueur, Inventaire du joueur
     * @param moi, Identification du joueur
     * @param loggerTrace, Logger pour suivre le déroulement de la partie
     * @return une Operation
     */
    @Override
    public Operation appliqueStrategie(LesCartesPresentes lesCartesPresentes, InventaireJoueur inventaireJoueur, Identification moi, LoggerTrace loggerTrace)
    {
        CartesPresente<CarteBatiment> batiments = lesCartesPresentes.getCartesPresente(CarteBatiment.class);
        CartesPresente<CarteOuvrier> ouvriers = lesCartesPresentes.getCartesPresente(CarteOuvrier.class);
        MainJoueur<CarteOuvrier> mainOuvier= inventaireJoueur.getMainOuvrier();
        MainJoueur<CarteBatiment> mainBatiment = inventaireJoueur.getMainBatiment();

        CarteBatiment firstBatimant = null;
        int nb = nbAleatoire();

        firstBatimant = this.lirePremiereCarteBatiment(mainBatiment);

        if (firstBatimant == null)
        {
            return this.tirerBatimentHard(batiments, nb,inventaireJoueur,moi);
        }
        else if ((mainOuvier.nombreCartes() < 1) && (!firstBatimant.estBatimentTerminé()) && (carteOuvrierNonNull(ouvriers) != 1))        {
            return this.tirerOuvrierHard(ouvriers, firstBatimant, nb,inventaireJoueur,moi);
        }
        else if (!firstBatimant.estBatimentTerminé())
        {
            return this.affectationOuvrierBatimentHard(firstBatimant,mainOuvier,inventaireJoueur,moi);
        }
        else
        {
            return getJoueur().obtenirEcu(ecuNecesaire(),inventaireJoueur,moi);
        }

    }

}
