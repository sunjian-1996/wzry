package com.bbs.dao;

import com.bbs.domain.BbsReportTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ReportDao {

    //根据用户名和帖编号查询举报
    @Select("select * from bbs_report_table where reportUserName = #{userName} and articleId = #{articleId}")
    BbsReportTable findByUserNameAndArticleId(@Param("userName") String userName, @Param("articleId") long articleId);

    //新增举报
    @Insert("insert into bbs_report_table values(null,#{reportContent},#{reportTime},#{reportUserName},#{reportStatus},#{articleId})")
    void addReport(BbsReportTable reportTable) throws Exception;
}
