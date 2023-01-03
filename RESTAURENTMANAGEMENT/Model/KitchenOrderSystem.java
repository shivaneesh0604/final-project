package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.OrderHook;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentKitchenOrderSystemInterface;

public class KitchenOrderSystem implements OrderHook {

    private RestaurentKitchenOrderSystemInterface kitchenOrderSystemInterface;

    public KitchenOrderSystem(Restaurent restaurent) {
        this.kitchenOrderSystemInterface = restaurent;
    }

    @Override
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {
        return kitchenOrderSystemInterface.getRandomChef().assignToChefAndReceieveFood(orders);
    }
    
}
