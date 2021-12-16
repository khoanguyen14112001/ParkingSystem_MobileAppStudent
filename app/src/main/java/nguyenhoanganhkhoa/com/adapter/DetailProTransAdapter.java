package nguyenhoanganhkhoa.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nguyenhoanganhkhoa.com.models.Date;
import nguyenhoanganhkhoa.com.models.DetailProTrans;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.home.HelpCenterDetailScreen;

public class DetailProTransAdapter extends RecyclerView.Adapter<DetailProTransAdapter.ViewHolder> {

    private Context context;
    private List<DetailProTrans> mList;
    private int layout;

    public DetailProTransAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    public void setData(List<DetailProTrans> list){
        this.mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailProTransAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailProTransAdapter.ViewHolder holder, int position) {
        DetailProTrans detailProTrans = mList.get(position);
        if(detailProTrans==null)
        {
            return;
        }

        holder.txtDetailProTrans.setText(detailProTrans.getDetailProTrans());
        holder.layout_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, HelpCenterDetailScreen.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mList!=null)
            return mList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDetailProTrans;
        private ConstraintLayout layout_problem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDetailProTrans = itemView.findViewById(R.id.txtDetailProTrans);
            layout_problem = itemView.findViewById(R.id.layout_problem);
        }
    }
}