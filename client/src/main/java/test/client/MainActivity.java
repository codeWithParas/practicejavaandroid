package test.client;

import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
                intent.setComponent(
                        new ComponentName("test.practice","test.practice.MyBroadCastReceiver"));
                sendBroadcast(intent);

                Toast.makeText(MainActivity.this, "BroadCast is send.",Toast.LENGTH_SHORT).show();

            }
        });




    }
}
