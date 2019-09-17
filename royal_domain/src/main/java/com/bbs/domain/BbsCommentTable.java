package com.bbs.domain;

import java.util.Date;
import java.util.List;

public class BbsCommentTable {

    private long commentId;//评论编号
    private String commentContent;//评论内容
    private Date commentTime;//评论时间
    private String commentUserName;//评论人
    private long commentStatus;//评论状态，1代表屏蔽，0代表解除
    private long articleId;//帖子编号
    private List<BbsReplyTable> bbsReplyTables; //回复表

    public List<BbsReplyTable> getBbsReplyTables() {
        return bbsReplyTables;
    }

    public void setBbsReplyTables(List<BbsReplyTable> bbsReplyTables) {
        this.bbsReplyTables = bbsReplyTables;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public long getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(long commentStatus) {
        this.commentStatus = commentStatus;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }
}
