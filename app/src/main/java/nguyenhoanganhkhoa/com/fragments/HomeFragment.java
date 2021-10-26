package nguyenhoanganhkhoa.com.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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

import nguyenhoanganhkhoa.com.adapter.TransactionAdapter;
import nguyenhoanganhkhoa.com.models.Transaction;
import nguyenhoanganhkhoa.com.myapplication.AllNotificationScreen;
import nguyenhoanganhkhoa.com.myapplication.CustomDialog;
import nguyenhoanganhkhoa.com.myapplication.HomePageScreen;
import nguyenhoanganhkhoa.com.myapplication.QRCodeScreen;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.ShowAllTransactionScreen;

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

    TransactionAdapter transactionAdapter;
    ListView lvHistoryTrans;
    TextView txtSeeAllTrans;
    ImageButton btnQRCodeHome;
    ImageView imvNoteBell;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lvHistoryTrans = view.findViewById(R.id.lvHistoryTrans);
        txtSeeAllTrans = view.findViewById(R.id.txtSeeAllTrans);
        btnQRCodeHome = view.findViewById(R.id.btnQRCodeHome);
        imvNoteBell = view.findViewById(R.id.imvNoteBell);


        // Xử lý sự kiện
        initData();
        addEvents();

        return view;


    }

    private void addEvents() {
        txtSeeAllTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShowAllTransactionScreen.class);
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
                    }
                });
                customDialogFragment.show();
            }
        });



    }


    private void initData() {
        transactionAdapter = new TransactionAdapter(getContext(),R.layout.item_transaction,getTransactionList());
        lvHistoryTrans.setAdapter(transactionAdapter);
    }


    private List<Transaction> getTransactionList() { List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("Top up","20 Oct, 10:07","+50.000",R.drawable.ic_topup));
        list.add(new Transaction("Parking payment","10 Oct, 16:19","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Withdraw","08 Oct, 20:59","-30.000",R.drawable.ic_withdraw));
        list.add(new Transaction("Parking payment","01 Oct, 12:09","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Parking payment","29 Sep, 15:08","-3.000",R.drawable.ic_bike));
        list.add(new Transaction("Top up","20 Sep, 19:07","+10.000",R.drawable.ic_topup));
//        list.add(new Transaction("Top up","19 Sep, 11:06","+70.000",R.drawable.ic_topup));
//        list.add(new Transaction("Parking payment","11 Sep, 16:18","-3.000",R.drawable.ic_bike));
//        list.add(new Transaction("Withdraw","08 Sep, 20:59","-10.000",R.drawable.ic_withdraw));
//        list.add(new Transaction("Parking payment","30 Aug, 12:04","-3.000",R.drawable.ic_bike));
//        list.add(new Transaction("Parking payment","29 Aug, 15:03","-3.000",R.drawable.ic_bike));
//        list.add(new Transaction("Top up","20 Aug, 18:08","+30.000",R.drawable.ic_topup));
        return list;
    }




}