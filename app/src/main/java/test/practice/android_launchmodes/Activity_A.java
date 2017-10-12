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

public class Activity_A extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        System.out.println("...onCreate method....A..");
        findViewById(R.id.but_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Activity_A.this, Activity_B.class);
                obj.putExtra("Test", "data");
                startActivity(obj);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("...onStart method....A..");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("...onResStart method....A..");

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("...onResume method....A..");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        System.out.println("...onPostResume method....A..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("...onPause method....A..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("...onStop method....A..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("...onDestroy method....A..");
    }
}
