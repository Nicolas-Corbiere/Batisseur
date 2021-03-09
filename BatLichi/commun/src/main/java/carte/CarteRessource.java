package carte;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarteBatiment.class, name = "CarteBatiment"),
        @JsonSubTypes.Type(value = CarteOuvrier.class, name = "CarteOuvrier"),
        @JsonSubTypes.Type(value = CarteOutils.class, name = "CarteOutils"),
        @JsonSubTypes.Type(value = CarteUniversite.class, name = "CarteUniversite"),
})
public abstract class CarteRessource extends Carte
{
    public static final int RessourcePierre = 0;
    public static final int RessourceBois = 1;
    public static final int RessourceSavoir = 2;
    public static final int RessourceTuile = 3;

    private int[] ressources;

    public CarteRessource(int id, String nom, int[] ressources, int ecu)
    {
        super(id, nom, ecu);
        this.ressources = Arrays.copyOf(ressources, 4);
    }

    public CarteRessource()
    {
        super();
    }
    //----------------------------------------------- Methode Lecteur --------------------------------------------------

    public int[] getRessources()
    {
        return ressources;
    }

    public int getRessource(int index)
    {
        return ressources[index];
    }

    //---------------------------------------------- Methode Override --------------------------------------------------

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof CarteRessource)) return false;
        CarteRessource that = (CarteRessource) o;
        return super.equals(o)
                && Arrays.equals(ressources, that.ressources);
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(ressources);
        return result;
    }

    //------------------------------------------------ Methode Static --------------------------------------------------

    public static int[] additionRessources(int[] ressources0, int[] ressources1)
    {
        if(ressources0.length != 4) ressources0 = Arrays.copyOf(ressources0, 4);

        if(ressources1.length != 4) ressources1 = Arrays.copyOf(ressources1, 4);

        return new int[]
                {
                    ressources0[CarteRessource.RessourcePierre] + ressources1[CarteRessource.RessourcePierre],
                    ressources0[CarteRessource.RessourceBois] + ressources1[CarteRessource.RessourceBois],
                    ressources0[CarteRessource.RessourceSavoir] + ressources1[CarteRessource.RessourceSavoir],
                    ressources0[CarteRessource.RessourceTuile] + ressources1[CarteRessource.RessourceTuile],
                };
    }

    public static int[] additionRessources(int[]... lesRessources)
    {
        int[] ressourcesTotal = {0,0,0,0};

        for(int[] ressources : lesRessources)
        {
            ressourcesTotal = additionRessources(ressourcesTotal,ressources);
        }

        return ressourcesTotal;
    }
}
