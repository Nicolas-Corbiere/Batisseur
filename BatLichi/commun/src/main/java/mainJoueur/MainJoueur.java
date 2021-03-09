package mainJoueur;

import carte.Carte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainJoueur<E extends Carte> implements IMainCarte<E>
{
    private ArrayList<E> cartes;

    public MainJoueur()
    {
        cartes = new ArrayList<>();
    }

    public MainJoueur(Collection<E> cartes)
    {
        this.cartes = new ArrayList<>(cartes);
    }

    @Override
    public int nombreCartes()
    {
        return cartes.size();
    }

    public ArrayList<E> getCartes()
    {
        return cartes;
    }

    public void setCartes(ArrayList<E> cartes) {
        this.cartes = cartes;
    }

    @Override
    public int searchIndex(E carte)
    {
        if(!contains(carte) && carte==null) return -1;
        int index = 0;
        for(E aCarte : cartes)
        {
            if(aCarte.equals(carte)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(E carte)
    {
        return cartes.contains(carte);
    }

    @Override
    public E getCarte(int index)
    {
        int n = 0;
        for(E carte : cartes)
        {
            if(n==index) return carte;
            n++;
        }
        return null;
    }

    @Override
    public E getCarte(E carte)
    {
        for(E aCarte : cartes)
        {
            if(aCarte.equals(carte)) return aCarte;
        }
        return null;
    }

    @Override
    public boolean estVide()
    {
        return cartes.isEmpty();
    }

    @Override
    public boolean ajoutCarte(E carte)
    {
        return cartes.add(carte);
    }

    @Override
    public boolean ajoutCartes(E... cartes)
    {
        return this.cartes.addAll(new ArrayList<E>(Arrays.asList(cartes)));
    }

    @Override
    public boolean ajoutCartes(Collection<E> cartes)
    {
        return this.cartes.addAll(cartes);
    }

    @Override
    public boolean enleverCarte(E carte)
    {
        return cartes.remove(carte);
    }

    @Override
    public boolean enleverCartes(E... cartes)
    {
        return this.enleverCartes(new ArrayList<E>(Arrays.asList(cartes)));
    }

    @Override
    public boolean enleverCartes(Collection<E> cartes)
    {
        return this.cartes.removeAll(cartes);
    }

    public void resetMainJoueur(){
        cartes.clear();
    }
}
