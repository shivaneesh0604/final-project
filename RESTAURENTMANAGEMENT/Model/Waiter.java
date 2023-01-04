package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import RESTAURENTMANAGEMENT.Interfaces.KitchenSystem;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentWaiterInterface;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.Timing;

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

    public HashMap<String, Item> providesMenu(Timing timing) {
        return restaurentWaiterInterface.getMenuItems(timing);
    }

    public String TakeOrders(int customerid, String foodName, int quantity, Timing timing) {
        if (restaurentWaiterInterface.getUserMenu().checkFoodAvailability(foodName, timing)) {
            if (orders.containsKey(customerid)) {
                OrderList orders1 = orders.get(customerid);
                for (Order order : orders1.getOrders()) {
                    if (order.getFoodname().equals(foodName) && !order.isDelivered()) {
                        order.setQuantity(order.getQuantity() + quantity);
                        return "qunatity changed to " + order.getQuantity();
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
            return "Enter the right foodname to order since it is not available at this time";
        }
        return "";
    }

    public String DeleteOrder(int customerid, String foodName, int quantity, Timing timing) {
        if (restaurentWaiterInterface.getUserMenu().checkFoodAvailability(foodName, timing)) {
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
                return o.deleteOrder(foodName, quantity);
            }
        }

        return "Enter the right foodname to delete order since this food in not available in menu at this time";

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
        KitchenSystem kitchensystem = restaurentWaiterInterface.getKitchenorderSystem();
        return kitchensystem.assignToChefAndReceieveFood(orders);
    }

    public Bill askbill(int customerid) {
        OrderList orders = this.orders.get(customerid);
        for (Order order : orders.getOrders()) {
            if (order.isDelivered()) {
                continue;
            } else {
                throw new RuntimeException();
            }
        }
        Cashier cashier = restaurentWaiterInterface.getCashier();
        return cashier.generateBill(orders.getOrders(), orders.getOrderId());
    }

    public void paybill(float paymentAmount, int customerid) {
        Cashier cashier = restaurentWaiterInterface.getCashier();
        cashier.payBill(paymentAmount, orders.get(customerid).getOrderId());
    }

    Set<String> getTablenumbers() {
        return Tablenumbers;
    }

    void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }
}
