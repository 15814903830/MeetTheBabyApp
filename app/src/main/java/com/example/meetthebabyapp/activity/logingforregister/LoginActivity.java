package com.example.meetthebabyapp.activity.logingforregister;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.meetthebabyapp.activity.MainActivity;
import com.example.meetthebabyapp.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhoneLogin;
    private EditText etPasswordLogin;
    private Button btnLoginLogin;
    private TextView tvRegisterLogin;
    private TextView tvForgetLogin;
    private TextView tvStatementLogin;
    private ImageView iveyeimg;
    private boolean isShowPassword = false;  //是否显示密码
    private Button btnLoginLogin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        etPhoneLogin = findViewById(R.id.et_phone_login);
        iveyeimg = findViewById(R.id.iv_eye_login);
        etPasswordLogin = findViewById(R.id.et_password_login);
        btnLoginLogin = findViewById(R.id.btn_login_login);
        tvRegisterLogin = findViewById(R.id.tv_register_login);
        tvForgetLogin = findViewById(R.id.tv_forget_login);
        tvStatementLogin = findViewById(R.id.tv_statement_login);
        btnLoginLogin1 = findViewById(R.id.btn_login_login1);
        btnLoginLogin.setOnClickListener(this);
        tvRegisterLogin.setOnClickListener(this);
        tvForgetLogin.setOnClickListener(this);
        tvStatementLogin.setOnClickListener(this);
        iveyeimg.setOnClickListener(this);

        TextChange textChange = new TextChange();
        etPhoneLogin.addTextChangedListener(textChange);
        etPasswordLogin.addTextChangedListener(textChange);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_login:
                etPhoneLogin.getText().toString();
                etPasswordLogin.getText().toString();
                //登录
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.tv_register_login:
                //注册账号
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.tv_forget_login:
                //忘记密码

                break;
            case R.id.tv_statement_login:
                //声明
                break;
            case R.id.iv_eye_login:
                //眼睛
                showOrHidePassword();
                break;
        }
    }

    /**
     * 显示或隐藏密码
     */
    private void showOrHidePassword() {
        if (isShowPassword) {
            isShowPassword = false;
            etPasswordLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
            iveyeimg.setSelected(false);
        } else {
            isShowPassword = true;
            etPasswordLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            iveyeimg.setSelected(true);
        }
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
            if (etPhoneLogin.length() > 0 &&
                    etPhoneLogin.length() > 0 ) {
                Log.e("Editable","GONE");
                btnLoginLogin.setVisibility(View.VISIBLE);
                btnLoginLogin1.setVisibility(View.GONE);
            }
        }
    }
}
