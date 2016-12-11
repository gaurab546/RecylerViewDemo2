package com.example.aspirev15.newfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aspirev15.newfragment.R;
import com.example.aspirev15.newfragment.module.News;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aspire V15 on 12/8/2016.
 */

public class NewsRVAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    public   Context context;
    public   ArrayList<News> newsList;
    private OnRecycleViewClickListner mRecyleViewItemClickListner;

    public NewsRVAdapter(Context mContext, ArrayList<News> newsList){
        this.context=mContext;
        this.newsList=newsList;
    }
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_item,null);
        NewsViewHolder mNewsViewHolder=new NewsViewHolder(view);

        return mNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {

        Log.e("Test","tes");
        final News mNews=newsList.get(position);
        holder.txtNewsTitle.setText(mNews.getNewsTitle());
        holder.txtNewsPublishDate.setText(mNews.getPublishDate());
        holder.txtNewsDesc.setText(mNews.getNewsDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyleViewItemClickListner.onItemClick(mNews,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
    
    
    public void setRecyleViewItemClickListner(OnRecycleViewClickListner mRecyleViewItemClickListner){
        this.mRecyleViewItemClickListner=mRecyleViewItemClickListner;
    }

    public void onMove(int fromPos,int toPos){
        Collections.swap(newsList,fromPos,toPos);
        notifyDataSetChanged();
    }


    public void onSwipeToDismiss(int pos){
        newsList.remove(pos);
        notifyDataSetChanged();
    }



    public interface OnRecycleViewClickListner{
        void onItemClick(News mNews, int postion);
    }
}
