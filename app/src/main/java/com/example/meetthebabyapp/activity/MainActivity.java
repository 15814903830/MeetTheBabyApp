package com.example.meetthebabyapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.activity.equipment.BindingActivity;
import com.example.meetthebabyapp.activity.equipment.NetworKingActivity;
import com.example.meetthebabyapp.activity.equipment.NetworkSettingsActivity;
import com.example.meetthebabyapp.activity.equipment.OpenActivity;
import com.example.meetthebabyapp.activity.equipment.SoundNetworkingActivity;
import com.example.meetthebabyapp.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView mian1;
    private TextView mian2;
    private TextView mian3;
    private TextView mian4;
    private TextView mian5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mian1 = findViewById(R.id.mian1);
        mian2 = findViewById(R.id.mian2);
        mian3 = findViewById(R.id.mian3);
        mian4 = findViewById(R.id.mian4);
        mian5 = findViewById(R.id.mian5);

        mian1.setOnClickListener(this);
        mian2.setOnClickListener(this);
        mian3.setOnClickListener(this);
        mian4.setOnClickListener(this);
        mian5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mian1:
                //设备启动
                startActivity(new Intent(MainActivity.this, OpenActivity.class));
                break;
            case R.id.mian2:
                //配置设备网络
                startActivity(new Intent(MainActivity.this, NetworkSettingsActivity.class));
                break;
            case R.id.mian3:
                //进入联网模式
                startActivity(new Intent(MainActivity.this, NetworKingActivity.class));
                break;
            case R.id.mian4:
                //声波联网
                startActivity(new Intent(MainActivity.this, SoundNetworkingActivity.class));
                break;
            case R.id.mian5:
                //绑定设备
                startActivity(new Intent(MainActivity.this, BindingActivity.class));
                break;

        }
    }
}
