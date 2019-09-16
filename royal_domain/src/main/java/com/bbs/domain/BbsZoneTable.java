package com.bbs.domain;


public class BbsZoneTable {

  private long zoneId;//交流区编号
  private String zoneName;//交流区名字
  private long isDef;//是否默认，1代表默认，2代表非默认


  public long getZoneId() {
    return zoneId;
  }

  public void setZoneId(long zoneId) {
    this.zoneId = zoneId;
  }


  public String getZoneName() {
    return zoneName;
  }

  public void setZoneName(String zoneName) {
    this.zoneName = zoneName;
  }


  public long getIsDef() {
    return isDef;
  }

  public void setIsDef(long isDef) {
    this.isDef = isDef;
  }

}
