package test.practice.android_onSaveInstanceState;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import test.practice.R;
import test.practice.android_onSaveInstanceState.model.Model;

//link : https://www.journaldev.com/22621/android-onsaveinstancestate-onrestoreinstancestate

/*
* We will disscuss : onSaveInstanceState and onRestoreInstanceState.
* Note : Whenever there is a configuration change, such as rotation or application going into
* multi-window mode, the activity is recreated.
* In this recreation, the application gets restarted and may lose data in the views if not handled properly.
* For this there are two methods that are triggered at different stages of the lifecycle:
* ->   onSaveInstanceState
* ->   onRestoreInstanceState
*
* They are used to save and retrieve values. The values are stored in the form of a key-value pair.
* */

public class OnRestoreActivityTest extends AppCompatActivity {

    Model model = new Model(10, "Hello");

    Button button;
    TextView textView;
    int counter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onrestoreview);
        /*
        * we’ll be creating a Counter Application in which we’ll save the state of the counter using the two methods.
        * */

        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("message");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            counter = savedInstanceState.getInt("counter", 0);
        }

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(counter));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = Integer.valueOf(textView.getText().toString()) + 1;
                textView.setText(String.valueOf(counter));
            }
        });


    }

    //create an instance of the Model and save it in onSaveInstanceState.
    //Note: onSaveInstanceState gets called whenever you press the home button in your application as well.
    //Another note: Things like EditText can save and restore their content implicitly provided you’ve set an id on the View.
    // Activity will automatically collect View’s State from every single View in the View hierarchy.

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putParcelable("parcelable", model);

        outState.putString("message", "This is a saved message");
        outState.putInt("counter", counter);
    }

    //Now we can retrieve these saved values in the onRestoreInstanceState method.
    //This method gets triggered only when something was saved in onSaveInstanceState method.
    //It gets called after onStart().

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Model model = savedInstanceState.getParcelable("parcelable");
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        counter = savedInstanceState.getInt("counter", 0);

        //you can use this or onCreate to restore the values
    }


}
