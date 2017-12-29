package test.practice.android_bluetooth.model;

import java.io.Serializable;

/**
 * Created by parasmani.sharma on 29/12/2017.
 */

public class BluetoothDeviceProperties implements Serializable {

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    String deviceName;

    public String getDeviceHardwareAddress() {
        return deviceHardwareAddress;
    }

    public void setDeviceHardwareAddress(String deviceHardwareAddress) {
        this.deviceHardwareAddress = deviceHardwareAddress;
    }

    String deviceHardwareAddress;


}
