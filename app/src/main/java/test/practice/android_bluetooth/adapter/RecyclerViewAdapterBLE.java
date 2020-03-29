package test.practice.android_bluetooth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import test.practice.R;
import test.practice.android_bluetooth.model.BluetoothDeviceProperties;

/**
 * Created by parasmani.sharma on 22/12/2017.
 */

public class RecyclerViewAdapterBLE extends RecyclerView.Adapter<RecyclerViewAdapterBLE.MyViewHolder> {

    private final IRecyclerViewHolderClicks iRecyclerClicks;
    private final Context context;
    private final ArrayList<BluetoothDeviceProperties> bleDeviceProp;

    public RecyclerViewAdapterBLE(ArrayList<BluetoothDeviceProperties> bleDeviceProp, Context context, IRecyclerViewHolderClicks i) {

        this.bleDeviceProp = bleDeviceProp;
        this.context = context;
        this.iRecyclerClicks = i;

    }

    public static interface IRecyclerViewHolderClicks {
        public void onClickRecyclerItem(int position, String deviceName, String deviceAddress);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        RecyclerViewAdapterBLE.MyViewHolder vh = new RecyclerViewAdapterBLE.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txt.setText( bleDeviceProp.get(position).getDeviceName()+ "\n" + bleDeviceProp.get(position).getDeviceHardwareAddress() );
        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iRecyclerClicks.onClickRecyclerItem(position,bleDeviceProp.get(position).getDeviceName(), bleDeviceProp.get(position).getDeviceHardwareAddress());
            }
        });
    }


    @Override
    public int getItemCount() {
        return bleDeviceProp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt = (TextView) itemView.findViewById(R.id.txt);

        }
    }
}
