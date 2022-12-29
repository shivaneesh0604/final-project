package RESTAURENTMANAGEMENT.Model;

public class Cook extends User {

    private Restaurent restaurent;

    public Cook(String name, int iD,Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    public Order getfoodAndProcess(Order order) {
        System.out.println("food in process...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("food completed");
        System.out.println("foodname is " + order.getFoodname() + " quantity is " + order.getQuantity());
        return order;
    }

    Restaurent getRestaurent() {
        return restaurent;
    }

    void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
}
