package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.OrderHook;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentOrderKitchenSystemInterface;

public class KitchenOrderSystem implements OrderHook {

    private RestaurentOrderKitchenSystemInterface kitchenOrderSystemInterface;

    @Override
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {
        return kitchenOrderSystemInterface.getRandomChef().assignToChefAndReceieveFood(orders);
    }

    RestaurentOrderKitchenSystemInterface getKitchenOrderSystemInterface() {
        return kitchenOrderSystemInterface;
    }

    void setKitchenOrderSystemInterface(Restaurent restaurent) {
        this.kitchenOrderSystemInterface = restaurent;
    }
    
}
