package com.example.logicprogram.other_java;

import com.example.logicprogram.java_string_operation.StringToASCIIConversion;

import java.nio.ByteBuffer;

/**
 * Created by parasmani.sharma on 24/10/2017.
 */

public class HexToByteConversionTest {


    public static final void main(String args[])
    {

        int b = 123;
        //convertHexToByte();
        char[] chars = "123".toCharArray();

        for(int i = 0; i < chars.length; i++){
            //int parsedResult = Integer.parseInt(String.valueOf(chars[i]), 16);
            //String parsedResult = Integer.toHexString((int)chars[i]);
            //mAuthData[i] = parsedResult;
            //System.out.println("0x" + StringToASCIIConversion.convertStringToHex(parsedResult));
            System.out.print("0x");
            System.out.println(StringToASCIIConversion.convertStringToHex(String.valueOf(chars[i])));
            //b.putInt(parsedResult);
        }




        //String s = Integer.toHexString(b);

        //byte[] bytes = hex_16StringToByteArray(s);
        //byte[] bytes = hex_64StringToByteArray("529AA670D72CD649752ED47352B037E8803B5C60829A5A3CAA2195553BA");
        //byte[] bytes = byteToByteArray();
        /*System.out.println("Testing Main " +  bytes.length);
        for(int i=0; i< bytes.length ; i++) {
            System.out.print(bytes[i] +" ");
        }*/
    }

    public static byte[] hex_16StringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static byte[] hex_64StringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 64) << 4)
                    + Character.digit(s.charAt(i+1), 64));
        }
        return data;
    }

    public static byte[] byteToByteArray()
    {
        //String pk =Byte.toString(a);
        String pk ="529AA670D72CD649752ED47352B037E8803B5C60829A5A3CAA2195553BA";
        //String pk ="";
        byte[] pkbyteArrray = pk.getBytes();
        return pkbyteArrray;
    }

    public static void convertHexToByte()
    {
        String str = "31";
        byte[] val = new byte[str.length() / 2];
        for (int i = 0; i < val.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(str.substring(index, index + 2), 16);
            val[i] = (byte) j;
        }

        for (int i = 0; i < val.length; i++) {
            System.out.println(val[i]+"");
        }

    }

    public static String convert(int n) {
        //return Integer.valueOf(String.valueOf(n), 16);
        return String.format("%X", n);
    }

}
