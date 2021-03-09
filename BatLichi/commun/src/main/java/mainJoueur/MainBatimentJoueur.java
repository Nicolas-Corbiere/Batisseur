package mainJoueur;

import JSONMAP.JSONToMap;
import JSONMAP.MapToJSON;
import carte.CarteBatiment;
import carte.CarteOuvrier;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.*;

public class MainBatimentJoueur
{/*
// c est une implementation ---------> implements IMainCarte<CarteBatiment>


    @JsonSerialize(using = MapToJSON.class)
    @JsonDeserialize(using = JSONToMap.class)
    private HashMap<CarteBatiment, ArrayList<CarteOuvrier>> cartes;

    public MainBatimentJoueur()
    {
        cartes = new HashMap<CarteBatiment, ArrayList<CarteOuvrier>>();
    }

    public MainBatimentJoueur(Collection<CarteBatiment> cartes)
    {
        this();
        this.ajoutCartes(cartes);
    }

    public HashMap<CarteBatiment, ArrayList<CarteOuvrier>> getCartes() {
        return cartes;
    }

    public void setCartes(HashMap<CarteBatiment, ArrayList<CarteOuvrier>> cartes) {
        this.cartes = cartes;
    }

    @Override
    public int nombreCartes()
    {
        return cartes.size();
    }

    @Override
    public int searchIndex(CarteBatiment carte)
    {
        int index = 0;
        for(CarteBatiment carteBatiment : cartes.keySet())
        {
            if(carteBatiment.equals(carte)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(CarteBatiment carte)
    {
        return cartes.containsKey(carte);
    }

    @Override
    public CarteBatiment getCarte(int index)
    {
        assert(index<cartes.size() && index>=0);
        int n = 0;
        for(CarteBatiment carteBatiment: cartes.keySet())
        {
            if(n==index) return carteBatiment;
            n++;
        }
        return null;
    }

    @Override
    public CarteBatiment getCarte(CarteBatiment carte)
    {
        for(CarteBatiment carteBatiment : cartes.keySet())
        {
            if(carteBatiment.equals(carte)) return carteBatiment;
        }
        return null;
    }

    @Override
    public boolean estVide()
    {
        return cartes.isEmpty();
    }

    @Override
    public boolean ajoutCarte(CarteBatiment carte)
    {
        return cartes.put(carte, new ArrayList<CarteOuvrier>())==null;
    }

    @Override
    public boolean ajoutCartes(CarteBatiment... cartes)
    {
        return this.ajoutCartes(new ArrayList<CarteBatiment>(Arrays.asList(cartes)));
    }

    @Override
    public boolean ajoutCartes(Collection<CarteBatiment> cartes)
    {
        boolean ajout = false;
        for(CarteBatiment carteBatiment : cartes)
        {
            if(this.ajoutCarte(carteBatiment) && !ajout) ajout = true;
        }
        return ajout;
    }

    @Override
    public boolean enleverCarte(CarteBatiment carte)
    {
        return this.cartes.remove(carte)!=null;
    }

    @Override
    public boolean enleverCartes(CarteBatiment... cartes)
    {
        return this.enleverCartes(new ArrayList<CarteBatiment>(Arrays.asList(cartes)));
    }

    @Override
    public boolean enleverCartes(Collection<CarteBatiment> cartes)
    {
        boolean enleve = false;
        for(CarteBatiment carteBatiment : cartes)
        {
            if(this.enleverCarte(carteBatiment) && !enleve) enleve = true;
        }
        return enleve;
    }

    public int nombreCarteOuvrier(CarteBatiment carteBatiment)
    {
        return cartes.get(carteBatiment).size();
    }

    public boolean carteOuvriersVide(CarteBatiment carteBatiment)
    {
        return cartes.get(carteBatiment).isEmpty();
    }

    public boolean ajoutCarteOuvrier(CarteBatiment carteBatiment, CarteOuvrier carteOuvrier)
    {
        if(!cartes.containsKey(carteBatiment)) return false;
        return cartes.get(carteBatiment).add(carteOuvrier);
    }

    public boolean ajoutCartesOuvriers(CarteBatiment carteBatiment, CarteOuvrier... carteOuvrier)
    {
        return this.ajoutCartesOuvriers(carteBatiment, new ArrayList<CarteOuvrier>(Arrays.asList(carteOuvrier)));
    }

    public boolean ajoutCartesOuvriers(CarteBatiment carteBatiment, Collection<CarteOuvrier> carteOuvrier)
    {
        if(!cartes.containsKey(carteBatiment)) return false;
        return cartes.get(carteBatiment).addAll(carteOuvrier);
    }

    public ArrayList<CarteOuvrier> removeOuvriers(CarteBatiment carteBatiment)
    {
        if(!cartes.containsKey(carteBatiment)) return null;
        ArrayList<CarteOuvrier> ouvriers = new  ArrayList<CarteOuvrier>(cartes.get(carteBatiment));
        cartes.get(carteBatiment).removeAll(ouvriers);
        return ouvriers;
    }
    */
}
