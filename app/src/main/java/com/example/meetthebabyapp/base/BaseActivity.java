package com.example.meetthebabyapp.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import com.example.meetthebabyapp.util.MyToastUtil;
import com.example.meetthebabyapp.util.status.SystemBarTintManager;

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
