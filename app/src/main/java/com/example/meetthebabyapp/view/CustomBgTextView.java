package com.example.meetthebabyapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.example.meetthebabyapp.util.DensityUtil;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomBgTextView extends AppCompatTextView {

    private Context mContext;
    private int mWidth;
    private int mHeight;

    public CustomBgTextView(Context context) {
        super(context);
        mContext = context;
    }

    public CustomBgTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public CustomBgTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBg(canvas);
        super.onDraw(canvas);
    }

    private void drawBg(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FEEE35"));
        paint.setStyle(Paint.Style.FILL);

        int height = DensityUtil.dip2px(mContext, 10);

        RectF rectF = new RectF(0, mHeight - height, mWidth, mHeight);
        canvas.drawRect(rectF, paint);
    }
}
