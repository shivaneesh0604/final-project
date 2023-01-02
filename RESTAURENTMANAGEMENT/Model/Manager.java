package RESTAURENTMANAGEMENT.Model;


public class Manager extends User{
    private Restaurent restaurent;
    
    public Manager(String name, int iD,Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

}