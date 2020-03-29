package test.practice.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import test.practice.MainActivity;
import test.practice.Utils;

/**
 * Created by Parasmani Sharma on 9/24/2017.
 */

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String packageName = intent.getComponent().getPackageName();
        /*Intent i = new Intent(context, Android_BroadCast_Server.class);
        i.putExtra("data",intent.getStringExtra("KeyName").toString());
        context.startActivity(intent);*/

        Utils.dataBroadCast = intent.getExtras().get("KeyName").toString();
        System.out.println("Received BroadCast Order : " + intent.getExtras().get("KeyName").toString());
        //Toast.makeText(context,"Received : " +intent.getStringExtra("KeyName").toString(), Toast.LENGTH_SHORT).show();

    }
}
