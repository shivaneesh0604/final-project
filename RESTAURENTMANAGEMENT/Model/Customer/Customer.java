package RESTAURENTMANAGEMENT.Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;

import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Order;
import RESTAURENTMANAGEMENT.Model.User;
import RESTAURENTMANAGEMENT.Model.Waiter;
import RESTAURENTMANAGEMENT.Model.Cashier.Bill;
import RESTAURENTMANAGEMENT.view.AppUsers;

public class Customer extends User {

    private final AppUsers appUsers;
    private final Timing timing;

    public Customer(String name, int iD, Timing timing) {
        super(name, iD);
        this.appUsers = AppUsers.CUSTOMER;
        this.timing = timing;
    }

    public HashMap<String, Item> askMenu(Waiter waiter, Timing timing) {
        return waiter.providesMenu(timing);
    }

    public String addOrders(Waiter waiter, String foodname, int quantity) {
        return waiter.TakeOrders(getID(), foodname, quantity, timing);
    }

    public String deleteOrder(Waiter waiter, String foodname, int quantity) {
        return waiter.DeleteOrder(getID(), foodname, quantity, timing);
    }

    public ArrayList<Order> confirmOrder(Waiter waiter) {
        return waiter.processOrder(getID());
    }

    public Bill askBill(Waiter waiter) {
        return waiter.askbill(getID());
    }

    public void paybill(Waiter waiter, float paymentAmount) {
        waiter.paybill(paymentAmount, getID());
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

}
