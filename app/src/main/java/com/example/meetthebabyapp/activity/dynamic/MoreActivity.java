package com.example.meetthebabyapp.activity.dynamic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.adapter.MultipleItemAdapter;
import com.example.meetthebabyapp.adapter.MyMultipleItem;
import com.example.meetthebabyapp.base.HomeFragmnetRecyclViewBase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llReturnBinding;
    private TextView tvMyMore;
    private RecyclerView rvMoreMoreactivity;
    private ImageView ivSendMore;

    private LinearLayoutManager layoutManager;
    private MultipleItemAdapter adapter;
    private List<MyMultipleItem> dast = new ArrayList<>();
    private List<HomeFragmnetRecyclViewBase> mhomelist = new ArrayList<>();
    private List<HomeFragmnetRecyclViewBase> mhomelist2 = new ArrayList<>();
    private List<String> lovelist = new ArrayList<>();
    private List<String> imglist = new ArrayList<>();
    private List<String> lovelist1 = new ArrayList<>();
    private List<String> imglist1 = new ArrayList<>();
    private List<HomeFragmnetRecyclViewBase.CommentBase> commentBaseslist = new ArrayList<>();
    private List<HomeFragmnetRecyclViewBase.CommentBase> commentBaseslist2 = new ArrayList<>();
    private HomeFragmnetRecyclViewBase homeFragmnetRecyclViewBase = new HomeFragmnetRecyclViewBase();
    private HomeFragmnetRecyclViewBase homeFragmnetRecyclViewBase2 = new HomeFragmnetRecyclViewBase();
    private HomeFragmnetRecyclViewBase.CommentBase commentBase = new HomeFragmnetRecyclViewBase.CommentBase();
    private HomeFragmnetRecyclViewBase.CommentBase commentBase2 = new HomeFragmnetRecyclViewBase.CommentBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        initManager();
        getDatas();
    }

    private void initView() {
        llReturnBinding = findViewById(R.id.ll_return_binding);
        tvMyMore = findViewById(R.id.tv_my_more);
        rvMoreMoreactivity = findViewById(R.id.rv_more_moreactivity);
        ivSendMore = findViewById(R.id.iv_send_more);

        llReturnBinding.setOnClickListener(this);
        tvMyMore.setOnClickListener(this);
        ivSendMore.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_return_binding:
                finish();
                break;
            case R.id.tv_my_more:
                Intent intent=new Intent(this,PersonagerDynamicActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_send_more:
                Toast.makeText(this, "发布新动态", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initAdapter(List<MyMultipleItem> basedast) {
        //创建适配器
        adapter = new MultipleItemAdapter(basedast, "1");
        //给RecyclerView设置适配器
        rvMoreMoreactivity.setAdapter(adapter);
        adapter.bindToRecyclerView(rvMoreMoreactivity);

        //上拉加载（设置这个监听就表示有上拉加载功能了）
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //这里设置的监听但是没有使用,使用自己判断的上拉加载,调用BaseRecyclerview的监听是因为要使用它的加载中加载失败加载完毕的布局
                Toast.makeText(MoreActivity.this, "底部", Toast.LENGTH_SHORT).show();
                mHandler.sendEmptyMessageDelayed(1, 1000);
                //                adapter.loadMoreComplete();//加载完成
                //                adapter.loadMoreFail();//加载失败
            }
        }, rvMoreMoreactivity);

    }


    @SuppressLint("WrongConstant")
    private void initManager() {
        //创建总布局管理
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMoreMoreactivity.setLayoutManager(layoutManager);
    }

    private void getDatas() {
        homeFragmnetRecyclViewBase.setName("张三");//名字
        homeFragmnetRecyclViewBase.setTime("一小时前");//时间
        homeFragmnetRecyclViewBase.setIslove(true);
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        homeFragmnetRecyclViewBase.setLoveList(lovelist);
        homeFragmnetRecyclViewBase.setHeadimgurl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4259300811,497831842&fm=26&gp=0.jpg");//头像
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        homeFragmnetRecyclViewBase.setImgList(imglist);//内容图片
        //内容文字描述
        homeFragmnetRecyclViewBase.setContent("下午，xià wǔ，与上午相对，从正午十二点到十八点的一段时间，一般指从正午十二点后到日落的一段时间。英文简写为pm、P.M.或p.m.。");

        //评论
        commentBase.setCommentcontent("66666666");
        commentBase.setCommentheadimgurl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2417542071,2189553958&fm=58&bpow=800&bpoh=600");
        commentBase.setCommentname("爸爸");
        commentBaseslist.add(commentBase);
        //评论
        commentBase.setCommentcontent("66666666");
        commentBase.setCommentheadimgurl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2417542071,2189553958&fm=58&bpow=800&bpoh=600");
        commentBase.setCommentname("爸爸");
        commentBaseslist.add(commentBase);
        homeFragmnetRecyclViewBase.setCommentBaseList(commentBaseslist);


        homeFragmnetRecyclViewBase2.setName("张三22");//名字
        homeFragmnetRecyclViewBase2.setTime("10小时前");//时间
        homeFragmnetRecyclViewBase2.setIslove(false);
        lovelist1.add("李四");//点赞
        homeFragmnetRecyclViewBase2.setLoveList(lovelist1);
        homeFragmnetRecyclViewBase2.setHeadimgurl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4259300811,497831842&fm=26&gp=0.jpg");//头像
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        homeFragmnetRecyclViewBase2.setImgList(imglist1);//内容图片
        //内容文字描述
        homeFragmnetRecyclViewBase2.setContent("下午，xià wǔ，与上午相对，从正午十二点到十八点的一段时间，一般指从正午十二点后到日落的一段时间。英文简写为pm、P.M.或p.m.。");

        //评论
        commentBase2.setCommentcontent("66666666");
        commentBase2.setCommentheadimgurl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2417542071,2189553958&fm=58&bpow=800&bpoh=600");
        commentBase2.setCommentname("爸爸");
        commentBaseslist2.add(commentBase2);
        homeFragmnetRecyclViewBase2.setCommentBaseList(commentBaseslist2);

        mhomelist.add(homeFragmnetRecyclViewBase);
        mhomelist2.add(homeFragmnetRecyclViewBase2);

        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist.get(0)));
        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist2.get(0)));
        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist.get(0)));
        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist2.get(0)));
        initAdapter(dast);

    }

    private void newDatas() {
        homeFragmnetRecyclViewBase.setName("张三");//名字
        homeFragmnetRecyclViewBase.setTime("一小时前");//时间
        homeFragmnetRecyclViewBase.setIslove(true);
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        lovelist.add("李四");//点赞
        homeFragmnetRecyclViewBase.setLoveList(lovelist);
        homeFragmnetRecyclViewBase.setHeadimgurl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4259300811,497831842&fm=26&gp=0.jpg");//头像
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        homeFragmnetRecyclViewBase.setImgList(imglist);//内容图片
        //内容文字描述
        homeFragmnetRecyclViewBase.setContent("下午，xià wǔ，与上午相对，从正午十二点到十八点的一段时间，一般指从正午十二点后到日落的一段时间。英文简写为pm、P.M.或p.m.。");

        //评论
        commentBase.setCommentcontent("66666666");
        commentBase.setCommentheadimgurl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2417542071,2189553958&fm=58&bpow=800&bpoh=600");
        commentBase.setCommentname("爸爸");
        commentBaseslist.add(commentBase);
        //评论
        commentBase.setCommentcontent("66666666");
        commentBase.setCommentheadimgurl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2417542071,2189553958&fm=58&bpow=800&bpoh=600");
        commentBase.setCommentname("爸爸");
        commentBaseslist.add(commentBase);
        homeFragmnetRecyclViewBase.setCommentBaseList(commentBaseslist);


        homeFragmnetRecyclViewBase2.setName("张三22");//名字
        homeFragmnetRecyclViewBase2.setTime("10小时前");//时间
        homeFragmnetRecyclViewBase2.setIslove(false);
        lovelist1.add("李四");//点赞
        homeFragmnetRecyclViewBase2.setLoveList(lovelist1);
        homeFragmnetRecyclViewBase2.setHeadimgurl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4259300811,497831842&fm=26&gp=0.jpg");//头像
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        imglist1.add("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg");
        homeFragmnetRecyclViewBase2.setImgList(imglist1);//内容图片
        //内容文字描述
        homeFragmnetRecyclViewBase2.setContent("下午，xià wǔ，与上午相对，从正午十二点到十八点的一段时间，一般指从正午十二点后到日落的一段时间。英文简写为pm、P.M.或p.m.。");

        //评论
        commentBase2.setCommentcontent("66666666");
        commentBase2.setCommentheadimgurl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2417542071,2189553958&fm=58&bpow=800&bpoh=600");
        commentBase2.setCommentname("爸爸");
        commentBaseslist2.add(commentBase2);
        homeFragmnetRecyclViewBase2.setCommentBaseList(commentBaseslist2);

        mhomelist.add(homeFragmnetRecyclViewBase);
        mhomelist2.add(homeFragmnetRecyclViewBase2);

        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist.get(0)));
        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist2.get(0)));
        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist.get(0)));
        dast.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, mhomelist2.get(0)));

        adapter.addData(dast);
        adapter.loadMoreComplete();//加载完成

    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    newDatas();
                    break;

            }
        }
    };
}
