package com.example.lockalarm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lockalarm.RoomDao.Alarm;
import com.example.lockalarm.RoomDao.AppDatabase;

import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter {

    private List<Alarm> arrayList;
    private Activity context;
    private AppDatabase database;

    public AlarmAdapter(Activity context, List<Alarm> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        notifyDataSetChanged();
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
        final Alarm data = arrayList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        database = AppDatabase.getDBInstance(context);

        //편집 클릭
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alarm alarm = arrayList.get(holder.getAdapterPosition());
                final int alarmID = alarm.getAlarm_id();
                String alarmTime = alarm.getAlarm_time();
                String alarmDate = alarm.getAlarm_date();
                String alarmLocation = alarm.getAlarm_location();

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.edit_box);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;

                dialog.getWindow().setLayout(width, height);
                dialog.show();

                final EditText editText_location = dialog.findViewById(R.id.edit_location2);
                final TextView textView_time = dialog.findViewById(R.id.tv_time2);
                final TextView textView_date = dialog.findViewById(R.id.tv_date2);

                editText_location.setText(alarmLocation);
                textView_time.setText(alarmTime);
                textView_date.setText(alarmDate);

            }
        });

        //삭제 롱클릭
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Alarm alarm = arrayList.get(holder.getAdapterPosition());
                database.alarmDao().alarmDelete(alarm);

                int position = holder.getAdapterPosition();
                arrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, arrayList.size());
                return false;
            }
        });


        viewHolder.location.setText(data.getAlarm_location());
        viewHolder.time.setText(data.getAlarm_time());
        viewHolder.date.setText(data.getAlarm_date());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView location;
        TextView time;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.location = itemView.findViewById(R.id.textView_location);
            this.time = itemView.findViewById(R.id.tv_time_item);
            this.date = itemView.findViewById(R.id.tv_date);

        }
    }

}
