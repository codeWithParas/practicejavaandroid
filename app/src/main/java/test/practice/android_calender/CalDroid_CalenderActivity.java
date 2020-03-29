package test.practice.android_calender;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import test.practice.R;
import test.practice.Utils;

/**
 * Created by parasmani.sharma on 14/12/2017.
 */

public class CalDroid_CalenderActivity extends AppCompatActivity {

    ArrayList<Date> disableDatesData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caldroid_calender_activity);


        disableDatesData.add(new Date("21-Jan-2018"));
        disableDatesData.add(new Date("28-Jan-2018"));
        disableDatesData.add(new Date("04-Feb-2018"));

        initializeCalendar(disableDatesData);

    }


    public void initializeCalendar(final ArrayList disabledDates) {

        final String[] getDate = {null};
        final CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();

        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);



        Date beginDate = null;
        Date startDate = null;
        Date endDate = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Utils.getLocalForCommunication());
        try {
            beginDate = sdf.parse("01-Jan-2018");
            endDate = sdf.parse("15-Mar-2018");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Dates >>>>>>>>>>>>>>>> Start Date :  " + beginDate + "   End date : " + endDate);

        setStartDate(cal, args , caldroidFragment, beginDate);
        setEndDate(cal, args , caldroidFragment, endDate);

        //color specific date
        caldroidFragment.setBackgroundDrawableForDate(getDrawable(R.color.caldroid_light_red), new Date("15-Jan-2018"));

        //Enabling blacklisted dates
        if(disabledDates != null)
        {
            try {
                caldroidFragment.setDisableDates(disabledDates);
                caldroidFragment.refreshView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        caldroidFragment.setCaldroidListener(new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {

                FragmentManager manager = ((FragmentActivity)CalDroid_CalenderActivity.this).getSupportFragmentManager();
                manager.popBackStack();

            }
        });

        //caldroidFragment.refreshView();

        FragmentTransaction t = CalDroid_CalenderActivity.this.getSupportFragmentManager().beginTransaction();
        t.add(R.id.lytMain, caldroidFragment, caldroidFragment.getClass().getName());
        t.addToBackStack(caldroidFragment.getClass().getName());
        t.commit();

        new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                ViewGroup.LayoutParams layoutParams = caldroidFragment.getView().getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                caldroidFragment.getView().setLayoutParams(layoutParams);
            }
        }.sendEmptyMessage(0);



    }

    private void setEndDate(Calendar cal, Bundle args, CaldroidFragment caldroidFragment, Date endDate) {

        caldroidFragment.setMaxDate(endDate);
    }

    private void setStartDate(Calendar cal, Bundle args, CaldroidFragment caldroidFragment, Date startDate) {

        int startMonth = 0;
        int startYear = 0;
        Date strtDate;
        caldroidFragment.setMinDate(startDate);
        startMonth = startDate.getMonth();
        startYear = startDate.getYear() + 1900;
        args.putInt(CaldroidFragment.MONTH, startMonth + 1);
        args.putInt(CaldroidFragment.YEAR, startYear );
        caldroidFragment.setArguments(args);

    }


}
