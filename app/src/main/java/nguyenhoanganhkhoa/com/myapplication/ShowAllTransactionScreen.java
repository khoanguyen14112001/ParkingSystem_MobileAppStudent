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

        List<Transaction> listTrans1 = new ArrayList<>();
        List<Transaction> listTrans2 = new ArrayList<>();
        List<Transaction> listTrans3 = new ArrayList<>();
        List<Transaction> listTrans4 = new ArrayList<>();

        listTrans1.add(new Transaction("Top up","20 Oct, 10:07 ","+50.000",R.drawable.ic_topup));
        listTrans1.add(new Transaction("Parking payment","10 Oct, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans1.add(new Transaction("Parking payment","09 Oct, 16:19 ","-3.000",R.drawable.ic_bike));

        listTrans2.add(new Transaction("Parking payment","20 Sep, 10:07 ","-3.000",R.drawable.ic_bike));
        listTrans2.add(new Transaction("Parking payment","10 Sep, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans2.add(new Transaction("Parking payment","09 Sep, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans2.add(new Transaction("Parking payment","08 Sep, 16:19 ","-3.000",R.drawable.ic_bike));

        listTrans3.add(new Transaction("Parking payment","20 Aug, 10:07 ","-3.000",R.drawable.ic_topup));
        listTrans3.add(new Transaction("Parking payment","10 Aug, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans3.add(new Transaction("Parking payment","09 Aug, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans3.add(new Transaction("Parking payment","08 Aug, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans3.add(new Transaction("Top up","07 Aug, 16:19 ","+20.000",R.drawable.ic_topup));


        listTrans4.add(new Transaction("Parking payment","20 July, 10:07 ","-3.000",R.drawable.ic_bike));
        listTrans4.add(new Transaction("Parking payment","10 July, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans4.add(new Transaction("Parking payment","09 July, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans4.add(new Transaction("Parking payment","08 July, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans4.add(new Transaction("Top up","07 July, 16:19 ","+20.000",R.drawable.ic_topup));
        listTrans4.add(new Transaction("Parking up","06 July, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans4.add(new Transaction("Parking up","05 July, 16:19 ","-3.000",R.drawable.ic_bike));
        listTrans4.add(new Transaction("Top up","04 July, 16:19 ","+20.000",R.drawable.ic_topup));




        listMonth.add(new Month("Oct 2021",listTrans1));
        listMonth.add(new Month("Sep 2021",listTrans2));
        listMonth.add(new Month("Aug 2021",listTrans3));
        listMonth.add(new Month("July 2021",listTrans4));

        return listMonth;
    }


}