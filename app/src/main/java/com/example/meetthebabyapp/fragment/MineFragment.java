package com.example.meetthebabyapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.adapter.MineMenuAdapter;
import com.example.meetthebabyapp.base.BaseFragment;
import com.example.meetthebabyapp.bean.MenuBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 5-0-0个人中心
 */
public class MineFragment extends BaseFragment {

    private RecyclerView rv_one;
    private RecyclerView rv_two;

    private Context mContext;

    private List<MenuBean> menuBeanList_one = new ArrayList<>();
    private MineMenuAdapter menuAdapter_one;

    private List<MenuBean> menuBeanList_two = new ArrayList<>();
    private MineMenuAdapter menuAdapter_two;

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_one = view.findViewById(R.id.rv_one_mine_fragment);
        rv_two = view.findViewById(R.id.rv_two_mine_fragment);

        rv_one.setNestedScrollingEnabled(false);
        rv_two.setNestedScrollingEnabled(false);

        GridLayoutManager layoutManager_one = new GridLayoutManager(mContext, 4);
        rv_one.setLayoutManager(layoutManager_one);
        menuAdapter_one = new MineMenuAdapter(mContext, menuBeanList_one);
        rv_one.setAdapter(menuAdapter_one);

        GridLayoutManager layoutManager_two = new GridLayoutManager(mContext, 4);
        rv_two.setLayoutManager(layoutManager_two);
        menuAdapter_two = new MineMenuAdapter(mContext, menuBeanList_two);
        rv_two.setAdapter(menuAdapter_two);

        initMenu();
    }

    private void initMenu() {
        MenuBean bean0 = new MenuBean(R.mipmap.gerenzhongxin5, "设备管理");
        menuBeanList_one.add(bean0);
        MenuBean bean1 = new MenuBean(R.mipmap.gerenzhongxin6, "机器声音");
        menuBeanList_one.add(bean1);
        MenuBean bean2 = new MenuBean(R.mipmap.gerenzhongxin7, "设备维护");
        menuBeanList_one.add(bean2);
        MenuBean bean3 = new MenuBean(R.mipmap.gerenzhongxin8, "音频收藏");
        menuBeanList_one.add(bean3);
        menuAdapter_one.notifyDataSetChanged();

        MenuBean menuBean0 = new MenuBean(R.mipmap.gerenzhongxin9, "我的押金");
        menuBeanList_two.add(menuBean0);
        MenuBean menuBean1 = new MenuBean(R.mipmap.gerenzhongxin10, "设备订单");
        menuBeanList_two.add(menuBean1);
        MenuBean menuBean2 = new MenuBean(R.mipmap.gerenzhongxin14, "邀请码");
        menuBeanList_two.add(menuBean2);
        MenuBean menuBean3 = new MenuBean(R.mipmap.gerenzhongxin15, "我的鹦鹉币");
        menuBeanList_two.add(menuBean3);
        MenuBean menuBean4 = new MenuBean(R.mipmap.gerenzhongxin23, "学习历程");
        menuBeanList_two.add(menuBean4);
        MenuBean menuBean5 = new MenuBean(R.mipmap.gerenzhongxin13, "我的打卡");
        menuBeanList_two.add(menuBean5);
        MenuBean menuBean6 = new MenuBean(R.mipmap.gerenzhongxin12, "成绩排名");
        menuBeanList_two.add(menuBean6);
        //todo 测试记录暂无图标
        MenuBean menuBean7 = new MenuBean(R.mipmap.gerenzhongxin16, "测试记录");
        menuBeanList_two.add(menuBean7);
        //todo 我的课程包暂无图标
        MenuBean menuBean8 = new MenuBean(R.mipmap.gerenzhongxin17, "我的课程包");
        menuBeanList_two.add(menuBean8);
        MenuBean menuBean9 = new MenuBean(R.mipmap.gerenzhongxin11, "已购课程");
        menuBeanList_two.add(menuBean9);
        MenuBean menuBean10 = new MenuBean(R.mipmap.gerenzhongxin22, "我的约课");
        menuBeanList_two.add(menuBean10);
        MenuBean menuBean11 = new MenuBean(R.mipmap.gerenzhongxin17, "我的动态");
        menuBeanList_two.add(menuBean11);
        MenuBean menuBean12 = new MenuBean(R.mipmap.gerenzhongxin16, "我的关注");
        menuBeanList_two.add(menuBean12);
        MenuBean menuBean13 = new MenuBean(R.mipmap.gerenzhongxin21, "我的粉丝");
        menuBeanList_two.add(menuBean13);
        MenuBean menuBean14 = new MenuBean(R.mipmap.gerenzhongxin20, "商城订单");
        menuBeanList_two.add(menuBean14);
        MenuBean menuBean15 = new MenuBean(R.mipmap.gerenzhongxin19, "版本信息");
        menuBeanList_two.add(menuBean15);
        menuAdapter_two.notifyDataSetChanged();
    }
}
