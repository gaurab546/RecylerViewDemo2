package com.example.aspirev15.newfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.aspirev15.newfragment.R.id.tabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        final String[] title = new String[]{"New", "Popular"};
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewFragments());
        fragments.add(new PopularFragment());
        ViewPageAdapter mViewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), title, fragments);
        mViewPager.setAdapter(mViewPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTitle(title[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactivitymenu, menu);
        return super.onCreateOptionsMenu(menu);


    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuEdit:

                Toast.makeText(this, "edit menu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.addmenu:
                Toast.makeText(this, "Add menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.updatemenu:
                Toast.makeText(this, "update menu", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}

