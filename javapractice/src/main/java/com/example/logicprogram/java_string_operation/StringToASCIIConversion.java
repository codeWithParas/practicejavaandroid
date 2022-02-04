package com.example.logicprogram.java_string_operation;

//import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class StringToASCIIConversion {

    public static void main(String[] args) {

        String s = "123";
        //System.out.println(" " + Integer.parseInt(String.valueOf(31, 16));
        //convertStringToHex(s);
        byte[] bytesArr = new byte[16];
        char[] chars = s.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            //int i1 = Integer.parseInt(String.valueOf(chars[i]), 16);
            //System.out.println(" " + i1);

            //int i1 = Integer.parseInt(Integer.toHexString((int)chars[i]));
            //bytesArr[i] = Byte.parseByte(String.valueOf(i1));
            bytesArr[i] = Byte.parseByte(Integer.toHexString((int)chars[i]));
            //System.out.println(" " + Integer.toHexString((int)chars[i]));
        }
        for(int i = 0; i < bytesArr.length; i++){
            System.out.println(" " + bytesArr[i]);
        }
    }

    /*public static byte[] hexToBytes(String hexString) {
        HexBinaryAdapter adapter = new HexBinaryAdapter();
        byte[] bytes = adapter.unmarshal(hexString);
        return bytes;
    }*/

    public static String convertStringToHex(String str){

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){

            //hex.append();
            System.out.println(" " + Integer.toHexString((int)chars[i]));
        }
        //System.out.println(" " + hex.toString());

        return hex.toString();
    }

    public static String convertHexToString(String hex){

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);

            temp.append(decimal);
        }
        System.out.println("Decimal : " + temp.toString());

        return sb.toString();
    }
}
