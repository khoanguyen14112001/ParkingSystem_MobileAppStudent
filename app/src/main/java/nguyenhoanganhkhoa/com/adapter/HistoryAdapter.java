package nguyenhoanganhkhoa.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nguyenhoanganhkhoa.com.models.History;
import nguyenhoanganhkhoa.com.myapplication.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;
    private List<History> mHistory;

    public void setData(List<History> list){
        this.mHistory = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_history_listview,parent,false);
        // Chỗ view này nó còn đại diện kiểu hiển thị nữa nha, có ăn parent ko thì nó trong đây nè

        // cái view hiện tại đại diện cho recyleview
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = mHistory.get(position);
        if(history==null){
            return;
        }

        holder.imvColorHis.setImageResource(history.getColorHis());
        holder.txtEntryExit.setText(history.getStatusInOut());
        holder.txtDateEntryExit.setText(history.getDayInOut());


    }

    @Override
    public int getItemCount() {
        if(mHistory!=null)
            return mHistory.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtEntryExit, txtDateEntryExit;
        ImageView imvColorHis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEntryExit =itemView.findViewById(R.id.txtEntryExit);
            txtDateEntryExit =itemView.findViewById(R.id.txtDateEntryExit);
            imvColorHis =itemView.findViewById(R.id.imvColorHis);
        }
    }
}
