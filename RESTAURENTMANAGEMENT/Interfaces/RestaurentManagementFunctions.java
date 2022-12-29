package RESTAURENTMANAGEMENT.Interfaces;

import java.util.Set;

import RESTAURENTMANAGEMENT.MenuList.MenuList;

public interface RestaurentManagementFunctions {

    public void addTableNumbersToWaiters(String tablenumber, int waiterid);

    public void deleteTableNumberforWaiter(String tablenumber, int waiterid);

    public Set<String> returnTableNumbers(int waiterID);

    public MenuList getFullMenu();

    public void createNewMenu();

}
