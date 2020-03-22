package test.client;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import test.client.android_CP_client.ContentProvider_Client;
import test.client.android_aidl_client.AIDL_Client_Binding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.send_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                *
                * when sending the broadcast add FLAG_INCLUDE_STOPPED_PACKAGES flag to the intent [src] because
                * when you broadcast from app A to app B , app B might not be running, this flag insures that the
                * broadcast reachs out even apps not running: FLAG_INCLUDE_STOPPED_PACKAGES flag is added to the
                * intent before it is sent to indicate that the intent is to be allowed to start a component of a
                * stopped application.
                *
                * */

                final Intent intent=new Intent();
                intent.setAction("test.server.broadcast.receiver");
                intent.putExtra("KeyName","paras");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                //intent.setComponent(
                        //new ComponentName("test.practice","test.practice.MyBroadCastReceiver"));
                intent.setComponent(
                        new ComponentName("test.practice","test.practice.android_broadcast.MyBroadCastReceiver"));
                sendBroadcast(intent);

                Toast.makeText(MainActivity.this, "BroadCast is send.",Toast.LENGTH_SHORT).show();

            }
        });


        /*
        * REceive Content provider
        * */

        findViewById(R.id.but_cp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ContentProvider_Client.class);
                startActivity(i);

            }
        });


        /*
        * AIDL Client.
        * 1) Bind with Server App
        * 2) Send two numbers and receive sum of both from server app.
        * */

        findViewById(R.id.but_aidl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, AIDL_Client_Binding.class);
                startActivity(i);

            }
        });


    }
}
