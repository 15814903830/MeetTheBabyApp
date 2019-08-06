package com.example.meetthebabyapp.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.BaseActivity;

public class PayHomeFragmnetActivity extends BaseActivity {

    private LinearLayout llReturnPay;
    private Button btnIntoPay;
    private CountDownTimer timer;
    private TextView tvSumPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_pay_home_fragmnet);
        initView();
        /** 倒计时60秒，一次1秒 */
        timer = new CountDownTimer(3 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvSumPay.setText(""+millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {
                showShortTip("立即学习");
            }
        }.start();
        llReturnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnIntoPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShortTip("立即学习");
            }
        });
    }

    private void initView() {
        llReturnPay = findViewById(R.id.ll_return_pay);
        btnIntoPay = findViewById(R.id.btn_into_pay);
        tvSumPay = findViewById(R.id.tv_sum_pay);
    }
}
