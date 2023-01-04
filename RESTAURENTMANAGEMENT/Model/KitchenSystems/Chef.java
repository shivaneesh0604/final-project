package RESTAURENTMANAGEMENT.Model.KitchenSystems;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentChefInterface;
import RESTAURENTMANAGEMENT.Model.Order;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.User;

public class Chef extends User {

    private RestaurentChefInterface restaurent;

    public Chef(String name, int iD, Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {

        Cook cook = restaurent.getRandomCook();

        ArrayList<Order> processedOrders = new ArrayList<>();
        for (Order order : orders) {
            Order order1 = cook.getfoodAndProcess(order);
            processedOrders.add(order1);
        }
        return processedOrders;
    }
}
