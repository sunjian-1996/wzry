package com.bbs.service;

import com.bbs.domain.BbsZoneTable;
import com.bbs.domain.BbsZoneapplyTable;

import java.util.List;

public interface ZoneService {

    List<BbsZoneTable> findAll() throws Exception;


    //版块管理分页及内容查询
    List<BbsZoneapplyTable> findByPageAndTitle(int page, int size, String zone, String senderName);

    //同意开辟新版块
    void changeStatus1(String applyZoneId, String zoneName);

    void changeStatus2(String applyZoneId);
}
