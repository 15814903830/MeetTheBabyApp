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

import androidx.appcompat.app.AppCompatActivity;

public class OpenActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llReturnOpenactivity;
    private Button btnStartOpenactivity;
    private TextView tvQueryOpenactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_open);
        initView();
    }

    private void initView() {
        llReturnOpenactivity = findViewById(R.id.ll_return_openactivity);
        btnStartOpenactivity = findViewById(R.id.btn_start_openactivity);
        tvQueryOpenactivity = findViewById(R.id.tv_query_openactivity);
        btnStartOpenactivity.setOnClickListener(this);
        llReturnOpenactivity.setOnClickListener(this);
        tvQueryOpenactivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_return_openactivity://返回
                finish();
                break;
            case R.id.btn_start_openactivity://启动

                break;
            case R.id.tv_query_openactivity://如何打开

                break;
        }

    }
}
