package nguyenhoanganhkhoa.com.myapplication.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopUpQRCodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopUpQRCodeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopUpQRCodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopUpQRCodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopUpQRCodeFragment newInstance(String param1, String param2) {
        TopUpQRCodeFragment fragment = new TopUpQRCodeFragment();
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

    TextView txtTimeMomo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_up_qr_code, container, false);
        linkView(view);
        addEvents();
        return view;
    }

    private void addEvents() {
        ReusedConstraint reusedConstraint = new ReusedConstraint(getContext());
        reusedConstraint.addTimer(txtTimeMomo,240000);
    }

    private void linkView(View view) {
        txtTimeMomo = view.findViewById(R.id.txtTimeMomo);
    }
}