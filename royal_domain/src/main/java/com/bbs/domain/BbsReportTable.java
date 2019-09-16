package com.bbs.domain;


import java.util.Date;

public class BbsReportTable {

  private long reportId;// 无意义id
  private String reportContent;//举报内容
  private Date reportTime;//举报时间
  private String reportUserName;//处理状举报人态
  private long reportStatus;//处理状态
  private long articleId;//文章ID

  public long getReportId() {
    return reportId;
  }

  public void setReportId(long reportId) {
    this.reportId = reportId;
  }

  public String getReportContent() {
    return reportContent;
  }

  public void setReportContent(String reportContent) {
    this.reportContent = reportContent;
  }

  public Date getReportTime() {
    return reportTime;
  }

  public void setReportTime(Date reportTime) {
    this.reportTime = reportTime;
  }

  public String getReportUserName() {
    return reportUserName;
  }

  public void setReportUserName(String reportUserName) {
    this.reportUserName = reportUserName;
  }

  public long getReportStatus() {
    return reportStatus;
  }

  public void setReportStatus(long reportStatus) {
    this.reportStatus = reportStatus;
  }

  public long getArticleId() {
    return articleId;
  }

  public void setArticleId(long articleId) {
    this.articleId = articleId;
  }
}
