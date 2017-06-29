package com.meng.viewpagercard_master;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoverFlowViewPager cfpDataViewpager = (CoverFlowViewPager) findViewById(R.id.cfp_data_viewpager);

        LayoutInflater layoutInflater = getLayoutInflater();
        // 初始化数据
        List<View> list = new ArrayList<>();
        View page1 = layoutInflater.inflate(R.layout.view_data_page1, null);
        View page2 = layoutInflater.inflate(R.layout.view_data_page2, null);
        View page3 = layoutInflater.inflate(R.layout.view_data_page3, null);

        list.add(page1);
        list.add(page2);
        list.add(page3);

        //设置显示的数据
        cfpDataViewpager.setViewList(list);
    }
}
