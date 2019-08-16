package com.example.meetthebabyapp.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.activity.dynamic.ParticularsActivity;
import com.example.meetthebabyapp.base.HomeFragmnetRecyclViewBase;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<MyMultipleItem, BaseViewHolder> {
    private ImgListAdapter mImgListAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager mGridLayoutManager;
    private TextView tvname, tvtime, tvcontent, tvcomment, tvlovesum;
    private View mViewtapy;
    private String tapy;

    public MultipleItemAdapter(List data,String tapy) {
        super(data);
        this.tapy=tapy;
        addItemType(MyMultipleItem.FIRST_TYPE, R.layout.recyclview_home_item);//给对应编号布局绑定xml
    }


    @Override
    protected void convert(BaseViewHolder helper, final MyMultipleItem item) {
        switch (helper.getItemViewType()) {
            case MyMultipleItem.FIRST_TYPE:
                mViewtapy=helper.getView(R.id.v_tapy);
                TextView delete=helper.getView(R.id.tv_delete_recyclview);
                if (tapy.equals("1")){//    默认显示，传入1为主页，不显示分割线
                    mViewtapy.setVisibility(View.GONE);
                }else if (tapy.equals("2")){//显示删除动态按钮
                    delete.setVisibility(View.VISIBLE);
                }
                recyclerView = helper.getView(R.id.rv_item_imglist);
                final ImageView ivislove = helper.getView(R.id.tv_islove_item);
                tvname = helper.getView(R.id.tv_name_recyclview);
                tvtime = helper.getView(R.id.tv_time_recyclview);
                tvcontent = helper.getView(R.id.tv_content_recyclview);
                tvcomment = helper.getView(R.id.tv_comment_recyclview);
                tvlovesum = helper.getView(R.id.tv_lovesum_recyclview);
                Log.e("islove",""+item.getData().getIslove());

                if (item.getData().getIslove()) {
                    ivislove.setSelected(true);
                } else {
                    ivislove.setSelected(false);
                }

                tvlovesum.setText("" + item.getData().getLoveList().size());
                tvcomment.setText("" + item.getData().getCommentBaseList().size());
                tvname.setText(item.getData().getName());//名字
                tvtime.setText(item.getData().getTime());//时间
                tvcontent.setText(item.getData().getContent());//正文
                Glide.with(mContext).load(item.getData().getHeadimgurl()).into((ImageView) helper.getView(R.id.civ_headimg));//
                    //创建布局管理
                mGridLayoutManager = new GridLayoutManager(mContext, 3);
                    recyclerView.setLayoutManager(mGridLayoutManager);
                    mImgListAdapter = new ImgListAdapter(mContext,item.getData().getImgList());
                    recyclerView.setAdapter(mImgListAdapter);
                    mImgListAdapter.setList(item.getData().getImgList());
                tvcontent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //点击文字跳转到详情页
                        Intent intent=new Intent(mContext, ParticularsActivity.class);
                        mContext.startActivity(intent);
                    }
                });

                ivislove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (item.getData().getIslove()) {
                            ivislove.setSelected(false);
                            item.getData().setIslove(false);
                        } else {
                            item.getData().setIslove(true);
                            ivislove.setSelected(true);
                        }
                    }
                });

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"删除"+item.getData().getId(), Toast.LENGTH_SHORT).show();
                        Log.e("删除",""+item.getData().getId());
                    }
                });

        }

    }
}