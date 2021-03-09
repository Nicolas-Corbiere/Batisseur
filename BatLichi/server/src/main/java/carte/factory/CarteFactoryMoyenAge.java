package carte.factory;

import carte.*;

import java.util.ArrayList;

public class CarteFactoryMoyenAge implements ICarteFactory
{

    public ArrayList<CarteBatiment> creeCartesBatimant()
    {
        ArrayList<CarteBatiment> carteBatiments = new ArrayList<CarteBatiment>();

        carteBatiments.add(new CarteBatiment(1,"l'abbaye",new int[]{4,3,2,1},18,5));
        carteBatiments.add(new CarteBatiment(2,"l'aqueduc",new int[]{5,2,5,0},20,6));
        carteBatiments.add(new CarteBatiment(3,"l'auberge",new int[]{2,1,1,2},12,1));
        carteBatiments.add(new CarteBatiment(4,"la cabane perché",new int[]{0,2,1,0},6,1));
        carteBatiments.add(new CarteBatiment(5,"le château-fort",new int[]{5,3,5,3},20,7));
        carteBatiments.add(new CarteBatiment(6,"la cabane",new int[]{0,1,1,0},8,0));
        carteBatiments.add(new CarteBatiment(7,"la chapelle",new int[]{3,2,2,3},18,5));
        carteBatiments.add(new CarteBatiment(8,"la cathédrale",new int[]{5,4,4,4},20,8));
        carteBatiments.add(new CarteBatiment(9,"la chaumière",new int[]{0,2,1,2},10,2));

        carteBatiments.add(new CarteBatiment(10,"l'écurie",new int[]{0,3,1,3},14,3));
        carteBatiments.add(new CarteBatiment(11,"l'église",new int[]{4,0,2,4},18,5));
        carteBatiments.add(new CarteBatiment(12,"l'étable",new int[]{0,1,2,3},12,3));
        carteBatiments.add(new CarteBatiment(13,"la forge",new int[]{2,2,0,3},14,3));
        carteBatiments.add(new CarteBatiment(14,"les halles",new int[]{0,3,2,3},16,4));
        carteBatiments.add(new CarteBatiment(15,"l'hôtel",new int[]{1,3,3,1},16,4));
        carteBatiments.add(new CarteBatiment(16,"la hutte en paille",new int[]{1,0,0,2},6,1));
        carteBatiments.add(new CarteBatiment(17,"le lavoir",new int[]{0,1,0,2},6,1));
        carteBatiments.add(new CarteBatiment(18,"la maison bourgeaoise",new int[]{2,2,2,2},16,4));
        carteBatiments.add(new CarteBatiment(19,"la maison rurale",new int[]{1,2,1,1},10,2));

        carteBatiments.add(new CarteBatiment(20,"la maison urbaine",new int[]{2,0,2,1},10,2));
        carteBatiments.add(new CarteBatiment(21,"la maisonnette",new int[]{2,1,0,2},10,2));
        carteBatiments.add(new CarteBatiment(22,"le moulin à vents",new int[]{3,0,3,1},14,3));
        carteBatiments.add(new CarteBatiment(23,"le moulin à eau",new int[]{0,2,3,2},14,3));
        carteBatiments.add(new CarteBatiment(24,"le pont ccuvert",new int[]{0,1,2,0},6,1));
        carteBatiments.add(new CarteBatiment(25,"le pont en pierre",new int[]{2,0,1,0},6,1));
        carteBatiments.add(new CarteBatiment(26,"la porcherie",new int[]{0,2,2,2},12,3));
        carteBatiments.add(new CarteBatiment(27,"le relais postal",new int[]{3,1,2,2},16,4));
        carteBatiments.add(new CarteBatiment(28,"le relais rural",new int[]{0,3,1,2},12,3));
        carteBatiments.add(new CarteBatiment(29,"le silo à grains",new int[]{0,2,3,1},12,3));

        carteBatiments.add(new CarteBatiment(30,"la taverne",new int[]{1,3,1,3},16,4));
        carteBatiments.add(new CarteBatiment(31,"la tonnelle",new int[]{1,0,0,1},8,0));
        carteBatiments.add(new CarteBatiment(32,"la tour de guet",new int[]{3,3,2,2},18,5));
        carteBatiments.add(new CarteBatiment(33,"la ferme",new int[]{4,2,0,2},16,4));
        carteBatiments.add(new CarteBatiment(34,"le cloître",new int[]{4,2,4,0},18,5));

        return carteBatiments;
    }

