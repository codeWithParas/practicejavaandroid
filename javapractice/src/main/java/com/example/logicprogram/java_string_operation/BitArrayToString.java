package com.example.logicprogram.java_string_operation;

public class BitArrayToString {

    public static void main(String[] args) {

        //yte[] data = {1,-116,-127,13,55,-58,-58,-5,-8,-112,110,-45,-96,-115,-57,-42};
        /*
        * 0 = 1
1 = -116
2 = -127
3 = 13
4 = 55
5 = -58
6 = -58
7 = -5
8 = -8
9 = -112
10 = 110
11 = -45
12 = -96
13 = -115
14 = -57
15 = -42*/

        //
        byte[] data = {02,01,06,03,02,28,18,0xc,16,28,18,00,68,0x8,118,97};

        String s = array2string(data);
        System.out.println("Array to String : " + s);
    }

    static String array2string(byte[] data) {

        if(data == null)
            return null;

        char hex[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<data.length; ++i) {
            buffer.append(hex[(data[i] >> 4) & 0x0F]);
            buffer.append(hex[(data[i] >> 0) & 0x0F]);
        }
        return buffer.toString();
    }
}
