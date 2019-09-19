package com.bbs.dao;

import com.bbs.domain.BbsZoneTable;
import com.bbs.domain.BbsZoneapplyTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ZoneDao {

    //查找所有版块
    @Select("select * from bbs_zone_table")
    List<BbsZoneTable> findAll() throws Exception;



    //版块管理分页及内容查询
    @Select("<script>select applyZoneId,zoneName,userName,reason,status from bbs_zoneapply_table where status=0 <if test=\"zone !=null \"> and zoneName like '%${zone}%' </if> <if test=\"senderName !=null \">and userName like '%${senderName}%' </if></script>")
    List<BbsZoneapplyTable> findByPageAndTitle(@Param("zone") String zone,@Param("senderName") String senderName);


    //同意新版块
    @Update("update bbs_zoneapply_table set status = 1 where applyZoneId = #{applyZoneId}")
    void changeStatus1(String applyZoneId);

    //驳回新版块
    @Update("update bbs_zoneapply_table set status = 2 where applyZoneId = #{applyZoneId}")
    void changeStatus2(String applyZoneId);

    //将新版块加入版块数据库
    @Insert("insert into bbs_zone_table (zoneName,isDef) values(#{zoneName},2)")
    void saveZone(String zoneName);
}