    public ArrayList<CarteMachine> creeCarteMachine()
    {
        ArrayList<CarteMachine> carteMachines = new ArrayList<CarteMachine>();

        carteMachines.add(new CarteMachine(35,"une grue",new int[]{0,1,0,1},1, CarteRessource.RessourcePierre, 2));
        carteMachines.add(new CarteMachine(36,"une scie circulaire",new int[]{1,0,0,1},1, CarteRessource.RessourceBois, 2));
        carteMachines.add(new CarteMachine(37,"un instrument de mesure",new int[]{1,1,0,0},1, CarteRessource.RessourceSavoir, 2));
        carteMachines.add(new CarteMachine(38,"un four à tuiles",new int[]{0,1,1,0},1, CarteRessource.RessourceTuile, 2));
        carteMachines.add(new CarteMachine(39,"une grue",new int[]{0,2,1,0},2, CarteRessource.RessourcePierre, 3));

        carteMachines.add(new CarteMachine(40,"une scie circulaire",new int[]{0,0,2,1},2, CarteRessource.RessourceBois, 3));
        carteMachines.add(new CarteMachine(41,"un instrument de mesure",new int[]{1,0,0,2},2, CarteRessource.RessourceSavoir,3));
        carteMachines.add(new CarteMachine(42,"un four à tuile",new int[]{2,1,0,0},2, CarteRessource.RessourceTuile, 3));

        return carteMachines;

    }

    /**
     * Création de toutes les cartes Apprenti
     * @return une liste de cartes Apprenti
     */
    public ArrayList<CarteOuvrier> creeCarteApprentis(){
        ArrayList<CarteOuvrier> carteApprentis = new ArrayList<CarteOuvrier>();

        carteApprentis.add( new CarteOuvrier(43,"apprenti",new int[]{0,1,1,0},2) );
        carteApprentis.add( new CarteOuvrier(44,"apprenti",new int[]{0,0,1,1},2) );
        carteApprentis.add( new CarteOuvrier(45,"apprenti",new int[]{0,1,0,1},2) );
        carteApprentis.add( new CarteOuvrier(46,"apprenti",new int[]{1,0,1,0},2) );
        carteApprentis.add( new CarteOuvrier(47,"apprenti",new int[]{1,1,0,0},2) );
        carteApprentis.add( new CarteOuvrier(48,"apprenti",new int[]{1,0,0,1},2) );

        return carteApprentis;
    }

