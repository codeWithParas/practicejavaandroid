package com.example.logicprogram.other_java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TestRegularExpression {

    //https://www.geeksforgeeks.org/how-to-validate-time-in-24-hour-format-using-regular-expression/

    // Function to validate the time in 24-hour format
    public static boolean isValidTime(String time) {

        // Regex to check valid time in 24-hour format.
        //String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        String regex = "[0-5][0-9]:[0-0][0-0]";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the time is empty
        // return false
        if (time == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given time
        // and regular expression.
        Matcher m = p.matcher(time);

        // Return if the time
        // matched the ReGex
        return m.matches();
    }

    // Driver Code.
    public static void main(String args[]) {

        // Test Case 0:
        String str0 = "59:00";
        System.out.println(str0 + ": "
                + isValidTime(str0));

        // Test Case 1:
        String str1 = "13:05";
        System.out.println(str1 + ": "
                + isValidTime(str1));

        // Test Case 2:
        String str2 = "02:15";
        System.out.println(str2 + ": "
                + isValidTime(str2));

        // Test Case 3:
        String str3 = "24:00";
        System.out.println(str3 + ": "
                + isValidTime(str3));

        // Test Case 4:
        String str4 = "10:60";
        System.out.println(str4 + ": "
                + isValidTime(str4));

        // Test Case 5:
        String str5 = "10:15 AM";
        System.out.println(str5 + ": "
                + isValidTime(str5));
    }
}
