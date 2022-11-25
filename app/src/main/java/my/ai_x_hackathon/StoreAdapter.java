package my.ai_x_hackathon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder>{
    private ArrayList<StoreList> mDataset;
    onItemClickListener OnItemClickListener;

    StoreFragment storeFragment = new StoreFragment();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_address;
        public TextView text1;
        public TextView text2;
        public ImageView imageView1;
        public ImageView imageView2;
        public ImageView imageView3;
        //public ImageButton btn_gotomap;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_address = itemView.findViewById(R.id.store_text_address);
            text1 = itemView.findViewById(R.id.textView_store1);
            text2 = itemView.findViewById(R.id.textView_store2);
            cardView = itemView.findViewById(R.id.store_cardview);
            imageView1 = itemView.findViewById(R.id.store_imageview1);
            imageView2 = itemView.findViewById(R.id.store_imageview2);
            imageView3 = itemView.findViewById(R.id.store_imageview3);
            //btn_gotomap = itemView.findViewById(R.id.btn_to_map);
            //mClick = (OnItemClick)btn_gotomap;
        }
    }
    public StoreAdapter(ArrayList<StoreList> myData) {
        this.mDataset = myData;
        //this.mClick = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.store_cardview, parent, false);
        return new StoreAdapter.MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text_address.setText(mDataset.get(holder.getAdapterPosition()).getStore_address());
        holder.text1.setText(mDataset.get(holder.getAdapterPosition()).getStore_text1());
        holder.text2.setText(mDataset.get(holder.getAdapterPosition()).getStore_text2());
        holder.imageView1.setImageResource(mDataset.get(holder.getAdapterPosition()).getImage1());
        holder.imageView2.setImageResource(mDataset.get(holder.getAdapterPosition()).getImage2());
        holder.imageView3.setImageResource(mDataset.get(holder.getAdapterPosition()).getImage3());

//        holder.btn_gotomap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //mClick.onClick(mDataset.get(holder.getAdapterPosition()).getLa(),mDataset.get(holder.getAdapterPosition()).getLo());
//            }
//        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setItems(ArrayList<StoreList> list) {
        mDataset = list;
        notifyDataSetChanged();
    }
}
