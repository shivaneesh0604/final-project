package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;

import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.Chef;
import RESTAURENTMANAGEMENT.Model.Cook;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Waiter;

public class OwnerUI {

    Scanner scanner = new Scanner(System.in);

    public void entersRestaurent(Restaurent restaurent) {
        System.out.println("added these");
        restaurent.addCashierToRestaurent(new Cashier("ram", 1,restaurent));
        restaurent.addChefToRestaurent(new Chef("ramu", 1,restaurent));
        restaurent.addCookToRestaurent(new Cook("sathya", 1,restaurent));
        restaurent.addManagerToRestaurent(new Manager("sankar", 1,restaurent));
        restaurent.addWaitersToRestaurent(new Waiter("shiva", 1,restaurent));
    }
}
