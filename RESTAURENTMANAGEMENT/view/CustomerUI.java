package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;
import java.util.ArrayList;

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
    public void entersTheRestaurent(Timing timing,int customerID) {
        System.out.println("enter table number to sit");
        String tablenumber = in.next();
        Waiter waiter = restaurentCustomerInterface.getIN(tablenumber, customerID);
        MainLoop: while (true) {
            System.out.println(
                    "press 1 for asking menu \n 2 to add new orders \n 3 for deleteOrder \n 4 for confirm order \n 5 for asking bill and paying  ");
            int option = in.nextInt();
            switch (option) {
                case 1:
                    UserMenu menu = waiter.providesMenu();
                    menu.showMenu(timing);
                    break;

                case 2:
                    System.out.println("enter food name ");
                    in.nextLine();
                    String foodname = in.nextLine();
                    System.out.println("enter the quantity");
                    int quantity = in.nextInt();
                    waiter.TakeOrders(customerID, foodname, quantity,timing);
                    break;

                case 3:
                    System.out.println("enter food name to delete");
                    in.nextLine();
                    String foodname1 = in.nextLine();
                    System.out.println("enter the quantity");
                    int quantity1 = in.nextInt();
                    try {
                        waiter.DeleteOrder(customerID, foodname1, quantity1,timing);
                    } catch (Exception e) {
                        System.out.println("this food is not ordered");
                    }
                    break;

                case 4:
                    try {
                        ArrayList<Order> orders = waiter.processOrder(customerID);
                        receiveOrder(orders);
                    } catch (Exception e) {
                        System.out.println("add an order first");
                    }
                    break;

                case 5:
                    Bill bill = waiter.askbill(customerID);
                    bill.ReadBill();
                    System.out.println("enter the amount to pay");
                    float paymentAmount = in.nextFloat();
                    waiter.paybill(paymentAmount, customerID);
                    break MainLoop;
            }
            
        }
    }
    private void receiveOrder(ArrayList<Order> order) {
        for (Order orders : order) {
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }
}
