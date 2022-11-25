package my.ai_x_hackathon;

import android.app.Dialog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.Inflater;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
    private ArrayList<InfoList> mDataset;
    onItemClickListener OnItemClickListener;
    Button btn;
    BarChart barchart;


    InfoFragment infoFragment = new InfoFragment();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_address;
        public TextView text_danger;
        public ImageView street_image;
        CardView cardView;

        public MyViewHolder(View view, onItemClickListener onItemClickListener){
            super(view);
            text_address = view.findViewById(R.id.info_text_address);
            text_danger = view.findViewById(R.id.info_text_danger);
            cardView = view.findViewById(R.id.info_cardview);
            street_image = view.findViewById(R.id.imageView_street);
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


    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.MyViewHolder holder, int position) {
                                                             // int position에있는 오류 걍 무시해여

        holder.text_address.setText(mDataset.get(holder.getAdapterPosition()).getAddress());
        holder.text_danger.setText(mDataset.get(holder.getAdapterPosition()).getDanger());
        holder.street_image.setImageResource(mDataset.get(holder.getAdapterPosition()).getImage_street());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                Dialog dialog = new Dialog(view.getRootView().getContext());
                dialog.setContentView(R.layout.graph);
                btn = dialog.findViewById(R.id.button_ok);
                barchart = dialog.findViewById(R.id.barchart);

                ArrayList Bar_list = new ArrayList();
//                for(int i = 5; i<24 ; i++)
//                {
//                    Bar_list.add(new BarEntry(i,30));
//                }
                Bar_list.add(new BarEntry(5,30));
                Bar_list.add(new BarEntry(6,-20));
                Bar_list.add(new BarEntry(7,30));
                Bar_list.add(new BarEntry(8,80));
                Bar_list.add(new BarEntry(9,30));
                Bar_list.add(new BarEntry(10,-10));

                BarDataSet barDataSet = new BarDataSet(Bar_list,"People");

                BarData data = new BarData(barDataSet);
                barchart.setTouchEnabled(false);
                barchart.animateY(1000);
                barchart.setData(data);


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                dialog.show();

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
