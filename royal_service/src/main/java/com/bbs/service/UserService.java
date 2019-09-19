package com.bbs.service;

import com.bbs.domain.BbsUserTable;
import com.bbs.domain.BbsZoneapplyTable;

public interface UserService {


    BbsUserTable findByuserName(String userName);

    void save(BbsUserTable bbsUserTable);

    void gaibiandengluzhuangtai(String userName);

    void gaibiandengluzhuangtai2(String userName);

    Boolean addZone(BbsZoneapplyTable zoneapply);
}
