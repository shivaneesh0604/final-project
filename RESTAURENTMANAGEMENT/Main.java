package RESTAURENTMANAGEMENT;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.ListOfRestaurents;
import RESTAURENTMANAGEMENT.Model.Manager;
import RESTAURENTMANAGEMENT.Model.Owner;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Customer.Customer;
import RESTAURENTMANAGEMENT.view.AppUsers;
import RESTAURENTMANAGEMENT.view.CustomerUI;
import RESTAURENTMANAGEMENT.view.InputVerification;
import RESTAURENTMANAGEMENT.view.ManagerUI;
import RESTAURENTMANAGEMENT.view.OwnerUI;

public class Main {
    private static int customerID = 0;
    private static ArrayList<Owner> owners = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Owner owner1 = new Owner("raj", 1);
        owners.add(owner1);
        Mainloop: while (true) {
            InputVerification.print(AppUsers.values());
            int option = InputVerification.inputVerificationApp(AppUsers.values().length);
            AppUsers preference = AppUsers.values()[option];
            switch (preference) {
                case MANAGER:
                    try {
                        System.out.println("enter restaurentID to enter the restaurent");
                        int restaurentID1 = sc.nextInt();
                        System.out.println("enter manager id of him");
                        int managerID = sc.nextInt();
                        Restaurent restaurent = ListOfRestaurents.getInstance().getRestaurents(restaurentID1);
                        if (restaurent != null) {
                            try {
                                Manager manager = restaurent.getManager(managerID);
                                new ManagerUI(restaurent, manager).entersUI();
                                ;
                            } catch (NullPointerException e) {
                                System.out.println("no manager with this id");
                            }
                        } else {
                            System.out.println("no restaurent found");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("enter only integer values");
                        break;
                    }
                    break;

                case CUSTOMER:
                    System.out.println("enter name");
                    String name = sc.nextLine();
                    int customerID1 = customerID;
                    System.out.println("enter which timing you are entering");
                    InputVerification.print(Timing.values());
                    int option1 = InputVerification.InputVerificationTiming(Timing.values().length);
                    Timing timingPreference = Timing.values()[option1];
                    Customer customer = new Customer(name, customerID1, timingPreference);
                    customerID++;
                    System.out.println("enter restaurent id to enter ");
                    try {
                        int restaurentID2 = sc.nextInt();
                        Restaurent restaurent2 = ListOfRestaurents.getInstance().getRestaurents(restaurentID2);
                        if (restaurent2 == null) {
                            System.out.println("no restaurents available with this id");
                            continue;
                        }
                        new CustomerUI(restaurent2, customer).entersTheRestaurent(timingPreference);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("input missmatched enter integer value");
                        break;
                    }
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
                        OwnerUI ownerUI = new OwnerUI(owner);
                        switch (ownerCase) {
                            case 1:
                                ownerUI.createNewRestaurent();
                                break;
                            case 2:
                                System.out.println("enter restaurentid to enter");
                                int restaurentID3 = sc.nextInt();
                                Restaurent restaurent4 = ListOfRestaurents.getInstance().getRestaurents(restaurentID3);
                                if (restaurent4 != null) {
                                    ownerUI.entersRestaurent(restaurent4);
                                } else {
                                    System.out.println("no restaurent available with this id");
                                }
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
