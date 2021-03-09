package carte.factory;

import carte.*;

import java.util.ArrayList;

public class CarteFactoryAntiquite implements ICarteFactory
{

    public ArrayList<CarteBatiment> creeCartesBatimant()
    {
        ArrayList<CarteBatiment> carteBatiments = new ArrayList<CarteBatiment>();

        carteBatiments.add(new CarteBatiment(1,"l'armurerie",new int[]{1,1,2,0},8,2));
        carteBatiments.add(new CarteBatiment(2,"la caserne",new int[]{2,3,1,2},12,4));
        carteBatiments.add(new CarteBatiment(3,"l'hôtel de ville",new int[]{2,0,2,2},10,3));
        carteBatiments.add(new CarteBatiment(4,"les jardins suspendus",new int[]{2,3,4,5},17,7));
        carteBatiments.add(new CarteBatiment(5,"la maison",new int[]{0,1,1,0},10,0));
        carteBatiments.add(new CarteBatiment(6,"la tour de babel",new int[]{3,1,5,3},15,6));
        carteBatiments.add(new CarteBatiment(7,"la ziggourat",new int[]{1,2,3,4},14,5));
        carteBatiments.add(new CarteBatiment(8,"le comptoir marchand",new int[]{0,1,1,0},6,1));
        carteBatiments.add(new CarteBatiment(9,"le marché",new int[]{1,0,0,1},10,0));

        carteBatiments.add(new CarteBatiment(10,"la palais d'assur",new int[]{3,1,4,2},14,5));
        carteBatiments.add(new CarteBatiment(11,"la carrière",new int[]{1,1,0,0},10,0));
        carteBatiments.add(new CarteBatiment(12,"le chantier naval",new int[]{1,0,1,2},8,2));
        carteBatiments.add(new CarteBatiment(13,"la chamellerie",new int[]{1,0,1,0},6,1));
        carteBatiments.add(new CarteBatiment(14,"l'échoppe",new int[]{0,1,0,1},6,1));
        carteBatiments.add(new CarteBatiment(15,"la maison noble",new int[]{2,2,0,2},10,3));
        carteBatiments.add(new CarteBatiment(16,"la forteresse",new int[]{3,2,2,1},12,4));
        carteBatiments.add(new CarteBatiment(17,"le port",new int[]{2,1,0,1},8,2));
        carteBatiments.add(new CarteBatiment(18,"la pyramide",new int[]{4,4,4,4},18,8));
        carteBatiments.add(new CarteBatiment(19,"le sphynx",new int[]{3,5,1,3},15,6));

        carteBatiments.add(new CarteBatiment(20,"l'archerie",new int[]{0,2,1,1},8,2));
        carteBatiments.add(new CarteBatiment(21,"le colosse de rhodes",new int[]{5,4,3,2},17,7));
        carteBatiments.add(new CarteBatiment(22,"l'école de philosophie",new int[]{1,2,2,3},14,4));
        carteBatiments.add(new CarteBatiment(23,"le forum",new int[]{2,1,3,2},12,3));
        carteBatiments.add(new CarteBatiment(24,"la maison rurale",new int[]{1,0,0,1},6,1));
        carteBatiments.add(new CarteBatiment(25,"la maison urbaine",new int[]{2,2,2,0},10,3));
        carteBatiments.add(new CarteBatiment(26,"le phare d'alexandrie",new int[]{2,4,1,3},14,5));
        carteBatiments.add(new CarteBatiment(27,"le temple",new int[]{0,2,2,2},10,3));
        carteBatiments.add(new CarteBatiment(28,"le théâtre",new int[]{4,3,2,1},14,5));
        carteBatiments.add(new CarteBatiment(29,"un abreuvoir",new int[]{0,0,1,1},10,0));

        return carteBatiments;
    }

    public ArrayList<CarteMachine> creeCarteMachine()
    {
        ArrayList<CarteMachine> carteMachines = new ArrayList<CarteMachine>();

        carteMachines.add(new CarteMachine(30,"une scie",new int[]{0,0,1,2},2, CarteRessource.RessourceBois, 3));
        carteMachines.add(new CarteMachine(31,"une table d'architecte",new int[]{2,0,0,1},2, CarteRessource.RessourceSavoir, 3));
        carteMachines.add(new CarteMachine(32,"un échafaudage",new int[]{1,1,0,0},2, CarteRessource.RessourceTuile, 3));
        carteMachines.add(new CarteMachine(33,"un palan",new int[]{0,1,1,0},2, CarteRessource.RessourcePierre, 3));

        return carteMachines;
    }

