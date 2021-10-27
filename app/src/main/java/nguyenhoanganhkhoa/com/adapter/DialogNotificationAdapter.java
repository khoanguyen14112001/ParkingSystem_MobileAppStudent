package nguyenhoanganhkhoa.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nguyenhoanganhkhoa.com.models.Notification;
import nguyenhoanganhkhoa.com.myapplication.R;

public class DialogNotificationAdapter extends RecyclerView.Adapter<DialogNotificationAdapter.ViewHolder> {

    private Context context;
    private List<Notification> mNotification;
    private int layoutItem;

    public DialogNotificationAdapter(Context context, int layoutItem) {
        this.context = context;
        this.layoutItem = layoutItem;
    }

    public void setData(List<Notification> list){
        this.mNotification = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DialogNotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutItem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogNotificationAdapter.ViewHolder holder, int position) {
        Notification notification = mNotification.get(position);
        if(notification ==null)
        {
            return;
        }
        holder.txtNotificationDate.setText(notification.getNotificationDate());
        holder.txtNotificationContent.setText(notification.getNotificationContent());
        holder.imvThumbNotification.setImageResource(notification.getNotificationThumb());


    }

    @Override
    public int getItemCount() {
        if(mNotification !=null)
            return mNotification.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNotificationDate,txtNotificationContent;
        ImageView imvThumbNotification;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNotificationDate = itemView.findViewById(R.id.txtNotificationDate);
            txtNotificationContent = itemView.findViewById(R.id.txtNotificationContent);
            imvThumbNotification = itemView.findViewById(R.id.imvThumbNotification);
        }
    }
}
