package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.view.CustomerUI;

public class Customer extends User{
    

    public Customer(String name, int iD) {
        super(name, iD);
    }

    public void entersTheRestaurent(Restaurent restaurent,Timing timing){
        CustomerUI customerUI = new CustomerUI(restaurent);
        customerUI.entersTheRestaurent(timing,this.getID());
    }


}
