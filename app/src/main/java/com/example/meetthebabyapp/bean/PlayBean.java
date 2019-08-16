package com.example.meetthebabyapp.bean;

/**
 * 音频
 */
public class PlayBean {

    private int index;  //序号
    private String title;  //标题
    private String duration;  //时长
    private boolean playable;  //是否可播放

    public PlayBean() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}
