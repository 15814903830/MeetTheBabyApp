package com.example.meetthebabyapp.activity.dynamic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.adapter.MultipleItemAdapter;
import com.example.meetthebabyapp.adapter.MyMultipleItem;
import com.example.meetthebabyapp.base.HomeFragmnetRecyclViewBase;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PersonagerDynamicActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llReturnBinding;
    private RecyclerView rvPersonageActivity;

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
    private MultipleItemAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personager_dynamic);
        initView();
        initManager();
        getDatas();
    }

    private void initView() {
        llReturnBinding = findViewById(R.id.ll_return_binding);
        rvPersonageActivity = findViewById(R.id.rv_personage_activity);
        llReturnBinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_return_binding:
                finish();
                break;
        }
    }

    private void initAdapter(List<MyMultipleItem> basedast) {
        //创建适配器
        adapter = new MultipleItemAdapter(basedast, "2");
        //给RecyclerView设置适配器
        rvPersonageActivity.setAdapter(adapter);
        adapter.bindToRecyclerView(rvPersonageActivity);

    }


    @SuppressLint("WrongConstant")
    private void initManager() {
        //创建总布局管理
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPersonageActivity.setLayoutManager(layoutManager);
    }

    private void getDatas() {
        homeFragmnetRecyclViewBase.setName("张三");//名字
        homeFragmnetRecyclViewBase.setTime("一小时前");//时间
        homeFragmnetRecyclViewBase.setIslove(true);
        homeFragmnetRecyclViewBase.setId(1);
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
        homeFragmnetRecyclViewBase2.setId(2);
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
        initAdapter(dast);

    }
}
