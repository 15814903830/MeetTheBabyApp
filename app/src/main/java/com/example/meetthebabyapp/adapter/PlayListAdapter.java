package com.example.meetthebabyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.bean.PlayBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 音频、绘本播放列表
 */
public class PlayListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<PlayBean> mList;

    public PlayListAdapter(Context context, List<PlayBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_playlist_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PlayBean bean = mList.get(position);
        ((ViewHolder) holder).tv_index.setText(String.valueOf(bean.getIndex()));
        ((ViewHolder) holder).tv_title.setText(bean.getTitle());
        ((ViewHolder) holder).tv_duration.setText(bean.getDuration());
        if (bean.isPlayable()) {
            ((ViewHolder) holder).iv_playable.setImageResource(R.mipmap.huibenxiangqing3);
        } else {
            ((ViewHolder) holder).iv_playable.setImageResource(R.mipmap.huibenxiangqing4);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_index;
        TextView tv_title;
        TextView tv_duration;
        ImageView iv_playable;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_index = itemView.findViewById(R.id.tv_index_playlist_item);
            tv_title = itemView.findViewById(R.id.tv_title_playlist_item);
            tv_duration = itemView.findViewById(R.id.tv_duration_playlist_item);
            iv_playable = itemView.findViewById(R.id.iv_playable_playlist_item);
        }
    }

}
