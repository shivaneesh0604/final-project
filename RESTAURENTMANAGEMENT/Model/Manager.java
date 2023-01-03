package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentManagementFunctions;
import RESTAURENTMANAGEMENT.MenuList.Course;
import RESTAURENTMANAGEMENT.MenuList.Dietery;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.MenuList;
import RESTAURENTMANAGEMENT.MenuList.Timing;

public class Manager extends User {
    private RestaurentManagementFunctions restaurent;

    public Manager(String name, int iD, Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    public String addTableNumbersToWaiter(String tablenumber, int waiterid) {
        return restaurent.addTableNumbersToWaiters(tablenumber, waiterid);
    }

    public void deleteTableNumberforWaiter(String deletetablenumber, int waiterid1) {
        restaurent.deleteTableNumberforWaiter(deletetablenumber, waiterid1);
    }

    public void addMenusItems(Item item) {
        restaurent.getFullMenuAccess().addMenusItems(item);
    }

    public void alterMenuItems(String foodname, int price) {
        restaurent.getFullMenuAccess().alterMenuItems(foodname, price);
    }

    public void deleteMenuItems(String foodname) {
        restaurent.getFullMenuAccess().deleteMenuItems(foodname);
    }

    public void createNewMenu() {
        restaurent.createNewMenu();
        //simply adding dummy values
        MenuList menu1 = restaurent.getFullMenuAccess();
        Item item2 = new Item("chicken Chucka", 130, Dietery.NONVEG, Course.MAINCOURSE, Timing.EVENING);
        menu1.addMenusItems(item2);
        Item item3 = new Item("rice", 100, Dietery.VEG, Course.MAINCOURSE, Timing.EVENING);
        menu1.addMenusItems(item3);
    }

    public void setTimingForFood(String foodname,Timing timing){
        MenuList menu1 = restaurent.getFullMenuAccess();
        menu1.setTimingForFood(foodname, timing);
    }

}