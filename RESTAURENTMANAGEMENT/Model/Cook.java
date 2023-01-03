package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentCookinterface;

public class Cook extends User {

    private final RestaurentCookinterface restaurent;

    public Cook(String name, int iD,Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    public Order getfoodAndProcess(Order order) {
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
