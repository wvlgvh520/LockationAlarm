package com.example.lockalarm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter {

    private ArrayList<Alarm> arrayList;

    public AlarmAdapter(ArrayList<Alarm> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() { //데이터값 반환
        return arrayList.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {    //onCreateViewHolder
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_alarm, parent, false);
        AlarmAdapter.ViewHolder viewHolder = new AlarmAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {   //onBindViewholder
        Alarm data = arrayList.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;



        viewHolder.location.setText(data.getTv_location());
        viewHolder.hour.setText(data.getTv_hour());
        viewHolder.minute.setText(data.getTv_minute());
        viewHolder.date.setText(data.getTv_date());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView location;
        TextView hour;
        TextView minute;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.location = itemView.findViewById(R.id.textView_location);
            this.hour = itemView.findViewById(R.id.tv_hour);
            this.minute = itemView.findViewById(R.id.tv_minute);
            this.date = itemView.findViewById(R.id.tv_date);

        }
    }

}
