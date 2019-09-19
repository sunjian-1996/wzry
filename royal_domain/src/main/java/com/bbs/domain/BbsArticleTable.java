package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BbsArticleTable implements Serializable {

    private long articleId;//帖子编号
    private String title;//标题
    private String content;//内容
    private Date sendTime;//发送时间
    private String senderName;//发送人编号
    private long isTop;//是否置顶，如果是0，代表不置顶；如果是1，代表置顶；
    private long replyCount;//评论数
    private long upvoteCount;//点赞数
    private long browseCount;//浏览数
    private Integer zoneId;//所在交流区
    private String zoneIdStr;//

    public String getZoneIdStr() {
        if (zoneId!=null){
            if (zoneId==1){
                zoneIdStr="综合交流区";
            }else if (zoneId==2){
                zoneIdStr="BUG反馈区";
            }else if (zoneId==3){
                zoneIdStr="新闻公告区";
            }else if (zoneId==4){
                zoneIdStr="活动专区";
            }
        }
        return zoneIdStr;
    }

    public void setZoneIdStr(String zoneIdStr) {
        this.zoneIdStr = zoneIdStr;
    }

    private long isReport;//举报状态
    private List<BbsCommentTable> bbsCommentTables; //评论表

    public List<BbsCommentTable> getBbsCommentTables() {
        return bbsCommentTables;
    }

    public void setBbsCommentTables(List<BbsCommentTable> bbsCommentTables) {
        this.bbsCommentTables = bbsCommentTables;
    }

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

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public long getIsReport() {
        return isReport;
    }

    public void setIsReport(long isReport) {
        this.isReport = isReport;
    }
}
