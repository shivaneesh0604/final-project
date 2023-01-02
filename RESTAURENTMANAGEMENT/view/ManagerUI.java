package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;
import java.util.Set;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentManagementFunctions;
import RESTAURENTMANAGEMENT.MenuList.Course;
import RESTAURENTMANAGEMENT.MenuList.Dietery;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.MenuList;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Model.Restaurent;

public class ManagerUI {
    private RestaurentManagementFunctions managerInterface;
    Scanner scanner = new Scanner(System.in);

    public ManagerUI(Restaurent restaurent) {
        this.managerInterface = restaurent;
    }

    public void entersUI() {
        MainLoop: while (true) {

            InputVerification.print(ManagerOptions.values());

            int option = InputVerification.inputVerificationManager(ManagerOptions.values().length);
            ManagerOptions preference = ManagerOptions.values()[option];
            switch (preference) {
                case ADD_TABLENUMBER:
                    System.out.println("enter waiterid to add tablenumer available ids are ");
                    int waiterid = scanner.nextInt();
                    try {
                        Set<String> tableForThisWaiter = managerInterface
                                .returnTableNumbers(waiterid);
                        System.out.println(tableForThisWaiter);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("no tablenumbers assigned for this waiter");
                    }
                    System.out.println("enter tablenumber to add");
                    scanner.nextLine();
                    String addtablenumber = scanner.nextLine();

                    managerInterface.addTableNumbersToWaiters(addtablenumber, waiterid);
                    break;

                case REMOVE_TABLENUMBER:
                    System.out.println("enter waiterid to delete tablenumer available ids are ");
                    int waiterid1 = scanner.nextInt();
                    Set<String> tableForThisWaiter1 = managerInterface
                            .returnTableNumbers(waiterid1);
                    System.out.println(tableForThisWaiter1);
                    System.out.println("enter tablenumber to delete");
                    scanner.nextLine();
                    String deletetablenumber = scanner.nextLine();

                    if (tableForThisWaiter1.contains(deletetablenumber)) {
                        System.out.println(managerInterface.returnTableNumbers(waiterid1));
                        managerInterface.deleteTableNumberforWaiter(deletetablenumber, waiterid1);
                    } else {
                        System.out.println("please enter available table number");
                        System.out.println("Available tablenumbers are " + tableForThisWaiter1);
                    }

                    break;

                case ADD_ITEMS:
                    System.out.println("food available are ");
                    MenuList menu = managerInterface.getFullMenu();
                    menu.showMenu();
                    System.out.println("enter foodname to add");
                    scanner.nextLine();
                    String foodname = scanner.nextLine();
                    System.out.println("enter price to add");
                    int price = scanner.nextInt();
                    Dietery dietery;
                    DietryLoop: while (true) {
                        System.out.println("Press 1 for Veg and 2 for NonVeg");
                        int diet = scanner.nextInt();
                        switch (diet) {
                            case 1:
                                dietery = Dietery.VEG;
                                break DietryLoop;
                            case 2:
                                dietery = Dietery.NONVEG;
                                break DietryLoop;
                            default:
                                System.out.println("enter correct option to select");
                        }
                    }
                    Timing timing;
                    Timing: while (true) {
                        System.out.println(
                                "enter which timing to have this food -press 1 for morning 2 for afternoon and 3 for night");
                        int time = scanner.nextInt();
                        switch (time) {
                            case 1:
                                timing = Timing.MORNING;
                                break Timing;
                            case 2:
                                timing = Timing.EVENING;
                                break Timing;
                            case 3:
                                timing = Timing.NIGHT;
                                break Timing;
                            default:
                                System.out.println("enter correct option to select");
                        }
                    }
                    Course courses;
                    Course: while (true) {
                        System.out.println(
                                "enter which course do you need - pres 1 for starter ,2 for maincourse,3 for dessert");
                        int course = scanner.nextInt();
                        switch (course) {
                            case 1:
                                courses = Course.STARTER;
                                break Course;
                            case 2:
                                courses = Course.MAINCOURSE;
                                break Course;
                            case 3:
                                courses = Course.DESSERT;
                                break Course;
                            default:
                                System.out.println("enter correct option to select");

                        }
                    }
                    Item item = new Item(foodname, price, dietery, courses, timing);
                    menu.addMenusItems(item);
                    break;

                case ALTER_FOODPRICE:
                    System.out.println("food available are ");
                    MenuList menuList1 = managerInterface.getFullMenu();
                    System.out.println("enter foodname to alter");
                    scanner.nextLine();
                    String foodname2 = scanner.nextLine();
                    System.out.println("enter price to alter");
                    int price2 = scanner.nextInt();
                    menuList1.alterMenuItems(foodname2, price2);
                    break;

                case DELETE_FOOD:
                    System.out.println("food available are ");
                    MenuList menuList2 = managerInterface.getFullMenu();
                    System.out.println("enter foodname to delete from menu");
                    scanner.nextLine();
                    String foodname3 = scanner.nextLine();
                    menuList2.deleteMenuItems(foodname3);
                    break;

                case CREATE_NEW_MENU:
                    managerInterface.createNewMenu();
                    System.out.println("menu created");
                    MenuList menu1 = managerInterface.getFullMenu();
                    Item item2 = new Item("chicken Chucka", 130, Dietery.NONVEG, Course.MAINCOURSE, Timing.NIGHT);
                    menu1.addMenusItems(item2);
                    break;

                case EXIT:
                    break MainLoop;

            }
        }
    }
}
