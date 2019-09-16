package com.bbs.domain;


import java.util.Date;

public class BbsUserTable {

  private long userId;//用户ID
  private String userName;//用户名
  private String userPass;//密码
  private String email;//邮箱
  private String picUrl;//头像
  private long role;//1代表普通用户；2代表高级用户，3代表超级管理员
  private Date lastLoginTime;//最后登录时间
  private long loginStatus;//登录状态，0代表未登录，1代表已登录
  private long talkStatus;//发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
  private long isupdating;//申请升级(0-未申请,1-已申请)
  private long updateStatus;//申请升级审核状态(0-未处理,1-已处理)

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPass() {
    return userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public long getLoginStatus() {
    return loginStatus;
  }

  public void setLoginStatus(long loginStatus) {
    this.loginStatus = loginStatus;
  }

  public long getTalkStatus() {
    return talkStatus;
  }

  public void setTalkStatus(long talkStatus) {
    this.talkStatus = talkStatus;
  }

  public long getIsupdating() {
    return isupdating;
  }

  public void setIsupdating(long isupdating) {
    this.isupdating = isupdating;
  }

  public long getUpdateStatus() {
    return updateStatus;
  }

  public void setUpdateStatus(long updateStatus) {
    this.updateStatus = updateStatus;
  }
}


