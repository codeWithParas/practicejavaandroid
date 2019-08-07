package com.example.logicprogram.other_java;

/**
 * Created by parasmani.sharma on 24/10/2017.
 */

public class Test {


    public static final void main(String args[])
    {

        hexStringToByteArray("5");
        System.out.println("Testing Main");
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
