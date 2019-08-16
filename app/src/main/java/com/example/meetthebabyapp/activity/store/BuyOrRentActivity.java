package com.example.meetthebabyapp.activity.store;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.BaseActivity;

/**
 * 3-1-2我要租、3-1-3我要购买
 */
public class BuyOrRentActivity extends BaseActivity {

    public static final String KEY_TYPE = "type";

    public static final int TYPE_BUY = 0;  //购买
    public static final int TYPE_RENT = 1;  //租

    private TextView tv_price;

    private int mType;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_or_rent);

        mContext = this;

        initView();
    }

    private void initView() {
        tv_price = findViewById(R.id.tv_price_buy_or_rent);
        updatePrice();
    }

    private void updatePrice() {
        String total = "合计 ";
        String price = "￥3000币";
        String text = total + price;
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(Color.parseColor("#F1522C"))
                , total.length(), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StyleSpan(Typeface.BOLD), total.length() + 1, text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new RelativeSizeSpan(1.9f), total.length() + 1, text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_price.setText(ss);
    }

}
