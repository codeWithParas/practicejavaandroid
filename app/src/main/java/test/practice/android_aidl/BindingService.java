package test.practice.android_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import test.practice.MyAIDL_Interface;

/**
 * Created by parasmani.sharma on 08/09/2017.
 */

public class BindingService extends Service {

    //private final IBinder mBinder = new Binder();
    MyImpl myImpl = new MyImpl();

    class MyImpl extends MyAIDL_Interface.Stub
    {

        @Override
        public int add(int num1, int num2) throws RemoteException {
            return num1+num2;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("Inside onBind of Service of Server App >>> ");

        return myImpl;
    }
}
