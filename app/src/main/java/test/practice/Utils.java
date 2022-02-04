package test.practice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Locale;

import test.practice.android_lifecycle.lifecyclefragments.Fragmenttwo;


/**
 * Created by Parasmani Sharma on 9/24/2017.
 */

public class Utils {


    /*From ST Test */

    public static String dataBroadCast;

    public static Locale getLocalForCommunication() {
        return new Locale("en_US");
    }


    public static int getToolbarHeight(Context context) {
        int height = (int) context.getResources().getDimension(R.dimen.abc_action_bar_default_height_material);
        return height;
    }

    public static int getStatusBarHeight(Context context) {
        int height = (int) context.getResources().getDimension(R.dimen.statusbar_size);
        return height;
    }


    public static void moveToFragment(Activity activity, Fragment fragment, Object data, int viewType) {
        //Utils.DEBUG("moveToFragment() called: " + fragment);
        System.out.print("....moveToFragment........>>>>>>>>>>>>");
        if (activity == null || fragment == null) {
            return;
        }

        FragmentManager manager = ((FragmentActivity) activity).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.lytMain, fragment, fragment.getClass().getName());

        Bundle bundle = new Bundle();


        if (data != null/* && (fragment.getClass().getSimpleName().equals(new FlightPassSearchFragment().getClass().getSimpleName())
                                || fragment.getClass().getSimpleName().equals(new FlightPassSearchSelectFragment().getClass().getSimpleName()))*/) {
            //bundle.putSerializable(activity.getString(R.string.key_serializable), (Serializable) data);
        }

       /* if (viewType > 0 && fragment.getClass().getSimpleName().equals(new FlightPassSearchSelectFragment().getClass().getSimpleName())) {
            //bundle.putInt(activity.getString(R.string.key_view_type), viewType);
        }*/

        fragment.setArguments(bundle);

        if(!fragment.getClass().getName().equals(new Fragmenttwo().getClass().getName()))
        {
            transaction.addToBackStack(fragment.getClass().getName());
        }



        transaction.commit();

        /*if (fragment instanceof BFragment) {
            ((BFragment) fragment).onFocusEvent();
        }*/
    }


    /*
    * check keyboard status
    * */

    public static void hideKeyboard(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        try {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            //Utils.ERROR("Error in hideKeyboard() : " + e.toString());
        }

    }

    /*catch use for fragments transaction*/

    /*public static void setTitleInCache(Activity activity, String className, String titleNameDynamic) {
        if(activity == null)
            return;
        SharedPrefs sp = AppSharedPrefs.getInstance(activity);
        sp.put(className, titleNameDynamic);
    }

    public static String getTitleFromCache(Activity activity, String className) {
        AppSharedPrefs sp = AppSharedPrefs.getInstance(activity);
        Object title = sp.get(className);

        if (title != null) {
            sp.clear(className);
        }
        return title == null ? "" : (String) title;
    }*/

}
