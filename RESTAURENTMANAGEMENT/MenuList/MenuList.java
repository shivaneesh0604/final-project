package RESTAURENTMANAGEMENT.MenuList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MenuList  {

    private Set<Item> totalItems = new HashSet<Item>();

    public void addMenusItems(Item items) {
        totalItems.add(items);

    }

    public void showMenu(Timing timing) {
        
        
    }

    public void alterMenuItems(String foodname, int price) {
        for (Item item : totalItems) {
            if (item.getFoodName().equals(foodname)) {
                item.setPrice(price);
                System.out.println("changed food name is " + item.getFoodName() + "price is " + item.getPrice());
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

}
