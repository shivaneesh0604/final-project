package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentChefInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentCookinterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentCashierInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentCustomerInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentManagementFunctions;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentKitchenOrderSystemInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentWaiterInterface;
import RESTAURENTMANAGEMENT.Interfaces.UserMenu;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.MenuList;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Cashier.Cashier;
import RESTAURENTMANAGEMENT.Model.KitchenSystems.Chef;
import RESTAURENTMANAGEMENT.Model.KitchenSystems.Cook;
import RESTAURENTMANAGEMENT.Model.KitchenSystems.KitchenOrderSystem;

public class Restaurent implements RestaurentWaiterInterface, RestaurentManagementFunctions, RestaurentCashierInterface,
        RestaurentKitchenOrderSystemInterface, RestaurentChefInterface, RestaurentCustomerInterface,
        RestaurentCookinterface {

    private final String restaurentName;
    private final int RestaurentID;
    private final int owner;

    private final ArrayList<Waiter> waiters = new ArrayList<Waiter>();
    private final ArrayList<Cook> cooks = new ArrayList<Cook>();
    private final ArrayList<Chef> chefs = new ArrayList<Chef>();
    private final ArrayList<Manager> managers = new ArrayList<>();
    private Cashier cashier;
    private final MenuList menu;
    private KitchenOrderSystem kitchenOrderSystem;
    private final ArrayList<String> tablesAvailable;

    public Restaurent(String restaurentName, int restaurentID, int ownerID, ArrayList<String> tablesAvailable) {
        this.RestaurentID = restaurentID;
        this.restaurentName = restaurentName;
        this.owner = ownerID;
        this.tablesAvailable = tablesAvailable;
        this.menu = new MenuList();
        kitchenOrderSystem = new KitchenOrderSystem(this);
    }

    public void addCookToRestaurent(Cook cook) {
        this.cooks.add(cook);
    }

    public void removeCookFromRestaurent(Cook cook) {
        this.cooks.remove(cook);
    }

    public void addWaitersToRestaurent(Waiter waiter) {
        waiters.add(waiter);
    }

    public void removeWaiterFromRestaurent(Waiter waiter) {
        this.waiters.remove(waiter);
    }

    public void addChefToRestaurent(Chef chef) {
        chefs.add(chef);
    }

    public void removeChefFromRestaurent(Chef chef) {
        this.chefs.remove(chef);
    }

    public void addManagerToRestaurent(Manager manager) {
        this.managers.add(manager);
    }

    public void removeManagerFromRestaurent(Manager manager) {
        this.managers.remove(manager);
    }

    public void addCashierToRestaurent(Cashier cashier) {
        this.cashier = cashier;
    }

    public void removeCashierFromRestaurent(Cashier cashier) {
        if (this.cashier == cashier)
            this.cashier = null;
    }

    @Override
    public String addTableNumbersToWaiters(String tablenumber, int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiter1.getID() == waiterid) {
                boolean check = checkTableNumbersForAllWaiters(tablenumber);
                if (check) {
                    return "Table number already added to another waiter so can't add";
                } else {
                    if (tablesAvailable.contains(tablenumber)) {
                        waiter1.setTableNumber(tablenumber);
                        return "table number " + tablenumber + " is added";
                    } else {
                        return "no tablenumber available";
                    }

                }
            }
        }
        return null;
    }

    @Override
    public void deleteTableNumberforWaiter(String tablenumber, int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiter1.getID() == waiterid) {
                Iterator<String> itr = waiter1.getTablenumbers().iterator();
                while (itr.hasNext()) {
                    String tablenumber1 = itr.next();
                    if (tablenumber1.equals(tablenumber)) {
                        itr.remove();
                    }
                }
            }
        }
    }

    @Override
    public Set<String> returnTableNumbers(int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiterid == waiter1.getID()) {
                return waiter1.getTablenumbers();
            }
        }
        return null;
    }

    private boolean checkTableNumbersForAllWaiters(String tableNumber) {
        for (Waiter waiters : waiters) {
            if (waiters.getTablenumbers().contains(tableNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MenuList getFullMenuAccess() {
        return this.menu;
    }

    @Override
    public Cashier getCashier() {
        return this.cashier;
    }

    @Override
    public HashMap<String, Item> getMenuItems() {
        return menu.getItems();
    }

    @Override
    public HashMap<String, Item> getMenuItems(Timing timing) {
        return menu.getItems(timing);
    }

    @Override
    public Chef getRandomChef() {
        Random rand = new Random();
        return chefs.get(rand.nextInt(chefs.size()));
    }

    @Override
    public Cook getRandomCook() {
        Random random = new Random();
        return cooks.get(random.nextInt(cooks.size()));
    }

    @Override
    public KitchenOrderSystem getKitchenorderSystem() {
        return kitchenOrderSystem;
    }

    @Override
    public Waiter getIN(String tablenumber, int customerid) {
        if (tablesAvailable.contains(tablenumber)) {
            return getWaiter(tablenumber, customerid);
        }
        System.out.println("available table numbers are" + tablesAvailable);
        return null;
        
    }
    
    @Override
    public ArrayList<Integer> getWaiterIDs() {
        ArrayList<Integer> waiterIds = new ArrayList<>();
        for (Waiter waiter : waiters) {
            waiterIds.add(waiter.getID());
        }
        return waiterIds;
    }

    private Waiter getWaiter(String TableNumber, int customerid) {
        for (Waiter waiter : waiters) {
            if (waiter.getTablenumbers().contains(TableNumber)) {
                return waiter;
            }
        }
        return null;
    }

    public ArrayList<String> gettablesAvailable() {
        return tablesAvailable;
    }

    public Manager getManager(int managerID) {
        for (Manager manager : managers) {
            if (manager.getID() == managerID) {
                return manager;
            }
        }
        return null;
    }

    @Override
    public UserMenu getUserMenu() {
        return this.menu;
    }

    public String getRestaurentName() {
        return restaurentName;
    }

    public int getRestaurentID() {
        return RestaurentID;
    }

    public int getOwner() {
        return owner;
    }


}
