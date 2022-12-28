package RESTAURENTMANAGEMENT.Customer;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Restaurent.Restaurent;
import RESTAURENTMANAGEMENT.view.CustomerUI;

public class Customer {
    private final String name;
    private final int ID;

    public Customer(String name, int iD) {
        this.name = name;
        ID = iD;
    }

    public void entersTheRestaurent(Restaurent restaurent,Timing timing){
        CustomerUI customerUI = new CustomerUI();
        customerUI.entersTheRestaurent(restaurent, timing,this.ID);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

}
