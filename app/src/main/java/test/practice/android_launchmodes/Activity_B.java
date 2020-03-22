package test.practice.android_launchmodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import test.practice.R;

/**
 * Created by parasmani.sharma on 11/10/2017.
 */

public class Activity_B extends AppCompatActivity {

    /*
    * set launchmodes
    * */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        System.out.println("...onCreate method....B..");
        //System.out.println(">>>>>>>>>>>>>   Activity B : Single Top Launch Mode Failed <<<<<<<<<<<<<  ");

        findViewById(R.id.but_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Activity_B.this, Activity_C.class);

                //use : android:launchMode="singleTop" // same instance of activity B is used
                //Intent obj = new Intent(Activity_B.this, Activity_B.class);
                startActivity(obj);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {

        String data = intent.getStringExtra("Test");

        System.out.println(">>>>>>>>>>>>>   Activity B : Single Top Launch Mode Successfull <<<<<<<<<<<<<  "+ data);
        //super.onNewIntent(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("...onStart method....B..");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("...onResStart method....B..");

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("...onResume method....B..");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        System.out.println("...onPostResume method....B..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("...onPause method....B..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("...onStop method....B..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("...onDestroy method....B..");
    }
}
