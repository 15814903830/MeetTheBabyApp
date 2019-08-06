package com.example.meetthebabyapp.base;

import java.util.List;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class HomeFragmnetRecyclViewBase {
    public boolean getIslove() {
        return islove;
    }

    @Override
    public String toString() {
        return "HomeFragmnetRecyclViewBase{" +
                "islove=" + islove +
                ", headimgurl='" + headimgurl + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", imgList=" + imgList +
                ", loveList=" + loveList +
                ", mCommentBaseList=" + mCommentBaseList +
                '}';
    }

    public void setIslove(boolean islove) {
        this.islove = islove;
    }

    private boolean islove;//头像
    private String headimgurl;//头像
    private String name;//名字
    private String time;//时间
    private String content;//正文
    private List<String> imgList;//配图集合
    private List<String> loveList;//点赞集合
    private List<CommentBase> mCommentBaseList;//评论集合

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public List<String> getLoveList() {
        return loveList;
    }

    public void setLoveList(List<String> loveList) {
        this.loveList = loveList;
    }

    public List<CommentBase> getCommentBaseList() {
        return mCommentBaseList;
    }

    public void setCommentBaseList(List<CommentBase> commentBaseList) {
        mCommentBaseList = commentBaseList;
    }

    public static class CommentBase{
        @Override
        public String toString() {
            return "CommentBase{" +
                    "Commentheadimgurl='" + Commentheadimgurl + '\'' +
                    ", Commentname='" + Commentname + '\'' +
                    ", Commentcontent='" + Commentcontent + '\'' +
                    '}';
        }

        String  Commentheadimgurl;
        String  Commentname;

        public String getCommentheadimgurl() {
            return Commentheadimgurl;
        }

        public void setCommentheadimgurl(String commentheadimgurl) {
            Commentheadimgurl = commentheadimgurl;
        }

        public String getCommentname() {
            return Commentname;
        }

        public void setCommentname(String commentname) {
            Commentname = commentname;
        }

        public String getCommentcontent() {
            return Commentcontent;
        }

        public void setCommentcontent(String commentcontent) {
            Commentcontent = commentcontent;
        }

        String  Commentcontent;
    }
}


