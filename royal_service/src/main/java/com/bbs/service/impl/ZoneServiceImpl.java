package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.domain.BbsZoneTable;
import com.bbs.service.ZoneService;
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
}
