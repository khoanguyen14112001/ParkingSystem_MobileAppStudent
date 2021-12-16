package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DetailProTransAdapter;
import nguyenhoanganhkhoa.com.models.DetailProTrans;
import nguyenhoanganhkhoa.com.myapplication.R;

public class DetailTransaction extends AppCompatActivity {

    RecyclerView rcvDetailProblem;
    DetailProTransAdapter adapter;
    ImageView imvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaction);

        linkView();
        initAdapter();
        addEvents();

    }

    private void initAdapter() {
        adapter = new DetailProTransAdapter(this,R.layout.item_detail_problem_trans);
        adapter.setData(getListProDetail());

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvDetailProblem.setLayoutManager(manager);

        rcvDetailProblem.setAdapter(adapter);

    }

    private List<DetailProTrans> getListProDetail() {
        List<DetailProTrans> list = new ArrayList<>();
        list.add(new DetailProTrans("I want to cancel the wrong top up"));
        list.add(new DetailProTrans("Fund transfer status is successful but my balance does not increase"));
        list.add(new DetailProTrans("E-wallet account is deducted 2 times for this transaction"));
        list.add(new DetailProTrans("E-wallet account has been deducted but myParking account has not changed"));

        return list;

    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void linkView() {
        rcvDetailProblem = findViewById(R.id.rcvDetailProblem);
        imvBack = findViewById(R.id.imvBack);
    }
}