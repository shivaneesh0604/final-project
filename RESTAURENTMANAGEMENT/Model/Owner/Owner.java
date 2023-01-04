package RESTAURENTMANAGEMENT.Model.Owner;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.User;
import RESTAURENTMANAGEMENT.Model.Waiter;
import RESTAURENTMANAGEMENT.Model.Cashier.Cashier;
import RESTAURENTMANAGEMENT.Model.KitchenSystems.Chef;
import RESTAURENTMANAGEMENT.Model.KitchenSystems.Cook;

public class Owner extends User {

    private ArrayList<Restaurent> restaurents;

    public Owner(String restaurentName, int ownerID) {
        super(restaurentName, ownerID);
        restaurents = new ArrayList<>();
    }

    public void addCashierToRestaurent(Restaurent restaurent, Cashier cashier) {
        restaurent.addCashierToRestaurent(cashier);
    }

    public void addChefToRestaurent(Restaurent restaurent, Chef chef) {
        restaurent.addChefToRestaurent(chef);
    }

    public void addCookToRestaurent(Restaurent restaurent, Cook cook) {
        restaurent.addCookToRestaurent(cook);
    }

    public void addManagerToRestaurent(Restaurent restaurent, Manager manager) {
        restaurent.addManagerToRestaurent(manager);
        manager.createNewMenu();
    }

    public void addWaitersToRestaurent(Restaurent restaurent, Waiter waiter) {
        restaurent.addWaitersToRestaurent(waiter);
    }

    public void createNewRestaurent(Restaurent restaurent) {
        // System.out.println("enter restaurent name");
        restaurents.add(restaurent);
        ListOfRestaurents.getInstance().addRestaurent(restaurent);
    }
}
