package general;

import java.util.Scanner;

/**
 * Created by zafar.imam on 24-10-2017.
 */

public class ChangesCaseDemo {
    public static void main(String ...arg){
        System.out.println("Enter any String : ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        changeCase(string);
    }

    private static void changeCase(String string) {
        System.out.println("Input String is : "+string);
        String arr[] = new String[string.length()];
        for (int i = 0; i < string.length(); i++) {
            Character myChar = string.charAt(i);
            if (myChar.isUpperCase(myChar)){
                arr[i] = myChar.toLowerCase(myChar)+"";
            }else {
                arr[i]= myChar.toUpperCase(myChar)+"";
            }

        }
        StringBuilder builder = new StringBuilder();
        for (String br : arr) {
            builder.append(br);
        }
        System.out.println("Output String is : "+builder.toString());
    }
}
