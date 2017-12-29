package test.practice.android_bluetooth.bluetooth_connection_example;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import test.practice.R;
import test.practice.android_bluetooth.adapter.RecyclerViewAdapterBLE;
import test.practice.android_bluetooth.model.BluetoothDeviceProperties;

/**
 * Created by parasmani.sharma on 04/12/2017.
 */

public class Check_BLE_Connection_Exm2 extends AppCompatActivity {

    private static final String TAG = "Making BLE Connection";
    private static final int REQUEST_ENABLE_BT = 1;
    private Button but_on;
    private Button but_off;
    private Button but_scan_connected_devices;
    private BluetoothManager ble_manager;
    private BluetoothAdapter ble_adapter;
    private RecyclerView recycler_connected_device;
    private Button but_discover_new_devices;
    private RecyclerView recycler_discover_new_devices;
    private boolean is_BLE_Supported;
    private ArrayList<BluetoothDeviceProperties> pairedDevice;

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action))
            {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
                System.out.println("Number of Pairing Devices : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + pairedDevice.size());

                BluetoothDeviceProperties devProperty = new BluetoothDeviceProperties();
                devProperty.setDeviceName(deviceName);
                devProperty.setDeviceHardwareAddress(deviceHardwareAddress);
                pairedDevice.add(devProperty);

            }
            else if(BluetoothDevice.ACTION_ACL_CONNECTED.equals(action))
            {
                //Broadcast Action: Indicates a low level (ACL) connection has been established with a remote device.
            }
            else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action))
            {
                //Broadcast Action: The local Bluetooth adapter has finished the device discovery process.
                System.out.println(">>>>>>>>>>>>>>> ACTION_DISCOVERY_FINISHED >>>>>>>>>>>>>>>> ");
                setProgressBarIndeterminateVisibility(false);
                setTitle(R.string.select_device);
                showNewPairingDevices(pairedDevice);
                /*if (mNewDevicesArrayAdapter.getCount() == 0) {
                    String noDevices = getResources().getText(R.string.none_found).toString();
                    mNewDevicesArrayAdapter.add(noDevices);
                }*/
            }
        }
    };





    /*
    * Points Before Connection
    * 1) Check if Bluetooth supported
    * 2) if (1) is true : register receiver
    *
    * Points for BLE connection
    * 1) getBluetoothAdapter
    * 2) Enable Bluetooth
    * 3) Finding Device : a) Paired Devices && 2) New Devices
    *
    *
    * */


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ble_connection);

        initUi();

        is_BLE_Supported = check_bluetooth_support();
        if(is_BLE_Supported)
        {
            // Register for broadcasts when a device is discovered.
            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mReceiver, filter);

            init_BLE_Adapter();
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(mReceiver);
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
        getBluetoothAdapter();


        /*
        * 2) Enable Bluetooth
        * */
        but_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(is_BLE_Supported) {
                    enableBluetooth();
                }
            }
        });

        but_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ble_adapter.disable();
                Toast.makeText(getApplicationContext(), "Turned turnOff" ,Toast.LENGTH_LONG).show();

            }
        });



        /*
        * 3) Finding Device (scanning)
        *
        * a) Querying paired devices : Check to see if the desired device is already known.
        * b) Discovering devices
        *
        * */

        but_scan_connected_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_BLE_Supported) {
                    findingDevice();
                }
            }
        });


        /*
        * 4) Connecting Devices : To initiate a connection with a Bluetooth device
        *
        * */

        connectingSelectedDevices();



        /*
        *
        * 5) Managing a connection : Process data communication.
        *
        * */

        managingDeviceCommunication();







    }

    private void managingDeviceCommunication() {


    }

    private void connectingSelectedDevices() {

        /*
        * Connecting Devices
        *
        * To initiate a connection with a Bluetooth device, all that's needed from the associated BluetoothDevice object
        * is the MAC address, which you retrieve by calling getAddress().
        * Caution: Performing device discovery consumes a lot of the Bluetooth adapter's resources. After you have found a
        * device to connect to, be certain that you stop discovery with cancelDiscovery() before attempting a connection.
        * Also, you shouldn't perform discovery while connected to a device because the discovery process significantly
        * reduces the bandwidth available for any existing connections.
        *
        * 1) In order to create a connection between two devices, you must implement both the server-side and client-side
        * mechanisms because one device must open a server socket, and the other one must initiate the connection using the
        * server device's MAC address.
        *
        * 2) The server device and the client device each obtain the required BluetoothSocket in different ways. The server
        * receives socket information when an incoming connection is accepted. The client provides socket information when it
        * opens an RFCOMM channel to the server.
        *
        *
        * Connection techniques :
        *
        * One implementation technique is to automatically prepare each device as a server so that each device has a
        * server socket open and listening for connections. In this case, either device can initiate a connection with the
        * other and become the client. Alternatively, one device can explicitly host the connection and open a server socket
        * on demand, and the other device initiates the connection.
        *
        * Note: If the two devices have not been previously paired, then the Android framework automatically shows a pairing
        * request notification or dialog to the user during the connection procedure.
        *
        *
        * */

        /*
        * A) Connecting as a server :
        *
        * When you want to connect two devices, one must act as a server by holding an open BluetoothServerSocket.
        * The purpose of the server socket is to listen for incoming connection requests and provide a connected BluetoothSocket
        * after a request is accepted. When the BluetoothSocket is acquired from the BluetoothServerSocket, the BluetoothServerSocket
        * can—and should—be discarded, unless you want the device to accept more connections.
        *
        * To set up a server socket and accept a connection, complete the following sequence of steps:
        *
        * 1) Get a BluetoothServerSocket by calling listenUsingRfcommWithServiceRecord().
        * The string is an identifiable name of your service, which the system automatically writes to a new Service Discovery
        * Protocol (SDP) database entry on the device. The name is arbitrary and can simply be your application name.
        * The UUID is also included in the SDP entry and forms the basis for the connection agreement with the client device.
        * That is, when the client attempts to connect with this device, it carries a UUID that uniquely identifies the service
        * with which it wants to connect. These UUIDs must match in order for the connection to be accepted.
        *
        * 2) Start listening for connection requests by calling accept().
        * This is a blocking call. It returns when either a connection has been accepted or an exception has occurred. A
        * connection is accepted only when a remote device has sent a connection request containing a UUID that matches
        * the one registered with this listening server socket. When successful, accept() returns a connected BluetoothSocket.
        *
        * 3) Unless you want to accept additional connections, call close().
        * This method call releases the server socket and all its resources, but doesn't close the connected BluetoothSocket
        * that's been returned by accept(). Unlike TCP/IP, RFCOMM allows only one connected client per channel at a time, so
        * in most cases, it makes sense to call close() on the BluetoothServerSocket immediately after accepting a connected socket.
        *
        * Because the accept() call is a blocking call, it should not be executed in the main activity UI thread so that your
        * application can still respond to other user interactions. It usually makes sense to do all work that involves a
        * BluetoothServerSocket or BluetoothSocket in a new thread managed by your application. To abort a blocked call such
        * as accept(), call close() on the BluetoothServerSocket or BluetoothSocket from another thread. Note that all methods
        * on a BluetoothServerSocket or BluetoothSocket are thread-safe.
        *
        * About UUID
        * A Universally Unique Identifier (UUID) is a standardized 128-bit format for a string ID used to uniquely identify
        * information. The point of a UUID is that it's big enough that you can select any random ID and it won't clash with
        * any other ID. In this case, it's used to uniquely identify your application's Bluetooth service. To get a UUID to
        * use with your application, you can use one of the many random UUID generators on the web, then initialize a UUID
        * with fromString(String).
        *
        * */

    }

    private class AcceptThread extends Thread {
        //private final BluetoothServerSocket mmServerSocket;

        /*public AcceptThread() {
            // Use a temporary object that is later assigned to mmServerSocket
            // because mmServerSocket is final.
            BluetoothServerSocket tmp = null;
            try {
                // MY_UUID is the app's UUID string, also used by the client code.
                tmp = ble_adapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            } catch (IOException e) {
                Log.e("TAG", "Socket's listen() method failed", e);
            }
            mmServerSocket = tmp;
        }

        public void run() {
            BluetoothSocket socket = null;
            // Keep listening until exception occurs or a socket is returned.
            while (true) {
                try {
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
                    Log.e(" Tag", "Socket's accept() method failed", e);
                    break;
                }

                if (socket != null) {
                    // A connection was accepted. Perform work associated with
                    // the connection in a separate thread.
                    manageMyConnectedSocket(socket);
                    mmServerSocket.close();
                    break;
                }
            }
        }

        // Closes the connect socket and causes the thread to finish.
        public void cancel() {
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the connect socket", e);
            }
        }*/
    }


    private void findingDevice() {

        /*
        * 3) Finding Device
        * Refer Link : https://developer.android.com/guide/topics/connectivity/bluetooth.html
        *
        * a) Using the BluetoothAdapter, you can find remote Bluetooth devices either through device discovery or by querying
        * the list of paired devices.
        * b) Device discovery is a scanning procedure that searches the local area for Bluetooth-enabled devices.
        * and requests some information about each one.
        * c) However, a nearby Bluetooth device responds to a discovery request only if it is currently accepting information
        * requests by being discoverable.
        * d) If a device is discoverable, it responds to the discovery request by sharing some information, such as the device's
        * name, its class, and its unique MAC address.
        * e) Using this information, the device that is performing the discovery process can then choose to initiate a connection
        * to the discovered device.
        * f) Once a connection is made with a remote device for the first time, a pairing request is automatically presented
        * to the user. When a device is paired, the basic information about that device—such as the device's name, class, and
        * MAC address—is saved and can be read using the Bluetooth APIs.
        * g) Using the known MAC address for a remote device, a connection can be initiated with it at any time without performing
        * discovery, assuming the device is still within range.
        *
        * Note that there is a difference between being paired and being connected:
        * 1) To be paired means that two devices are aware of each other's existence, have a shared link-key that can be used for
        * authentication, and are capable of establishing an encrypted connection with each other.
        * 2) To be connected means that the devices currently share an RFCOMM channel and are able to transmit data with each other.
        * The current Android Bluetooth API's require devices to be paired before an RFCOMM connection can be established.
        * Pairing is automatically performed when you initiate an encrypted connection with the Bluetooth APIs.
        *
        * */

        /*
        * A) Querying paired devices
        * Before performing device discovery, it's worth querying the set of paired devices to see if the desired device is
        * already known. To do so, call getBondedDevices(). This returns a set of BluetoothDevice objects representing paired
        * devices. For example, you can query all paired devices and get the name and MAC address of each device, as the
        * following code snippet demonstrates:
        *
        * */

        Set<BluetoothDevice> pairedDevices = ble_adapter.getBondedDevices();

        pairedDevice = new ArrayList();
        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                BluetoothDeviceProperties devProperty = new BluetoothDeviceProperties();
                devProperty.setDeviceName(deviceName);
                devProperty.setDeviceHardwareAddress(deviceHardwareAddress);
                pairedDevice.add(devProperty);
            }
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        recycler_connected_device.setLayoutManager(gridLayoutManager);

        RecyclerViewAdapterBLE adapter = new RecyclerViewAdapterBLE(pairedDevice,this,new RecyclerViewAdapterBLE.IRecyclerViewHolderClicks() {
            @Override
            public void onClickRecyclerItem(int position, String deviceName, String deviceAddress) {

                Toast.makeText(Check_BLE_Connection_Exm2.this,"Selected Device : " + deviceName, Toast.LENGTH_SHORT).show();

            }
        });

        recycler_connected_device.setAdapter(adapter);

        /*
        * B) Discovering devices
        *
        * 1) To start discovering devices, simply call startDiscovery().
        * 2) The process is asynchronous and returns a boolean value indicating whether discovery has successfully started.
        * The discovery process usually involves an inquiry scan of about 12 seconds, followed by a page scan of each device
        * found to retrieve its Bluetooth name.
        * 3) In order to receive information about each device discovered, your application must register a BroadcastReceiver
        * for the ACTION_FOUND intent.
        * 4) In order to receive information about each device discovered, your application must register a BroadcastReceiver
        * for the ACTION_FOUND intent. The system broadcasts this intent for each device. The intent contains the extra
        * fields EXTRA_DEVICE and EXTRA_CLASS, which in turn contain a BluetoothDevice and a BluetoothClass, respectively.
        * The following code snippet shows how you can register to handle the broadcast when devices are discovered:
        *
        * */



        but_discover_new_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doDiscovery();
            }
        });

    }

    /**
     * Start device discover with the BluetoothAdapter
     */
    private void doDiscovery() {
        Log.d(TAG, "doDiscovery()");

        // Indicate scanning in the title
        setProgressBarIndeterminateVisibility(true);
        setTitle(R.string.scanning);

        // If we're already discovering, stop it
        if (ble_adapter.isDiscovering()) {
            ble_adapter.cancelDiscovery();
        }

        // Request discover from BluetoothAdapter
        ble_adapter.startDiscovery();
    }

    private void showNewPairingDevices(ArrayList<BluetoothDeviceProperties> pairedDevice) {


        if(!pairedDevice.isEmpty() && pairedDevice.size()>0)
        {
            return;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        recycler_discover_new_devices.setLayoutManager(gridLayoutManager);

        RecyclerViewAdapterBLE adapter = new RecyclerViewAdapterBLE(pairedDevice,this, new RecyclerViewAdapterBLE.IRecyclerViewHolderClicks() {
            @Override
            public void onClickRecyclerItem(int position, String deviceName, String deviceAddress) {

                Toast.makeText(Check_BLE_Connection_Exm2.this,"Selected Device : " + deviceName, Toast.LENGTH_SHORT).show();

            }
        });

        recycler_discover_new_devices.setAdapter(adapter);

    }

    private void enableBluetooth() {
        /*
        * 2) Enable Bluetooth
        * Refer Link : https://developer.android.com/guide/topics/connectivity/bluetooth.html
        * */
        // Ensures Bluetooth is available on the device and it is enabled. If not,
        // displays a dialog requesting user permission to enable Bluetooth.
        /*
        * The REQUEST_ENABLE_BT constant passed to startActivityForResult() is a locally defined integer that must be
        * greater than 0. The system passes this constant back to you in your onActivityResult() implementation as the
        * requestCode parameter.If enabling Bluetooth succeeds, your activity receives the RESULT_OK result code in the
        * onActivityResult() callback. If Bluetooth was not enabled due to an error (or the user responded "No") then the
        * result code is RESULT_CANCELED.
        *
        * Optionally, your application can also listen for the ACTION_STATE_CHANGED broadcast intent, which the system
        * broadcasts whenever the Bluetooth state changes. This broadcast contains the extra fields EXTRA_STATE and
        * EXTRA_PREVIOUS_STATE, containing the new and old Bluetooth states, respectively. Possible values for these extra
        * fields are STATE_TURNING_ON, STATE_ON, STATE_TURNING_OFF, and STATE_OFF. Listening for this broadcast can be useful
        * if your app needs to detect runtime changes made to the Bluetooth state.
        * */
        if (ble_adapter == null || !ble_adapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);

            Toast.makeText(getApplicationContext(), "Turned turnON" ,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Failed" ,Toast.LENGTH_LONG).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            /*case REQUEST_CONNECT_DEVICE_SECURE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, true);
                }
                break;
            case REQUEST_CONNECT_DEVICE_INSECURE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, false);
                }
                break;*/
            case REQUEST_ENABLE_BT:
                // When the request to enable Bluetooth returns
                if (resultCode == Activity.RESULT_OK) {
                    // Bluetooth is now enabled, so set up a chat session
                    //setupChat();
                } else {
                    // User did not enable Bluetooth or an error occurred
                    Log.d(TAG, "BT not enabled");
                    Toast.makeText(Check_BLE_Connection_Exm2.this, R.string.bt_not_enabled_leaving,
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }


    private void getBluetoothAdapter() {
        /*
        * 1) Get the BluetoothAdapter
        * Refer Link : https://developer.android.com/guide/topics/connectivity/bluetooth.html
        * */

        ble_manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        ble_adapter = ble_manager.getAdapter();
    }

    public void scanLE(View v)
    {

    }

    private void initUi() {

        but_on = (Button) findViewById(R.id.but_on);
        but_off = (Button) findViewById(R.id.but_off);
        but_discover_new_devices = (Button) findViewById(R.id.but_discover_new_devices);
        but_scan_connected_devices = (Button) findViewById(R.id.but_scan_connected_devices);
        recycler_connected_device = (RecyclerView)findViewById(R.id.recycler_connected_device);
        recycler_discover_new_devices = (RecyclerView)findViewById(R.id.recycler_discover_new_devices);

    }
}
