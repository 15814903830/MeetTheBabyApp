package com.example.meetthebabyapp.activity.equipment;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.BaseActivity;

public class NetworKingActivity extends BaseActivity implements View.OnClickListener {


    private LinearLayout llReturnNetworking;
    private Button btnStartNetworking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_networking);

        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_return_networking://返回
                finish();
                break;
            case R.id.btn_start_networking://下一步

                break;
        }

    }

    private void initView() {
        llReturnNetworking = findViewById(R.id.ll_return_networking);
        btnStartNetworking = findViewById(R.id.btn_start_networking);
        llReturnNetworking.setOnClickListener(this);
        btnStartNetworking.setOnClickListener(this);
    }
}
