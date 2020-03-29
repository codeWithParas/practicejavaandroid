package test.practice.android_handler;

import android.os.Handler;
import android.os.HandlerThread;

public class HandlerTest extends Handler {

    static HandlerTest create()
    {
        HandlerThread thread = new HandlerThread("PB-GATT thread");
        thread.start();
        return new HandlerTest(thread);
    }

    public HandlerTest(HandlerThread thread)
    {
        super(thread.getLooper());
    }


}
