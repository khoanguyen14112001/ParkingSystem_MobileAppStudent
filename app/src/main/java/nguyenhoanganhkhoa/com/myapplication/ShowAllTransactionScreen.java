package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DateAdapter;
import nguyenhoanganhkhoa.com.adapter.MonthTransAdapter;
import nguyenhoanganhkhoa.com.models.Date;
import nguyenhoanganhkhoa.com.models.History;
import nguyenhoanganhkhoa.com.models.Month;
import nguyenhoanganhkhoa.com.models.Transaction;

public class ShowAllTransactionScreen extends AppCompatActivity {

    RecyclerView rcvDisplayTransaction;
    MonthTransAdapter monthTransAdapter;
    ImageView imvAllTransBack;


    private void linkView() {
        imvAllTransBack= findViewById(R.id.imvAllTransBack);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_transaction_screen);

        linkView();
        initAdapter();
        addEvents();

    }

    private void addEvents() {
        imvAllTransBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initAdapter() {
        rcvDisplayTransaction = findViewById(R.id.rcvDisplayTransaction);
        monthTransAdapter= new MonthTransAdapter(ShowAllTransactionScreen.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowAllTransactionScreen.this,RecyclerView.VERTICAL,false);
        rcvDisplayTransaction.setLayoutManager(linearLayoutManager);

        monthTransAdapter.setData(getListMonth());
        rcvDisplayTransaction.setAdapter(monthTransAdapter);
    }

    private List<Month> getListMonth() {
        List<Month> listMonth = new ArrayList<>();

        List<Transaction> listHis1 = new ArrayList<>();
        List<Transaction> listHis2 = new ArrayList<>();
        List<Transaction> listHis3 = new ArrayList<>();

        listHis1.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis1.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis1.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis2.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis2.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis2.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis3.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis3.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis3.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));
        listHis3.add(new Transaction("Top up","123123","+1232131231",R.drawable.ic_topup));


        listMonth.add(new Month("Oct 12",listHis1));
        listMonth.add(new Month("Sep 12",listHis2));
        listMonth.add(new Month("Aug 12",listHis3));

        return listMonth;
    }


}