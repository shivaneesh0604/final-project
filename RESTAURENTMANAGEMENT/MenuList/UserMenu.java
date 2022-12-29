package RESTAURENTMANAGEMENT.MenuList;

public interface UserMenu {
    public void showMenu(Timing timing);
    public boolean checkFoodAvailability(String foodname,Timing timing);
}
