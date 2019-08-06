package com.example.meetthebabyapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.meetthebabyapp.R;
import com.example.meetthebabyapp.base.PopupWindowBase;
import com.example.meetthebabyapp.listen.OnItemPositionClickListen;
import com.example.meetthebabyapp.util.MyProgressBar;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 地址列表适配器
 */
public class PoPupWindowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    public List<PopupWindowBase> getList() {
        return mList;
    }

    public void setList(List<PopupWindowBase> list) {
        mList = list;
    }

    private List<PopupWindowBase> mList;
    private defaultAddress mDefaultAddress;

    public PoPupWindowAdapter(Context context, List<PopupWindowBase> list, defaultAddress mDefaultAddress) {
        this.mContext = context;
        this.mList = list;
        this.mDefaultAddress=mDefaultAddress;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.pow_recyclview_item, viewGroup, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        PopupWindowBase popupWindowBase = mList.get(i);
        ((ViewHolder) viewHolder).tv_popuo_title.setText(popupWindowBase.getTitle());
        ((ViewHolder) viewHolder).tv_sum.setText(""+popupWindowBase.getSum()+"%");
        ((ViewHolder) viewHolder).pb_myProgressBar.setProgress(popupWindowBase.getSum());
        Glide.with(mContext).load(popupWindowBase.getImgurl()).into(((ViewHolder) viewHolder).iv_popuo__img);
        ((ViewHolder) viewHolder).iv_popuo__img.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemDeleteClick != null) {
                    onItemDeleteClick.onClick(i);
                }
                mDefaultAddress.defaultAdd(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
    }

    private OnItemPositionClickListen onItemDeleteClick;

    public void setOnItemDeleteClick(OnItemPositionClickListen onItemDeleteClick) {
        this.onItemDeleteClick = onItemDeleteClick;
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_popuo_title;
        TextView tv_sum;
        MyProgressBar pb_myProgressBar;
        CircleImageView iv_popuo__img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pb_myProgressBar = itemView.findViewById(R.id.pb_myProgressBar);
            tv_sum = itemView.findViewById(R.id.tv_popuo_sum);
            tv_popuo_title = itemView.findViewById(R.id.tv_popuo_title);
            iv_popuo__img = itemView.findViewById(R.id.cv_popuo__img);
        }
    }

    public interface defaultAddress{
        void defaultAdd(int i);
    }
}
