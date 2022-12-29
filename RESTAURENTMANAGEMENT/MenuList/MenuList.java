package RESTAURENTMANAGEMENT.MenuList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MenuList implements UserMenu {

    private Set<Item> totalItems = new HashSet<Item>();

    public void addMenusItems(Item items) {
        totalItems.add(items);

    }

    public void showMenu(){
        for (Item item : totalItems) {
            System.out.println(item.getFoodName()+" "+item.getPrice()+" "+item.getTiming());
        }
    }

    @Override
    public void showMenu(Timing timing) {
        System.out.println("Food available are ");
        System.out.println("foodname \t price\t dietory");
        System.out.println("veg starters are");
        for (Item item : totalItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.STARTER)) {
                    if (item.getDietery().equals(Dietery.VEG)){
                        System.out.println(item.getFoodName() + "\t" + item.getPrice() + "\t " + item.getDietery());
                    }
                }
            }
        }

        System.out.println("nonveg starters are");
        for (Item item : totalItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.STARTER)) {
                    if (item.getDietery().equals(Dietery.NONVEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }

        System.out.println("maincourse veg items are");
        for (Item item : totalItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.MAINCOURSE)) {
                    if (item.getDietery().equals(Dietery.VEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        System.out.println("maincourse nonveg items are");
        for (Item item : totalItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.MAINCOURSE)) {
                    if (item.getDietery().equals(Dietery.NONVEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        System.out.println("dessert veg items are ");

        for (Item item : totalItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.DESSERT)) {
                    if (item.getDietery().equals(Dietery.VEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        System.out.println("dessert nonveg items items are");

        for (Item item : totalItems) {
            if(item.getTiming().equals(timing)){
                if (item.getCourse().equals(Course.DESSERT)) {
                    if (item.getDietery().equals(Dietery.NONVEG)){
                        System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getDietery());
                    }
                }
            }
        }
        
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

}
