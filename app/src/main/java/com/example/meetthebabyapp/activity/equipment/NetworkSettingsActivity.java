package com.example.meetthebabyapp.activity.equipment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.meetthebabyapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.meetthebabyapp.R.color.texrwifi;

public class NetworkSettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> list = new ArrayList<String>();
    private TextView textview;
    private Spinner spinnertext;
    private ArrayAdapter<String> adapter;
    private LinearLayout llReturnSettings;
    private TextView tvWifiSettings;
    private TextView tvHotspotSettings;
    private EditText tvWifiPasswrod;
    private Button btnNewSettings;
    private TextView tvQuerySettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_network_settings);
        initView();
        initSpinner();//wifi下拉选项

    }




    private void initView() {
        spinnertext = findViewById(R.id.spinner_wifi_setting);
        textview = findViewById(R.id.tv_wifi_name);
        llReturnSettings = findViewById(R.id.ll_return_settings);
        tvWifiSettings = findViewById(R.id.tv_wifi_settings);
        tvHotspotSettings = findViewById(R.id.tv_hotspot_settings);
        tvWifiPasswrod = findViewById(R.id.tv_wifi_passwrod);
        btnNewSettings = findViewById(R.id.btn_new_settings);
        tvQuerySettings = findViewById(R.id.tv_query_settings);

        tvWifiSettings.setOnClickListener(this);
        tvQuerySettings.setOnClickListener(this);
        btnNewSettings.setOnClickListener(this);
        tvWifiPasswrod.setOnClickListener(this);
        tvHotspotSettings.setOnClickListener(this);
        llReturnSettings.setOnClickListener(this);
    }
    private void initSpinner() {
        //第一步：定义下拉列表内容
        list.add("1303");
        list.add("1304");
        list.add("1305");
        list.add("1306");
        list.add("1307");
        //第二步：为下拉列表定义一个适配器
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //第三步：设置下拉列表下拉时的菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        spinnertext.setAdapter(adapter);
        //第五步：添加监听器，为下拉列表设置事件的响应
        spinnertext.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                /* 将所选spinnertext的值带入myTextView中*/
                textview.setText(adapter.getItem(i));
                /* 将 spinnertext 显示^*/
                adapterView.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> argO) {
                textview.setText("NONE");
                argO.setVisibility(View.VISIBLE);
            }
        });
        spinnertext.setOnTouchListener(new Spinner.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        //焦点改变事件处理
        spinnertext.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                //  v.setVisibility(View.VISIBLE);
                Log.i("spinner", "Spinner FocusChange事件被触发！");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_new_settings://下一步

                break;
            case  R.id.tv_query_settings://找不到wifi解答
                break;
            case R.id.tv_wifi_settings://wifi
                settextcolor(0);
                break;
            case R.id.tv_hotspot_settings://热点
                settextcolor(1);
                break;
            case R.id.ll_return_settings://返回
                finish();
                break;
        }

    }

    private void settextcolor(int i) {

        if (i==0){
            Log.e("settextcolor1","settextcolor");
            tvWifiSettings.setTextColor(getResources().getColor(R.color.texrwifi));
            tvHotspotSettings.setTextColor(getResources().getColor(R.color.texrwifi1));
        }else {
            Log.e("settextcolor2","settextcolor");
            tvHotspotSettings.setTextColor(getResources().getColor(R.color.texrwifi));
            tvWifiSettings.setTextColor(getResources().getColor(R.color.texrwifi1));
        }


    }
}
