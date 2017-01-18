package com.my.spring.model;

import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/1/18.
 */
public class CommunicationEntity {
    private String theme;
    private String title;
    private String userName;
    private Long   replyQuantity;
    private String contents;
    private Timestamp publishedTime;
    private Timestamp replyTime;
    public CommunicationEntity(){}
    public CommunicationEntity(String theme, String title, String userName, Long replyQuantity, String contents, Timestamp publishedTime, Timestamp replyTime) {
        this.theme = theme;
        this.title = title;
        this.userName = userName;
        this.replyQuantity = replyQuantity;
        this.contents = contents;
        this.publishedTime = publishedTime;
        this.replyTime = replyTime;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getReplyQuantity() {
        return replyQuantity;
    }

    public void setReplyQuantity(Long replyQuantity) {
        this.replyQuantity = replyQuantity;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Timestamp getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Timestamp publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }
}
