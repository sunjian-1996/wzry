package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.util.Date;

public class BbsArticleTable {

    private long articleId;//帖子编号
    private String title;//标题
    private String content;//内容
    private Date sendTime;//发送时间
    private String senderName;//发送人编号
    private long isTop;//是否置顶，如果是0，代表不置顶；如果是1，代表置顶；
    private long replyCount;//评论数
    private long upvoteCount;//点赞数
    private long browseCount;//浏览数
    private long zoneId;//所在交流区
    private long isReport;//举报状态

    @Override
    public String toString() {
        return "BbsArticleTable{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + this.getSendTime() +
                ", senderName='" + senderName + '\'' +
                ", isTop=" + isTop +
                ", replyCount=" + replyCount +
                ", upvoteCount=" + upvoteCount +
                ", browseCount=" + browseCount +
                ", zoneId=" + zoneId +
                ", isReport=" + isReport +
                '}';
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return DateUtils.date2String(sendTime);
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public long getIsTop() {
        return isTop;
    }

    public void setIsTop(long isTop) {
        this.isTop = isTop;
    }

    public long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(long replyCount) {
        this.replyCount = replyCount;
    }

    public long getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(long upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public long getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(long browseCount) {
        this.browseCount = browseCount;
    }

    public long getZoneId() {
        return zoneId;
    }

    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }

    public long getIsReport() {
        return isReport;
    }

    public void setIsReport(long isReport) {
        this.isReport = isReport;
    }
}
