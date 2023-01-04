package RESTAURENTMANAGEMENT.Model.KitchenSystems;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentCookinterface;
import RESTAURENTMANAGEMENT.Model.Order;
import RESTAURENTMANAGEMENT.Model.Restaurent;
import RESTAURENTMANAGEMENT.Model.User;

public class Cook extends User {

    private final RestaurentCookinterface restaurent;

    public Cook(String name, int iD, Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    Order getfoodAndProcess(Order order) {
        System.out.println("food in process...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("food completed");
        System.out.println("foodname is " + order.getFoodname() + " quantity is " + order.getQuantity());
        return order;
    }

    public RestaurentCookinterface getRestaurent() {
        return restaurent;
    }
}
