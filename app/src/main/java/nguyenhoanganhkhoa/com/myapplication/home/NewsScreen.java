package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import nguyenhoanganhkhoa.com.adapter.ImagesAdapter;
import nguyenhoanganhkhoa.com.models.Images;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class NewsScreen extends AppCompatActivity {

    ViewPager2 viewPagerNews;
    RecyclerView rcvAds;
    ImagesAdapter imagesAdapter;
    TextView dots[]  = new TextView[getImagesNews().size()];
    LinearLayout layout_dots_news;

    int currentPosition = 0;
    Timer timer;
    ImageView imvBackNews;

    ReusedConstraint reusedConstraint= new ReusedConstraint(NewsScreen.this);




    private void linkViews() {
        viewPagerNews = findViewById(R.id.viewPagerNews);
        rcvAds = findViewById(R.id.rcvAds);
        layout_dots_news = findViewById(R.id.layout_dots_news);
        imvBackNews= findViewById(R.id.imvBackNews);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_screen);

        linkViews();
        initAdapter(R.layout.item_news);
        initAdapter(R.layout.item_ads);

        addAutoEvents();
        addEvents();

    }

    private void addAutoEvents() {
        createSlideShow();
        reusedConstraint.prepareDots(this,getImagesNews().size(),layout_dots_news,dots,9);
    }

    private void initAdapter(int layout) {
        if(layout == R.layout.item_news)
        {
            imagesAdapter = new ImagesAdapter(getImagesNews(),layout,this);
            viewPagerNews.setAdapter(imagesAdapter);


        }
        if(layout == R.layout.item_ads){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
            rcvAds.setLayoutManager(linearLayoutManager);
            imagesAdapter = new ImagesAdapter(getImagesAds(),layout,this);
            rcvAds.setAdapter(imagesAdapter);
        }
    }

    private List<Images> getImagesAds() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.img_ads1));
        list.add(new Images(R.drawable.img_ads2));
        list.add(new Images(R.drawable.img_ads3));
        list.add(new Images(R.drawable.img_ads4));
        list.add(new Images(R.drawable.img_ads5));
        return list;
    }

    private List<Images> getImagesNews() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.img_news1));
        list.add(new Images(R.drawable.img_news2));
        list.add(new Images(R.drawable.img_news3));
        list.add(new Images(R.drawable.img_news4));
        list.add(new Images(R.drawable.img_news5));
        return list;
    }

    private void addEvents() {
        viewPagerNews.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                reusedConstraint.seletedIndicator(dots, position);
                currentPosition = position;
                super.onPageSelected(position);
            }
        });

        imvBackNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private void createSlideShow() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currentPosition ==getImagesNews().size()){
                    currentPosition = 0;
                }
                viewPagerNews.setCurrentItem(currentPosition++,true);

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 250,2500);
    }

}