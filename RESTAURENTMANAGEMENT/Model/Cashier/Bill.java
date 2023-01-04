package RESTAURENTMANAGEMENT.Model.Cashier;

import java.util.ArrayList;

public class Bill {

    public class BillItem {
        public final String itemName;
        public final int quantity;
        public final int price;

        public BillItem(String itemName, int quantity, int price) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }
    }

    private final ArrayList<BillItem> items;

    public Bill() {
        items = new ArrayList<>();
    }

    void addItem(String name, int quantity, int price) {
        items.add(new BillItem(name, quantity, price));
    }

    // TODO removeItem()

    public int total() {
        int total = 0;
        for (BillItem item : items) {
            total += item.price * item.quantity;
        }
        return total;
    }

    public ArrayList<BillItem> getItems() {
        return items;
    }
}
