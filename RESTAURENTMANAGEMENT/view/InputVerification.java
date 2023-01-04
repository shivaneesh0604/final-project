package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;

public class InputVerification {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputVerificationManager(int noOfOptions) {
        String input = sc.nextLine();
        if (input.matches("[0-6]") && (Integer.parseInt(input) <= noOfOptions)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("enter inbetween 0-6");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static int inputVerificationCustomer(int noOfOptions) {
        String input = sc.nextLine();
        if (input.matches("[0-4]") && (Integer.parseInt(input) <= noOfOptions)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("enter inbetween 0-4");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static int inputVerificationApp(int noOfOptions) {
        System.out.println("enter which user you are");
        String input = sc.nextLine();
        if (input.matches("[0-3]") && (Integer.parseInt(input) <= noOfOptions)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("enter inbetween 0-3");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static int InputVerificationTiming(int noOfOptions) {
        String input = sc.nextLine();
        if (input.matches("[0-2]") && (Integer.parseInt(input) <= noOfOptions)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("enter inbetween 0-2");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static int InputVerificationCourse(int noOfOptions) {
        String input = sc.nextLine();
        if (input.matches("[0-2]") && (Integer.parseInt(input) <= noOfOptions)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("enter inbetween 0-2");
            return InputVerificationCourse(noOfOptions);
        }
    }

    public static int InputVerificationDietery(int noOfOptions) {
        String input = sc.nextLine();
        if (input.matches("[0-1]") && (Integer.parseInt(input) <= noOfOptions)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("enter 0 or 1");
            return InputVerificationDietery(noOfOptions);
        }
    }

    public static void print(Enum[] enums) {
        for (int i = 0; i < enums.length; i++) {
            System.out.println(i + "," + enums[i]);
        }
    }
}
