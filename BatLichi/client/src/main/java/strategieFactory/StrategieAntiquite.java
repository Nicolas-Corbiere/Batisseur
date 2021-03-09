package strategieFactory;

import joueur.strategie.strategieNiveau1.StrategieBasique;
import joueur.strategie.strategieNiveau2.StrategieMedium;
import joueur.strategie.strategieNiveau1.StrategieBasiqueAntiquite;
import joueur.strategie.strategieNiveau2.StrategieMediumAntiquite;
import joueur.strategie.strategieNiveau3.StrategieHard;
import joueur.strategie.strategieNiveau3.StrategieHardAntiquite;


public class StrategieAntiquite implements StrategieFactory
{

    @Override
    public StrategieBasique getBasique(boolean estSilencieux)
    {
        return new StrategieBasiqueAntiquite(estSilencieux);
    }

    @Override
    public StrategieMedium getMedium(boolean estSilencieux)
    {
        return new StrategieMediumAntiquite(estSilencieux);
    }

    @Override
    public StrategieHard getHard(boolean estSilencieux)
    {
        return new StrategieHardAntiquite(estSilencieux);
    }
}
