package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import nguyenhoanganhkhoa.com.adapter.ImagesAdapter;
import nguyenhoanganhkhoa.com.models.Images;
import nguyenhoanganhkhoa.com.models.Major;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class NewsScreen extends AppCompatActivity {

    ViewPager2 viewPagerNews;
    RecyclerView rcvAds;
    ImagesAdapter imagesAdapter;
    TextView dots[];
    LinearLayout layout_dots_news;

    int currentPosition = 0;
    Timer timer;
    ImageView imvBackNews;

    DatabaseReference databaseReferenceAds =  FirebaseDatabase.getInstance().getReference();





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


        loadFireBaseData("ads",R.layout.item_ads);
        loadFireBaseData("news",R.layout.item_news);

        addEvents();
        addAutoEvents();

        Log.d("TAG", "onCreate: " + sizeListNews);

    }
    static int sizeListNews;
    private void addAutoEvents() {
        dots = new TextView[sizeListNews];
        createSlideShow();
        reusedConstraint.prepareDots(this,sizeListNews,layout_dots_news,dots,9);
        Log.d("TAG", "addAutoEvents: " + sizeListNews);
    }


    private void initAdapter(int layout, List<Images> list) {
        if(layout == R.layout.item_news)
        {
            imagesAdapter = new ImagesAdapter(list,layout,this);
            viewPagerNews.setAdapter(imagesAdapter);
        }

        if(layout == R.layout.item_ads){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
            rcvAds.setLayoutManager(linearLayoutManager);
            imagesAdapter = new ImagesAdapter(list,layout,this);
            rcvAds.setAdapter(imagesAdapter);
        }
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
                if(currentPosition ==sizeListNews){
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

//        Log.d("TAG", "createSlideShow: " + sizeListNews);
    }

    private void loadFireBaseData(String cate,int layout) {
        List<Images> list = new ArrayList<>();
        databaseReferenceAds.child(cate).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data : snapshot.getChildren()){
                    Images images = new Images((data.child("link").getValue().toString()));
                    Log.d("TAG", "onDataChange: " + data.child("link").getValue().toString());
                    list.add(images);
                }
                sizeListNews = list.size();
                Log.d("TAG", "sizeListNews trong datachange: " + sizeListNews);
                initAdapter(layout,list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(NewsScreen.this, "Fail to load Data", Toast.LENGTH_SHORT).show();
            }
        });


    }




}