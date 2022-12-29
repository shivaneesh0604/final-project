package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentChefInterface;

public class Chef extends User{
    
    private RestaurentChefInterface restaurent;

    public Chef(String name, int iD,Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
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
}
