package test.practice.android_launchmodes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.practice.R;

/**
 * Created by parasmani.sharma on 03/11/2017.
 */

public class Activity_D extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        System.out.println("...onCreate method....D..");
        findViewById(R.id.but_d).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Activity_D.this, Activity_B.class);
                obj.putExtra("Test", "data");
                startActivity(obj);
            }
        });

    }
}
