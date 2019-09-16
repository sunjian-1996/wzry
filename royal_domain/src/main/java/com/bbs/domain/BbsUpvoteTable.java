package com.bbs.domain;


public class BbsUpvoteTable {

  private String upvoteUserName;//点赞人
  private long upvoteArticleId;//点赞帖子
  private long isUpvote;//点赞状态，0代表未点赞，1代表已点赞（默认）


  public String getUpvoteUserName() {
    return upvoteUserName;
  }

  public void setUpvoteUserName(String upvoteUserName) {
    this.upvoteUserName = upvoteUserName;
  }


  public long getUpvoteArticleId() {
    return upvoteArticleId;
  }

  public void setUpvoteArticleId(long upvoteArticleId) {
    this.upvoteArticleId = upvoteArticleId;
  }


  public long getIsUpvote() {
    return isUpvote;
  }

  public void setIsUpvote(long isUpvote) {
    this.isUpvote = isUpvote;
  }

}
