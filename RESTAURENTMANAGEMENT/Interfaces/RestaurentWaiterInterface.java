package RESTAURENTMANAGEMENT.Interfaces;

import java.util.HashMap;

import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.KitchenOrderSystem;

public interface RestaurentWaiterInterface {
    public UserMenu getUserMenu();
    public HashMap<String,Item> getMenuItems();
    public Cashier returnCashier();
    public KitchenOrderSystem getKitchenorderSystem();
}
