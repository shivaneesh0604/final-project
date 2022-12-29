package RESTAURENTMANAGEMENT;

import java.util.Scanner;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Customer;
import RESTAURENTMANAGEMENT.Model.ListOfRestaurents;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Owner;
import RESTAURENTMANAGEMENT.Model.Restaurent;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Owner owner1 = new Owner("raj", 1);
        // Cashier cashier = new Cashier("ram", 1);
        // Chef chef = new Chef("ramu", 1);
        // Cook cook = new Cook("sathya", 1);
        // Manager manager = new Manager("sankar", 1);
        // Waiter waiter = new Waiter("shiva", 1);

        owner1.createNewRestaurent();
        owner1.entersOwnerUI(1);
        // owner1.addCashierToRestaurent(cashier,1);
        // owner1.addChefToRestaurent(chef,1);
        // owner1.addCookToRestaurent(cook, 1);
        // owner1.addManagerToRestaurent(manager, 1);
        // owner1.addWaiterToRestaurent(waiter, 1);

        int restaurentID = 1;
        int managerID = 1;

        for (Restaurent restaurent : ListOfRestaurents.getInstance().getRestaurents()) {
            if(restaurent.getRestaurentID()==restaurentID){
                Manager manager=restaurent.getManager(managerID);
                manager.enterRestaurent();
            }
        }

        Customer customer = new Customer("devi", 1);
        ListOfRestaurents.getInstance().showRestaurents();
        for (Restaurent restaurent : ListOfRestaurents.getInstance().getRestaurents()) {
            if (restaurent.getRestaurentName().equals("atchayas")) {
                customer.entersTheRestaurent(restaurent, Timing.NIGHT);
                break;
            }
        }
        sc.close();
    }
}
