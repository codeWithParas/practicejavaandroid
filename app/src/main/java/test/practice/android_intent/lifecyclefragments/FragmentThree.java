package test.practice.android_intent.lifecyclefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.practice.R;
import test.practice.android_intent.lifecycleactivity.FirstActivity;

/**
 * Created by parasmani.sharma on 10/12/2016.
 */
public class FragmentThree extends Fragment {

    private View view;
    private Button butfrag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragthree,container,false);

        butfrag = (Button) view.findViewById(R.id.butfrag);
        butfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((FirstActivity)getContext()).onBackPressed();

            }
        });

        return view;
    }
}
