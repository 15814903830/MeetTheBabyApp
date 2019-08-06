package com.example.meetthebabyapp.activity.logingforregister;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhoneRegister;
    private EditText etCodeRegister;
    private TextView tvGetcodeRegister;
    private EditText etPasswordRegister;
    private ImageView ivEyeRegister;
    private Button btnLoginRegister;
    private TextView tvLoginRegister;
    private TextView tvForgetRegister;
    private TextView tvStatementRegister;
    private boolean isShowPassword = false;  //是否显示密码
    private ImageView ivClearaccountRegister;
    private Button btnRegisterRegister1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_getcode_register:
                //获取验证码
                sendCode();
                break;
            case R.id.iv_eye_register:
                //眼睛
                showOrHidePassword();
                break;
            case R.id.btn_register_register:
                //注册
                break;
            case R.id.tv_overseas_register:
                //海外注册
                startActivity(new Intent(RegisterActivity.this, OverseasActivity.class));
                break;
            case R.id.tv_statement_register:
                //声明
                break;
            case R.id.tv_login_register:
                //返回登录账号
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.iv_clearaccount_register:
                //返回登录账号
                clearAccount();
                break;

        }

    }

    private void initView() {
        etPhoneRegister = findViewById(R.id.et_phone_register);
        etCodeRegister = findViewById(R.id.et_code_register);
        tvGetcodeRegister = findViewById(R.id.tv_getcode_register);
        etPasswordRegister = findViewById(R.id.et_password_register);
        ivEyeRegister = findViewById(R.id.iv_eye_register);
        btnLoginRegister = findViewById(R.id.btn_register_register);
        tvLoginRegister = findViewById(R.id.tv_login_register);
        tvForgetRegister = findViewById(R.id.tv_overseas_register);
        tvStatementRegister = findViewById(R.id.tv_statement_register);
        ivClearaccountRegister = findViewById(R.id.iv_clearaccount_register);
        btnRegisterRegister1 = findViewById(R.id.btn_register_register1);

        ivClearaccountRegister.setOnClickListener(this);
        tvGetcodeRegister.setOnClickListener(this);
        btnLoginRegister.setOnClickListener(this);
        tvLoginRegister.setOnClickListener(this);
        tvForgetRegister.setOnClickListener(this);
        tvStatementRegister.setOnClickListener(this);
        ivEyeRegister.setOnClickListener(this);
        TextChange textChange = new TextChange();
        etPhoneRegister.addTextChangedListener(textChange);
        etCodeRegister.addTextChangedListener(textChange);
        etPasswordRegister.addTextChangedListener(textChange);
    }

    /**
     * 显示或隐藏密码
     */
    private void showOrHidePassword() {
        if (isShowPassword) {
            isShowPassword = false;
            etPasswordRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivEyeRegister.setSelected(false);
        } else {
            isShowPassword = true;
            etPasswordRegister.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivEyeRegister.setSelected(true);
        }
    }

    /**
     * 发送验证码
     */
    private void sendCode() {
        String account = etPhoneRegister.getText().toString();
        if (account.isEmpty()) {
            showShortTip("请输入您的手机号");
            return;
        }
        tvGetcodeRegister.setEnabled(false);
        timer.start();
    }

    //获取验证码倒计时
    private CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String last = millisUntilFinished / 1000 + "s";
            tvGetcodeRegister.setText(last);
        }

        @Override
        public void onFinish() {
            tvGetcodeRegister.setEnabled(true);
            tvGetcodeRegister.setText("获取验证码");
        }
    };

    /**
     * 清除账号
     */
    private void clearAccount() {
        etPhoneRegister.setText("");
    }

    //EditText的监听器
    class TextChange implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.e("Editable","Editable");
            if (etPhoneRegister.length() > 0 &&
                    etCodeRegister.length() > 0 &&
                    etPasswordRegister.length() > 0
                    ) {
                Log.e("Editable","GONE");
                btnLoginRegister.setVisibility(View.VISIBLE);
                btnRegisterRegister1.setVisibility(View.GONE);
            }
        }
    }
}
