package carte;

public class CarteUniversite extends CarteRessource
{
    public CarteUniversite(int id, String nom, int[] ressources, int ecu)
    {
        super(id, nom, ressources, ecu);
    }

    public CarteUniversite()
    {
        super();
    }

    //---------------------------------------------- Methode Override --------------------------------------------------


    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof CarteUniversite)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
