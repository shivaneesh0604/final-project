package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.OrderHook;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentOrderKitchenSystemInterface;

public class KitchenOrderSystem implements OrderHook {

    private RestaurentOrderKitchenSystemInterface kitchenOrderSystemInterface;

    public KitchenOrderSystem(Restaurent restaurent) {
        this.kitchenOrderSystemInterface = restaurent;
    }

    @Override
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {
        return kitchenOrderSystemInterface.getRandomChef().assignToChefAndReceieveFood(orders);
    }
    
}
