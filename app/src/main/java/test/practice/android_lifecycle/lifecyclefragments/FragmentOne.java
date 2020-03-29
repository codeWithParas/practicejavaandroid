package test.practice.android_lifecycle.lifecyclefragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import test.practice.R;
import test.practice.Utils;

/**
 * Created by parasmani.sharma on 10/12/2016.
 */
public class FragmentOne extends Fragment {

    private View view;
    private Button but_frag2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragmentone,container, false);

        System.out.println("...onCreateView..1 Fragment.");

        but_frag2 = (Button) view.findViewById(R.id.but_frag2);
        but_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*FragmentManager manager = getFragmentManager();
                FragmentTransaction tran = manager.beginTransaction();
                tran.add(R.id.lytMain, new Fragmenttwo(), new Fragmenttwo().getClass().getName());
                tran.addToBackStack(new Fragmenttwo().getClass().getName());
                tran.commit();*/

                Utils.moveToFragment(getActivity(), new Fragmenttwo(),null,0);

            }
        });

        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("...onAttach..1.Fragment.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("...onCreate..1.Fragment.");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        System.out.println("...onActivityCreated..1.Fragment.");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("...onStart..1.Fragment.");

    }


    @Override
    public void onResume() {
        super.onResume();
        System.out.println("...onResume..1.Fragment.");
    }


    @Override
    public void onPause() {
        super.onPause();
        System.out.println("...onPause..1.Fragment.");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("...onStop..1.Fragment.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("...onDestroyView..1.Fragment.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("...onDestroy..1.Fragment.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("...onDetach..1.Fragment.");
    }
}
