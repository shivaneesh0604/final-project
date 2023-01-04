package RESTAURENTMANAGEMENT.Model;

import java.util.Set;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentManagementFunctions;
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

    public MenuList getFullMenuAccess(){
        return restaurent.getFullMenuAccess();
    }

    public Set<String> returnTableNumbers(int waiterid){
        return restaurent.returnTableNumbers(waiterid);
    }

    public void setTimingForFood(String foodname, Timing timing) {
        MenuList menu1 = restaurent.getFullMenuAccess();
        menu1.setTimingForFood(foodname, timing);
    }

}