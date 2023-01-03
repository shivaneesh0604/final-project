package RESTAURENTMANAGEMENT.Model;

import java.util.ArrayList;
import java.util.HashMap;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentCashierInterface;
import RESTAURENTMANAGEMENT.MenuList.Item;

public class Cashier extends User {

    private RestaurentCashierInterface restaurent;
    private HashMap<Integer, Bill> bills = new HashMap<>();

    public Cashier(String name, int iD, Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    public Bill generateBill(ArrayList<Order> listOfOrders, int orderid) {
        Bill bill = new Bill();
        for (Order order : listOfOrders) {
            Item item = restaurent.getMenuItems().get(order.getFoodname());
            System.out.println(item.getPrice());
            bill.addItem(order.getFoodname(), order.getQuantity(), item.getPrice());
        }
        bill.total();
        bills.put(orderid, bill);
        return bill;
    }

    public void payBill(float paymentAmount, int orderid) {
        if (bills.get(orderid).total() == paymentAmount) {
            System.out.println("payment done");
        } else {
            System.out.println("payable amount is less than " + bills.get(orderid).total()
                    + " so enter amount equal to " + bills.get(orderid).total());
            throw new RuntimeException();
        }
    }

}
