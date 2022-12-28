package RESTAURENTMANAGEMENT.Interfaces;

import RESTAURENTMANAGEMENT.MenuList.UserMenu;
import RESTAURENTMANAGEMENT.Restaurent.Cashier;
import RESTAURENTMANAGEMENT.Restaurent.KitchenOrderSystem;

public interface RestaurentWaiterInterface {
    public UserMenu getUserMenu();
    public Cashier returnCashier();
    public KitchenOrderSystem getKitchenorderSystem();
}
