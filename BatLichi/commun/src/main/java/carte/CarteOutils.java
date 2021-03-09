package carte;

public class CarteOutils extends CarteRessource
{
    public CarteOutils(int id, String nom, int[] ressourcesProduit)
    {
        super(id, nom, ressourcesProduit, 2);
    }

    public CarteOutils()
    {
        super();
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof CarteOutils)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}
