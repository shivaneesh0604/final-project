package RESTAURENTMANAGEMENT.Model.KitchenSystems;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Interfaces.KitchenSystem;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentKitchenOrderSystemInterface;
import RESTAURENTMANAGEMENT.Model.Order;
import RESTAURENTMANAGEMENT.Model.Restaurent;

public class KitchenOrderSystem implements KitchenSystem {

    private RestaurentKitchenOrderSystemInterface kitchenOrderSystemInterface;

    public KitchenOrderSystem(Restaurent restaurent) {
        this.kitchenOrderSystemInterface = restaurent;
    }

    @Override
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {
        return kitchenOrderSystemInterface.getRandomChef().assignToChefAndReceieveFood(orders);
    }

}
