package string_operation;

import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by zafar.imam on 26-09-2017.
 */

public class StringDemo {
    public static void main(String ...arg){
        String string1 = "Optiontown_Aggrawal_City_Mall_Pitampura";
        String string = "optiontown Pitampura";
       // splitString(string1);

        reverseString(string);
        /*String reverse = new StringBuilder(string).reverse().toString();
        System.out.println(reverse);*/

      //  HashSet removeDuplicate = removeDuplicateChar(string1);
      //  System.out.println(removeDuplicate.toString());
    }

    private static void reverseString(String string) {
        System.out.println("Given String is :" +string);
        StringBuilder builder = new StringBuilder(string.length());
        for (int i = string.length()-1; i >0; i--) {
            builder.append(string.charAt(i));
        }

        System.out.println("Reverse String is :" +builder);
    }

    private static HashSet removeDuplicateChar(String string1) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < string1.length(); i++) {
            set.add(string1.charAt(i));
        }
        return set;
    }

    private static void splitString(String string) {
        String arr[] = string.split(" ");
        for (String s : arr) {
            System.out.println(s);
        }

        System.out.println();
        //splitting using Tokenizer
        StringTokenizer token = new StringTokenizer(string," ");
        while (token.hasMoreTokens()){
            System.out.println(token.nextToken());
        }
    }
}
