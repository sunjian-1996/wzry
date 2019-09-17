package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.util.Date;

public class BbsReplyTable {

    private long replyId;//回复编号
    private String replyContent;//回复内容
    private Date replyTime;//回复时间
    private String replyUserName;//回复人
    private long commentId;//评论编号

    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return DateUtils.date2String(replyTime);
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
}


