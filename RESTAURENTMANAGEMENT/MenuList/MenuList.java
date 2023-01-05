package RESTAURENTMANAGEMENT.MenuList;

import java.util.Collection;
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
        Item item = totalItems.get(foodname);
        if(item.getTiming()==timing){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkFoodAvailability(String foodname){
        return totalItems.containsKey(foodname);
    }

    public void setTimingForFood(String foodname, Timing timing) {
        Item item = totalItems.get(foodname);
        if (item == null)
            return;
        item.setTiming(timing);
    }

    public HashMap<String, Item> getItems(Timing timing) {
        HashMap<String, Item> availableTimingItems = new HashMap<>();
        Collection<Item> menuItems_values = totalItems.values();
        for (Item item : menuItems_values) {
            if (item.getTiming() == timing) {
                availableTimingItems.put(item.getFoodName(), item);
            }
        }
        return availableTimingItems;
    }

    public HashMap<String, Item> getItems() {
        return totalItems;
    }

}
