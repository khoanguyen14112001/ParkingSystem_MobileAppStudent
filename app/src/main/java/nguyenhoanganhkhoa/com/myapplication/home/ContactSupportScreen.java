package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DetailProTransAdapter;
import nguyenhoanganhkhoa.com.models.DetailProTrans;
import nguyenhoanganhkhoa.com.myapplication.R;

public class ContactSupportScreen extends AppCompatActivity {

    RecyclerView rcvContactSupport;
    DetailProTransAdapter adapter;

    ImageView imvBack;

    private void linkView() {
        rcvContactSupport = findViewById(R.id.rcvContactSupport);
        imvBack = findViewById(R.id.imvBack);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_support_screen);

        linkView();
        initAdapter();
        addEvents();

    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initAdapter() {
        adapter = new DetailProTransAdapter(this,R.layout.item_detail_problem_trans);
        adapter.setData(getListProblem());

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvContactSupport.setLayoutManager(manager);
        rcvContactSupport.setAdapter(adapter);
    }

    private List<DetailProTrans> getListProblem() {
        List<DetailProTrans> list = new ArrayList<>();
        list.add(new DetailProTrans("This is not my entry and exit history"));
        list.add(new DetailProTrans("There is confusion between entry and exit"));
        list.add(new DetailProTrans("Datetime format incorrect"));
        list.add(new DetailProTrans("I do not want to receive notification history about my parking"));

        return list;
    }
}