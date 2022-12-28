package RESTAURENTMANAGEMENT.Interfaces;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Orders.Order;

public interface OrderHook {
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders);
}
