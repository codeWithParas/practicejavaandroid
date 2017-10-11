package test.practice.android_intent.lifecycleactivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import test.practice.R;
import test.practice.Utils;
import test.practice.android_intent.SqliteTest;
import test.practice.android_intent.lifecyclefragments.FragmentOne;

/**
 * Created by parasmani.sharma on 11/10/2017.
 */

public class FirstActivity extends AppCompatActivity {

    private Button but;
    private Button butfragment;
    private Button but_popup;
    public Dialog dialoge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_intent);

        /*finish();
         System.out.print("After Finish Called or Not :: Yes ");*/

        System.out.println("First Activity >>>>>>>>>>>>>>>>>> ");

        but_popup = (Button) findViewById(R.id.but_popup);
        but_popup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                alertDialog();
                //simpleDialog();

                SqliteTest sqliteTest = new SqliteTest(FirstActivity.this);
                sqliteTest.getWritableDatabase();

            }
        });

        butfragment = (Button) findViewById(R.id.butfragment);
        butfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment f = new FragmentOne();
                transaction.add(R.id.lytMain, f);
                transaction.commit();


            }
        });

        but = (Button) findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();

                Intent obj = new Intent(FirstActivity.this, Second.class);
                startActivity(obj);
                /*finish();
                System.out.print("After Finish Called or Not :: Yes ");*/
            }
        });
        System.out.println("...onCreate method....main..");

    }

    private void simpleDialog() {

        /*ProgressDialog obj = new ProgressDialog(MainActivity.this);
                obj.show();*/

        dialoge = new Dialog(FirstActivity.this);
        dialoge.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialoge.setCanceledOnTouchOutside(false);
        dialoge.getWindow().setLayout(DrawerLayout.LayoutParams.FILL_PARENT, DrawerLayout.LayoutParams.FILL_PARENT);
        dialoge.setContentView(R.layout.dialog);
        dialoge.show();
        Button butclose = (Button) dialoge.findViewById(R.id.butclose);
        butclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialoge.dismiss();
                //dialog.cancel();
            }
        });
    }

    private void alertDialog() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(FirstActivity.this);
        builder1.setMessage("Write your message here.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);

        System.out.println("...onActionModeFinished method....main..");

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("...onStart method....main..");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("...onResStart method....main..");

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("...onResume method....main..");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        System.out.println("...onPostResume method....main..");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("...onPause method....main..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("...onStop method....main..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("...onDestroy method....main..");
    }


    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 0) {
            FragmentManager.BackStackEntry a = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1);//top
            Fragment baseFrag = (Fragment) getSupportFragmentManager().findFragmentByTag(a.getName());
            if (baseFrag instanceof Fragment) {
                /*((Fragment) baseFrag).onBackEventPre();
                if(a.getName().equals(new MMBPaymentFragment().getClass().getName()))
                {
                    return;
                }*/
            }



            //pop back stack
            getSupportFragmentManager().popBackStack();
            //now update action bar, depending upon screen

            System.out.print("back stack entry count after removing >>>>>>>>>>>>>>>>> " + getSupportFragmentManager().getBackStackEntryCount()+"\n");

            try {
                FragmentManager.BackStackEntry entry = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 2);

                Fragment baseFragment = (Fragment) getSupportFragmentManager().findFragmentByTag(entry.getName());

            } catch (Exception e) {
                //user is moving at home
                //Utils.ERROR("onBackPressed >> Error while poping back fragment at : " + (getSupportFragmentManager().getBackStackEntryCount() - 2));
                //Utils.updateActionBarForFeatures(this, new HomeFragment().getClass().getName());
            }

            Utils.hideKeyboard(this, baseFrag.getView());
        } else {
            super.onBackPressed();
        }
    }

}
