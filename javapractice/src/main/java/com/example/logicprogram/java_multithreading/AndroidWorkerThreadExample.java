package com.example.logicprogram.java_multithreading;

/**
 * Created by parasmani.sharma on 25/05/2017.
 */

public class AndroidWorkerThreadExample {

    //inside oncreate of activity
    //However, note that you cannot update the UI from any thread other than the UI thread or the "main" thread.

    //To fix this problem, Android offers several ways to access the UI thread from other threads. Here is a list of methods that can help:

    // Activity.runOnUiThread(Runnable)
    //View.post(Runnable)
    //View.postDelayed(Runnable, long)

    /*public void onClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                // a potentially  time consuming task
                final Bitmap bitmap =
                        processBitMap("image.png");


                mImageView.post(new Runnable() {
                    public void run() {
                        mImageView.setImageBitmap(bitmap);
                    }
                });



            }
        }).start();
    }*/

}
