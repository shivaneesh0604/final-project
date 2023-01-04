package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderList {

    private int orderId = 0;

    private ArrayList<Order> orders = new ArrayList<>();

    public void AddtoOrders(Order order) {
        orders.add(order);
    }

    public String deleteOrder(String foodname, int quantity) {
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            Order order = it.next();
            if (order.getFoodname().equals(foodname.toUpperCase()) && !order.isDelivered()) {
                if (order.getQuantity() == quantity) {
                    it.remove();
                    return order.getFoodname() + " is totally deleted";
                } else if (order.getQuantity() > quantity) {
                    order.setQuantity(order.getQuantity() - quantity);
                    return "Changed order is " + order.getFoodname() + " with the quantity " + order.getQuantity();
                } else if (order.getQuantity() < quantity) {
                    return "Your order is not compatible to change please enter value on or below "
                            + order.getQuantity() + " to delete";

                }
            }
        }
        return null;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id;
    }

}
