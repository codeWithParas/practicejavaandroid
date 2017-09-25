package test.practice.android_broadcast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import test.practice.R;
import test.practice.Utils;

/**
 * Created by parasmani.sharma on 21/09/2017.
 */

public class Android_BroadCast_Server extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_server);

        TextView viewTxt = (TextView) findViewById(R.id.txt_broadCast);
        viewTxt.setText(Utils.dataBroadCast);
    }
}
