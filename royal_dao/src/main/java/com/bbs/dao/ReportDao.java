package com.bbs.dao;

import com.bbs.domain.BbsReportTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReportDao {

    //根据用户名和帖编号查询举报
    @Select("select * from bbs_report_table where reportUserName = #{userName} and articleId = #{articleId}")
    BbsReportTable findByUserNameAndArticleId(@Param("userName") String userName, @Param("articleId") long articleId);

    //新增举报
    @Insert("insert into bbs_report_table values(null,#{reportContent},#{reportTime},#{reportUserName},#{reportStatus},#{articleId})")
    void addReport(BbsReportTable reportTable) throws Exception;


    @Select("select * from bbs_report_table")
    List<BbsReportTable> findByPage();

    @Update("update bbs_report_table set reportStatus=#{reportStatus} WHERE reportId=#{reportId}")
    void upreportStatus(@Param("reportId") Integer reportId, @Param("reportStatus") Integer reportStatus);

    /**
     * 删除
     *
     * @param reportId
     */
    @Delete("delete from bbs_report_table where reportId=#{reportId}")
    void deleteArticle(Integer reportId);

    @Select("select content from bbs_article_table where articleId = #{articleId}")
    String findArticleContent(int articleId) throws Exception;

}
