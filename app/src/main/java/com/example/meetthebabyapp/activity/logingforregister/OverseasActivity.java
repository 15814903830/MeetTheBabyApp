package com.example.meetthebabyapp.activity.logingforregister;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.BaseActivity;

public class OverseasActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhoneOverseas;
    private EditText etCodeOverseas;
    private TextView tvGetcodeOverseas;
    private EditText etPasswordOverseas;
    private ImageView ivEyeRegister;
    private Button btnRegisterOverseas;
    private TextView tvLoginOverseas;
    private TextView tvNewregiterOverseas;
    private TextView tvStatementRegister;
    private boolean isShowPassword = false;  //是否显示密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overseas);
        initView();
    }

    private void initView() {
        etPhoneOverseas = findViewById(R.id.et_phone_overseas);
        etCodeOverseas = findViewById(R.id.et_code_overseas);
        tvGetcodeOverseas = findViewById(R.id.tv_getcode_overseas);
        etPasswordOverseas = findViewById(R.id.et_password_overseas);
        ivEyeRegister = findViewById(R.id.iv_eye_register);
        btnRegisterOverseas = findViewById(R.id.btn_register_overseas);
        tvLoginOverseas = findViewById(R.id.tv_login_overseas);
        tvNewregiterOverseas = findViewById(R.id.tv_newregiter_overseas);
        tvStatementRegister = findViewById(R.id.tv_statement_register);


        tvGetcodeOverseas.setOnClickListener(this);
        ivEyeRegister.setOnClickListener(this);
        btnRegisterOverseas.setOnClickListener(this);
        tvLoginOverseas.setOnClickListener(this);
        tvNewregiterOverseas.setOnClickListener(this);
        tvStatementRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_getcode_overseas://获取验证码
                sendCode();
                break;
            case R.id.iv_eye_register://眼睛
                showOrHidePassword();
                break;
            case R.id.btn_register_overseas://注册

                break;
            case R.id.tv_login_overseas://登录
                startActivity(new Intent(OverseasActivity.this, LoginActivity.class));
                break;
            case R.id.tv_newregiter_overseas://新用户注册
                startActivity(new Intent(OverseasActivity.this, RegisterActivity.class));
                break;
            case R.id.tv_statement_register://声明

                break;

        }
    }

    /**
     * 显示或隐藏密码
     */
    private void showOrHidePassword() {
        if (isShowPassword) {
            isShowPassword = false;
            etPasswordOverseas.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivEyeRegister.setSelected(false);
        } else {
            isShowPassword = true;
            etPasswordOverseas.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivEyeRegister.setSelected(true);
        }
    }

    /**
     * 发送验证码
     */
    private void sendCode() {
        String account = etPhoneOverseas.getText().toString();
        if (account.isEmpty()) {
            showShortTip("请输入您的手机号");
            return;
        }
        tvGetcodeOverseas.setEnabled(false);
        timer.start();
    }

    //获取验证码倒计时
    private CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String last = millisUntilFinished / 1000 + "s";
            tvGetcodeOverseas.setText(last);
        }

        @Override
        public void onFinish() {
            tvGetcodeOverseas.setEnabled(true);
            tvGetcodeOverseas.setText("获取验证码");
        }
    };
}
