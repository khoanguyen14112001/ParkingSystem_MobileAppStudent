package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DialogNotificationAdapter;
import nguyenhoanganhkhoa.com.models.Notification;

public class AllNotificationScreen extends AppCompatActivity {

    DialogNotificationAdapter dialogNotificationAdapterRecents, dialogNotificationAdapterBefore;
//            dialogNotificationAdapterRecentsRead, dialogNotificationAdapterBeforeRead,
//            dialogNotificationAdapterUnread,
//            dialogNotificationAdapterAllRead;

    RecyclerView rcvDisplayRecentNotifications, rcvBeforeNotifications;
    ImageView imvBackNotifications;
    TextView txtMarkAllAsRead,txtRecent, txtBefore;
    RadioButton radNotificationAllRead, radNotificationAllUnread, radNotificationAllAll;

    private void linkView() {
        rcvDisplayRecentNotifications =findViewById(R.id.rcvDisplayAllNotifications);
        rcvBeforeNotifications =findViewById(R.id.rcvDisTest);
        imvBackNotifications = findViewById(R.id.imvBackNotifications);
        txtMarkAllAsRead = findViewById(R.id.txtMarkAllAsRead);
        radNotificationAllRead= findViewById(R.id.radNotificationAllRead);
        radNotificationAllUnread = findViewById(R.id.radNotificationAllUnread);
        radNotificationAllAll = findViewById(R.id.radNotificationAllAll);
        txtRecent = findViewById(R.id.txtRecent);
        txtBefore = findViewById(R.id.txtBefore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notification_screen);

        linkView();

        initAdapter(dialogNotificationAdapterRecents, rcvDisplayRecentNotifications,
                getListRecentNotification(),R.layout.item_notification_all_bold);
        initAdapter(dialogNotificationAdapterBefore, rcvBeforeNotifications,
                getListBeforeNotification(),R.layout.item_notification_all_bold);
        addEvents();



    }
    private int messageRead = 0;
    private void addEvents() {
        imvBackNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        radNotificationAllRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                /** Nháp
                 *  if(b)
                 *                 {
                 *                     txtMarkAllAsRead.setText(R.string.mark_all_as_unread);
                 *                     txtRecent.setVisibility(View.INVISIBLE);
                 *                     txtBefore.setVisibility(View.INVISIBLE);
                 *                     rcvBeforeNotifications.setVisibility(View.GONE);
                 *                     if(messageRead == 90)
                 *                     {
                 *                         rcvDisplayRecentNotifications.setVisibility(View.GONE);
                 *                     }
                 *                     else
                 *                     {
                 *                         initAdapter(dialogNotificationAdapterAllRead, rcvDisplayRecentNotifications,
                 *                                 getAllReadList(),R.layout.item_notification_all);
                 *                     }
                 *                 }
                 */

            }
        });
        radNotificationAllAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                /** Nháp
                 *  if(b)
                 *                 {
                 *                     txtMarkAllAsRead.setText(R.string.mark_all_as_read);
                 *                     txtRecent.setVisibility(View.VISIBLE);
                 *                     txtBefore.setVisibility(View.VISIBLE);
                 *                     rcvBeforeNotifications.setVisibility(View.VISIBLE);
                 *                     rcvDisplayRecentNotifications.setVisibility(View.VISIBLE);
                 *
                 *                     initAdapter(dialogNotificationAdapterRecents, rcvDisplayRecentNotifications,
                 *                             getListRecentNotification(),R.layout.item_notification_all_bold);
                 *                     initAdapter(dialogNotificationAdapterBefore, rcvBeforeNotifications,
                 *                             getListBeforeNotification(),R.layout.item_notification_all_bold);
                 *                 }
                 */

            }
        });
        radNotificationAllUnread.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                /**Nháp
                 * if(b)
                 *                 {
                 *                     getUnreadList();
                 *                     txtMarkAllAsRead.setText(R.string.mark_all_as_read);
                 *                     txtRecent.setVisibility(View.INVISIBLE);
                 *                     txtBefore.setVisibility(View.INVISIBLE);
                 *                     rcvBeforeNotifications.setVisibility(View.GONE);
                 *                     if(messageRead == 99)
                 *                     {
                 *                         rcvDisplayRecentNotifications.setVisibility(View.GONE);
                 *                     }
                 *                     else
                 *                     {
                 *                         rcvDisplayRecentNotifications.setVisibility(View.VISIBLE);
                 *                         initAdapter(dialogNotificationAdapterUnread, rcvDisplayRecentNotifications,
                 *                                 getUnreadList(),R.layout.item_notification_all_bold);
                 *                     }
                 *
                 *                 }
                 */
            }
        });


    }
    /** Chưa hiểu lắm, cần tìm hiểu thêm
     *
        private List<Notification> getListAllReadRecentNotification() {
        List<Notification> list = new ArrayList<>();

        for(int i =0; i<getListRecentNotification().size();i++)
        {
            list.add(new Notification(getListRecentNotification().get(i).getNotificationThumb(),
                    getListRecentNotification().get(i).getNotificationContent(),
                    getListRecentNotification().get(i).getNotificationDate()));

            int k = list.get(i).getNotificationThumb();
            if(k==R.drawable.ic_img_nomoney_notice_new)
            {

                list.get(i).setNotificationThumb(R.drawable.img_nomoney_notice);
            }

            if(k==R.drawable.img_newnotice)
            {
                list.get(i).setNotificationThumb(R.drawable.img_notice);
            }

        }
        return list;
    }
    private List<Notification> getListAllReadBeforeNotification() {
        List<Notification> list = new ArrayList<>();

        for(int i =0; i<getListBeforeNotification().size();i++)
        {
            list.add(new Notification(getListBeforeNotification().get(i).getNotificationThumb(),
                    getListBeforeNotification().get(i).getNotificationContent(),
                    getListBeforeNotification().get(i).getNotificationDate()));

            int k = list.get(i).getNotificationThumb();
            if(k==R.drawable.ic_img_nomoney_notice_new)
            {

                list.get(i).setNotificationThumb(R.drawable.img_nomoney_notice);
            }

            if(k==R.drawable.img_newnotice)
            {
                list.get(i).setNotificationThumb(R.drawable.img_notice);
            }

        }
        return list;
    }
    private List<Notification> getUnreadList() {
        List<Notification> list = new ArrayList<>();
        if(getListRecentNotification().size()!=0)
        {
            for(int i =0; i<getListRecentNotification().size();i++)
            {

                int k = getListRecentNotification().get(i).getNotificationThumb();
                if(k==R.drawable.ic_img_nomoney_notice_new)
                {

                    list.add(new Notification(getListRecentNotification().get(i).getNotificationThumb(),
                            getListRecentNotification().get(i).getNotificationContent(),
                            getListRecentNotification().get(i).getNotificationDate()));
                }

                if(k==R.drawable.img_newnotice)
                {
                    list.add(new Notification(getListRecentNotification().get(i).getNotificationThumb(),
                            getListRecentNotification().get(i).getNotificationContent(),
                            getListRecentNotification().get(i).getNotificationDate()));
                }

            }
        }
        if(getListBeforeNotification().size()!=0)
        {
            for(int i =0; i<getListBeforeNotification().size();i++)
            {

                int k = list.get(i).getNotificationThumb();
                if(k==R.drawable.ic_img_nomoney_notice_new)
                {

                    list.add(new Notification(getListBeforeNotification().get(i).getNotificationThumb(),
                            getListBeforeNotification().get(i).getNotificationContent(),
                            getListBeforeNotification().get(i).getNotificationDate()));
                }

                if(k==R.drawable.img_newnotice)
                {
                    list.add(new Notification(getListBeforeNotification().get(i).getNotificationThumb(),
                            getListBeforeNotification().get(i).getNotificationContent(),
                            getListBeforeNotification().get(i).getNotificationDate()));
                }

            }
        }
        else
            return list;
        return list;
    }
    private List<Notification> getAllReadList() {
        List<Notification> list = new ArrayList<>();
        if(getListRecentNotification().size()==0 &&getListBeforeNotification().size()==0 )
            return list;
        else
        {
            for(int i =0; i<getListRecentNotification().size();i++)
            {

                int k = getListRecentNotification().get(i).getNotificationThumb();
                if(k==R.drawable.img_nomoney_notice)
                {

                    list.add(new Notification(getListRecentNotification().get(i).getNotificationThumb(),
                            getListRecentNotification().get(i).getNotificationContent(),
                            getListRecentNotification().get(i).getNotificationDate()));
                }

                if(k==R.drawable.img_notice)
                {
                    list.add(new Notification(getListRecentNotification().get(i).getNotificationThumb(),
                            getListRecentNotification().get(i).getNotificationContent(),
                            getListRecentNotification().get(i).getNotificationDate()));
                }

            }
            for(int i =0; i<getListBeforeNotification().size();i++)
            {
                int k = getListBeforeNotification().get(i).getNotificationThumb();
                if(k==R.drawable.img_nomoney_notice)
                {

                    list.add(new Notification(getListBeforeNotification().get(i).getNotificationThumb(),
                            getListBeforeNotification().get(i).getNotificationContent(),
                            getListBeforeNotification().get(i).getNotificationDate()));
                }

                if(k==R.drawable.img_notice)
                {
                    list.add(new Notification(getListBeforeNotification().get(i).getNotificationThumb(),
                            getListBeforeNotification().get(i).getNotificationContent(),
                            getListBeforeNotification().get(i).getNotificationDate()));
                }

            }
        }

        return list;
    }
     */


    private void initAdapter(DialogNotificationAdapter dialogNotificationAdapter,RecyclerView rcv,
                             List<Notification> list, int layout) {
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
        list.add(new Notification(R.drawable.img_notice,"Due to the Christmas holiday, " +
                "the parking lot will not be open","23 Dec, 18:35"));



        return list;
    }
    private List<Notification> getListBeforeNotification() {
        List<Notification> list = new ArrayList<>();
        list.add(new Notification(R.drawable.img_newnotice,"The parking lot will be under " +
                "maintenance from 11 Nov to 14 Nov","13 Jan, 19:04"));
        list.add(new Notification(R.drawable.img_newnotice,"You currently do not have enough " +
                "money to pay, please top up","03 Nov, 17:05"));
        list.add(new Notification(R.drawable.img_newnotice,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.ic_img_nomoney_notice_new,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.ic_img_nomoney_notice_new,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.ic_img_nomoney_notice_new,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.img_nomoney_notice,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.img_nomoney_notice,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.img_nomoney_notice,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        list.add(new Notification(R.drawable.img_nomoney_notice,"You currently do not have enough " +
                "money to pay, please top up","01 Nov, 18:45"));
        return list;
    }


}