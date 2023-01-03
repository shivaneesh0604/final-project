package RESTAURENTMANAGEMENT.MenuList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import RESTAURENTMANAGEMENT.Interfaces.UserMenu;

public class MenuList implements UserMenu  {

    private Set<Item> totalItems = new HashSet<Item>();

    public void addMenusItems(Item items) {
        totalItems.add(items);
    }

    public void alterMenuItems(String foodname, int price) {
        for (Item item : totalItems) {
            if (item.getFoodName().equals(foodname)) {
                item.setPrice(price);
            }
        }

    }

    public void deleteMenuItems(String foodname) {
        Iterator<Item> it = totalItems.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getFoodName().equals(foodname)) {
                it.remove();
            }
        }
    }

    @Override
    public boolean checkFoodAvailability(String foodname,Timing timing) {
        for (Item item : totalItems) {
            if (item.getFoodName().equals(foodname) && item.getTiming().equals(timing)) {
                return true;
            }
        }
        return false;
    }

    public Set<Item> getMenuItems() {
        return totalItems;
    }

    public void setTimingForFood(String foodname,Timing timing){
        for (Item item : totalItems) {
            if(item.getFoodName().equals(foodname)){
                item.setTiming(timing);
            }
        }
    }

}
