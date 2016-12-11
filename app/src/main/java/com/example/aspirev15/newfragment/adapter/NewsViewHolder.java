package com.example.aspirev15.newfragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aspirev15.newfragment.MyApplication;
import com.example.aspirev15.newfragment.R;

/**
 * Created by Aspire V15 on 12/8/2016.
 */
public class NewsViewHolder  extends RecyclerView.ViewHolder{
    TextView txtNewsTitle;
    TextView txtNewsDesc;
    TextView txtNewsPublishDate;
    public NewsViewHolder(View itemView) {
        super(itemView);
        txtNewsDesc=(TextView)itemView.findViewById(R.id.txtNewsDesc);
        txtNewsPublishDate=(TextView)itemView.findViewById(R.id.txtNewsDate);
        txtNewsTitle=(TextView)itemView.findViewById(R.id.txtNewsTitle);
        txtNewsTitle.setTypeface(MyApplication.font);
    }
}
