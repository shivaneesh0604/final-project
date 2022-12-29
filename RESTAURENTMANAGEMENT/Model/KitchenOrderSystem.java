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

    protected RestaurentOrderKitchenSystemInterface getKitchenOrderSystemInterface() {
        return kitchenOrderSystemInterface;
    }

    protected void setKitchenOrderSystemInterface(Restaurent restaurent) {
        this.kitchenOrderSystemInterface = restaurent;
    }
    
}