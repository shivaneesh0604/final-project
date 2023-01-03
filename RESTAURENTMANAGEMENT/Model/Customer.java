package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.Set;

import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.view.AppUsers;

public class Customer extends User {

    private final AppUsers appUsers;
    private final Timing timing;

    public Customer(String name, int iD,Timing timing) {
        super(name, iD);
        this.appUsers = AppUsers.CUSTOMER;
        this.timing = timing;
    }

    public Set<Item> askMenu(Waiter waiter) {
        return waiter.providesMenu();
    }

    public void addOrders(Waiter waiter,String foodname,int quantity){
        waiter.TakeOrders(getID(), foodname, quantity, timing);
    }

    public void deleteOrder(Waiter waiter,String foodname,int quantity){
        waiter.DeleteOrder(getID(), foodname, quantity, timing);
    }

    public ArrayList<Order> confirmOrder(Waiter waiter){
        return waiter.processOrder(getID());
    }

    public Bill askBill(Waiter waiter){
        Bill bill = waiter.askbill(getID());
        return bill;
    }

    public void paybill(Waiter waiter,float paymentAmount){
        waiter.paybill(paymentAmount, getID());
    }



    public AppUsers getAppUsers() {
        return appUsers;
    }

}
