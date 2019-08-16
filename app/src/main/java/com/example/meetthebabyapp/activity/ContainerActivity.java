package com.example.meetthebabyapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.activity.playlist.PlayListActivity;
import com.example.meetthebabyapp.activity.store.BuyOrRentActivity;
import com.example.meetthebabyapp.base.BaseActivity;
import com.example.meetthebabyapp.fragment.HomeFragment;
import com.example.meetthebabyapp.fragment.MineFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ContainerActivity extends BaseActivity implements View.OnClickListener {
    private FragmentManager fm = getSupportFragmentManager();
    private Fragment mFragment;
    private FrameLayout main;
    private LinearLayout ll;
    private LinearLayout mainLlHome;
    private TextView mainTvHome;
    private LinearLayout mainLlTrain;
    private TextView mainTvTrain;
    private LinearLayout mainLlScan;
    private TextView mainTvScan;
    private LinearLayout mainLlNotice;
    private TextView mainTvNotice;
    private LinearLayout mainLlPersonage;
    private TextView mainTvPersonage;
    private String mtag;
    private HomeFragment homepageFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_container);
        initView();
    }

    private void initView() {
        main = findViewById(R.id.main);
        ll = findViewById(R.id.ll);
        mainLlHome = findViewById(R.id.main_ll_home);
        mainTvHome = findViewById(R.id.main_tv_home);
        mainLlTrain = findViewById(R.id.main_ll_train);
        mainTvTrain = findViewById(R.id.main_tv_train);
        mainLlScan = findViewById(R.id.main_ll_scan);
        mainTvScan = findViewById(R.id.main_tv_scan);
        mainLlNotice = findViewById(R.id.main_ll_notice);
        mainTvNotice = findViewById(R.id.main_tv_notice);
        mainLlPersonage = findViewById(R.id.main_ll_personage);
        mainTvPersonage = findViewById(R.id.main_tv_personage);
        mainTvHome.setSelected(true);
        mainLlHome.setOnClickListener(this);
        mainLlTrain.setOnClickListener(this);
        mainLlScan.setOnClickListener(this);
        mainLlNotice.setOnClickListener(this);
        mainLlPersonage.setOnClickListener(this);
        //首页
        if (homepageFragment == null) {
            homepageFragment = HomeFragment.newInstance();
        }
        showFragment(homepageFragment, "HOME");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_ll_home:
                //首页
                if (homepageFragment == null) {
                    homepageFragment = HomeFragment.newInstance();
                }
                showFragment(homepageFragment, "HOME");
                mainTvHome.setSelected(true);
                mainTvTrain.setSelected(false);
                mainTvScan.setSelected(false);
                mainTvNotice.setSelected(false);
                mainTvPersonage.setSelected(false);
                break;
            case R.id.main_ll_train:
                //商城
                mainTvHome.setSelected(false);
                mainTvTrain.setSelected(true);
                mainTvScan.setSelected(false);
                mainTvNotice.setSelected(false);
                mainTvPersonage.setSelected(false);

                //todo 暂时作为音频、绘本详情的入口
                startActivity(new Intent(ContainerActivity.this, PlayListActivity.class));
                break;
            case R.id.main_ll_scan:
                //设备
                mainTvHome.setSelected(false);
                mainTvTrain.setSelected(false);
                mainTvScan.setSelected(true);
                mainTvNotice.setSelected(false);
                mainTvPersonage.setSelected(false);

                //todo 暂时作为租、购买设备入口
                startActivity(new Intent(ContainerActivity.this, BuyOrRentActivity.class));
                break;
            case R.id.main_ll_notice:
                //消息
                mainTvHome.setSelected(false);
                mainTvTrain.setSelected(false);
                mainTvScan.setSelected(false);
                mainTvNotice.setSelected(true);
                mainTvPersonage.setSelected(false);
                break;

            case R.id.main_ll_personage:
                //我的
                if (mineFragment == null) {
                    mineFragment = MineFragment.getInstance();
                }
                showFragment(mineFragment, "MINE");
                mainTvHome.setSelected(false);
                mainTvTrain.setSelected(false);
                mainTvScan.setSelected(false);
                mainTvNotice.setSelected(false);
                mainTvPersonage.setSelected(true);
                break;
            default:
                break;
        }
    }

    private void showFragment(Fragment fragment, String tag) {

        if (tag.equals(mtag)) {
            return;
        }
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if (mFragment != null) {
            fragmentTransaction.hide(mFragment);
        }
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.main, fragment);
        }

        fragmentTransaction.commit();
        mFragment = fragment;
        mtag = tag;
    }
}
