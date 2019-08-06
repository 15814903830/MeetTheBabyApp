package com.example.meetthebabyapp.adapter;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class CustomLinearGridLayoutManager extends GridLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomLinearGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomLinearGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public CustomLinearGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }


    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        int orientation = getOrientation();
        if (orientation == LinearLayoutManager.VERTICAL) {
            return isScrollEnabled && super.canScrollVertically();
        }
        return super.canScrollVertically();
    }

    @Override
    public boolean canScrollHorizontally() {
        int orientation = getOrientation();
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            return isScrollEnabled && super.canScrollHorizontally();
        }
        return super.canScrollHorizontally();
    }
}
