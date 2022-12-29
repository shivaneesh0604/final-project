package RESTAURENTMANAGEMENT.Interfaces;

import RESTAURENTMANAGEMENT.MenuList.UserMenu;
import RESTAURENTMANAGEMENT.Model.Cashier;
import RESTAURENTMANAGEMENT.Model.KitchenOrderSystem;

public interface RestaurentWaiterInterface {
    public UserMenu getUserMenu();
    public Cashier returnCashier();
    public KitchenOrderSystem getKitchenorderSystem();
}
