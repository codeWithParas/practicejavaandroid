package test.practice;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import test.practice.android_aaa_kotlin_app.StartKotlinApp;
import test.practice.android_alarm_manager.TestAlarmManager;
import test.practice.android_animation.animate_transition.AndroidAnimationActivity;
import test.practice.android_animation.parallax_tab.Android_Parallax_Tab;
import test.practice.android_animation.parallax_tab.FabHideActivity;
import test.practice.android_bluetooth.BluetoothMainActivity;
import test.practice.android_broadcast.Android_BroadCast_Server;
import test.practice.android_calender.CalDroid_CalenderActivity;
import test.practice.android_coroutines.TestCoroutinesActivity;
import test.practice.android_cp.ContentProvider_Server;
import test.practice.android_handler.Handler_Example;
import test.practice.android_intent.Intent_Example;
import test.practice.android_intent.PendingIntent_Example;
import test.practice.android_launchmodes.Activity_A;
import test.practice.android_media.PlayVideoActivity;
import test.practice.android_onSaveInstanceState.OnRestoreActivityTest;
import test.practice.android_parcelable.FirstActivity;
import test.practice.android_recyclerview.RecyclerViewActivity;
import test.practice.android_session.Android_SessionMgmt;
import test.practice.android_spannable.NewLineSpannable;
import test.practice.android_volley.Volley_Test;
import test.practice.loader.LoaderTest;
import test.practice.model.Student;

public class MainActivity extends AppCompatActivity {

    private Button txt_checkparcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * 1)Container for a message (data and object references) that can
         * be sent through an IBinder.  A Parcel can contain both flattened data
         * that will be unflattened on the other side of the IPC
         *
         * 2)Parcel is <strong>not</strong> a general-purpose
         * serialization mechanism.  This class (and the corresponding
         * {@link Parcelable} API for placing arbitrary objects into a Parcel) is
         * designed as a high-performance IPC transport.  As such, it is not
         * appropriate to place any Parcel data in to persistent storage: changes
         * in the underlying implementation of any of the data in the Parcel can
         * render older data unreadable.
         *
         * 3) Usefull : Intent generally pass primitive type objects not custom objects.
         * So in order to satisfy IPC between Activities via intent we can use Parcelable Interface for our object class.
         *
         * 4)In Parcelable, developers write custom code for marshaling and unmarshaling so
         * it creates less garbage objects in comparison to Serialization. The performance of Parcelable
         * over Serialization dramatically improves (around two times faster), because of this custom implementation.
         *
         * 5)Serialization is a marker interface, which implies the user cannot marshal the data according
         * to their requirements. In Serialization, a marshaling operation is performed on a Java Virtual Machine (JVM)
         * using the Java reflection API. This helps identify the Java objects member and behavior, but also ends up
         * creating a lot of garbage objects. Due to this, the Serialization process is slow in comparison to Parcelable.
         *
         *
         * */

        final Student student = new Student("Boy1", 1);

        txt_checkparcelable = (Button) findViewById(R.id.txt_checkparcelable);
        txt_checkparcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.txt_check_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*
                 * check if Async work after finish call
                 * Ans : Working
                 * */

                //new Asyncc().execute();

                Intent intent = new Intent(MainActivity.this, Android_BroadCast_Server.class);
                startActivity(intent);


            }
        });


        /*
         * Content provider
         * */

        findViewById(R.id.txt_check_cp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContentProvider_Server.class);
                startActivity(intent);


            }
        });





        /*
         * IActivity LAunch modes
         * */

        findViewById(R.id.txt_check_launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Activity_A.class);
                startActivity(intent);
            }
        });


        /*
         * IActivity Life Cycle
         * */

        findViewById(R.id.txt_check_lifecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, test.practice.android_lifecycle.lifecycleactivity.FirstActivity.class);
                startActivity(intent);
            }
        });


        /*
         * Intent
         * */

        findViewById(R.id.txt_check_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Intent_Example.class);
                startActivity(intent);
            }
        });


        /*
         * Pending Intent
         * */

        findViewById(R.id.txt_check_pandingintent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PendingIntent_Example.class);
                startActivity(intent);
            }
        });


        /*
         * Android Design
         * */

        findViewById(R.id.txt_parallax_tab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Android_Parallax_Tab.class);
                startActivity(intent);
            }
        });


        /*
         * Volley Test
         * */

        findViewById(R.id.txt_volley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Volley_Test.class);
                startActivity(intent);
            }
        });

        /*
         * Android Design
         * */

        findViewById(R.id.txt_design).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FabHideActivity.class);
                startActivity(intent);
            }
        });


        /*
         *
         * Recycler View
         * */

        findViewById(R.id.txt_recyclertxt_recycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });


        /*
         *
         * Animation
         * */

        findViewById(R.id.txt_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AndroidAnimationActivity.class);
                startActivity(intent);
            }
        });

        /*
         *
         * Handler
         * */

        findViewById(R.id.txt_handler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Handler_Example.class);
                startActivity(intent);
            }
        });

        /*
         *
         * Bluetooth
         * */

        findViewById(R.id.txt_bluetooth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, Check_BLE_Connection_Exm1.class);
                Intent intent = new Intent(MainActivity.this, BluetoothMainActivity.class);
                startActivity(intent);
            }
        });

        /*
         *
         * Session Mgmt
         * */

        findViewById(R.id.txt_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Android_SessionMgmt.class);
                startActivity(intent);
            }
        });



        /*
         *
         * Android Calender
         * */

        findViewById(R.id.txt_calender).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalDroid_CalenderActivity.class);
                startActivity(intent);
            }
        });


        /*
         *
         * txt_saveInstance
         * */

        findViewById(R.id.txt_saveInstance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OnRestoreActivityTest.class);
                startActivity(intent);
            }
        });


        /*
         *
         * txt_kotlin
         * */

        findViewById(R.id.txt_kotlin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartKotlinApp.class);
                startActivity(intent);
            }
        });

        /*
         *
         * txt_kotlin mvp
         * */

        findViewById(R.id.txt_kotlin_mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, MVPLoginActivity.class);
                //startActivity(intent);
            }
        });

        findViewById(R.id.test_alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestAlarmManager.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.txt_spannable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewLineSpannable.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.txt_qrscanner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, ScannedBarcodeActivity.class);
                //startActivity(intent);
            }
        });

        findViewById(R.id.test_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoaderTest.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.test_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayVideoActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.test_coroutine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestCoroutinesActivity.class);
                startActivity(intent);
            }
        });


    }


    class Asyncc extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {

            finish();

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {


                }
                System.out.println("Async is running " + i);
            }

            return null;
        }
    }
}
