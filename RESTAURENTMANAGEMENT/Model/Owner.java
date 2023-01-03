package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;


public class Owner extends User {

    private ArrayList<Restaurent> restaurents;

    public Owner(String restaurentName, int ownerID) {
        super(restaurentName, ownerID);
        restaurents = new ArrayList<>();
    }

    public void addCashierToRestaurent(Restaurent restaurent,Cashier cashier) {
        restaurent.addCashierToRestaurent(cashier);
    }

    public void addChefToRestaurent(Restaurent restaurent,Chef chef){
        restaurent.addChefToRestaurent(chef);
    }

    public void addCookToRestaurent(Restaurent restaurent,Cook cook){
        restaurent.addCookToRestaurent(cook);
    }

    public void addManagerToRestaurent(Restaurent restaurent,Manager manager){
        restaurent.addManagerToRestaurent(manager);
    }

    public void addWaitersToRestaurent(Restaurent restaurent,Waiter waiter){
        restaurent.addWaitersToRestaurent(waiter);
    }

    public void createNewRestaurent(Restaurent restaurent) {
        // System.out.println("enter restaurent name");
        restaurents.add(restaurent);
        ListOfRestaurents.getInstance().addRestaurent(restaurent);
    }
}
