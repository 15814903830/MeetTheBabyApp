package com.example.meetthebabyapp.bean;

/**
 * 个人、菜单项
 */
public class MenuBean {

    private int imageRes;
    private String item;

    public MenuBean(int imageRes, String item) {
        this.imageRes = imageRes;
        this.item = item;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getItem() {
        return item;
    }
}
