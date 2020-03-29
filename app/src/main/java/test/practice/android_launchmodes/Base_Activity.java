package test.practice.android_launchmodes;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by parasmani.sharma on 12/10/2017.
 */

public class Base_Activity extends AppCompatActivity implements View.OnClickListener {

    protected static ActivityManager activityManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(activityManager == null)
            activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);

    }

    protected void startActivity(Activity activity, Class targetActivityClass)
    {
        Intent intent = new Intent(activity, targetActivityClass);
        startActivity(intent);
    }

    protected static String getAppTaskState()
    {

        StringBuilder stringBuilder = new StringBuilder();
        int totalNumberOfTask = activityManager.getRunningTasks(10).size();
        stringBuilder.append("\n Total Number of Task: "+totalNumberOfTask+"\n\n");

        List<ActivityManager.RunningTaskInfo> taskInfo = activityManager.getRunningTasks(10);

        for (ActivityManager.RunningTaskInfo info: taskInfo)
        {
            stringBuilder.append("Task Id"+info);


        }

        return stringBuilder.toString();
    }

    @Override
    public void onClick(View v) {

    }
}
