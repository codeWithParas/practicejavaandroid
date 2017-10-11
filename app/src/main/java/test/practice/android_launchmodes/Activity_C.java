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

public class Activity_C extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        findViewById(R.id.but_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Activity_C.this, Activity_A.class);
                startActivity(obj);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("...onStart method....C..");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("...onResStart method....C..");

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("...onResume method....C..");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        System.out.println("...onPostResume method....C..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("...onPause method....C..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("...onStop method....C..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("...onDestroy method....C..");
    }
}
