package RESTAURENTMANAGEMENT.Interfaces;

import java.util.ArrayList;

import RESTAURENTMANAGEMENT.Model.Order;

public interface OrderHook {
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders);
}
