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
    private RestaurentWaiterInterface restaurentWaiterInterface;
    private final HashMap<Integer, OrderList> orders;
    private final Set<String> Tablenumbers;

    public Waiter(String name, int iD, Restaurent restaurent) {
        super(name, iD);
        this.restaurentWaiterInterface = restaurent;
        Tablenumbers = new HashSet<String>();
        orders = new HashMap<>();
    }

    public UserMenu providesMenu() {
        UserMenu menu = restaurentWaiterInterface.getUserMenu();
        return menu;
    }

    public void TakeOrders(int customerid, String foodName, int quantity, Timing timing) {
        if (restaurentWaiterInterface.getUserMenu().checkFoodAvailability(foodName, timing)) {
            if (orders.containsKey(customerid)) {
                OrderList orders1 = orders.get(customerid);
                for (Order order : orders1.getOrders()) {
                    if (order.getFoodname().equals(foodName) && !order.isDelivered()) {
                        order.setQuantity(order.getQuantity() + quantity);
                        return;
                    }
                }
                Order order = new Order(foodName, quantity);
                orders1.AddtoOrders(order);

            } else {
                OrderList order = new OrderList();
                this.orders.put(customerid, order);
                Order order2 = new Order(foodName, quantity);
                order.AddtoOrders(order2);
            }
        } else {
            System.out.println("Enter the right foodname to order since it is not available at this time");
        }
    }

    public void DeleteOrder(int customerid, String foodName, int quantity, Timing timing) {
        if(restaurentWaiterInterface.getUserMenu().checkFoodAvailability(foodName, timing)){
            OrderList o = orders.get(customerid);
    
            boolean checkfoodprocessed = false;
            for (Order order : o.getOrders()) {
                if (!order.isDelivered() && order.getFoodname().equals(foodName)) {
                    checkfoodprocessed = true;
                    break;
                }
            }
            if (checkfoodprocessed == false) {
                throw new NullPointerException();
            } else {
                System.out.println("Orders in main orders are");
                o.deleteOrder(foodName, quantity);
            }
        }
        else{
            System.out.println(
                    "Enter the right foodname to delete order since this food in not available in menu at this time");
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
        OrderHook kitchensystem = restaurentWaiterInterface.getKitchenorderSystem();
        return kitchensystem.assignToChefAndReceieveFood(orders);
    }

    public Bill askbill(int customerid) {
        OrderList orders = this.orders.get(customerid);
        for (Order order : orders.getOrders()) {
            if(order.isDelivered()){
                continue;
            }
            else{
                throw new RuntimeException();
            }
        }
        Cashier cashier = restaurentWaiterInterface.returnCashier();
        return cashier.generateBill(orders.getOrders(), orders.getOrderId());
    }

    public void paybill(float paymentAmount, int customerid) {
        Cashier cashier = restaurentWaiterInterface.returnCashier();
        cashier.payBill(paymentAmount, orders.get(customerid).getOrderId());
    }

    Set<String> getTablenumbers() {
        return Tablenumbers;
    }

    void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }
}
