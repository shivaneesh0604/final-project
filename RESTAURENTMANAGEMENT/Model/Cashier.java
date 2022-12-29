package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.HashMap;

import RESTAURENTMANAGEMENT.Bill.Bill;
import RESTAURENTMANAGEMENT.Interfaces.RestaurentCashierInterface;

public class Cashier extends User{
    
    private RestaurentCashierInterface restaurent ;
    private HashMap<Integer, Bill> bills = new HashMap<>();

    public Cashier(String name, int iD) {
        super(name, iD);
    }

    public Bill generateBill(ArrayList<Order> listOfOrders, int orderid) {
        Bill bill = new Bill(listOfOrders,orderid,restaurent.getMenuItems());
        bill.calculateBill();
        bills.put(orderid, bill);
        return bill;
    }

    public void payBill(float paymentAmount, int orderid) {
        if (bills.get(orderid).getTotalAmount() == paymentAmount) {
            System.out.println("payment done");
            System.out.println("Happy journey! \n THANK YOU");
        }
        else{
            System.out.println("payable amount is less than "+bills.get(orderid).getTotalAmount()+" so enter amount equal to "+bills.get(orderid).getTotalAmount());
        }
    }

    protected RestaurentCashierInterface getRestaurent() {
        return restaurent;
    }
    protected void setRestaurent(RestaurentCashierInterface restaurent) {
        this.restaurent = restaurent;
    }

    

}