    public ArrayList<CarteOuvrier> creeCartesOuvrier()
    {
        ArrayList<CarteOuvrier> carteOuvriers = new ArrayList<CarteOuvrier>();

        carteOuvriers.add( new CarteOuvrier(34,"apprenti",new int[]{0,1,1,0},2) );
        carteOuvriers.add( new CarteOuvrier(35,"apprenti",new int[]{0,1,0,1},2) );
        carteOuvriers.add( new CarteOuvrier(36,"apprenti",new int[]{1,0,1,0},2) );
        carteOuvriers.add( new CarteOuvrier(37,"apprenti",new int[]{1,0,1,0},2) );


        carteOuvriers.add( new CarteOuvrier(38,"manœuvre",new int[]{0,1,0,2},3) );
        carteOuvriers.add( new CarteOuvrier(39,"manœuvre",new int[]{1,0,2,0},3) );
        carteOuvriers.add( new CarteOuvrier(40,"manœuvre",new int[]{2,0,0,1},3) );
        carteOuvriers.add( new CarteOuvrier(41,"manœuvre",new int[]{0,2,1,0},3) );


        carteOuvriers.add( new CarteOuvrier(42,"compagnon",new int[]{3,0,1,0},4) );
        carteOuvriers.add( new CarteOuvrier(43,"compagnon",new int[]{1,0,3,0},4) );
        carteOuvriers.add( new CarteOuvrier(44,"compagnon",new int[]{1,1,1,1},4) );
        carteOuvriers.add( new CarteOuvrier(45,"compagnon",new int[]{1,1,1,1},4) );
        carteOuvriers.add( new CarteOuvrier(46,"compagnon",new int[]{0,3,0,1},4) );
        carteOuvriers.add( new CarteOuvrier(47,"compagnon",new int[]{0,1,0,3},4) );


        carteOuvriers.add( new CarteOuvrier(48,"maître",new int[]{2,0,0,3},5) );
        carteOuvriers.add( new CarteOuvrier(49,"maître",new int[]{3,2,0,0},5) );
        carteOuvriers.add( new CarteOuvrier(50,"maître",new int[]{0,3,2,0},5) );
        carteOuvriers.add( new CarteOuvrier(51,"maître",new int[]{0,0,3,2},5) );

        return carteOuvriers;
    }

    public ArrayList<CarteEsclave> creeCarteEsclave()
    {
        ArrayList<CarteEsclave> carteEsclaves = new ArrayList<CarteEsclave>();

        carteEsclaves.add( new CarteEsclave(52,"esclave",new int[]{2,0,0,2}) );
        carteEsclaves.add( new CarteEsclave(53,"esclave",new int[]{0,0,2,2}) );
        carteEsclaves.add( new CarteEsclave(54,"esclave",new int[]{2,0,2,0}) );
        carteEsclaves.add( new CarteEsclave(55,"esclave",new int[]{2,2,0,0}) );
        carteEsclaves.add( new CarteEsclave(56,"esclave",new int[]{0,2,0,2}) );
        carteEsclaves.add( new CarteEsclave(57,"esclave",new int[]{0,2,2,0}) );


        return carteEsclaves;
    }

    public ArrayList<CarteUniversite> creeCartesUniversite()
    {
        ArrayList<CarteUniversite> carteUniversites = new ArrayList<CarteUniversite>();

        carteUniversites.add( new CarteUniversite(58, "Unviverté", new int[]{3,0,0,0},7));
        carteUniversites.add( new CarteUniversite(59, "Unviverté", new int[]{0,3,0,0},7));
        carteUniversites.add( new CarteUniversite(60, "Unviverté", new int[]{0,0,3,0},7));
        carteUniversites.add( new CarteUniversite(61, "Unviverté", new int[]{0,0,0,3},7));

        return carteUniversites;
    }

    public ArrayList<CarteOutils> creeCarteOutils()
    {
        ArrayList<CarteOutils> carteOutils = new ArrayList<CarteOutils>();

        carteOutils.add(new CarteOutils(62, "maillet", new int[]{1,0,0,0}));
        carteOutils.add(new CarteOutils(63, "scie", new int[]{0,1,0,0}));
        carteOutils.add(new CarteOutils(64, "équerre", new int[]{0,0,1,0}));
        carteOutils.add(new CarteOutils(65, "pinceau", new int[]{0,0,0,1}));

        return carteOutils;
    }

    public ArrayList<CarteEmprunt> creeCarteEmprunts()
    {
        ArrayList<CarteEmprunt> carteEmprunts = new ArrayList<CarteEmprunt>();

        carteEmprunts.add(new CarteEmprunt(66));
        carteEmprunts.add(new CarteEmprunt(67));
        carteEmprunts.add(new CarteEmprunt(68));
        carteEmprunts.add(new CarteEmprunt(69));

        return carteEmprunts;
    }

}
