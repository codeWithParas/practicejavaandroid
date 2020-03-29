package test.practice.android_bluetooth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import test.practice.R;
import test.practice.android_bluetooth.bluetooth_chat_example.BluetoothChatFragment;
import test.practice.android_bluetooth.bluetooth_connection_example.Check_BLE_Connection_Exm2;

/**
 * Created by parasmani.sharma on 28/12/2017.
 */

public class BluetoothMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble_home_page);

        findViewById(R.id.ble_test_connection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent i = new Intent(BluetoothMainActivity.this, Check_BLE_Connection_Exm1.class);
                Intent i = new Intent(BluetoothMainActivity.this, Check_BLE_Connection_Exm2.class);
                startActivity(i);

            }
        });

        findViewById(R.id.ble_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    BluetoothChatFragment fragment = new BluetoothChatFragment();
                    transaction.replace(R.id.sample_content_fragment, fragment);
                    transaction.commit();

            }
        });

    }
}
