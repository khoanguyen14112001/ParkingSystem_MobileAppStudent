package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.adapter.QuestionsAdapter;
import nguyenhoanganhkhoa.com.models.QuestionsCategories;
import nguyenhoanganhkhoa.com.myapplication.R;

public class HelpCenterScreen extends AppCompatActivity {
    QuestionsAdapter questionsAdapter;
    RecyclerView rcvQuestions, rcvProblemCate;
    ImageView imvComebackHelpCenter;
    private void linkView() {
        rcvQuestions = findViewById(R.id.rcvQuestions);
        rcvProblemCate = findViewById(R.id.rcvProblemCate);
        imvComebackHelpCenter = findViewById(R.id.imvComebackHelpCenter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center_screen);

        linkView();
        initAdapter(R.layout.item_problem_categories);
        initAdapter(R.layout.item_question);
        addEvents();
    }

    private void addEvents() {
        imvComebackHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void initAdapter(int layout) {
        if(layout == R.layout.item_question)
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
            rcvQuestions.setLayoutManager(linearLayoutManager);
            questionsAdapter = new QuestionsAdapter(getQuestionsList(),layout,this);
            rcvQuestions.setAdapter(questionsAdapter);


        }
        if(layout == R.layout.item_problem_categories){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
            rcvProblemCate.setLayoutManager(linearLayoutManager);
            questionsAdapter = new QuestionsAdapter(getProblemsCateList(),layout,this);
            rcvProblemCate.setAdapter(questionsAdapter);
        }
    }

    private List<QuestionsCategories> getProblemsCateList() {
        List<QuestionsCategories> list = new ArrayList<>();

        list.add(new QuestionsCategories("E-Wallet and Top up",
                R.drawable.ic_topup,12));
        list.add(new QuestionsCategories("Parking lot",
                R.drawable.ic_bike,8));
        list.add(new QuestionsCategories("Safety and Security",
                R.drawable.ic_safety,4));
        list.add(new QuestionsCategories("For beginners",
                R.drawable.ic_aboutus,12));
        list.add(new QuestionsCategories("User manual",
                R.drawable.ic_news,8));

        return list;
    }

    private List<QuestionsCategories> getQuestionsList() {
        List<QuestionsCategories> list = new ArrayList<>();


        list.add(new QuestionsCategories("How to top up my wallet?",
                R.drawable.ic_topup));
        list.add(new QuestionsCategories("I did not see my latest history",
                R.drawable.ic_bike));
        list.add(new QuestionsCategories("I have not received money from Momo wallet",
                R.drawable.ic_topup));
        list.add(new QuestionsCategories("How to recover my password?",
                R.drawable.ic_topup));
        list.add(new QuestionsCategories("I did not see my latest history",
                R.drawable.ic_topup));
        list.add(new QuestionsCategories("How to top up my wallet?",
                R.drawable.ic_topup));



        return list;

    }




}