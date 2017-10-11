package test.practice.android_intent.lifecyclefragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.practice.R;
import test.practice.Utils;
import test.practice.android_intent.lifecycleactivity.FirstActivity;


/**
 * Created by parasmani.sharma on 10/12/2016.
 */
public class Fragmenttwo extends Fragment {

    private View view;
    private Button butfrag;
    private Button butfragthree;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmenttwo, container, false);

        System.out.println("...onCreateView..2.frag.");

        butfragthree = (Button) view.findViewById(R.id.butfragthree);
        butfragthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager manager = getFragmentManager();
                FragmentTransaction tran = manager.beginTransaction();
                tran.add(R.id.lytMain,new FragmentThree(), new FragmentThree().getClass().getName());
                tran.addToBackStack(new FragmentThree().getClass().getName());
                tran.commit();*/

                Utils.moveToFragment(getActivity(), new FragmentThree(),null,0);
            }
        });
        butfrag = (Button) view.findViewById(R.id.butfrag);
        butfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((FirstActivity)getContext()).onBackPressed();

            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("...onAttach..2.frag.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("...onCreate..2.frag.");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        System.out.println("...onActivityCreated..2.frag.");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("...onStart..2.frag.");

    }


    @Override
    public void onResume() {
        super.onResume();
        System.out.println("...onResume..2.frag.");
    }


    @Override
    public void onPause() {
        super.onPause();
        System.out.print("...onPause..2.frag.\n");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.print("...onStop..2.frag.\n");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.print("...onDestroyView..2.frag.\n");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.print("...onDestroy..2.frag.\n");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.print("...onDetach..2.frag.\n");
    }
}
