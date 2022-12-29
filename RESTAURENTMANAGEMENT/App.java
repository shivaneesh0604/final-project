package RESTAURENTMANAGEMENT;


import java.util.ArrayList;
import java.util.Scanner;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.Chef;
import RESTAURENTMANAGEMENT.Model.Cook;
import RESTAURENTMANAGEMENT.Model.Customer;
import RESTAURENTMANAGEMENT.Model.ListOfRestaurents;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Owner;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Waiter;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Owner owner1 = new Owner("raj",1);
        Restaurent restaurent1 = new Restaurent("atchayas", 1, owner1.getID());
        Cashier cashier = new Cashier("ram", 1);
        Chef chef = new Chef("ramu", 1);
        Cook cook = new Cook("sathya", 1);
        Manager manager = new Manager("sankar", 1);
        Waiter waiter = new Waiter("shiva", 1);

        owner1.createNewRestaurent(restaurent1);
        owner1.addCashierToRestaurent(cashier,1);
        owner1.addChefToRestaurent(chef,1);
        owner1.addCookToRestaurent(cook, 1);
        owner1.addManagerToRestaurent(manager, 1);
        owner1.addWaiterToRestaurent(waiter, 1);
        manager.enterRestaurent();

        Customer customer = new Customer("devi", 1);
        ArrayList<Restaurent> restaurents = ListOfRestaurents.getInstance().getRestaurents();
        for (Restaurent restaurent : restaurents) {
            if(restaurent.getRestaurentName().equals("atchayas")){
                customer.entersTheRestaurent(restaurent,Timing.NIGHT);
                break;
            }
        }
        sc.close();
    }
}
