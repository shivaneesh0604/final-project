package RESTAURENTMANAGEMENT.Restaurent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentChefInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentCashierInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentCustomerInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentManagementFunctions;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentOrderKitchenSystemInterface;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentWaiterInterface;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.MenuList;
import RESTAURENTMANAGEMENT.MenuList.UserMenu;

public class Restaurent implements RestaurentWaiterInterface, RestaurentManagementFunctions, RestaurentCashierInterface,
        RestaurentOrderKitchenSystemInterface, RestaurentChefInterface,RestaurentCustomerInterface {

    private final String restaurentName;
    private final int RestaurentID;
    private final int owner;

    private final ArrayList<Waiter> waiters = new ArrayList<Waiter>();
    private final ArrayList<Cook> cooks = new ArrayList<Cook>();
    private final ArrayList<Chef> chefs = new ArrayList<Chef>();
    private final ArrayList<Manager> managers = new ArrayList<Manager>();
    private Cashier cashier;
    private MenuList menu;
    private KitchenOrderSystem kitchenOrderSystem ;
    
    public Restaurent(String restaurentName, int restaurentID, int ownerID) {
        this.RestaurentID = restaurentID;
        this.restaurentName = restaurentName;
        this.owner = ownerID;
        kitchenOrderSystem = new KitchenOrderSystem();
        kitchenOrderSystem.setKitchenOrderSystemInterface(this);
    }

    public void addCookToRestaurent(Cook cook) {
        this.cooks.add(cook);
    }

    public void addWaitersToRestaurent(Waiter waiter) {
        waiters.add(waiter);
    }

    public void addChefToRestaurent(Chef chef) {
        chefs.add(chef);

    }

    public void addManagerToRestaurent(Manager manager) {
        this.managers.add(manager);
    }

    public void addCashierToRestaurent(Cashier cashier) {
        this.cashier = cashier;
    }

    @Override
    public UserMenu getUserMenu() {
        return this.menu;
    }

    @Override
    public Cashier returnCashier() {
        return this.cashier;
    }

    @Override
    public void addTableNumbersToWaiters(String tablenumber, int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiter1.getID() == waiterid) {
                boolean check = checkTableNumbersForAllWaiters(tablenumber);
                if (check) {
                    System.out.println("Table number already added to another waiter so can't add");
                    break;
                } else {
                    waiter1.setTableNumber(tablenumber);
                    break;
                }
            }
        }
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
    public List<String> returnTableNumbers(int waiterid) {
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
    public MenuList getFullMenu() {
        return this.menu;
    }

    @Override
    public ArrayList<Item> getMenuItems() {
        return menu.getMenuItems();
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
        return getWaiter(tablenumber, customerid);

    }

    private Waiter getWaiter(String TableNumber, int customerid) {
        for (Waiter waiter : waiters) {
            if (waiter.getTablenumbers().contains(TableNumber)) {
                return waiter;
            }
        }
        return null;
    }

    @Override
    public MenuList createNewMenu() {
        // TODO Auto-generated method stub
        this.menu = new MenuList();
        return menu;
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
