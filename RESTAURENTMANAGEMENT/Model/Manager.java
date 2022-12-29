package RESTAURENTMANAGEMENT.Model;

import RESTAURENTMANAGEMENT.view.ManagerUI;

public class Manager extends User{
    private Restaurent restaurent;
    

    public Manager(String name, int iD) {
        super(name, iD);
    }

    public void enterRestaurent(){
        ManagerUI managerUI = new ManagerUI();
        managerUI.enterRestaurent(restaurent);
    }

    protected Restaurent getRestaurent() {
        return restaurent;
    }

    protected void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }

}