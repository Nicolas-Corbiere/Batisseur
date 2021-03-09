package carte;

import java.util.Arrays;
import java.util.Objects;
/*
 * Represente une carte machine  
 * @author Rethers Mathieu
 */

public class CarteMachine extends CarteBatiment implements IConvertionCarte<CarteOuvrier>
{
    private int[] ressourceProduira = {0,0,0,0};
    private CarteOuvrier versionCarteOuvrier;


    public CarteMachine(int id, String nom, int[] ressourcesNecessaire, int pointVictoire, int typeRessource, int nbRessourcesProduit)
    {
        super(id, nom, ressourcesNecessaire, 0, pointVictoire);
        ressourceProduira[typeRessource] = nbRessourcesProduit;
        versionCarteOuvrier = new CarteOuvrier(this.getId(), this.getNom(), this.ressourceProduira,0);
    }

    public CarteMachine()
    {
        super();
    }

    //---------------------------------------------- Methode Lecteur ---------------------------------------------------

    public CarteOuvrier getVersionCarteOuvrier()
    {
        return versionCarteOuvrier;
    }

    public int[] getRessourceProduira()
    {
        return Arrays.copyOf(ressourceProduira,4);
    }

    //---------------------------------------------- Methode Ecriture --------------------------------------------------


    public void setRessourceProduira(int[] ressourceProduira)
    {
        this.ressourceProduira = ressourceProduira;
    }

    public void setVersionCarteOuvrier(CarteOuvrier versionCarteOuvrier) {
        this.versionCarteOuvrier = versionCarteOuvrier;
    }

    //---------------------------------------------- Methode Override --------------------------------------------------

    @Override
    public CarteOuvrier getOtherVesionCarte()
    {
        return versionCarteOuvrier;
    }

    @Override
    public void setOtherVesionCarte(CarteOuvrier version)
    {
        this.versionCarteOuvrier=version;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof CarteMachine)) return false;

        CarteMachine that = (CarteMachine) o;
        return super.equals(o)
                && Arrays.equals(ressourceProduira, that.ressourceProduira)
                && versionCarteOuvrier.equals(that.versionCarteOuvrier);
    }

    @Override
    public int hashCode()
    {
        int result = Objects.hash(super.hashCode(), versionCarteOuvrier);
        result = 31 * result + Arrays.hashCode(ressourceProduira);
        return result;
    }
}
