package my.ai_x_hackathon;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.Inflater;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
    private ArrayList<InfoList> mDataset;
    onItemClickListener OnItemClickListener;
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    InfoFragment infoFragment = new InfoFragment();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_address;
        public TextView text_danger;
        TextView text_time;
        CardView cardView;

        public MyViewHolder(View view, onItemClickListener onItemClickListener){
            super(view);
            text_address = view.findViewById(R.id.info_text_address);
            text_danger = view.findViewById(R.id.info_text_danger);
            text_time = view.findViewById(R.id.text_info_time);
            cardView = view.findViewById(R.id.info_cardview);
        }
    }
    public InfoAdapter(ArrayList<InfoList> myData) {
        this.mDataset = myData;
    }

    @NonNull
    @Override
    public InfoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.info_cardview, parent, false);
        return new MyViewHolder(item, OnItemClickListener);
    }

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }
    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.MyViewHolder holder, int position) {
                                                             // int position에있는 오류 걍 무시해여

        holder.text_address.setText(mDataset.get(holder.getAdapterPosition()).getAddress());
        holder.text_danger.setText(mDataset.get(holder.getAdapterPosition()).getDanger());
        String time = mDataset.get(position).getTime();

        // 시간 설정하기

        holder.text_time.setText(getTime());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                // 그래프 보여주기
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setItems(ArrayList<InfoList> list) {
        mDataset = list;
        notifyDataSetChanged();
    }
}
