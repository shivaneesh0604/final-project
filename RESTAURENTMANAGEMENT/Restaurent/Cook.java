package RESTAURENTMANAGEMENT.Restaurent;

public class Cook {
    private final String name;
    private final int ID;
    private Restaurent restaurent;
    public Cook(String name, int iD) {
        this.name = name;
        ID = iD;
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
    
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    protected Restaurent getRestaurent() {
        return restaurent;
    }
    protected void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
}
