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



/*
* What is the problem with java thread?
* Java threads are one-time use only and die after executing its run method.
* Can we improve upon it?
* The Thread is a double edged sword. We can speed up the execution by distributing the tasks among threads of execution,
* but can also slow it down when threads are in excess. Thread creation in itself is an overhead. So, the best option is to
* have an optimum number of threads and reuse them for tasks execution.
*
* So Note Important Point : Android Handlers basically provide a working thread (runs internally) called looper. That loops the
* message queue .So this helps to increase the normal thread capability to work as a reusable component that works by its own
* without explicitly calling again and again that generally we cant do with normal thread execution. So that makes some sense when you try
* to update your android view for example - as in case of progressBar.
*
*
* The main thread in Android is built with a Looper and Handlers.
* A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue.
* Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler,
* it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver
* messages and runnables to that message queue and execute them as they come out of the message queue.
* There are two main uses for a Handler:
*                              (1) to schedule messages and runnables to be executed as some point in the future;
*                          and (2) to enqueue an action to be performed on a different thread than your own.
*
* About Looper : https://developer.android.com/reference/android/os/Looper.html
* Class used to run a message loop for a thread. Threads by default do not have a message loop associated with them; to
* create one, call prepare() in the thread that is to run the loop, and then loop() to have it process messages until the
* loop is stopped.
* Most interaction with a message loop is through the Handler class.
*
*
* Talk About Handler, Looper, HandlerThread : https://blog.mindorks.com/android-core-looper-handler-and-handlerthread-bd54d69fe91a
*
* Looper is a worker that keeps a thread alive, loops through MessageQueue and sends messages to the corresponding
* handler to process.
*
*
* */


public class SendMsg_ThreadToMain extends AppCompatActivity {

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
