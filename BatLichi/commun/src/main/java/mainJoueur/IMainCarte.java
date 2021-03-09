package mainJoueur;

import carte.Carte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public interface IMainCarte<E extends Carte>
{
    public int nombreCartes();

    public int searchIndex(E carte);

    public boolean contains(E carte);

    public E getCarte(int index);

    public E getCarte(E carte);

    public boolean estVide();

    public boolean ajoutCarte(E carte);

    public boolean ajoutCartes(E... cartes);

    public boolean ajoutCartes(Collection<E> cartes);

    public boolean enleverCarte(E carte);

    public boolean enleverCartes(E... cartes);

    public boolean enleverCartes(Collection<E> cartes);
}
