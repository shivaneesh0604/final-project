package RESTAURENTMANAGEMENT.Interfaces;

import java.util.List;

import RESTAURENTMANAGEMENT.MenuList.MenuList;

public interface RestaurentManagementFunctions {

    public void addTableNumbersToWaiters(String tablenumber, int waiterid);

    public void deleteTableNumberforWaiter(String tablenumber, int waiterid);

    public List<String> returnTableNumbers(int waiterID);

    public MenuList getFullMenu();

    public void createNewMenu();

}
