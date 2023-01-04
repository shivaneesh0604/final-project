package RESTAURENTMANAGEMENT.Interfaces;

import RESTAURENTMANAGEMENT.MenuList.Timing;

public interface UserMenu {
    public boolean checkFoodAvailability(String foodname, Timing timing);
}
