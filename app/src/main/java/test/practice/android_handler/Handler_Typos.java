package test.practice.android_handler;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.practice.R;

/**
 * Created by parasmani.sharma on 22/11/2017.
 */


/*
* A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue.
* Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler,
* it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver
* messages and runnables to that message queue and execute them as they come out of the message queue.
* There are two main uses for a Handler:
*                              (1) to schedule messages and runnables to be executed as some point in the future;
*                          and (2) to enqueue an action to be performed on a different thread than your own.
*
* Scheduling messages is accomplished with the :
*      post(Runnable),
*      postAtTime(Runnable, long),
*      postDelayed(Runnable, long),
*      sendEmptyMessage(int),
*      sendMessage(Message),
*      sendMessageAtTime(Message, long), and
*      sendMessageDelayed(Message, long) methods.
*
*
* */

public class Handler_Typos extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_types);

        // 1) new Handler().postDelayed(new Runnable(), 200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },200);


    }
}