    public ArrayList<CarteOuvrier> creeCartesOuvrier()
    {
        ArrayList<CarteOuvrier> carteOuvriers = new ArrayList<CarteOuvrier>();



        carteOuvriers.add( new CarteOuvrier(49,"manœuvre",new int[]{0,0,2,1},3) );
        carteOuvriers.add( new CarteOuvrier(50,"manœuvre",new int[]{1,0,2,0},3) );
        carteOuvriers.add( new CarteOuvrier(51,"manœuvre",new int[]{0,1,2,0},3) );
        carteOuvriers.add( new CarteOuvrier(52,"manœuvre",new int[]{1,2,0,0},3) );
        carteOuvriers.add( new CarteOuvrier(53,"manœuvre",new int[]{0,2,0,1},3) );
        carteOuvriers.add( new CarteOuvrier(54,"manœuvre",new int[]{0,2,1,0},3) );
        carteOuvriers.add( new CarteOuvrier(55,"manœuvre",new int[]{2,0,1,0},3) );
        carteOuvriers.add( new CarteOuvrier(56,"manœuvre",new int[]{2,0,0,1},3) );
        carteOuvriers.add( new CarteOuvrier(57,"manœuvre",new int[]{2,1,0,0},3) );
        carteOuvriers.add( new CarteOuvrier(58,"manœuvre",new int[]{0,0,1,2},3) );
        carteOuvriers.add( new CarteOuvrier(59,"manœuvre",new int[]{0,1,0,2},3) );
        carteOuvriers.add( new CarteOuvrier(60,"manœuvre",new int[]{1,0,0,2},3) );


        carteOuvriers.add( new CarteOuvrier(61,"compagnon",new int[]{1,0,3,0},4) );
        carteOuvriers.add( new CarteOuvrier(62,"compagnon",new int[]{1,1,1,1},4) );
        carteOuvriers.add( new CarteOuvrier(63,"compagnon",new int[]{1,1,1,1},4) );
        carteOuvriers.add( new CarteOuvrier(64,"compagnon",new int[]{0,3,0,1},4) );
        carteOuvriers.add( new CarteOuvrier(65,"compagnon",new int[]{0,2,0,2},4) );
        carteOuvriers.add( new CarteOuvrier(66,"compagnon",new int[]{2,0,2,0},4) );
        carteOuvriers.add( new CarteOuvrier(67,"compagnon",new int[]{3,1,0,0},4) );
        carteOuvriers.add( new CarteOuvrier(68,"compagnon",new int[]{0,0,2,2},4) );
        carteOuvriers.add( new CarteOuvrier(69,"compagnon",new int[]{0,2,2,0},4) );
        carteOuvriers.add( new CarteOuvrier(70,"compagnon",new int[]{0,0,1,3},4) );
        carteOuvriers.add( new CarteOuvrier(71,"compagnon",new int[]{2,0,0,2},4) );
        carteOuvriers.add( new CarteOuvrier(72,"compagnon",new int[]{2,2,0,0},4) );
        carteOuvriers.add( new CarteOuvrier(73,"compagnon",new int[]{2,1,1,0},4) );
        carteOuvriers.add( new CarteOuvrier(74,"compagnon",new int[]{0,1,1,2},4) );
        carteOuvriers.add( new CarteOuvrier(75,"compagnon",new int[]{1,2,0,1},4) );
        carteOuvriers.add( new CarteOuvrier(76,"compagnon",new int[]{1,0,2,1},4) );


        carteOuvriers.add( new CarteOuvrier(77,"maître",new int[]{0,2,3,0},5) );
        carteOuvriers.add( new CarteOuvrier(78,"maître",new int[]{0,0,3,2},5) );
        carteOuvriers.add( new CarteOuvrier(79,"maître",new int[]{2,3,0,0},5) );
        carteOuvriers.add( new CarteOuvrier(80,"maître",new int[]{0,3,2,0},5) );
        carteOuvriers.add( new CarteOuvrier(81,"maître",new int[]{3,2,0,0},5) );
        carteOuvriers.add( new CarteOuvrier(82,"maître",new int[]{3,0,0,2},5) );
        carteOuvriers.add( new CarteOuvrier(83,"maître",new int[]{2,0,0,3},5) );
        carteOuvriers.add( new CarteOuvrier(84,"maître",new int[]{0,0,2,3},5) );

        return carteOuvriers;
    }

    public ArrayList<CarteEsclave> creeCarteEsclave()
    {
        ArrayList<CarteEsclave> carteEsclaves = new ArrayList<CarteEsclave>();

        return carteEsclaves;
    }

    public ArrayList<CarteUniversite> creeCartesUniversite()
    {
        ArrayList<CarteUniversite> carteUniversites = new ArrayList<CarteUniversite>();

        return carteUniversites;
    }

    public ArrayList<CarteOutils> creeCarteOutils()
    {
        ArrayList<CarteOutils> carteOutils = new ArrayList<CarteOutils>();

        return carteOutils;
    }

    public ArrayList<CarteEmprunt> creeCarteEmprunts()
    {
        ArrayList<CarteEmprunt> carteEmprunts = new ArrayList<CarteEmprunt>();

        return carteEmprunts;
    }
}
