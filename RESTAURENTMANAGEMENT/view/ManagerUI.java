package RESTAURENTMANAGEMENT.view;

import java.util.List;
import java.util.Scanner;

import RESTAURENTMANAGEMENT.Interfaces.RestaurentManagementFunctions;
import RESTAURENTMANAGEMENT.MenuList.Course;
import RESTAURENTMANAGEMENT.MenuList.Dietery;
import RESTAURENTMANAGEMENT.MenuList.Item;
import RESTAURENTMANAGEMENT.MenuList.MenuList;
import RESTAURENTMANAGEMENT.MenuList.Timing;
import RESTAURENTMANAGEMENT.Restaurent.Restaurent;

public class ManagerUI {
    private RestaurentManagementFunctions managerInterface;
    Scanner scanner = new Scanner(System.in);

    public void enterRestaurent(Restaurent restaurent) {
        managerInterface= restaurent;
        while (true) {
            System.out.println(
                    " 1 for adding tablenumber to waiter \n 2 for deleting table number for waiter \n 3 for Adding items in menu \n 4 for altering the food pirce \n 5 for deleting food \n 6 for creating new menu");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("enter waiterid to add tablenumer available ids are ");
                    int waiterid = scanner.nextInt();
                    List<String> tableForThisWaiter = managerInterface
                            .returnTableNumbers(waiterid);
                    System.out.println(tableForThisWaiter);
                    System.out.println("enter tablenumber to add");
                    scanner.nextLine();
                    String addtablenumber = scanner.nextLine();

                    if (tableForThisWaiter.contains(addtablenumber)) {
                        System.out.println("please enter other table number than this " + tableForThisWaiter);
                    } else {
                        managerInterface.addTableNumbersToWaiters(addtablenumber, waiterid);
                    }
                    break;

                case 2:
                    System.out.println("enter waiterid to add tablenumer available ids are ");
                    int waiterid1 = scanner.nextInt();
                    List<String> tableForThisWaiter1 = managerInterface
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

                case 3:
                    System.out.println("food available are ");
                    MenuList menu = managerInterface.getFullMenu();
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

                case 4:
                    System.out.println("food available are ");
                    MenuList menuList1 = managerInterface.getFullMenu();
                    System.out.println("enter foodname to alter");
                    scanner.nextLine();
                    String foodname2 = scanner.nextLine();
                    System.out.println("enter price to alter");
                    int price2 = scanner.nextInt();
                    menuList1.alterMenuItems(foodname2, price2);
                    break;

                case 5:
                    System.out.println("food available are ");
                    MenuList menuList2 = managerInterface.getFullMenu();
                    System.out.println("enter foodname to delete from menu");
                    scanner.nextLine();
                    String foodname3 = scanner.nextLine();
                    menuList2.deleteMenuItems(foodname3);
                    break;

                case 6:
                    managerInterface.createNewMenu();

            }
            System.out.println("if you want to exit press 1");
            int exit = scanner.nextInt();
            if (exit == 1) {
                break;
            } else {
                continue;
            }
        }

    }
}
