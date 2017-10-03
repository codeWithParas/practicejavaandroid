package test.client.android_aidl_client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import test.client.R;
import test.practice.MyAIDL_Interface;

/**
 * Created by parasmani.sharma on 03/10/2017.
 */

public class AIDL_Client_Binding extends AppCompatActivity {

    public MyAIDL_Interface myInterface;
    ServiceConnection serviceCon = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("......Binding Connection Created.......");
            Toast.makeText(AIDL_Client_Binding.this, "Binding Done", Toast.LENGTH_SHORT).show();

            myInterface = MyAIDL_Interface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    private TextView txt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidl_client_binding);


        /**
         *
         * 3 most important point before going to build AIDL based connection :
         *
         * To have service connection :
         * 1) Require Server App Package Name : Package Name (Ex : test.practice)
         * 2) Require Server App Binding Service Action Name : Service Action Name (Ex : android.test.aidl.BindingService)
         * 3) Important : Require same package(test.practice) for AIDL interface in both Client and Server App.
         *
         * */


        findViewById(R.id.btnBind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("......Creating Binding Connection.......");

                Intent intent = new Intent("android.test.server.BindingService");
                intent.setPackage("test.practice");
                bindService(intent, serviceCon, BIND_AUTO_CREATE);
            }
        });


        txt = (TextView) findViewById(R.id.txt);
        findViewById(R.id.btnCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int number = myInterface.add(2, 2);
                    System.out.println("Addition .. >> " + number);
                    txt.setText(number + "");
                    Toast.makeText(AIDL_Client_Binding.this, "Add : " + number, Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
