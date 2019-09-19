package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.domain.BbsZoneTable;
import com.bbs.domain.BbsZoneapplyTable;
import com.bbs.service.ZoneService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("zoneService")
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneDao zoneDao;

    @Override
    public List<BbsZoneTable> findAll() throws Exception {
        return zoneDao.findAll();
    }

    //版块管理分页及内容查询
    @Override
    public List<BbsZoneapplyTable> findByPageAndTitle(int page, int size, String zone, String senderName) {
        PageHelper.startPage(page,size);
        return zoneDao.findByPageAndTitle(zone,senderName);
    }

    //同意开辟新版块
    @Override
    public void changeStatus1(String applyZoneId, String zoneName) {
        zoneDao.changeStatus1(applyZoneId);
        zoneDao.saveZone(zoneName);
    }

    @Override
    public void changeStatus2(String applyZoneId) {
        zoneDao.changeStatus2(applyZoneId);
    }
}
