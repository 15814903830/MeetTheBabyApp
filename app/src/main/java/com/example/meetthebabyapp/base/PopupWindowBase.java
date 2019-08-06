package com.example.meetthebabyapp.base;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class PopupWindowBase {
    private int sum;

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "PopupWindowBase{" +
                "sum=" + sum +
                ", imgurl='" + imgurl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String imgurl;
    private String title;
}
