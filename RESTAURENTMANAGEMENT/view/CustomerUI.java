package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.InputMismatchException;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentCustomerInterface;
import RESTAURENTMANAGEMENT.MenuList.Course;
import RESTAURENTMANAGEMENT.MenuList.Dietery;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Bill;
import RESTAURENTMANAGEMENT.Model.Customer;
import RESTAURENTMANAGEMENT.Model.Order;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.Waiter;

public class CustomerUI {
    Scanner in = new Scanner(System.in);
    private RestaurentCustomerInterface restaurentCustomerInterface;
    private final Customer customer;

    public CustomerUI(Restaurent restaurent,Customer customer) {
        this.restaurentCustomerInterface = restaurent;
        this.customer = customer;
    }

    public void entersTheRestaurent(Timing timing) {
        MainLoops: while (true) {
            System.out.println("enter table number to sit");
            String tablenumber = in.next();

            Waiter waiter = restaurentCustomerInterface.getIN(tablenumber, customer.getID());
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
                        Set<Item> menuItems = customer.askMenu(waiter);
                        showMenu(menuItems,timing);
                        break;

                    case ADD_ORDERS:
                        System.out.println("enter food name ");
                        in.nextLine();
                        String foodname = in.nextLine();
                        System.out.println("enter the quantity");
                        int quantity = in.nextInt();
                        customer.addOrders(waiter, foodname.toUpperCase(), quantity);
                        break;

                    case DELETE_ORDER:
                        System.out.println("enter food name to delete");
                        in.nextLine();
                        String foodname1 = in.nextLine();
                        System.out.println("enter the quantity");
                        try {
                            int quantity1 = in.nextInt();
                            try {
                                System.out.println(customer.deleteOrder(waiter, foodname1.toUpperCase(), quantity1)); 
                            } catch (NullPointerException e) {
                                System.out.println("this food is not ordered");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("input missmatched");
                        }
                        break;

                    case CONFIRM_ORDER:
                        try {
                            ArrayList<Order> orders = customer.confirmOrder(waiter);
                            receiveOrder(orders);
                        } catch (Exception e) {
                            System.out.println("add an order first");
                        }
                        break;

                    case ASKING_BILL:
                        try {
                            Bill bill = customer.askBill(waiter);
                            bill.ReadBill();
                            System.out.println("enter the amount to pay");
                            float paymentAmount = in.nextFloat();
                            try {
                                customer.paybill(waiter,paymentAmount);
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

    private void showMenu(Set<Item> menuItems,Timing timing){
        System.out.println("Food available are ");
        System.out.println("foodname \t price\t dietory");
        System.out.println("veg starters are");
        for (Item item : menuItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.STARTER)) {
                    if (item.getDietery().equals(Dietery.VEG)){
                        System.out.println(item.getFoodName() + "\t" + item.getPrice() + "\t " + item.getDietery());
                    }
                }
            }
        }

        System.out.println("nonveg starters are");
        for (Item item : menuItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.STARTER)) {
                    if (item.getDietery().equals(Dietery.NONVEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }

        System.out.println("maincourse veg items are");
        for (Item item : menuItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.MAINCOURSE)) {
                    if (item.getDietery().equals(Dietery.VEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        System.out.println("maincourse nonveg items are");
        for (Item item : menuItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.MAINCOURSE)) {
                    if (item.getDietery().equals(Dietery.NONVEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        System.out.println("dessert veg items are ");

        for (Item item : menuItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.DESSERT)) {
                    if (item.getDietery().equals(Dietery.VEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        System.out.println("dessert nonveg items items are");

        for (Item item : menuItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.DESSERT)) {
                    if (item.getDietery().equals(Dietery.NONVEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
    }
}
