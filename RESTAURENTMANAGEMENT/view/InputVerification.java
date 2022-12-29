package RESTAURENTMANAGEMENT.view;

import java.util.Scanner;

public class InputVerification {
    private static final Scanner sc = new Scanner(System.in);
    public static int inputVerificationManager(int noOfOptions){
        String input = sc.nextLine();
        if(input.matches("[0-7]+?")&&(Integer.parseInt(input)<=noOfOptions)){
            return Integer.parseInt(input);
        }
        else{
            System.out.println("enter between 1-7");
            return inputVerificationManager(noOfOptions);
        }
    }

    public static void print(Enum[] enums){
        for(int i=0;i<enums.length;i++){
            System.out.println(i+1+","+enums[i]);
        }
    }
}
