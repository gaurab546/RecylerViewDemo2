package com.example.aspirev15.newfragment.module;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.aspirev15.newfragment.adapter.NewsRVAdapter;

/**
 * Created by Aspire V15 on 12/11/2016.
 */

public class MyItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    NewsRVAdapter mNewsRVAdapter;

    public MyItemTouchHelper(NewsRVAdapter mNewsRVAdapter) {
        super(ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.mNewsRVAdapter = mNewsRVAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Log.e("OnMove", "OnMove");
        mNewsRVAdapter.onMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mNewsRVAdapter.onSwipeToDismiss(viewHolder.getAdapterPosition());
    }
}
