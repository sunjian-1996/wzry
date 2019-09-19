package com.bbs.domain;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserOnline {
    private List<BbsUserTable> list; //储存在线用户的集合
    private int totalNum;           //计算在线用户数

    public List<BbsUserTable> getList() {
        return list;
    }

    public void setList(List<BbsUserTable> list) {
        this.list = list;
    }

    public int getTotalNum() {
        totalNum=0;
        for (BbsUserTable user : list) {
            totalNum+=1;
        }
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
