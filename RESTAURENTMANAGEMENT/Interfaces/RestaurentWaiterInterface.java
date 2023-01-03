package RESTAURENTMANAGEMENT.Interfaces;

import java.util.Set;

import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.KitchenOrderSystem;

public interface RestaurentWaiterInterface {
    public UserMenu getUserMenu();
    public Set<Item> getMenuItems();
    public Cashier returnCashier();
    public KitchenOrderSystem getKitchenorderSystem();
}
