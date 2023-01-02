package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;

public class InputVerification {
    private static final Scanner sc = new Scanner(System.in);
    public static int inputVerificationManager(int noOfOptions){
        String input = sc.nextLine();
        if(input.matches("[1-7]")&&(Integer.parseInt(input)<=noOfOptions)){
            return Integer.parseInt(input);
        }
        else{
            System.out.println("enter between 1-7");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static int inputVerificationApp(int noOfOptions){
        System.out.println("enter which user you are");
        String input = sc.nextLine();
        if(input.matches("[0-2]")&&(Integer.parseInt(input)<=noOfOptions)){
            return Integer.parseInt(input);
        }
        else{
            System.out.println("enter between 1-3");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static int InputVerificationTiming(int noOfOptions){
        String input = sc.nextLine();
        if(input.matches("[1-3]")&&(Integer.parseInt(input)<=noOfOptions)){
            return Integer.parseInt(input);
        }
        else{
            System.out.println("enter between 1-3");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static void print(Enum[] enums){
        for(int i=0;i<enums.length;i++){
            System.out.println(i+","+enums[i]);
        }
    }
}