package com.example.meetthebabyapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.activity.dynamic.PersonageActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 地址列表适配器
 */
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    private List<String> mList;

    public CommentAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.comment_item_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
       // Glide.with(mContext).load(mList.get(i)).into( ((ViewHolder) viewHolder).iv_img);//
        Glide.with(mContext).load("http://img3.imgtn.bdimg.com/it/u=3139953554,3011511497&fm=26&gp=0.jpg").into( ((ViewHolder) viewHolder).iv_img);//
        ((ViewHolder) viewHolder).iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击评论的头像跳转到个人
                Intent intent=new Intent(mContext, PersonageActivity.class);
                mContext.startActivity(intent);
            }
        });
        ((ViewHolder) viewHolder).tv_comment.setText("评论内容");
        ((ViewHolder) viewHolder).tv_name.setText("名字");
    }

    @Override
    public int getItemCount() {
        return 20;
       // return mList.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView iv_img;
        TextView tv_name;
        TextView tv_comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.civ_headimg_comment);
            tv_name = itemView.findViewById(R.id.tv_name_recyclview_comment);
            tv_comment = itemView.findViewById(R.id.tv_comment__comment);
        }
    }

}
