package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.view.ManagerUI;

public class Manager extends User{
    private Restaurent restaurent;
    

    public Manager(String name, int iD) {
        super(name, iD);
    }

    public void enterRestaurent(){
        ManagerUI managerUI = new ManagerUI(restaurent);
        managerUI.enterRestaurent();
    }

     Restaurent getRestaurent() {
        return restaurent;
    }

     void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }

}