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

import nguyenhoanganhkhoa.com.models.Images;
import nguyenhoanganhkhoa.com.models.Member;
import nguyenhoanganhkhoa.com.myapplication.R;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder>  {

    private List<Images> mListImages;
    int layout;
    Context context;

    public ImagesAdapter(List<Images> mListImages, int layout, Context context) {
        this.mListImages = mListImages;
        this.layout = layout;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layout,parent,false);
        return new ImagesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.ViewHolder holder, int position) {
        Images images = mListImages.get(position);
        if(images ==null){
            return;
        }
        if(layout==R.layout.item_news){
            holder.imvNews.setImageResource(images.getImagesSource());
        }
        else if(layout==R.layout.item_ads){
            holder.imvAds.setImageResource(images.getImagesSource());
        }


    }

    @Override
    public int getItemCount() {
        return mListImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvNews,imvAds;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvNews = itemView.findViewById(R.id.imvNews);
            imvAds = itemView.findViewById(R.id.imvAds);
        }
    }
}
