package test.practice.android_lifecycle.lifecycleactivity;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import test.practice.R;

/**
 * Created by parasmani.sharma on 10/12/2016.
 */
public class Second extends AppCompatActivity {

    private Button but;
    private Button but_popup;
    public Dialog dialoge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_intent);

        System.out.println(".2..onCreate method......");

        //finish();  //check

        but_popup = (Button) findViewById(R.id.but_popup);
        but_popup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                dialoge = new Dialog(Second.this);
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
        });



        but = (Button) findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 System.out.println("<<<<<<<<<<<<<<<<<2..onFinish method called >>>>>>>>>>>>>>>>>>> ");
                 finish();

               /* AlertDialog.Builder builder1 = new AlertDialog.Builder(Second.this);
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
                        });*/

                /*AlertDialog alert11 = builder1.create();
                alert11.show();*/

                /*ProgressDialog obj = new ProgressDialog(Second.this);
                obj.show();*/

                /*Intent obj1 = new Intent(Second.this, MainActivity.class);
                startActivity(obj1);*/
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(".2..onStart method......");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(".2..onResStart method.....");

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println(".2..onResume method......");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        System.out.println(".2..onPostResume method......");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(".2..onPause method......");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(".2..onStop method......");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(".2..onDestroy method......");
    }

}
