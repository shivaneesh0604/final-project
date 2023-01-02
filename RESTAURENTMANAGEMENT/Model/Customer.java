package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.view.AppUsers;
import RESTAURENTMANAGEMENT.view.CustomerUI;

public class Customer extends User {

    private final AppUsers appUsers;

    public Customer(String name, int iD) {
        super(name, iD);
        this.appUsers = AppUsers.CUSTOMER;
    }

    public void entersTheRestaurent(Restaurent restaurent, Timing timing) {
        CustomerUI customerUI = new CustomerUI(restaurent);
        customerUI.entersTheRestaurent(timing, this.getID());
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

}
