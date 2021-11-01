package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.MemberAdapter;
import nguyenhoanganhkhoa.com.adapter.TransAllAdapter;
import nguyenhoanganhkhoa.com.models.Member;
import nguyenhoanganhkhoa.com.models.Transaction;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class AboutUsScreen extends AppCompatActivity {
    RecyclerView rcvListMemberTeam;
    MemberAdapter memberAdapter;
    TextView txtIntroduceTeam, txtIntroduceSystem;
    ImageView imvComebackAboutUs;

    ReusedConstraint reusedConstraint = new ReusedConstraint(AboutUsScreen.this);

    private void linkView() {
        rcvListMemberTeam = findViewById(R.id.rcvListMemberTeam);
        txtIntroduceTeam = findViewById(R.id.txtIntroduceTeam);
        txtIntroduceSystem = findViewById(R.id.txtIntroduceSystem);
        imvComebackAboutUs = findViewById(R.id.imvComebackAboutUs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_screen);

        linkView();
        initAdapter();
        addEvents();
    }

    private void initAdapter() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AboutUsScreen.this,RecyclerView.HORIZONTAL,false);
        rcvListMemberTeam.setLayoutManager(linearLayoutManager);

        memberAdapter = new MemberAdapter(AboutUsScreen.this);
        memberAdapter.setData(getMemberList());

        rcvListMemberTeam.setAdapter(memberAdapter);

    }

    public static List<Member> getMemberList() {
        List<Member> list = new ArrayList<>();
        list.add(new Member(R.drawable.img_avatar_male,"Developer","Nguyen Hoang Anh Khoa","Leader",
                "Male","November 14, 2001"));
        list.add(new Member(R.drawable.img_avatar_male,"Developer","Tran Hoang Gia Bao","Member",
                "Male","July 06, 2001"));
        list.add(new Member(R.drawable.img_avatar_female,"Business Analyst","Vo Thi Tuyet Trinh","Member",
                "Female","July 06, 2001"));
        list.add(new Member(R.drawable.img_heo,"Designer","Truong Hoang Y","Member",
                "Female","July 06, 2001"));
        list.add(new Member(R.drawable.img_avatar_male,"Designer","Trinh Chan Khoa","Member",
                "Male","July 06, 2001"));



        return list;
    }

    private void addEvents() {
        reusedConstraint.changeColor(txtIntroduceTeam,0,14,R.color.primary_yellow);
        reusedConstraint.changeColor(txtIntroduceSystem,0,14,R.color.primary_yellow);
        imvComebackAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}