package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DialogNotificationAdapter;
import nguyenhoanganhkhoa.com.models.Notification;

public class AllNotificationScreen extends AppCompatActivity {

    DialogNotificationAdapter dialogNotificationAdapterRecents, dialogNotificationAdapterBefore;
    RecyclerView rcvDisplayRecentNotifications, rcvBeforeNotifications;
    ImageView imvBackNotifications;

    private void linkView() {
        rcvDisplayRecentNotifications =findViewById(R.id.rcvDisplayAllNotifications);
        rcvBeforeNotifications =findViewById(R.id.rcvDisTest);
        imvBackNotifications = findViewById(R.id.imvBackNotifications);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notification_screen);

        linkView();
        initAdapter(dialogNotificationAdapterRecents, rcvDisplayRecentNotifications,
                getListRecentNotification(),R.layout.item_notification_all_bold);
        initAdapter(dialogNotificationAdapterBefore, rcvBeforeNotifications,
                getListBeforeNotification(),R.layout.item_notification_all);
        addEvents();


    }

    private void addEvents() {
        imvBackNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initAdapter(DialogNotificationAdapter dialogNotificationAdapter,RecyclerView rcv, List<Notification> list, int layout) {
        dialogNotificationAdapter = new DialogNotificationAdapter(this,layout);
        rcv.setAdapter(dialogNotificationAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);

        dialogNotificationAdapter.setData(list);
        rcv.setAdapter(dialogNotificationAdapter);

    }
    private List<Notification> getListRecentNotification() {
        List<Notification> list = new ArrayList<>();
        list.add(new Notification(R.drawable.img_newnotice,"The parking lot will be under " +
                "maintenance from 14, Jan to 20, Jan","13 Jan, 19:04"));
        list.add(new Notification(R.drawable.img_newnotice,"Due to the Christmas holiday, " +
                "the parking lot will not be open","23 Dec, 18:35"));
        return list;
    }

    private List<Notification> getListBeforeNotification() {
        List<Notification> list = new ArrayList<>();
        list.add(new Notification(R.drawable.img_notice,"The parking lot will be under " +
                "maintenance from 11 Nov to 14 Nov","13 Jan, 19:04"));
        list.add(new Notification(R.drawable.img_nomoney_notice,"You currently do not have enough " +
                "money to pay, please top up","03 Nov, 17:05"));
        list.add(new Notification(R.drawable.img_nomoney_notice,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        return list;
    }


}