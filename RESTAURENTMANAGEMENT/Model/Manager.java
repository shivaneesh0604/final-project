package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.view.ManagerUI;

public class Manager extends User{
    private Restaurent restaurent;
    

    public Manager(String name, int iD,Restaurent restaurent) {
        super(name, iD);
        this.restaurent = restaurent;
    }

    public void enterRestaurent(){
        ManagerUI managerUI = new ManagerUI(restaurent);
        managerUI.enterRestaurent();
    }

}