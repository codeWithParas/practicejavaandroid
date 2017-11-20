package test.practice.android_handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import test.practice.R;
import test.practice.android_volley.AppController;

/**
 * Created by Parasmani Sharma on 11/20/2017.
 */

public class Handler_MsgQueue_Example extends AppCompatActivity {

    private ProgressBar progressBar;
    Thread thread;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_msgqueue);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        thread = new Thread(new MyThread());
        thread.start();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                progressBar.setProgress(msg.arg1);
            }
        };
    }

    class MyThread implements Runnable
    {

        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {

                Message msg = new Message();
                msg.arg1  = i;
                handler.sendMessage(msg);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
