package com.example.logicprogram.otherproblems;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by parasmani.sharma on 21/04/2017.
 */

public class DateFormate {

    public static void main(String arg[])
    {

        String fromFormat = "dd-MM-yyyy";
        String toFormat = "dd-MMM-yyyy";
        String strDate = "30-01-2000";

        try{
            SimpleDateFormat sdf = new SimpleDateFormat(fromFormat, Locale.getDefault());
            SimpleDateFormat dateFormat2 = new SimpleDateFormat(toFormat.trim());
            String date = dateFormat2.format(sdf.parse(strDate));
            String result = date.replaceAll(" ","");

            System.out.println("Date : " + result );
        }catch (Exception e) {
            e.printStackTrace();

        }


    }


}
