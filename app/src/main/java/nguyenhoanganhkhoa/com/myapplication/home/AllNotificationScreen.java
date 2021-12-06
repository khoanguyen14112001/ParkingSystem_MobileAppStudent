package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.DialogNotificationAdapter;
import nguyenhoanganhkhoa.com.models.Notification;
import nguyenhoanganhkhoa.com.myapplication.R;

public class AllNotificationScreen extends AppCompatActivity {

    ImageView imvBackNotifications;
    RadioButton radUnread, radAll, radTransaction, radFromAdmin;

    Fragment fragment = null;

    private void linkView() {

        imvBackNotifications = findViewById(R.id.imvBackNotifications);

        radUnread = findViewById(R.id.radNotificationAllUnread);
        radAll = findViewById(R.id.radNotificationAllAll);
        radFromAdmin = findViewById(R.id.radFromAdmin);
        radTransaction = findViewById(R.id.radTransaction);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notification_screen);

        linkView();

        inflateFragment();
        addEvents();

    }

    private void inflateFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragment = new AllNoticeFragment();

        fragmentTransaction.add(R.id.layout_notification, fragment);
        fragmentTransaction.commit();
    }


    private void changeFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_notification, fragment);
        fragmentTransaction.commit();
    }

    private void addEvents() {
        imvBackNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });

        radAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    changeFragment(new AllNoticeFragment());
                }
            }
        });
        radUnread.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    changeFragment(new UnreadFNoticeFragment());
                }
            }
        });

        radTransaction.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    changeFragment(new TransNoticeFragment());
                }
            }
        });

        radFromAdmin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    changeFragment(new FromAdminNoticeFragment());
                }
            }
        });


    }



}