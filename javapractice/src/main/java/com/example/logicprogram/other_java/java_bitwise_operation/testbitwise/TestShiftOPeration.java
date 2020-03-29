package com.example.logicprogram.other_java.java_bitwise_operation.testbitwise;

public class TestShiftOPeration {

    public static void main(String[] args) {

        /*
        * Given : any Octet : 00001111 = 15
        * i.e :               0,0,0,Alphanumeric,Numeric,Vibrate,Beep,Blink
        * From Left to Right : each binary value if 1 then that value is supported in BLE device.
        * Get the incoming written value from any BLE. For example the final value is 15 as given above.
        * Question is : what are the OOB output actions will be covered in digit 15.
        * Apply shift operation.
        *
        * */


        OutputActions outputOOB = getOutputTypeAction(15/*capabilities.getOutputOOBActions()*/);

        System.out.println("Blink Support        "  + outputOOB.isBlink());
        System.out.println("Beap Support         "  + outputOOB.isBeep());
        System.out.println("Vibrate Support      "  + outputOOB.isVibrate());
        System.out.println("Numeric Support      "  + outputOOB.isOutputNumeric());
        System.out.println("AlphaNumeric Support "  + outputOOB.isOutputAlphanumeric());
    }

    private static OutputActions getOutputTypeAction(int outputOOBAction) {

        OutputActions outputActions = new OutputActions();

        if((outputOOBAction & 0x01) >> 0 == 1)
        {
            outputActions.setBlink(true);
        }
        if((outputOOBAction & 0x02) >> 1 == 1)
        {
            outputActions.setBeep(true);
        }
        if((outputOOBAction & 0x04) >> 2 == 1)
        {
            outputActions.setVibrate(true);
        }
        if((outputOOBAction & 0x08) >> 3 == 1)
        {
            outputActions.setOutputNumeric(true);
        }
        if((outputOOBAction & 0x16) >> 4 == 1)
        {
            outputActions.setOutputAlphanumeric(true);
        }

        return outputActions;
    }
}
