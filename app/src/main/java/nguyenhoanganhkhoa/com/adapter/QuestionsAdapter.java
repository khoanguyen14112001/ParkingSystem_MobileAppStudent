package nguyenhoanganhkhoa.com.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import nguyenhoanganhkhoa.com.models.Images;
import nguyenhoanganhkhoa.com.models.QuestionsCategories;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.home.HelpCenterScreen;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> implements Filterable {

    private List<QuestionsCategories> mListQuesCate;
    private List<QuestionsCategories> mListQuesCateOld;
    int layout;
    Context context;

    public QuestionsAdapter(List<QuestionsCategories> mListQuesCate, int layout, Context context) {
        this.mListQuesCate = mListQuesCate;
        this.mListQuesCateOld = new ArrayList<>(mListQuesCate);
        this.layout = layout;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layout,parent,false);
        return new QuestionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsAdapter.ViewHolder holder, int position) {
        QuestionsCategories questionsCategories = mListQuesCate.get(position);
        if(questionsCategories ==null){
            return;
        }
        if(layout==R.layout.item_question){
            holder.imvThumbQuestion.setImageResource(questionsCategories.getThumbQuestion_Categories());
            holder.txtQuestions.setText(questionsCategories.getNameQuestion_Categories());
            if(position%2 == 1){
                holder.cvQuetstions.setBackgroundTintList(context.getResources().getColorStateList(R.color.primary_yellow));
            }
            String s1 = "I have not received money from Momo wallet";
            if(mListQuesCate.get(position).getNameQuestion_Categories().equals(s1)){
                holder.txtQuestions.setText(changeColor(s1,31,35,R.color.purple_momo));
            }
        }
        else if(layout==R.layout.item_problem_categories){
            holder.imvProblemCategories.setImageResource(questionsCategories.getThumbQuestion_Categories());
            holder.txtNameCategories.setText(questionsCategories.getNameQuestion_Categories());
            holder.txtArticles.setText(String.valueOf(questionsCategories.getArticlesCategories()));

        }


    }
    public SpannableString changeColor(String textVerifcation, int numStart, int numEnd, int ColorChange) {
        SpannableString ss = new SpannableString(textVerifcation) ;
        ForegroundColorSpan fcsYellow = new ForegroundColorSpan(context.getColor(ColorChange));
        ss.setSpan(fcsYellow,numStart,numEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        StyleSpan typefaceSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(typefaceSpan,numStart,numEnd,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ss;
    }
    @Override
    public int getItemCount() {
        return mListQuesCate.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumbQuestion,imvProblemCategories;
        TextView txtNameCategories,txtArticles, txtQuestions ;
        CardView cvQuetstions;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvThumbQuestion = itemView.findViewById(R.id.imvThumbQuestion);
            imvProblemCategories = itemView.findViewById(R.id.imvProblemCategories);
            txtNameCategories = itemView.findViewById(R.id.txtNameCategories);
            txtArticles = itemView.findViewById(R.id.txtArticles);
            txtQuestions = itemView.findViewById(R.id.txtQuestions);
            cvQuetstions = itemView.findViewById(R.id.cvQuetstions);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<QuestionsCategories> quesList = new ArrayList<>();
                String strSearch = charSequence.toString();
                if(strSearch.isEmpty()){
                    mListQuesCate = mListQuesCateOld;
                }else{
                    for (QuestionsCategories question : mListQuesCateOld){
                        if (question.getNameQuestion_Categories().toLowerCase().contains(strSearch.toLowerCase()));
                        quesList.add(question);
                    }
                }

                mListQuesCate = quesList;

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListQuesCate;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListQuesCate = (List<QuestionsCategories>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
