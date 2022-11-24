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
import android.widget.EditText;
import my.ai_x_hackathon.R;

import java.util.ArrayList;

public class InfoFragment extends Fragment {
    private ArrayList<InfoList> InfoList = new ArrayList<>();
    private RecyclerView recyclerView;
    InfoAdapter mAdapter;
    EditText SearchET;
    ArrayList<InfoList> search_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 수정필요!! (임의로 추가한거임. db에서 받아서 넣어야함)
        InfoList.add(new InfoList("율곡로 3길","ex) 위험"));
        InfoList.add(new InfoList("북촌로 5가길","ex) 안전"));
        InfoList.add(new InfoList("계동길","ex) 보통"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info,container,false);

        SearchET = (EditText) v.findViewById(R.id.edit_Search);
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
                    mAdapter.setItems(InfoList);
                }else {
                    for(int a=0; a< InfoList.size(); a++) {
                        if (InfoList.get(a).getAddress().toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(InfoList.get(a));
                        }
                        mAdapter.setItems(search_list);
                    }
                }

            }
        });
        recyclerView = (RecyclerView) v.findViewById(R.id.inforecycle);
        //recyclerView.setHasFixedSize(true);
        mAdapter = new InfoAdapter(InfoList);

        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        //recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return v;
    }
}