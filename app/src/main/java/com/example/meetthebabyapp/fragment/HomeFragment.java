package com.example.meetthebabyapp.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.activity.PayHomeFragmnetActivity;
import com.example.meetthebabyapp.activity.dynamic.MoreActivity;
import com.example.meetthebabyapp.adapter.MultipleItemAdapter;
import com.example.meetthebabyapp.adapter.MyMultipleItem;
import com.example.meetthebabyapp.adapter.PoPupWindowAdapter;
import com.example.meetthebabyapp.base.HomeFragmnetRecyclViewBase;
import com.example.meetthebabyapp.base.PopupWindowBase;
import com.example.meetthebabyapp.listen.OnItemPositionClickListen;
import com.example.meetthebabyapp.view.dialog.BaseNiceDialog;
import com.example.meetthebabyapp.view.dialog.NiceDialog;
import com.example.meetthebabyapp.view.dialog.ViewConvertListener;
import com.example.meetthebabyapp.view.dialog.ViewHolder;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class HomeFragment extends Fragment implements View.OnClickListener, PoPupWindowAdapter.defaultAddress {
    private View mView;
    public static final int[] RES = new int[]{R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};
    private MZBannerView mMZBanner;
    private String TAG = "page";
    private MZBannerView banner;
    private LinearLayout llAlertHome;
    private LinearLayout llTestHome;
    private LinearLayout llTaskHome;
    private LinearLayout llStartHome;
    private LinearLayout llThenHome;
    private LinearLayout llReviewfortextHome;
    private LinearLayout llTextforsumgoneHome;
    private LinearLayout llGetmoreHome;
    private CardView cardviewTeacherHome;
    private Button btnText1;
    private Button btnText2;
    private Button btnText3;
    private Button btnText4;
    private Button btnText5;
    private Button btnpurpletext;
    private TextView tvTitleHome;
    private TextView tvStartHome;
    private Button btnReviewHome;
    private Button btnTextHome;
    private Button btnGetdeviceHome;
    private Button btnFvbdeviceHome;
    private CircleImageView mCircleImageView;
    private PopupWindow pop;
    private RecyclerView recyclerView;
    private PoPupWindowAdapter mPoPupWindowAdapter;
    private List<PopupWindowBase> mList = new ArrayList<>();
    private MultipleItemAdapter adapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView rvDynamicstateHome;
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

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        mView = inflater.inflate(R.layout.homefragment, container, false);
        initView(mView);
        initManager();//recyclview布局管理器
        getDatas();
        MZBinitView(mView);
        condition1();//今日有新任务/200/开始学习
        return mView;
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


    private void initAdapter(List<MyMultipleItem> basedast) {
        //创建适配器
        adapter = new MultipleItemAdapter(basedast,"1");
        //给RecyclerView设置适配器
        rvDynamicstateHome.setAdapter(adapter);
        adapter.bindToRecyclerView(rvDynamicstateHome);

    }


    @SuppressLint("WrongConstant")
    private void initManager() {
        //创建总布局管理
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDynamicstateHome.setLayoutManager(layoutManager);
    }


    private void MZBinitView(View view) {

        mMZBanner = view.findViewById(R.id.banner);
        mMZBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(getContext(), "click page:" + position, Toast.LENGTH_LONG).show();
            }
        });
        mMZBanner.addPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG, "----->addPageChangeLisnter:" + position + "positionOffset:" + positionOffset + "positionOffsetPixels:" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "addPageChangeLisnter:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < RES.length; i++) {
            list.add(RES[i]);
        }

        mMZBanner.setIndicatorVisible(false);
        mMZBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });


    }

    private void initView(View mView) {
        banner = mView.findViewById(R.id.banner);
        btnText1 = mView.findViewById(R.id.btn_text1);
        btnText2 = mView.findViewById(R.id.btn_text2);
        btnText3 = mView.findViewById(R.id.btn_text3);
        btnText4 = mView.findViewById(R.id.btn_text4);
        btnText5 = mView.findViewById(R.id.btn_text5);
        llAlertHome = mView.findViewById(R.id.ll_alert_home);
        llTestHome = mView.findViewById(R.id.ll_test_home);
        llTaskHome = mView.findViewById(R.id.ll_task_home);
        llStartHome = mView.findViewById(R.id.ll_start_home);
        llThenHome = mView.findViewById(R.id.ll_then_home);
        llTextforsumgoneHome = mView.findViewById(R.id.ll_textforsumgone_home);
        llReviewfortextHome = mView.findViewById(R.id.ll_reviewfortext_home);
        cardviewTeacherHome = mView.findViewById(R.id.cardview_teacher_home);
        tvTitleHome = mView.findViewById(R.id.tv_title_home);
        tvStartHome = mView.findViewById(R.id.tv_start_home);
        btnpurpletext = mView.findViewById(R.id.btn_purpletext);
        btnReviewHome = mView.findViewById(R.id.btn_review_home);
        btnTextHome = mView.findViewById(R.id.btn_text_home);
        btnGetdeviceHome = mView.findViewById(R.id.btn_getdevice_home);
        btnFvbdeviceHome = mView.findViewById(R.id.btn_fvbdevice_home);
        mCircleImageView = mView.findViewById(R.id.cirview_head_home);
        rvDynamicstateHome = mView.findViewById(R.id.rv_dynamicstate_home);
        llGetmoreHome = mView.findViewById(R.id.ll_getmore_home);
        mCircleImageView.setOnClickListener(this);
        llGetmoreHome.setOnClickListener(this);
        btnText1.setOnClickListener(this);
        btnText2.setOnClickListener(this);
        btnText3.setOnClickListener(this);
        btnText4.setOnClickListener(this);
        btnText5.setOnClickListener(this);
        tvStartHome.setOnClickListener(this);
        btnpurpletext.setOnClickListener(this);
        btnReviewHome.setOnClickListener(this);
        btnTextHome.setOnClickListener(this);
        cardviewTeacherHome.setOnClickListener(this);
        btnGetdeviceHome.setOnClickListener(this);
        btnFvbdeviceHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cirview_head_home:
                //头像
                showPop();
                Toast.makeText(getContext(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_text1:
                condition1();//今日有新任务/200/开始学习
                break;
            case R.id.btn_text2:
                condition2();//未进行问答测试/立即测试
                break;
            case R.id.btn_text3:
                condition3();//今日有新任务/200/开始学习  温馨提醒
                break;
            case R.id.btn_text4:
                condition4();//您有未完成的学习任务  继续学习
                break;
            case R.id.btn_text5:
                condition5();//今天的学习任务已完成
                break;
            case R.id.tv_start_home:
                //开始学习for继续学习按钮'
                starthome();
                break;
            case R.id.btn_purpletext:
                Toast.makeText(getContext(), "紫色立即测试", Toast.LENGTH_SHORT).show();
                //紫色立即测试
                break;
            case R.id.btn_review_home:
                Toast.makeText(getContext(), "左立即复习", Toast.LENGTH_SHORT).show();
                //左立即复习
                break;
            case R.id.btn_text_home:
                Toast.makeText(getContext(), "右立即测试", Toast.LENGTH_SHORT).show();
                //右立即测试
                break;
            case R.id.cardview_teacher_home:
                Toast.makeText(getContext(), "名师约课", Toast.LENGTH_SHORT).show();
                //右立即测试
                break;
            case R.id.btn_getdevice_home:
                Toast.makeText(getContext(), "温馨提醒获取设备", Toast.LENGTH_SHORT).show();
                //温馨提醒获取设备
                break;
            case R.id.btn_fvbdevice_home:
                Toast.makeText(getContext(), "温馨提醒去绑定设备", Toast.LENGTH_SHORT).show();
                //温馨提醒去绑定设备
                break;
            case R.id.ll_getmore_home://更多动态
                Intent intent=new Intent(getContext(), MoreActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void starthome() {
        if (tvStartHome.getText().equals("开始学习")) {
            showdialog();
            // Toast.makeText(getContext(), "开始学习", Toast.LENGTH_SHORT).show();
        } else {
            //继续学习
            Toast.makeText(getContext(), "继续学习", Toast.LENGTH_SHORT).show();
        }
    }

    private void showdialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.homedialog)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        TextView commoditysum = holder.getView(R.id.tv_commoditysum_dialog);//商品价格
                        TextView balance = holder.getView(R.id.tv_balance_dialog);//余额
                        LinearLayout close = holder.getView(R.id.close_ll_dialog);
                        LinearLayout confirm = holder.getView(R.id.ll_confirm_dialog);//支付
                        LinearLayout confirm1 = holder.getView(R.id.ll_confirm_dialog1);//支付(余额不足)

                        if (Integer.parseInt(commoditysum.getText().toString()) > Integer.parseInt(balance.getText().toString())) {//钱不够
                            confirm1.setVisibility(View.VISIBLE);
                            confirm.setVisibility(View.GONE);
                        } else {
                            confirm1.setVisibility(View.GONE);
                            confirm.setVisibility(View.VISIBLE);
                        }

                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();

                            }
                        });
                        confirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(getContext(), PayHomeFragmnetActivity.class));
                                Toast.makeText(getActivity(), "支付", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                            }
                        });


                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(true)
                .setAnimStyle(R.style.PracticeModeAnimation)
                .setOutCancel(true) //触摸外部是否取消
                .show(getFragmentManager());
    }

    private void condition1() {
        llAlertHome.setVisibility(View.GONE);
        llTestHome.setVisibility(View.GONE);
        llTaskHome.setVisibility(View.VISIBLE);
        llStartHome.setVisibility(View.VISIBLE);
        llThenHome.setVisibility(View.GONE);
        llReviewfortextHome.setVisibility(View.VISIBLE);
        llTextforsumgoneHome.setVisibility(View.VISIBLE);
        tvTitleHome.setText("您今日有新的学习任务");
        tvStartHome.setText("开始学习");
    }


    private void condition2() {
        llAlertHome.setVisibility(View.GONE);
        llTestHome.setVisibility(View.VISIBLE);
        llTaskHome.setVisibility(View.GONE);
        llStartHome.setVisibility(View.GONE);
        llThenHome.setVisibility(View.GONE);
        llReviewfortextHome.setVisibility(View.GONE);
    }

    private void condition3() {
        llAlertHome.setVisibility(View.VISIBLE);
        llTestHome.setVisibility(View.GONE);
        llTaskHome.setVisibility(View.VISIBLE);
        llStartHome.setVisibility(View.VISIBLE);
        llThenHome.setVisibility(View.GONE);
        llReviewfortextHome.setVisibility(View.VISIBLE);
        llTextforsumgoneHome.setVisibility(View.GONE);
        tvTitleHome.setText("您今日有新的学习任务");
        tvStartHome.setText("开始学习");
    }

    private void condition4() {
        llAlertHome.setVisibility(View.GONE);
        llTestHome.setVisibility(View.GONE);
        llTaskHome.setVisibility(View.VISIBLE);
        llStartHome.setVisibility(View.VISIBLE);
        llThenHome.setVisibility(View.GONE);
        llReviewfortextHome.setVisibility(View.VISIBLE);
        llTextforsumgoneHome.setVisibility(View.GONE);
        tvTitleHome.setText("您有未完成的学习任务");
        tvStartHome.setText("继续学习");
    }

    private void condition5() {
        llAlertHome.setVisibility(View.GONE);
        llTestHome.setVisibility(View.GONE);
        llTaskHome.setVisibility(View.VISIBLE);
        llStartHome.setVisibility(View.GONE);
        llThenHome.setVisibility(View.VISIBLE);
        llReviewfortextHome.setVisibility(View.GONE);
        llTextforsumgoneHome.setVisibility(View.GONE);
        tvTitleHome.setText("今天的学习任务已完成");
    }

    @Override
    public void defaultAdd(int i) {

    }

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mMZBanner.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMZBanner.start();
    }

    private void showPop() {
        View root = this.getLayoutInflater().inflate(R.layout.popupwindow_credit_add_screen, null);
        recyclerView = root.findViewById(R.id.popup_recyclerview);
        initData();
        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mPoPupWindowAdapter = new PoPupWindowAdapter(getContext(), mList, this);
        recyclerView.setAdapter(mPoPupWindowAdapter);
        mPoPupWindowAdapter.setOnItemDeleteClick(new OnItemPositionClickListen() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        mPoPupWindowAdapter.notifyDataSetChanged();
        pop = new PopupWindow(root);
        pop.setWidth(900);
        pop.setHeight(430);
        //pop.setAnimationStyle(R.style.PopupWindowAnimStyle);
        pop.setFocusable(true);
        pop.setTouchable(true);
        pop.showAsDropDown(mCircleImageView);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                bgAlpha(1.0f);
            }
        });
        bgAlpha(0.5f);
    }

    private void bgAlpha(float alpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = alpha;// 0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }

    private void initData() {
        PopupWindowBase pop = new PopupWindowBase();
        pop.setImgurl("http://img.redocn.com/sheji/20141219/zhongguofengdaodeliyizhanbanzhijing_3744115.jpg");
        pop.setSum(100);
        pop.setTitle("广东省广州市天河区");
        mList.add(pop);
        mList.add(pop);
        mList.add(pop);
        mList.add(pop);


    }
}
