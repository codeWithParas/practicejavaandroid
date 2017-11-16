package test.practice.android_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import test.practice.R;
import test.practice.android_recyclerview.model.DataValues;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final ArrayList<DataValues> list;
    private final Context context;
    private final IRecyclerViewHolderClicks l;

    public RecyclerViewAdapter(Context context, ArrayList<DataValues> list, IRecyclerViewHolderClicks l) {

        this.list = list;
        this.context = context;
        this.l = l;

    }

    public static interface IRecyclerViewHolderClicks {
        public void onClickRecyclerItem(View v, int position);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txt.setText(list.get(position).getName() + "\n" + list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt = (TextView) itemView.findViewById(R.id.txt);

        }
    }
}
