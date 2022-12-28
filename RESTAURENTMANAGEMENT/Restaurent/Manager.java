package RESTAURENTMANAGEMENT.Restaurent;

import RESTAURENTMANAGEMENT.view.ManagerUI;

public class Manager {
    private Restaurent restaurent;
    private final String name;
    private final int ID;

    public Manager(String name, int iD) {
        this.name = name;
        ID = iD;
    }

    public void enterRestaurent(){
        ManagerUI managerUI = new ManagerUI();
        managerUI.enterRestaurent(restaurent);
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