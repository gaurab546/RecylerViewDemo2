package com.example.aspirev15.newfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aspirev15.newfragment.adapter.NewsRVAdapter;
import com.example.aspirev15.newfragment.adapter.NewsViewHolder;
import com.example.aspirev15.newfragment.module.MyItemTouchHelper;
import com.example.aspirev15.newfragment.module.News;

import java.util.ArrayList;

/**
 * Created by Aspire V15 on 12/6/2016.
 */

public class NewFragments extends Fragment {

    RecyclerView rvNewsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.newmenufragment,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvNewsList = (RecyclerView) view.findViewById(R.id.rvNewsList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvNewsList.setLayoutManager(manager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final NewsRVAdapter mNewsRVAdapter=new NewsRVAdapter(getContext(),getNews());
        rvNewsList.setAdapter(mNewsRVAdapter);
        mNewsRVAdapter.setRecyleViewItemClickListner(new NewsRVAdapter.OnRecycleViewClickListner() {
            @Override
            public void onItemClick(News mNews, int postion) {

                Toast.makeText(getContext(), mNews.getNewsTitle() +" "+postion, Toast.LENGTH_SHORT).show();

            }
        });
        ItemTouchHelper.Callback mCallback= new MyItemTouchHelper(mNewsRVAdapter);
        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(rvNewsList);



    }


    private ArrayList<News> getNews() {
        ArrayList<News> newses = new ArrayList<>();
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        newses.add(new News("Hello news", "Hello desc", "3 Dec"));
        return newses;
    }
}
