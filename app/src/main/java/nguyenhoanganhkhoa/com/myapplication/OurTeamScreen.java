package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import nguyenhoanganhkhoa.com.adapter.DetailMemberAdapter;
import nguyenhoanganhkhoa.com.models.Member;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;

public class OurTeamScreen extends AppCompatActivity {

    ViewPager2 viewPagerOurTeam;
    LinearLayout layout_dots;
    List<Member> mList = AboutUsScreen.getMemberList();
    ImageView imvBackOurTeam;
    TextView dots[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team_screen);

        linkView();
        initAdapter();
        addEvents();

    }

    private void addEvents() {
        AppUtil.prepareDots(this,mList.size(),layout_dots,dots,14);
        imvBackOurTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        viewPagerOurTeam.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                seletedIndicator(position);
                super.onPageSelected(position);

            }
        });
    }

    private void seletedIndicator(int position) {
        for (int i =0; i<dots.length;i++)
        {
            if(i==position)
            {
                dots[i].setTextColor(getColor(R.color.primary_yellow));

            }
            else {
                dots[i].setTextColor(getColor(R.color.xamChu));
            }
        }
    }


    private void initAdapter() {
        DetailMemberAdapter detailMemberAdapter = new DetailMemberAdapter(mList);
        viewPagerOurTeam.setAdapter(detailMemberAdapter);

    }



    private void linkView() {
        viewPagerOurTeam = findViewById(R.id.viewPagerOurTeam);
        layout_dots = findViewById(R.id.layout_dots);
        imvBackOurTeam= findViewById(R.id.imvBackOurTeam);
        dots = new TextView[mList.size()];

    }
}