package strategieFactory;


import joueur.strategie.strategieNiveau1.StrategieBasique;
import joueur.strategie.strategieNiveau2.StrategieMedium;
import joueur.strategie.strategieNiveau1.StrategieBasiqueMoyenAge;
import joueur.strategie.strategieNiveau3.StrategieHard;


import joueur.strategie.strategieNiveau2.StrategieMediumMoyenAge;
import joueur.strategie.strategieNiveau3.StrategieHardMoyenAge;

public class StrategieMoyenAge implements StrategieFactory
{
    @Override
    public StrategieBasique getBasique(boolean estSilencieux)
    {
        return new StrategieBasiqueMoyenAge(estSilencieux);
    }

    @Override
    public StrategieMedium getMedium(boolean estSilencieux)
    {
        return new StrategieMediumMoyenAge(estSilencieux);
    }

    @Override
    public StrategieHard getHard(boolean estSilencieux)
    {
        return new StrategieHardMoyenAge(estSilencieux);
    }
}

