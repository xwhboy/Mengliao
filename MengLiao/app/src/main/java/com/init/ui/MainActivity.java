package com.init.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.init.ui.mengliao.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoson on 5/5/15.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    static String account;
    ImageView im_comm;
    ImageView im_me;
    ViewPager vp_main;
    FragmentPagerAdapter mAdapter;
    List<android.support.v4.app.Fragment> mTabs = new ArrayList<android.support.v4.app.Fragment>();
    List<ImageView> mTabIndicators = new ArrayList<ImageView>();
    CommunicationFragment communicationFragment;
    MeFragment meFragment;
    int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        vp_main.setAdapter(mAdapter);
        setListener();
    }

    protected void initView(){
        vp_main = (ViewPager)findViewById(R.id.vp_main);
        im_comm = (ImageView)findViewById(R.id.im_comm);
        im_me = (ImageView)findViewById(R.id.im_me);


        mTabIndicators.add(im_comm);
        mTabIndicators.add(im_me);

    }

    protected void initData(){
        account = getIntent().getStringExtra("account");
        communicationFragment = new CommunicationFragment();
        meFragment = new MeFragment();
        mTabs.add(communicationFragment);
        mTabs.add(meFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };
    }
    protected void setListener(){
        vp_main.setOnPageChangeListener(this);
        im_comm.setOnClickListener(this);
        im_me.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_comm:vp_main.setCurrentItem(mTabIndicators.indexOf(im_comm),false);
                break;
           // case R.id.im_list:vp_main.setCurrentItem(mTabIndicators.indexOf(im_list),false);
             //   break;
            case R.id.im_me:vp_main.setCurrentItem(mTabIndicators.indexOf(im_me), false);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset == 0)return;
        switch (page){
            case 0:communicationFragment.getMainView().setAlpha(1.0f-positionOffset);meFragment.getMainView().setAlpha(positionOffset);break;
            case 1:communicationFragment.getMainView().setAlpha(positionOffset);meFragment.getMainView().setAlpha(1.0f-positionOffset);break;
        }
        if (positionOffset ==0) {
            if (page == 0)page =1;
            if (page == 1)page =0;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
