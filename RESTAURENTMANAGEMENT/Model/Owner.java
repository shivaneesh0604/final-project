package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.view.OwnerUI;

public class Owner extends User {

    private ArrayList<Restaurent> restaurents;

    public Owner(String restaurentName, int ownerID) {
        super(restaurentName, ownerID);
        restaurents = new ArrayList<>();
    }

    // public void entersOwnerUI(int restaurentID){
    // for (Restaurent restaurent : restaurents) {
    // if(restaurent.getRestaurentID()==restaurentID){
    // OwnerUI ownerUI = new OwnerUI();
    // ownerUI.entersRestaurent(restaurent);
    // }
    // }
    // }

    public void createNewRestaurent() {
        // System.out.println("enter restaurent name");
        ArrayList<String> tableAvailable = new ArrayList<String>(){{
            add("t1");
            add("t2");
            add("t3");
        }};

        Restaurent restaurent = new Restaurent("atchayas", 1, this.getID(),tableAvailable);
        System.out.println("created atchayas restaurent");
        restaurents.add(restaurent);
        ListOfRestaurents.getInstance().addRestaurent(restaurent);
        OwnerUI ownerUI = new OwnerUI();
        ownerUI.entersRestaurent(restaurent);
    }
}
