package RESTAURENTMANAGEMENT;

import java.util.ArrayList;
import java.util.Scanner;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Customer;
import RESTAURENTMANAGEMENT.Model.ListOfRestaurents;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Owner;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.view.AppUsers;
import RESTAURENTMANAGEMENT.view.InputVerification;

public class App {
    private static int customerID = 0;
    private static ArrayList<Owner> owners = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Owner owner1 = new Owner("raj", 1);
        owners.add(owner1);
        owner1.createNewRestaurent();
        // int managerID = 1;

        // for (Restaurent restaurent :
        // ListOfRestaurents.getInstance().getRestaurents()) {
        // if (restaurent.getRestaurentID() == restaurentID) {
        // Manager manager = restaurent.getManager(managerID);
        // manager.enterRestaurent();
        // }
        // }
        Mainloop: while (true) {
            InputVerification.print(AppUsers.values());
            int option = InputVerification.inputVerificationApp(AppUsers.values().length);
            AppUsers preference = AppUsers.values()[option];
            switch (preference) {
                case MANAGER:
                    System.out.println("enter restaurentID to enter the restaurent");
                    int restaurentID1 = sc.nextInt();
                    System.out.println("enter manager id of him");
                    int managerID = sc.nextInt();
                    Restaurent restaurent = ListOfRestaurents.getInstance().getRestaurents(restaurentID1);
                    try {
                        Manager manager = restaurent.getManager(managerID);
                        manager.enterRestaurent();
                    } catch (NullPointerException e) {
                        // TODO: handle exception
                        System.out.println("no manager with this id");
                    }
                    break;

                case CUSTOMER:
                    System.out.println("enter name");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int customerID1 = customerID;
                    Customer customer = new Customer(name, customerID1);
                    customerID++;
                    System.out.println("enter restaurent id to enter ");
                    int restaurentID2 = sc.nextInt();
                    System.out.println("enter which timing you are entering");
                    InputVerification.print(Timing.values());
                    int option1 = InputVerification.InputVerificationTiming(Timing.values().length);
                    Timing timingPreference = Timing.values()[option1];
                    Restaurent restaurent2 = ListOfRestaurents.getInstance().getRestaurents(restaurentID2);
                    customer.entersTheRestaurent(restaurent2, timingPreference);
                    break;
                case OWNER:
                    Owner owner = null;
                    System.out.println("enter owner id ");
                    int ownerID = sc.nextInt();
                    for (Owner owner2 : owners) {
                        if (owner2.getID() == ownerID) {
                            owner = owner2;
                        }
                    }
                    if (owner == null) {
                        System.out.println("no owner found");
                        continue;
                    }
                    OwnerLoop: while (true) {
                        System.out.println(
                                "if you create new restaurent press 1 or enter a restaurent press 2 to exit press other");
                        int ownerCase = sc.nextInt();
                        switch (ownerCase) {
                            case 1:
                                owner.createNewRestaurent();
                                break;
                            case 2:
                                System.out.println("enter restaurentid to enter");
                                int restaurentID3 = sc.nextInt();
                                owner.entersOwnerUI(restaurentID3);
                                break;
                            default:
                                break OwnerLoop;
                        }
                    }
                    break;
                case EXIT:
                    break Mainloop;
            }
        }
        sc.close();
    }
}
