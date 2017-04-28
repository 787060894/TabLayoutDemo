package com.panku.zhengtest.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化配置信息
        initConfig();
        //初始化数据
        initData();
        viewpager.setAdapter(new MyAdapter());
    }

    private void initConfig() {
        //tablayout和viewpager关联起来
        tabLayout.setupWithViewPager(viewpager);
    }

    private ArrayList<View> mList;

    private String[] mTitle = new String[]{"首页", "分类", "寻找", "个人"};

    private void initData() {
        View viewpagerA = getLayoutInflater().inflate(R.layout.viewpager_a, null);
        View viewpagerB = getLayoutInflater().inflate(R.layout.viewpager_b, null);
        View viewpagerC = getLayoutInflater().inflate(R.layout.viewpager_c, null);
        View viewpagerD = getLayoutInflater().inflate(R.layout.viewpager_d, null);

        mList = new ArrayList<>();
        mList.add(viewpagerA);
        mList.add(viewpagerB);
        mList.add(viewpagerC);
        mList.add(viewpagerD);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    }
}
