package test.practice.android_bluetooth.connecting_ble_devices;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import test.practice.R;

/**
 * Created by parasmani.sharma on 04/12/2017.
 */

public class Making_BLE_Connection extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;
    private Button on;
    private Button off;
    private Button scan;
    private RecyclerView recycler;
    private BluetoothManager ble_manager;
    private BluetoothAdapter ble_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ble_connection);

        initUi();

        boolean is_BLE_Supported = check_bluetooth_support();
        if(is_BLE_Supported)
        {
            init_BLE_Adapter();
        }



    }

    private boolean check_bluetooth_support() {

        // Use this check to determine whether BLE is supported on the device. Then
        // you can selectively disable BLE-related features.
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, " <<  BLE Not Supported  >> ", Toast.LENGTH_SHORT).show();
            return false;
        }else
        {
            return true;
        }
    }

    private void init_BLE_Adapter() {

        /*
        * 1) Get the BluetoothAdapter
        * */

        ble_manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        ble_adapter = ble_manager.getAdapter();


        /*
        * 2) Enable Bluetooth
        * */
        // Ensures Bluetooth is available on the device and it is enabled. If not,
        // displays a dialog requesting user permission to enable Bluetooth.
        if (ble_adapter == null || !ble_adapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

    }

    public void scanLE(View v)
    {

    }

    private void initUi() {

        on = (Button) findViewById(R.id.but_on);
        off = (Button) findViewById(R.id.but_off);
        scan = (Button) findViewById(R.id.but_scan);
        recycler = (RecyclerView) findViewById(R.id.recycler);

    }
}
