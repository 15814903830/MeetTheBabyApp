package com.example.meetthebabyapp.adapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.meetthebabyapp.base.HomeFragmnetRecyclViewBase;

import java.util.List;


/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class MyMultipleItem implements MultiItemEntity {

    public static final int FIRST_TYPE = 1;//设置布局编号
    public static final int SECOND_TYPE = 2;
    public static final int NORMAL_TYPE = 3;

    private int itemType;
    private HomeFragmnetRecyclViewBase homeFragmnetRecyclViewBase;


    public MyMultipleItem(int itemType, HomeFragmnetRecyclViewBase homeFragmnetRecyclViewBase) {
        this.itemType = itemType;
        this.homeFragmnetRecyclViewBase = homeFragmnetRecyclViewBase;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public HomeFragmnetRecyclViewBase  getData(){
        return homeFragmnetRecyclViewBase;
    }
}