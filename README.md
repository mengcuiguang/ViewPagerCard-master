# ViewPagerCard-master
炫酷的ViewPager卡片效果

![image](https://github.com/mengcuiguang/ViewPagerCard-master/blob/master/test.gif )  

目的：
    封装了常见的卡片效果，使用起来巨简单
    
使用方法：

  1：布局
  
       <com.meng.viewpagercard_master.CoverFlowViewPager
            android:layout_width="match_parent"
            android:layout_height="300dp"/>
  
  2：MainActivity
  
        CoverFlowViewPager cfpDataViewpager = (CoverFlowViewPager) findViewById(R.id.cfp_data_viewpager);

        LayoutInflater layoutInflater = getLayoutInflater();
        // 初始化子布局
        List<View> list = new ArrayList<>();
        View page1 = layoutInflater.inflate(R.layout.view_data_page1, null);
        View page2 = layoutInflater.inflate(R.layout.view_data_page2, null);
        View page3 = layoutInflater.inflate(R.layout.view_data_page3, null);

        list.add(page1);
        list.add(page2);
        list.add(page3);

        //设置Adapter
        cfpDataViewpager.setViewList(list);
