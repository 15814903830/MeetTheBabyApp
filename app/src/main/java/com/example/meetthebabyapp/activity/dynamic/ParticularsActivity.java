package com.example.meetthebabyapp.activity.dynamic;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.adapter.CommentAdapter;
import com.example.meetthebabyapp.adapter.ImgListAdapter;
import com.example.meetthebabyapp.adapter.MyMultipleItem;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ParticularsActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout llReturnBinding;
    private CircleImageView civHeadimg;
    private TextView tvNameRecyclview;
    private TextView tvTimeRecyclview;
    private TextView tvContentRecyclview;
    private RecyclerView rvItemImglist;
    private TextView tvCommentRecyclview;
    private ImageView tvIsloveItem;
    private TextView tvLovesumRecyclview;
    private List<MyMultipleItem> basedast;
    private RecyclerView rvCommentItem;
    private boolean lovrimg=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_particulars);
        initView();
        initimgadapter();
        initcommentadapter();
    }

    private void initcommentadapter() {
        List<String> list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCommentItem.setLayoutManager(linearLayoutManager);
        CommentAdapter commentAdapter = new CommentAdapter(this, list);
        rvCommentItem.setAdapter(commentAdapter);

    }


    private void initView() {
        llReturnBinding = findViewById(R.id.ll_return_binding);
        llReturnBinding.setOnClickListener(this);
        civHeadimg = findViewById(R.id.civ_headimg);
        tvNameRecyclview = findViewById(R.id.tv_name_recyclview);
        tvTimeRecyclview = findViewById(R.id.tv_time_recyclview);
        tvContentRecyclview = findViewById(R.id.tv_content_recyclview);
        rvItemImglist = findViewById(R.id.rv_item_imglist);
        tvCommentRecyclview = findViewById(R.id.tv_comment_recyclview);
        tvIsloveItem = findViewById(R.id.tv_islove_item);
        tvIsloveItem.setOnClickListener(this);
        tvLovesumRecyclview = findViewById(R.id.tv_lovesum_recyclview);
        rvCommentItem = findViewById(R.id.rv_comment_item);

        tvLovesumRecyclview.setText("10");//点赞数
        tvContentRecyclview.setText("10");//评论数
        tvNameRecyclview.setText("名字");//名字
        tvTimeRecyclview.setText("时间");//时间
        tvContentRecyclview.setText("正文");//正文文字描述
        Glide.with(this).load("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg").into(civHeadimg);//头像
    }


    private void initimgadapter() {//图片
        List<String> list = new ArrayList<>();
        list.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 3);
        rvItemImglist.setLayoutManager(mGridLayoutManager);
        ImgListAdapter imgListAdapter = new ImgListAdapter(this, list);
        rvItemImglist.setAdapter(imgListAdapter);
        imgListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_return_binding:
                finish();
                break;
            case R.id.tv_islove_item:
                if (lovrimg){
                    tvIsloveItem.setSelected(true);
                    lovrimg=false;
                }else {
                    tvIsloveItem.setSelected(false);
                    lovrimg=true;
                }

                break;
        }
    }
}
