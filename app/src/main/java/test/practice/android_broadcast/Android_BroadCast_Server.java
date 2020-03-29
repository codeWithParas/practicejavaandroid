package test.practice.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

            Toast.makeText(Android_BroadCast_Server.this, "BroadCast is Received", Toast.LENGTH_LONG).show();

        }
    };
    private TextView viewTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_server);

        //Registering BroadCast Receiver through Manifest-->
        registerReceiver(receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        //registerReceiver(receiver, new IntentFilter("test.server.broadcast.receiver"));

        viewTxt = (TextView) findViewById(R.id.txt_broadCast);


        findViewById(R.id.show_received).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewTxt.setText(Utils.dataBroadCast);
            }
        });

        findViewById(R.id.send_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("test.server.broadcast.receiver");
                sendBroadcast(i);
            }
        });
        /*Intent i = new Intent("com.hmkcode.android.USER_ACTION");
        sendBroadcast(i);*/
    }
}
