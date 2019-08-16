package com.example.meetthebabyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.bean.MenuBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 我的、菜单列表适配器
 */
public class MineMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements View.OnClickListener {

    private Context mContext;
    private List<MenuBean> mList;

    public MineMenuAdapter(Context context, List<MenuBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_mine_menu_layout, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuBean bean = mList.get(position);
        ((ViewHolder) holder).imageView.setImageResource(bean.getImageRes());
        ((ViewHolder) holder).textView.setText(bean.getItem());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListen != null) {
            onItemClickListen.onClick(view);
        }
    }

    private OnItemClickListen onItemClickListen;

    public void setOnItemClickListen(OnItemClickListen onItemClickListen) {
        this.onItemClickListen = onItemClickListen;
    }

    public interface OnItemClickListen {
        void onClick(View view);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_mine_menu_item);
            textView = itemView.findViewById(R.id.tv_mine_menu_item);
        }
    }

}
