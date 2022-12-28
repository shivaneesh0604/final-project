package RESTAURENTMANAGEMENT.Restaurent;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentChefInterface;
import RESTAURENTMANAGEMENT.Orders.Order;

public class Chef {
    private final String name;
    private final int ID;
    private RestaurentChefInterface restaurent;

    public Chef(String name, int iD) {
        this.name = name;
        ID = iD;
    }

    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {

        Cook cook = restaurent.getRandomCook();
        
        ArrayList<Order> processedOrders = new ArrayList<>();
        for (Order order : orders) {
            Order order1 = cook.getfoodAndProcess(order);
            processedOrders.add(order1);
        }
        return processedOrders;
    }

    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }

    protected RestaurentChefInterface getRestaurent() {
        return restaurent;
    }
    protected void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
}
