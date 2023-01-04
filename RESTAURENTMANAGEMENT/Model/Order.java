package RESTAURENTMANAGEMENT.Model;

public class Order {

    private final String foodname;
    private int quantity;
    private boolean delivered = false;

    public Order(String foodname, int quantity) {
        this.foodname = foodname.toUpperCase();
        this.quantity = quantity;
    }

    public String getFoodname() {
        return foodname;
    }

    public int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelivered() {
        return delivered;
    }

    void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

}
