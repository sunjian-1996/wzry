package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    /*`articleId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '帖子编号',
      `title` VARCHAR(500) DEFAULT NULL COMMENT '标题',
      `content` TEXT NOT NULL COMMENT '内容',
      `sendTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
      `senderName` VARCHAR(255) NOT NULL COMMENT '发送人编号',
      `isTop` INT(11) NOT NULL DEFAULT '0' COMMENT '是否置顶，如果是0，代表不置顶；如果是1，代表置顶；',
      `replyCount` INT(11) NOT NULL DEFAULT '0' COMMENT '评论数',
      `upvoteCount` INT(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
      `browseCount` INT(11) NOT NULL DEFAULT '0' COMMENT '浏览数',
      `zoneId` INT(11) NOT NULL COMMENT '所在交流区',
      `isReport` INT(2) DEFAULT '0' COMMENT '举报状态',*/
    private int articleId;
    private String title;
    private String content;
    private Date sendTime;
    private String sendTimeStr;
    private String senderName;
    private int isTop;
    private int replyCount;
    private int upvoteCount;
    private int browseCount;
    private int zoneId;
    private int isReport;

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", sendTimeStr='" + sendTimeStr + '\'' +
                ", senderName='" + senderName + '\'' +
                ", isTop=" + isTop +
                ", replyCount=" + replyCount +
                ", upvoteCount=" + upvoteCount +
                ", browseCount=" + browseCount +
                ", zoneId=" + zoneId +
                ", isReport=" + isReport +
                '}';
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendTimeStr() {
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(int upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public int getIsReport() {
        return isReport;
    }

    public void setIsReport(int isReport) {
        this.isReport = isReport;
    }
}
