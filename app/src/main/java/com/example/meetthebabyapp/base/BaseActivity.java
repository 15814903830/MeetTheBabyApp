package com.example.meetthebabyapp.base;

import android.os.Bundle;

import com.example.meetthebabyapp.util.MyToastUtil;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showShortTip(String tip) {
        MyToastUtil.showShortToast(this, tip);
    }

    public void showLongTip(String tip) {
        MyToastUtil.showLongToast(this, tip);
    }

}
