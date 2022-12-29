package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import RESTAURENTMANAGEMENT.Interfaces.OrderHook;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentWaiterInterface;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.MenuList.UserMenu;

public class Waiter extends User {
    private RestaurentWaiterInterface waiterInterface;
    private final HashMap<Integer, OrderList> orders;
    private final Set<String> Tablenumbers;

    public Waiter(String name, int iD) {
        super(name, iD);
        Tablenumbers = new HashSet<String>();
        orders = new HashMap<>();
    }

    public UserMenu providesMenu() {
        UserMenu menu = waiterInterface.getUserMenu();
        return menu;
    }

    public void TakeOrders(int customerid, String foodName, int quantity, Timing timing) {

        if (orders.containsKey(customerid)) {
            OrderList orders1 = orders.get(customerid);
            boolean foodExists = false;
            foodExists = waiterInterface.getUserMenu().checkFoodAvailability(foodName, timing);
            if (foodExists == false) {
                System.out.println("Enter the right foodname to order since it is not available at this time");
            } else {
                Order order = new Order(foodName, quantity);
                orders1.AddtoOrders(order);
            }
        } else {
            OrderList order = new OrderList();
            this.orders.put(customerid, order);
            Order order2 = new Order(foodName, quantity);
            order.AddtoOrders(order2);
        }
    }

    public ArrayList<Order> processOrder(int customerid) {
        OrderList o1 = orders.get(customerid);

        if (o1.getOrders().size() == 0) {
            throw new NullPointerException();
        }
        if (o1.getOrderId() == 0) {
            o1.setOrderId(customerid);
        }
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : o1.getOrders()) {
            if (order.isDelivered()) {
                continue;
            } else if (!order.isDelivered()) {
                orders.add(order);
                order.setDelivered(true);
            }
        }
        OrderHook kitchensystem = waiterInterface.getKitchenorderSystem();
        return kitchensystem.assignToChefAndReceieveFood(orders);
    }

    public void DeleteOrder(int customerid, String foodName, int quantity, Timing timing) {
        boolean foodExists = false;
        foodExists = waiterInterface.getUserMenu().checkFoodAvailability(foodName, timing);
        if (foodExists == false) {
            System.out.println(
                    "Enter the right foodname to delete order since this food in not available in menu at this time");
            return;
        }
        OrderList o = orders.get(customerid);

        boolean checkfoodprocessed = false;
        for (Order order : o.getOrders()) {
            if (!order.isDelivered() && order.getFoodname().equals(foodName)) {
                checkfoodprocessed = true;
                break;
            }
        }
        if (checkfoodprocessed == false) {
            throw new RuntimeException();
        } else {
            System.out.println("Orders in main orders are");
            o.deleteOrder(foodName, quantity);
        }
    }

    public Bill askbill(int customerid) {
        OrderList order = this.orders.get(customerid);
        Cashier cashier = waiterInterface.returnCashier();
        return cashier.generateBill(order.getOrders(), order.getOrderId());
    }

    public void paybill(float paymentAmount, int customerid) {
        Cashier cashier = waiterInterface.returnCashier();
        cashier.payBill(paymentAmount, orders.get(customerid).getOrderId());
    }

    Set<String> getTablenumbers() {
        return Tablenumbers;
    }

    void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }

    void setRestaurent(Restaurent restaurent) {
        this.waiterInterface = restaurent;
    }

}
