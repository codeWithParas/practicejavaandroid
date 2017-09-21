package test.practicejavaandroid.android_broadcast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import test.practicejavaandroid.R;

/**
 * Created by parasmani.sharma on 21/09/2017.
 */

public class Android_BroadCast_Server extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_server);


        findViewById(R.id.but_broadCast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }
}
