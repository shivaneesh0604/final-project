package RESTAURENTMANAGEMENT.Model;
import java.util.ArrayList;

public class Bill {

    public class BillItem {
        public final String itemName;
        public final int quantity;
        public final float price;

        public BillItem(String itemName, int quantity, float price) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }
    }

    private final ArrayList<BillItem> items;

    public Bill() {
        items = new ArrayList<>();
    }

    void addItem(String name, int quantity, float price) {
        items.add(new BillItem(name, quantity, price));
    }

    // TODO removeItem()

    public float total() {
        float total = 0;
        for(BillItem item: items) {
            total += item.price * item.quantity;
        }
        return total;
    }

    public ArrayList<BillItem> getItems() {
        return items;
    }

    // public void calculateBill(){
    //     int totalPrice = 0;
    //     int price = 0;
    //     for (Order order : orders) {
    //         for (Item item : menuItems) {
    //             if (item.getFoodName().equals(order.getFoodname())) {
    //                 price = item.getPrice() * order.getQuantity();
    //                 totalPrice += price;
    //             }
    //         }
    //     }
    //     totalAmount = totalPrice;
    // }

    // public void ReadBill() {
    //     System.out.format(
    //             "-----------------------------------------------------------------------------------------------------------------------------------");
    //     System.out.print("\nProductName\t\tQuantity\t\tRate \t\t\tTotal Price\n");
    //     System.out.format(
    //             "-----------------------------------------------------------------------------------------------------------------------------------\n");
    //     for (Order order : orders) {
    //         for (Item item : menuItems) {
    //             if (item.getFoodName().equals(order.getFoodname())) {
    //                 float price = item.getPrice() * order.getQuantity();
    //                 System.out.format("  %-9s             %-9d          %5d               %9f\n",
    //                         order.getFoodname(),
    //                         order.getQuantity(), item.getPrice(), price);
    //             }
    //         }
    //     }
    //     System.out.println("total price is " + totalAmount);
        
    // }
}
