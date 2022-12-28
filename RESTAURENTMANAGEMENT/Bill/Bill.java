package RESTAURENTMANAGEMENT.Bill;
import java.util.ArrayList;

import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.Orders.Order;

public class Bill {

    private final ArrayList<Order> orders;
    private float totalAmount;
    private final ArrayList<Item> menuItems;

     public Bill(ArrayList<Order> order, int orderid,ArrayList<Item> menuItems) {
        this.orders = order;
        this.menuItems=menuItems;
    }

    public void calculateBill(){
        int totalPrice = 0;
        int price = 0;
        for (Order order : orders) {
            for (Item item : menuItems) {
                if (item.getFoodName().equals(order.getFoodname())) {
                    price = item.getPrice() * order.getQuantity();
                    totalPrice += price;
                }
            }
        }
        totalAmount = totalPrice;
    }

    public void ReadBill() {
        System.out.format(
                "-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProductName\t\tQuantity\t\tRate \t\t\tTotal Price\n");
        System.out.format(
                "-----------------------------------------------------------------------------------------------------------------------------------\n");
        for (Order order : orders) {
            for (Item item : menuItems) {
                if (item.getFoodName().equals(order.getFoodname())) {
                    float price = item.getPrice() * order.getQuantity();
                    System.out.format("  %-9s             %-9d          %5d               %9d\n",
                            order.getFoodname(),
                            order.getQuantity(), item.getPrice(), price);
                }
            }
        }
        System.out.println("total price is " + totalAmount);
        
    }

    public float getTotalAmount() {
        return totalAmount;
    }
}
