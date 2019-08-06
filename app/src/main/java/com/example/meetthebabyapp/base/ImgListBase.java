package com.example.meetthebabyapp.base;

import java.util.List;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class ImgListBase {
    @Override
    public String toString() {
        return "ImgListBase{" +
                "mStringList=" + mStringList +
                '}';
    }

    public List<String> getStringList() {
        return mStringList;
    }

    public void setStringList(List<String> stringList) {
        mStringList = stringList;
    }

    List<String> mStringList;
}
