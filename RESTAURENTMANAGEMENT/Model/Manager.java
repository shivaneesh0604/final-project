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

    public void addTableNumbersToWaiter(String tablenumber, int waiterid) {
        restaurent.addTableNumbersToWaiters(tablenumber, waiterid);
    }

    public void deleteTableNumberforWaiter(String deletetablenumber, int waiterid1) {
        restaurent.deleteTableNumberforWaiter(deletetablenumber, waiterid1);
    }

    public void addMenusItems(Item item) {
        restaurent.getFullMenu().addMenusItems(item);
    }

    public void alterMenuItems(String foodname, int price) {
        restaurent.getFullMenu().alterMenuItems(foodname, price);
    }

    public void deleteMenuItems(String foodname) {
        restaurent.getFullMenu().deleteMenuItems(foodname);
    }

    public void createNewMenu() {
        restaurent.createNewMenu();
        MenuList menu1 = restaurent.getFullMenu();
        Item item2 = new Item("chicken Chucka", 130, Dietery.NONVEG, Course.MAINCOURSE, Timing.NIGHT);
        menu1.addMenusItems(item2);
    }

}