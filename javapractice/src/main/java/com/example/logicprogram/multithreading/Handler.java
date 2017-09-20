package com.example.logicprogram.multithreading;


/**
 * Created by parasmani.sharma on 08/09/2017.
 */

public class Handler {

    void test()
    {
        new Thread()
        {
            @Override
            public void run() {
                Handler h = new Handler();

            }
        }.start();;


       /* Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //we are here now
            }
        };

        Message msg = Message.obtain();
        msg.arg1 = 1;

        handler.sendMessage(msg);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 200);*/

    }

}
