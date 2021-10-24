package nguyenhoanganhkhoa.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import nguyenhoanganhkhoa.com.models.Transaction;
import nguyenhoanganhkhoa.com.myapplication.R;


public class TransactionAdapter extends ArrayAdapter<Transaction> {

    Context context;
    int resource;
    List<Transaction> transactions;

    public TransactionAdapter(@NonNull Context context, int resource, @NonNull List<Transaction> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.transactions = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_transaction,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txtStatusTrans = convertView.findViewById(R.id.txtStatusTrans);
            viewHolder.txtDateTrans = convertView.findViewById(R.id.txtDateStatusTrans);
            viewHolder.txtMoneyTrans = convertView.findViewById(R.id.txtMoneyTrans);
            viewHolder.imvStatusTrans = convertView.findViewById(R.id.imvStatusTrans);
            convertView.setTag(viewHolder);

        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Transaction transaction = this.getItem(position);
        viewHolder.txtStatusTrans.setText(transaction.getStatusTrans());
        viewHolder.txtDateTrans.setText(transaction.getDateTrans());
        viewHolder.txtMoneyTrans.setText(transaction.getMoneyTrans());
        viewHolder.imvStatusTrans.setImageResource(transaction.getImgStatusTrans());


        return convertView;
    }

    public class ViewHolder{
        TextView txtStatusTrans, txtDateTrans, txtMoneyTrans;
        ImageView imvStatusTrans;
    }
}
