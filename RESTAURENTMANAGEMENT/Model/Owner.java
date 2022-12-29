package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.view.OwnerUI;


public class Owner extends User{

    private ArrayList<Restaurent> restaurents;

    public Owner(String restaurentName, int restaurentID) {
        super(restaurentName, restaurentID);
        restaurents = new ArrayList<>();
    }

    public void entersOwnerUI(int restaurentID){
        for (Restaurent restaurent : restaurents) {
            if(restaurent.getRestaurentID()==restaurentID){
                OwnerUI ownerUI = new OwnerUI();
                ownerUI.entersRestaurent(restaurent);
            }
        }
    }

    public void createNewRestaurent(){
        OwnerUI ownerUI = new OwnerUI();
        restaurents.add(ownerUI.createNewRestaurent(getID()));
    }

    // public void addWaiterToRestaurent(Waiter w1,int restaurentID) {
    //     for (Restaurent restaurent : restaurents) {
    //         if (restaurent.getRestaurentID() == restaurentID) {
    //             w1.setRestaurent(restaurent);
    //             restaurent.addWaitersToRestaurent(w1);
    //         }
    //     }
    // }

    // public void addCookToRestaurent(Cook cook,int restaurentID) {
    //     for (Restaurent restaurent : restaurents) {
    //         if (restaurent.getRestaurentID() == restaurentID) {
    //             cook.setRestaurent(restaurent);
    //             restaurent.addCookToRestaurent(cook);
    //         }
    //     }
    // }

    // public void addChefToRestaurent(Chef chef,int restaurentID) {
    //     for (Restaurent restaurent : restaurents) {
    //         if (restaurent.getRestaurentID() == restaurentID) {
    //             chef.setRestaurent(restaurent);
    //             restaurent.addChefToRestaurent(chef);
    //         }
    //     }
    // }

    // public void addManagerToRestaurent(Manager manager,int restaurentID) {
    //     for (Restaurent restaurent : restaurents) {
    //         if (restaurent.getRestaurentID() == restaurentID) {
    //             manager.setRestaurent(restaurent);
    //             restaurent.addManagerToRestaurent(manager);
    //         }
    //     }
    // }

    // public void addCashierToRestaurent(Cashier cashier,int restaurentID){
    //     for (Restaurent restaurent : restaurents) {
    //         if (restaurent.getRestaurentID() == restaurentID) {
    //             cashier.setRestaurent(restaurent);
    //             restaurent.addCashierToRestaurent(cashier);
    //         }
    //     }
    // }

}
