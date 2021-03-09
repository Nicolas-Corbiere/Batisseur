package strategieFactory;

import joueur.strategie.strategieNiveau1.StrategieBasique;
import joueur.strategie.strategieNiveau2.StrategieMedium;
import joueur.strategie.strategieNiveau3.StrategieHard;

public interface StrategieFactory {
    public StrategieBasique getBasique(boolean estSilencieux);
    public StrategieMedium getMedium(boolean estSilencieux);
    public StrategieHard getHard(boolean estSilencieux);
}
