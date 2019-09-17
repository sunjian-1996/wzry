package com.bbs.dao;

import com.bbs.domain.BbsZoneTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZoneDao {

    //查找所有版块
    @Select("select * from bbs_zone_table")
    List<BbsZoneTable> findAll() throws Exception;
}
