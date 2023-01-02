package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentCustomerInterface;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.MenuList.UserMenu;
import RESTAURENTMANAGEMENT.Model.Bill;
import RESTAURENTMANAGEMENT.Model.Order;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Waiter;

public class CustomerUI {
    Scanner in = new Scanner(System.in);
    private RestaurentCustomerInterface restaurentCustomerInterface;

    public CustomerUI(Restaurent restaurent) {
        this.restaurentCustomerInterface = restaurent;
    }

    public void entersTheRestaurent(Timing timing, int customerID) {
        MainLoops: while (true) {
            System.out.println("enter table number to sit");
            String tablenumber = in.next();

            Waiter waiter = restaurentCustomerInterface.getIN(tablenumber, customerID);
            if (waiter == null) {
                System.out.println("you have entered wrong tablenumber");
                continue;
            }
            InnerLoop: while (true) {
                InputVerification.print(CustomerOptions.values());

                int option = InputVerification.inputVerificationCustomer(CustomerOptions.values().length);
                CustomerOptions preference = CustomerOptions.values()[option];

                switch (preference) {
                    case ASKING_MENU:
                        UserMenu menu = waiter.providesMenu();
                        menu.showMenu(timing);
                        break;

                    case ADD_ORDERS:
                        System.out.println("enter food name ");
                        in.nextLine();
                        String foodname = in.nextLine();
                        System.out.println("enter the quantity");
                        int quantity = in.nextInt();
                        waiter.TakeOrders(customerID, foodname.toUpperCase(), quantity, timing);
                        break;

                    case DELETE_ORDER:
                        System.out.println("enter food name to delete");
                        in.nextLine();
                        String foodname1 = in.nextLine();
                        System.out.println("enter the quantity");
                        try {
                            int quantity1 = in.nextInt();
                            try {
                                waiter.DeleteOrder(customerID, foodname1.toUpperCase(), quantity1, timing);
                            } catch (NullPointerException e) {
                                System.out.println("this food is not ordered");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("input missmatched");
                        }
                        break;

                    case CONFIRM_ORDER:
                        try {
                            ArrayList<Order> orders = waiter.processOrder(customerID);
                            receiveOrder(orders);
                        } catch (Exception e) {
                            System.out.println("add an order first");
                        }
                        break;

                    case ASKING_BILL:
                        try {
                            Bill bill = waiter.askbill(customerID);
                            bill.ReadBill();
                            System.out.println("enter the amount to pay");
                            float paymentAmount = in.nextFloat();
                            try {
                                waiter.paybill(paymentAmount, customerID);
                            } catch (RuntimeException e) {
                                // TODO: handle exception
                                break;
                            }
                        } catch (RuntimeException e) {
                            // TODO: handle exception
                            System.out.println("confirm the order first");
                            break;
                        }
                        break InnerLoop;
                }
            }
            break MainLoops;
        }
    }

    private void receiveOrder(ArrayList<Order> order) {
        for (Order orders : order) {
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }
}
