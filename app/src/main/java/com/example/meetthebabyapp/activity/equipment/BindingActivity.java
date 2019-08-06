package com.example.meetthebabyapp.activity.equipment;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.BaseActivity;

import androidx.appcompat.app.AppCompatActivity;

public class BindingActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llReturnBinding;
    private EditText etSumBing1;
    private EditText etSumBing2;
    private EditText etSumBing3;
    private EditText etSumBing4;
    private Button btnStartBinding;
    private Button btnStartBinding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_binding);
        initView();
    }

    private void initView() {
        llReturnBinding = findViewById(R.id.ll_return_binding);
        etSumBing1 = findViewById(R.id.et_sum_bing1);
        etSumBing2 = findViewById(R.id.et_sum_bing2);
        etSumBing3 = findViewById(R.id.et_sum_bing3);
        etSumBing4 = findViewById(R.id.et_sum_bing4);
        btnStartBinding = findViewById(R.id.btn_start_binding);
        btnStartBinding1 = findViewById(R.id.btn_start_binding1);
        llReturnBinding.setOnClickListener(this);
        btnStartBinding.setOnClickListener(this);

        TextChange textChange = new TextChange();
        etSumBing1.addTextChangedListener(textChange);
        etSumBing2.addTextChangedListener(textChange);
        etSumBing3.addTextChangedListener(textChange);
        etSumBing4.addTextChangedListener(textChange);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_return_binding:
                finish();
                break;
            case R.id.btn_start_binding://绑定设备
                showShortTip("绑定设备");
                break;
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
            if (etSumBing1.length() > 0 &&
                    etSumBing2.length() > 0 &&
                    etSumBing3.length() > 0 &&
                    etSumBing4.length() > 0) {
                Log.e("Editable","GONE");
                btnStartBinding.setVisibility(View.VISIBLE);
                btnStartBinding1.setVisibility(View.GONE);
            }
        }
    }
}
