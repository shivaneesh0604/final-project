package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentChefInterface;

public class Chef extends User{
    
    private RestaurentChefInterface restaurent;

    public Chef(String name, int iD) {
        super(name, iD);
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

    protected RestaurentChefInterface getRestaurent() {
        return restaurent;
    }
    protected void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
}
