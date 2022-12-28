package RESTAURENTMANAGEMENT.Interfaces;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Restaurent.Order;

public interface OrderHook {
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders);
}
