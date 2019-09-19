package com.bbs.dao;

import com.bbs.domain.BbsZoneapplyTable;
import org.apache.ibatis.annotations.Insert;

public interface ZoneapplyDao {
//    添加新版块
    @Insert("insert into bbs_zoneapply_table values(#{applyZoneId},#{zoneName},#{userName},#{reason},#{status})")
    void addZone(BbsZoneapplyTable zoneapply)throws Exception;
}
