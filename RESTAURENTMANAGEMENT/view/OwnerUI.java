package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;

import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.Chef;
import RESTAURENTMANAGEMENT.Model.Cook;
import RESTAURENTMANAGEMENT.Model.ListOfRestaurents;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Waiter;

public class OwnerUI {

    Scanner scanner = new Scanner(System.in);

    public void entersRestaurent(Restaurent restaurent) {
        restaurent.addCashierToRestaurent(new Cashier("ram", 1,restaurent));
        restaurent.addChefToRestaurent(new Chef("ramu", 1,restaurent));
        restaurent.addCookToRestaurent(new Cook("sathya", 1,restaurent));
        restaurent.addManagerToRestaurent(new Manager("sankar", 1,restaurent));
        restaurent.addWaitersToRestaurent(new Waiter("shiva", 1,restaurent));
    }

    public Restaurent createNewRestaurent(int OwnerID){
        // System.out.println("enter restaurent name ");
        // String restaurentname=scanner.nextLine();
        // System.out.println("enter restaurentID");
        // int restaurentID = scanner.nextInt();
        Restaurent restaurent = new Restaurent("atchayas", 1, OwnerID);
        ListOfRestaurents.getInstance().addRestaurent(restaurent);
        return restaurent;
    }
}
