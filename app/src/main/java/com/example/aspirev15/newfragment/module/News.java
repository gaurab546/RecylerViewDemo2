package com.example.aspirev15.newfragment.module;

/**
 * Created by Aspire V15 on 12/8/2016.
 */

public class News {

    private String newsTitle;
    private String newsDesc;
    private String publishDate;

    public News(String title, String desc, String date) {
        this.newsTitle=title;
        this.newsDesc=desc;
        this.publishDate=date;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
