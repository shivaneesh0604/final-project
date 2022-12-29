package RESTAURENTMANAGEMENT.Model;

public class Cook extends User{

    private Restaurent restaurent;
    public Cook(String name, int iD) {
        super(name, iD);
    }

    protected Order getfoodAndProcess(Order order) {
        System.out.println("food in process...");
        try {
            Thread.sleep(2000);
        } catch (Exception e){
        }
        System.out.println("food completed");
        System.out.println("foodname is "+order.getFoodname()+" quantity is "+order.getQuantity());
        return order;
    }
    
    protected Restaurent getRestaurent() {
        return restaurent;
    }
    protected void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
}
