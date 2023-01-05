package RESTAURENTMANAGEMENT.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import RESTAURENTMANAGEMENT.MenuList.Course;
import RESTAURENTMANAGEMENT.MenuList.Dietery;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.MenuList;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Manager;

public class ManagerUI {
    private final Manager manager;
    Scanner scanner = new Scanner(System.in);

    public ManagerUI(Manager manager) {
        this.manager = manager;
    }

    public void entersUI() {
        MainLoop: while (true) {

            InputVerification.print(ManagerOptions.values());

            int option = InputVerification.inputVerificationManager(ManagerOptions.values().length);
            ManagerOptions preference = ManagerOptions.values()[option];
            switch (preference) {
                case ADD_TABLENUMBER:
                    System.out.println("available tablenumbers are");
                    ArrayList<Integer> waiterIDs = manager.getWaiterIDs();
                    for (Integer integer : waiterIDs) {
                        System.out.println(integer);
                    }
                    System.out.print("enter waiterid to add tablenumer ");
                    try {
                        int waiterid = scanner.nextInt();
                        Set<String> tableForThisWaiter = manager
                                .returnTableNumbers(waiterid);
                        System.out.println(tableForThisWaiter);
                        if (tableForThisWaiter == null) {
                            System.out.println("no waiter available");
                            break;
                        }
                        System.out.println("enter tablenumber to add");
                        scanner.nextLine();
                        String addtablenumber = scanner.nextLine();
                        System.out.println(manager.addTableNumbersToWaiter(addtablenumber, waiterid));

                    } catch (InputMismatchException e) {
                        System.out.println("you have entered wrong input");
                    }
                    break;

                case REMOVE_TABLENUMBER:
                    ArrayList<Integer> waiterIDs1 = manager.getWaiterIDs();
                    for (Integer integer : waiterIDs1) {
                        System.out.println(integer);
                    }
                    System.out.println("enter waiterid to delete tablenumer available ids are ");
                    try {
                        int waiterid1 = scanner.nextInt();
                        Set<String> tableForThisWaiter1 = manager
                                .returnTableNumbers(waiterid1);
                        System.out.println(tableForThisWaiter1);
                        if (tableForThisWaiter1 == null) {
                            System.out.println("no waiter available");
                            break;
                        }
                        System.out.println("enter tablenumber to delete");
                        scanner.nextLine();
                        String deletetablenumber = scanner.nextLine();

                        if (tableForThisWaiter1.contains(deletetablenumber)) {
                            manager.deleteTableNumberforWaiter(deletetablenumber, waiterid1);
                            System.out.println(manager.returnTableNumbers(waiterid1));
                        } else {
                            System.out.println("please enter available table number");
                            System.out.println("Available tablenumbers are " + tableForThisWaiter1);
                        }

                    } catch (Exception e) {
                        System.out.println("you have entered wrong input");
                    }
                    break;

                case ADD_ITEMS:
                    System.out.println("food available are ");
                    MenuList menu = manager.getFullMenuAccess();
                    showMenu(menu.getItems());
                    try {
                        System.out.println("enter foodname to add");
                        String foodname = scanner.nextLine();
                        System.out.println("enter price to add");
                        int price = scanner.nextInt();
                        InputVerification.print(Dietery.values());
    
                        int option2 = InputVerification.InputVerificationDietery(Dietery.values().length);
                        Dietery dietoryPreference = Dietery.values()[option2];
    
                        InputVerification.print(Course.values());
    
                        int option3 = InputVerification.InputVerificationCourse(Course.values().length);
                        Course coursepreference = Course.values()[option3];
    
                        InputVerification.print(Timing.values());
    
                        int option4 = InputVerification.InputVerificationTiming(Timing.values().length);
                        Timing timingPreference = Timing.values()[option4];
    
                        Item item = new Item(foodname, price, dietoryPreference, coursepreference, timingPreference);
                        manager.addMenusItems(item);
                        
                    } catch (InputMismatchException e) {
                        System.out.println("input missmatched");
                    }
                    break;

                case ALTER_FOODPRICE:
                try {
                    
                    System.out.println("food available are ");
                    MenuList menuList1 = manager.getFullMenuAccess();
                    showMenu(menuList1.getItems());
                    System.out.println("enter foodname to alter");
                    scanner.nextLine();
                    String foodname2 = scanner.nextLine();
                    System.out.println("enter price to alter");
                    int price2 = scanner.nextInt();
                    manager.alterMenuItems(foodname2, price2);
                    System.out.println("changed food name is " + foodname2 + "price is " + price2);
                } catch (InputMismatchException e) {
                    System.out.println("input missmatch exception");
                }
                break;

                case DELETE_ITEM:
                try {
                    System.out.println("food available are ");
                    MenuList menuList2 = manager.getFullMenuAccess();
                    showMenu(menuList2.getItems());
                    System.out.println("enter foodname to delete from menu");
                    scanner.nextLine();
                    String foodname3 = scanner.nextLine();
                    manager.deleteMenuItems(foodname3);
                    
                } catch (InputMismatchException e) {
                    System.out.println("input missmatch exception");
                }
                break;

                case SET_TIMING:
                MenuList menu1 = manager.getFullMenuAccess();
                showMenu(menu1.getItems());
                    System.out.println("enter foodname to set timing");
                    String foodname4 = scanner.nextLine();
                    if(menu1.checkFoodAvailability(foodname4)){
                        System.out.println("enter which timing you need");
                        InputVerification.print(Timing.values());
    
                        int option5 = InputVerification.InputVerificationTiming(Timing.values().length);
                        Timing timingPreference1 = Timing.values()[option5];
                        manager.setTimingForFood(foodname4, timingPreference1);
                    }
                    else{
                        System.out.println("wrong foodname");
                    }
                    break;

                case EXIT:
                    break MainLoop;

            }
        }

    }

    private void showMenu(HashMap<String, Item> menu) {
        Collection<Item> items = menu.values();
        for (Item item : items) {
            System.out.println(item.getFoodName() + " " + item.getPrice());
        }
    }
}
