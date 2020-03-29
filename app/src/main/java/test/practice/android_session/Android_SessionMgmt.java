package test.practice.android_session;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.practice.R;

/**
 * Created by parasmani.sharma on 24/11/2017.
 */

/*
*
* Controlling Session TimeOut at two level separately
* 1) At Backend Level
* 2) At Android Level
*        a)Use onUserInteraction() method inside activity.
*        b)Get present time when user touch or perform any event and save that time in sharedpreference.
*        c)Then on next touch event get the time. And find elapsed time by calculating the difference between both the time.
*        d)Hence Timeout Occurs. If time is more than certain time limit then call Logout API .
* */

public class Android_SessionMgmt extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_mgmt);
    }


    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        System.out.println("           User Interacted : Control session            ");
        Toast.makeText(Android_SessionMgmt.this, "User Interacted : Control session", Toast.LENGTH_SHORT).show();
    }
}
