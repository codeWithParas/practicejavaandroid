package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zafar.imam on 25-10-2017.
 */

public class PrintAsciValue {
    private static char chars;
    /*
    Given a character C, print the ASCII value of that character.
     */

    public static void main(String arg[]){
        System.out.println("Enter Any Character : ");

       /* Scanner scanner = new Scanner(System.in);
        int chars = scanner.nextInt();*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String read = reader.readLine();
            int len = read.length();
             chars = read.charAt(len-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ascii = chars;
        System.out.println("Entered Char is : "+chars+"  Ascii Value is : "+ascii);
    }
}
