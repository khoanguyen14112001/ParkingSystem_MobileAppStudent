package nguyenhoanganhkhoa.com.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import nguyenhoanganhkhoa.com.myapplication.home.EditInfomationScreen;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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

    ImageView imvChangeProfile;
    TextView txtDateOfBirthIns,txtFacultyIns, txtMajorIns, txtPhoneIns, txtNameIns,txtGender, txtIDIns ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        linkView(view);
        addEvents();
        return view;
    }



    //    private Bundle getData(){
//        Bundle bundle = new Bundle();
//        if(bundle!=null)
//        {
//            txtDateOfBirthIns.setText(bundle.getString(AppUtil.DATE_OF_BIRTH));
//            txtFacultyIns.setText(bundle.getString(AppUtil.FACULTY));
//            txtMajorIns.setText(bundle.getString(AppUtil.MAJOR));
//            txtPhoneIns.setText(bundle.getString(AppUtil.PHONE));
//            txtNameIns.setText(bundle.getString(AppUtil.NAME));
//            txtGender.setText(bundle.getString(AppUtil.GENDER));
//            txtIDIns.setText(bundle.getString(AppUtil.ID));
//        }
//        return bundle;
//
//
//    }
    private void pushData(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString(AppUtil.DATE_OF_BIRTH,txtDateOfBirthIns.getText().toString());
        bundle.putString(AppUtil.FACULTY,txtFacultyIns.getText().toString());
        bundle.putString(AppUtil.MAJOR,txtMajorIns.getText().toString());
        bundle.putString(AppUtil.PHONE,txtPhoneIns.getText().toString());
        bundle.putString(AppUtil.NAME,txtNameIns.getText().toString());
        bundle.putString(AppUtil.GENDER,txtGender.getText().toString());
        bundle.putString(AppUtil.ID,txtIDIns.getText().toString());
        intent.putExtra("my_bundle",bundle);
    }

    private void linkView(View view) {
        imvChangeProfile = view.findViewById(R.id.imvChangeProfile);
        txtDateOfBirthIns = view.findViewById(R.id.txtDateOfBirthIns);
        txtFacultyIns = view.findViewById(R.id.txtFacultyIns);
        txtMajorIns = view.findViewById(R.id.txtMajorIns);
        txtPhoneIns = view.findViewById(R.id.txtPhoneIns);
        txtNameIns = view.findViewById(R.id.txtNameIns);
        txtGender = view.findViewById(R.id.txtGender);
        txtIDIns = view.findViewById(R.id.txtIDIns);

    }

    private void addEvents() {
        imvChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditInfomationScreen.class);
                pushData(intent);
                startActivity(intent);
            }
        });

    }


}