package RESTAURENTMANAGEMENT.view;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.Chef;
import RESTAURENTMANAGEMENT.Model.Cook;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Owner;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Waiter;

public class OwnerUI {

    private final Owner owner ;
    
    public OwnerUI(Owner owner) {
        this.owner = owner;
    }

    public void createNewRestaurent() {
        ArrayList<String> tableAvailable = new ArrayList<String>() {
            {
                add("t1");
                add("t2");
                add("t3");
            }
        };

        Restaurent restaurent = new Restaurent("atchayas", 1, owner.getID(), tableAvailable);
        System.out.println("created atchayas restaurent");
        owner.createNewRestaurent(restaurent);
    }

    public void entersRestaurent(Restaurent restaurent) {
        init(restaurent);
    }
    
    private void init(Restaurent restaurent){
        System.out.println("added these");
        Cashier cashier = new Cashier("ram", 1,restaurent);
        Chef chef = new Chef("ramu", 1,restaurent);
        Cook cook = new Cook("sathya", 1,restaurent);
        Manager manager = new Manager("sankar", 1,restaurent);
        Waiter waiter = new Waiter("shiva", 1,restaurent);
        owner.addCashierToRestaurent(restaurent, cashier);
        owner.addChefToRestaurent(restaurent, chef);
        owner.addCookToRestaurent(restaurent, cook);
        owner.addManagerToRestaurent(restaurent, manager);
        owner.addWaitersToRestaurent(restaurent, waiter);
    }
}
