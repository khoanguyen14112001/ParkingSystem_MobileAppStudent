package nguyenhoanganhkhoa.com.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DateAdapter;
import nguyenhoanganhkhoa.com.models.Date;
import nguyenhoanganhkhoa.com.models.History;
import nguyenhoanganhkhoa.com.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    SearchView svHistory;
    RecyclerView rcvDisplayHistoryAndDate;
    DateAdapter dateAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_history, container, false);

        rcvDisplayHistoryAndDate = view.findViewById(R.id.rcvDisplayHistoryAndDate);
        dateAdapter= new DateAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rcvDisplayHistoryAndDate.setLayoutManager(linearLayoutManager);

        dateAdapter.setData(getListDate());
        rcvDisplayHistoryAndDate.setAdapter(dateAdapter);


        return view;


    }

    private List<Date> getListDate() {
        List<Date> listDate = new ArrayList<>();

        List<History> listHis = new ArrayList<>();
        listHis.add(new History(R.drawable.img_red_bike,"Exit","20/124/2012"));
        listHis.add(new History(R.drawable.img_red_bike,"E14xit","20/11240/1242012"));
        listHis.add(new History(R.drawable.img_red_bike,"Ex124it","20/10112424/2012"));
        listHis.add(new History(R.drawable.img_red_bike,"Ex112424it","20/10124/2012"));
        listHis.add(new History(R.drawable.img_red_bike,"Ex124it","20/1240/2012"));
        listHis.add(new History(R.drawable.img_red_bike,"Ex14it","20/1120/2012"));
        listHis.add(new History(R.drawable.img_red_bike,"Ex14it","20/1120/2012"));
        listHis.add(new History(R.drawable.img_red_bike,"Ex2it","20/410/2012"));

        listDate.add(new Date("14/12/2021",listHis));
        listDate.add(new Date("14/12/2022",listHis));
        listDate.add(new Date("14/12/2031",listHis));
        listDate.add(new Date("14/12/20141",listHis));
        listDate.add(new Date("14/12/20411",listHis));
        listDate.add(new Date("14/12/20231",listHis));

        return listDate;
    }
}