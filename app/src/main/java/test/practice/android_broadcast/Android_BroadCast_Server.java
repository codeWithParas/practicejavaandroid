package test.practice.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import test.practice.MainActivity;
import test.practice.R;
import test.practice.Utils;

/**
 * Created by parasmani.sharma on 21/09/2017.
 */

public class Android_BroadCast_Server extends AppCompatActivity {


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(Android_BroadCast_Server.this, "BroadCast Receiver", Toast.LENGTH_LONG).show();

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_server);

        registerReceiver(receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));

        /*TextView viewTxt = (TextView) findViewById(R.id.txt_broadCast);
        viewTxt.setText(Utils.dataBroadCast);*/
    }
}
