package RESTAURENTMANAGEMENT.MenuList;

import java.util.HashMap;

import RESTAURENTMANAGEMENT.Interfaces.UserMenu;

public class MenuList implements UserMenu {

    private HashMap<String, Item> totalItems = new HashMap<>();

    public void addMenusItems(Item items) {
        totalItems.put(items.getFoodName(), items);
    }

    public void alterMenuItems(String foodname, int price) {
        Item item = totalItems.get(foodname);
        if (item == null)
            return;
        item.setPrice(price);
    }

    public void deleteMenuItems(String foodname) {
        totalItems.remove(foodname);
    }

    @Override
    public boolean checkFoodAvailability(String foodname, Timing timing) {
        return totalItems.containsKey(foodname);
    }

    public void setTimingForFood(String foodname, Timing timing) {
        Item item = totalItems.get(foodname);
        if (item == null)
            return;
        item.setTiming(timing);
    }

    public HashMap<String, Item> getTotalItems() {
        return totalItems;
    }

}
