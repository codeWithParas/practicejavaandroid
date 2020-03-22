package test.practice.android_animation.animate_transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import test.practice.R;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class AndroidAnimationActivity extends AppCompatActivity {

    private ViewGroup transitionsContainer;
    private TextView text;
    private Button button;

    /*
    * Refer : https://medium.com/@andkulikov/animate-all-the-things-transitions-in-android-914af5477d50
    *
    * */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_animation);

        transitionsContainer = (ViewGroup)findViewById(R.id.transitions_container);
        text = (TextView) transitionsContainer.findViewById(R.id.text);
        button = (Button) transitionsContainer.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);
            }

        });

    }
}
