package test.practice.android_recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import test.practice.R;
import test.practice.android_recyclerview.model.DataValues;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class RecyclerViewActivity extends AppCompatActivity {



    private RecyclerView recyclerview;
    private ArrayList<DataValues> list;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        dataList();


    }

    private void setRecyclerAdapter() {

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(gridLayoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list, new RecyclerViewAdapter.IRecyclerViewHolderClicks() {
            @Override
            public void onClickRecyclerItem(View v, int position) {
                Toast.makeText(RecyclerViewActivity.this, "Clicked : " + position, Toast.LENGTH_LONG).show();
            }
        });


        recyclerview.setAdapter(adapter);

        /*recyclerview.addItemDecoration(new StickHeaderItemDecoration(
                this,0,true, new StickHeaderItemDecoration.SectionCallback(){
                    @NotNull
                    @Override
                    public String getSectionHeader(int position) {
                        return list.get(position).getName().toString();
                    }

                    @Override
                    public boolean isSection(int position) {
                        return true;
                    }
                }));*/


    }

    private void dataList() {

        list = new ArrayList<DataValues>();
        for (int i = 0; i < 20; i++) {
            list.add(new DataValues("asd  " + i, i+"sad@asd.asd"));
        }

        setRecyclerAdapter();
    }
}
