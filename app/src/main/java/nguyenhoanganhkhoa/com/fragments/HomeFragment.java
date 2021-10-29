package nguyenhoanganhkhoa.com.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.TransAllAdapter;
import nguyenhoanganhkhoa.com.models.Transaction;
import nguyenhoanganhkhoa.com.myapplication.AllNotificationScreen;
import nguyenhoanganhkhoa.com.myapplication.CustomDialog;
import nguyenhoanganhkhoa.com.myapplication.HomePageScreen;
import nguyenhoanganhkhoa.com.myapplication.QRCodeScreen;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.ShowAllTransactionScreen;
import nguyenhoanganhkhoa.com.myapplication.TopUpScreen;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    TransAllAdapter transAllAdapter;
    RecyclerView rcvHistoryTrans;
    TextView txtSeeAllTrans;
    ImageButton btnQRCodeHome,btnTopUpHome;
    ImageView imvNoteBell, btnAboutUs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        linkView(view);

        // Xử lý sự kiện
        initData();
        addEvents();
        return view;


    }

    private void linkView(View view) {
        rcvHistoryTrans = view.findViewById(R.id.rcvHistoryTrans);
        txtSeeAllTrans = view.findViewById(R.id.txtSeeAllTrans);
        btnQRCodeHome = view.findViewById(R.id.btnQRCodeHome);
        imvNoteBell = view.findViewById(R.id.imvNoteBell);
        btnTopUpHome = view.findViewById(R.id.btnTopUpHome);
        btnAboutUs = view.findViewById(R.id.btnAboutUs);
    }

    private void addEvents() {
//        btnAboutUs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), AboutUsScreen.class);
//                startActivity(intent);
//            }
//        });
        txtSeeAllTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShowAllTransactionScreen.class);
                startActivity(intent);
            }
        });

        btnTopUpHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TopUpScreen.class);
                startActivity(intent);
            }
        });

        btnQRCodeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QRCodeScreen.class);
                startActivity(intent);
            }
        });

        imvNoteBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogFragment customDialogFragment = new CustomDialogFragment(getActivity(),R.layout.custom_dialog_notification);
                customDialogFragment.btnSeeAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), AllNotificationScreen.class);
                        startActivity(intent);
                        customDialogFragment.dismiss();
                    }
                });
                customDialogFragment.show();
            }
        });



    }


    private void initData() {
        transAllAdapter = new TransAllAdapter();
        transAllAdapter.setData(getTransactionList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rcvHistoryTrans.setLayoutManager(linearLayoutManager);

        rcvHistoryTrans.setAdapter(transAllAdapter);
    }


    private List<Transaction> getTransactionList() { List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("Top up","20 Oct, 10:07 ","+50.000",R.drawable.ic_topup));
        list.add(new Transaction("Parking payment","10 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","09 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","08 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","07 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","06 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","05 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","04 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","03 Oct, 16:19 ","-3.000",R.drawable.ic_bike));

        return list;
    }




}