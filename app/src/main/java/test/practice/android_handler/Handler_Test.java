package test.practice.android_handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import test.practice.R;

/**
 * Created by parasmani.sharma on 12/10/2017.
 */

public class Handler_Test extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_activity);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 400);

        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });

        new Handler()
        {

            @Override
            public void dispatchMessage(Message msg) {
                super.dispatchMessage(msg);


            }

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);


            }

            @Override
            public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
                return super.sendMessageAtTime(msg, uptimeMillis);
            }
        };


    }
}
