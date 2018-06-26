package com.example.rikao_3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;



public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{
    private Context context;
    private List<String>mDatas;
    private List<Integer>mHeight;

    public PhotoAdapter(Context context, List<String>mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        mHeight = new ArrayList<>();
        //设置大小
        for (int i = 0; i < mDatas.size(); i++) {
            int height = (int)(Math.random()*(800-200+1)+100);
            mHeight.add(height);
        }
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        PhotoViewHolder holder = new PhotoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        String url = mDatas.get(position);
        Picasso.with(context).load(url).into(holder.iv);
        ViewGroup.LayoutParams params = holder.iv.getLayoutParams();
        params.height = mHeight.get(position);
        holder.iv.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            iv =  itemView.findViewById(R.id.item_photo_iv);
        }
    }
}
