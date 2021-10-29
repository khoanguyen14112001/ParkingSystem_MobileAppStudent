package nguyenhoanganhkhoa.com.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.SimpleFileVisitor;
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

        changeReadImange(holder);
        addEvents(holder);

    }


    private void addEvents(DialogNotificationAdapter.ViewHolder holder) {

        if(layoutItem==R.layout.item_notification)
        {
            holder.layout_item_notification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Typeface typeface = context.getResources().getFont(R.font.be_vietnam_light);
                    holder.txtNotificationContent.setTypeface(typeface);
                    changeNotice(holder);



                }
            });


        }
        if(layoutItem==R.layout.item_notification_all_bold)
        {
            holder.layout_item_notification_all_bold.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Typeface typeface = context.getResources().getFont(R.font.be_vietnam_light);
                    holder.txtNotificationContent.setTypeface(typeface);
                    changeNotice(holder);

                }
            });


        }
    }

    private void changeReadImange(DialogNotificationAdapter.ViewHolder holder) {
        Drawable.ConstantState drawable = holder.imvThumbNotification.getDrawable().getConstantState();
        Drawable.ConstantState drawable1 = context.getResources().getDrawable(R.drawable.img_notice).getConstantState();
        Drawable.ConstantState drawable2 = context.getResources().getDrawable(R.drawable.img_nomoney_notice).getConstantState();
        if(drawable==drawable1 || drawable==drawable2)
        {
            Typeface typeface = context.getResources().getFont(R.font.be_vietnam_light);
            holder.txtNotificationContent.setTypeface(typeface);
        }

    }

    private void changeNotice(DialogNotificationAdapter.ViewHolder holder) {

        Drawable.ConstantState drawable = holder.imvThumbNotification.getDrawable().getConstantState();
        Drawable.ConstantState drawable1 = context.getResources().getDrawable(R.drawable.img_newnotice).getConstantState();
        Drawable.ConstantState drawable2 = context.getResources().getDrawable(R.drawable.ic_img_nomoney_notice_new).getConstantState();

        if(drawable == drawable1)
        {
            holder.imvThumbNotification.setImageResource(R.drawable.img_notice);
        }
        if(drawable == drawable2)
        {
            holder.imvThumbNotification.setImageResource(R.drawable.img_nomoney_notice);
        }

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
        ConstraintLayout layout_item_notification,layout_item_notification_all_bold,layout_item_notification_light;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNotificationDate = itemView.findViewById(R.id.txtNotificationDate);
            txtNotificationContent = itemView.findViewById(R.id.txtNotificationContent);
            imvThumbNotification = itemView.findViewById(R.id.imvThumbNotification);
            layout_item_notification = itemView.findViewById(R.id.layout_item_notification);
            layout_item_notification_all_bold = itemView.findViewById(R.id.layout_item_notification_all_bold);
            layout_item_notification_light = itemView.findViewById(R.id.layout_item_notification_light);
        }
    }
}
