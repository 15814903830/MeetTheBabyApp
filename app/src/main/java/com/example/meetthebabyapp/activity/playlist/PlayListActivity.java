package com.example.meetthebabyapp.activity.playlist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.adapter.PlayListAdapter;
import com.example.meetthebabyapp.base.BaseActivity;
import com.example.meetthebabyapp.bean.PlayBean;
import com.example.meetthebabyapp.view.RecycleViewDivider;
import com.example.meetthebabyapp.view.dialog.BaseNiceDialog;
import com.example.meetthebabyapp.view.dialog.NiceDialog;
import com.example.meetthebabyapp.view.dialog.ViewConvertListener;
import com.example.meetthebabyapp.view.dialog.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 2-1-1音频详情 、2-1-2 绘本详情
 * 两个界面基本类似，加判断来辨别
 */
public class PlayListActivity extends BaseActivity implements View.OnClickListener {

    public static final String KEY_TYPE = "type";

    public static final int TYPE_AUDIO = 0;  //音频
    public static final int TYPE_PICTURE_BOOK = 1;  //绘本

    private RecyclerView recyclerView;
    private LinearLayout ll_pay;
    private TextView tv_price;

    private Context mContext;

    private int mType = TYPE_AUDIO;  //界面类型

    private List<PlayBean> mList = new ArrayList<>();
    private PlayListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        mContext = this;

        initView();
        initData();
        initEvents();
    }

    private void initEvents() {
        ll_pay.setOnClickListener(this);
    }

    private void initData() {
        PlayBean bean = new PlayBean();
        bean.setIndex(0);
        bean.setTitle("与偶遇的小熊一起踢足球");
        bean.setDuration("12:32");
        bean.setPlayable(false);
        mList.add(bean);

        PlayBean bean1 = new PlayBean();
        bean1.setIndex(1);
        bean1.setTitle("动物森林音乐狂欢会");
        bean1.setDuration("08:46");
        bean1.setPlayable(false);
        mList.add(bean1);

        PlayBean bean2 = new PlayBean();
        bean2.setIndex(2);
        bean2.setTitle("与偶遇的小熊一起踢足球");
        bean2.setDuration("12:32");
        bean2.setPlayable(true);
        mList.add(bean2);

        PlayBean bean3 = new PlayBean();
        bean3.setIndex(3);
        bean3.setTitle("动物森林音乐狂欢会");
        bean3.setDuration("08:46");
        bean3.setPlayable(false);
        mList.add(bean3);

        PlayBean bean4 = new PlayBean();
        bean4.setIndex(4);
        bean4.setTitle("与偶遇的小熊一起踢足球");
        bean4.setDuration("12:32");
        bean4.setPlayable(true);

        PlayBean bean5 = new PlayBean();
        bean5.setIndex(5);
        bean5.setTitle("动物森林音乐狂欢会");
        bean5.setDuration("08:46");
        bean5.setPlayable(false);
        mList.add(bean5);

        PlayBean bean6 = new PlayBean();
        bean6.setIndex(6);
        bean6.setTitle("与偶遇的小熊一起踢足球");
        bean6.setDuration("12:32");
        bean6.setPlayable(true);
        mList.add(bean6);

        PlayBean bean7 = new PlayBean();
        bean7.setIndex(7);
        bean7.setTitle("动物森林音乐狂欢会");
        bean7.setDuration("08:46");
        bean7.setPlayable(false);
        mList.add(bean7);

        PlayBean bean8 = new PlayBean();
        bean8.setIndex(8);
        bean8.setTitle("与偶遇的小熊一起踢足球");
        bean8.setDuration("12:32");
        bean8.setPlayable(true);

        adapter.notifyDataSetChanged();
    }

    private void initView() {
        tv_price = findViewById(R.id.tv_price_playlist);
        ll_pay = findViewById(R.id.ll_pay_order_playlist);

        recyclerView = findViewById(R.id.rv_playlist);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new RecycleViewDivider(mContext, RecyclerView.HORIZONTAL,
                1, getResources().getColor(R.color.colorLine)));

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlayListAdapter(mContext, mList);
        recyclerView.setAdapter(adapter);

        updatePrice();
    }

    private void updatePrice() {
        String total = "合计 ";
        String price = "218币";
        String text = total + price;
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(Color.parseColor("#F1522C"))
                , total.length(), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StyleSpan(Typeface.BOLD), total.length(), text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new RelativeSizeSpan(1.9f), total.length(), text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_price.setText(ss);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_pay_order_playlist:
                showPayDialog();
                break;
        }
    }

    /**
     * 显示支付对话框
     */
    private void showPayDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.dialog_pay_playlist_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder holder, BaseNiceDialog dialog) {
                        TextView tv_pay = holder.getView(R.id.tv_pay_playlist_dialog);
                        tv_pay.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(mContext, PaySuccessActivity.class));
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }
}
