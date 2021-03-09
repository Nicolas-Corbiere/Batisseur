package carte.factory;

import carte.*;

import java.util.ArrayList;

public interface ICarteFactory
{
    public ArrayList<CarteBatiment> creeCartesBatimant();
    public ArrayList<CarteMachine> creeCarteMachine();
    public ArrayList<CarteOuvrier> creeCartesOuvrier();
    public ArrayList<CarteEsclave> creeCarteEsclave();
    public ArrayList<CarteUniversite> creeCartesUniversite();
    public ArrayList<CarteOutils> creeCarteOutils();
    public ArrayList<CarteEmprunt> creeCarteEmprunts();
}
