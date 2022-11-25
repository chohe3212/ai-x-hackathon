package my.ai_x_hackathon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;

import java.util.ArrayList;


public class StoreFragment extends Fragment{

    private ArrayList<my.ai_x_hackathon.StoreList> StoreList = new ArrayList<my.ai_x_hackathon.StoreList>();
    private RecyclerView recyclerView;
    StoreAdapter mAdapter;
    private EditText SearchET;
    public MapFragment mapFragment1;
    ArrayList<StoreList> search_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 수정필요!! (임의로 추가한거임. api에서 받아서 넣어야함)
        StoreList.add(new StoreList("경복궁","궁궐","매일 09:00 - 17:00",R.drawable.k_1,R.drawable.k_2,R.drawable.k_3,37.579548,126.977047));
        StoreList.add(new StoreList("국립민속박물관","박물관","매일 09:00 - 17:00",R.drawable.b_1,R.drawable.b_2,R.drawable.b_3,37.581841,126.979041));
        StoreList.add(new StoreList("갤러리현대","갤러리,화랑","화~일 10:00 - 18:00",R.drawable.h_1,R.drawable.h_2,R.drawable.h_3,37.577272,126.979893));
        StoreList.add(new StoreList("쌈지길","복합문화공간","매일 10:30 - 20:30",R.drawable.s_1,R.drawable.s_2,R.drawable.s_3,37.574164,126.984877));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_store, container, false);
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) v.findViewById(R.id.store_recycle);
        SearchET = (EditText) v.findViewById(R.id.edit_store_Search);
        mapFragment1 = new MapFragment();
        SearchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = SearchET.getText().toString();
                //searchFilter(searchText);
                search_list.clear();

                if(searchText.equals("")) {
                    mAdapter.setItems(StoreList);
                }else {
                    for(int a=0; a< StoreList.size(); a++) {
                        if (StoreList.get(a).getStore_address().toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(StoreList.get(a));
                        }
                        mAdapter.setItems(search_list);
                    }
                }

            }
        });

        mAdapter = new StoreAdapter(StoreList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return v;
    }


}