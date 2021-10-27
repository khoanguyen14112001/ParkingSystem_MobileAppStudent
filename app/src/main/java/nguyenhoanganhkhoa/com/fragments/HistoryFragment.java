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
        dateAdapter= new DateAdapter(getContext(),R.layout.item_history_recycleview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rcvDisplayHistoryAndDate.setLayoutManager(linearLayoutManager);

        dateAdapter.setData(getListDate());
        rcvDisplayHistoryAndDate.setAdapter(dateAdapter);


        return view;


    }

    private List<Date> getListDate() {
        List<Date> listMonth = new ArrayList<>();

        List<History> listHis1 = new ArrayList<>();
        List<History> listHis2 = new ArrayList<>();
        List<History> listHis3 = new ArrayList<>();

        listHis1.add(new History(R.drawable.img_green_bike,"Entry","21 Oct, 20:07"));
        listHis1.add(new History(R.drawable.img_red_bike,"Exit","20 Oct, 16:49"));
        listHis1.add(new History(R.drawable.img_green_bike,"Entry","20 Oct, 12:14"));
        listHis1.add(new History(R.drawable.img_red_bike,"Exit","06 Oct, 12:07"));
        listHis1.add(new History(R.drawable.img_green_bike,"Entry","06 Oct, 09:18"));
        listHis1.add(new History(R.drawable.img_red_bike,"Exit","04 Oct, 16:53"));
        listHis1.add(new History(R.drawable.img_green_bike,"Entry","04 Oct, 07:07"));

        listHis2.add(new History(R.drawable.img_red_bike,"Exit","29 Sep, 15:53"));
        listHis2.add(new History(R.drawable.img_green_bike,"Entry","29 Sep, 06:57"));
        listHis2.add(new History(R.drawable.img_red_bike,"Exit","27 Sep, 11:58"));
        listHis2.add(new History(R.drawable.img_green_bike,"Entry","27 Sep, 07:04"));
        listHis2.add(new History(R.drawable.img_red_bike,"Exit","24 Sep, 14:53"));

        listHis3.add(new History(R.drawable.img_green_bike,"Entry","24 Aug, 06:57"));
        listHis3.add(new History(R.drawable.img_red_bike,"Exit","22 Aug, 11:58"));
        listHis3.add(new History(R.drawable.img_green_bike,"Entry","22 Aug, 07:04"));
        listHis3.add(new History(R.drawable.img_red_bike,"Exit","20 Aug, 14:53"));
        listHis3.add(new History(R.drawable.img_green_bike,"Entry","20 Aug, 07:04"));




        listMonth.add(new Date("Oct 2021",listHis1));
        listMonth.add(new Date("Sep 2021",listHis2));
        listMonth.add(new Date("Aug 2021",listHis3));

        return listMonth;
    }
}