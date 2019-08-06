package com.example.meetthebabyapp.activity.equipment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetthebabyapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class SoundNetworkingActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llReturnSettings;
    private TextView tvStartSound;
    private TextView tvStartSound1;
    private Button btnReceiveSound;
    private TextView tvQuerySound;
    private boolean types=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_sound_networking);
        initView();
    }

    private void initView() {
        llReturnSettings = findViewById(R.id.ll_return_settings);
        tvStartSound = findViewById(R.id.tv_start_sound);
        tvStartSound1 = findViewById(R.id.tv_start_sound1);
        btnReceiveSound = findViewById(R.id.btn_receive_sound);
        tvQuerySound = findViewById(R.id.tv_query_sound);
        tvStartSound.setOnClickListener(this);
        tvStartSound1.setOnClickListener(this);
        btnReceiveSound.setOnClickListener(this);
        llReturnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_start_sound://绑定设备
                startNetking(types);
                break;
            case R.id.tv_start_sound1://绑定设备
                startNetking(types);
                break;
            case R.id.btn_receive_sound://绑定设备

                break;
            case R.id.ll_return_settings://返回
                finish();
                break;
        }
    }

    private void startNetking(boolean type) {
        if (type) {
            Log.e("true","true");
            types=false;
            tvStartSound.setVisibility(View.GONE);
            tvStartSound1.setVisibility(View.VISIBLE);
            btnReceiveSound.setVisibility(View.VISIBLE);
        } else {
            Log.e("else","else");
            types=true;
            tvStartSound.setVisibility(View.VISIBLE);
            tvStartSound1.setVisibility(View.GONE);
        }
    }
}
