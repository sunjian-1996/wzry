package com.bbs.dao;

import com.bbs.domain.BbsArticleTable;
import com.bbs.domain.BbsArticleTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleDao {

    //查询单个版块的所有帖
    @Select("select * from bbs_article_table where zoneId = #{zoneId} ORDER BY sendTime DESC ")
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    //写帖
    @Insert("insert into bbs_article_table(title,content,sendTime,senderName,zoneId) values(" +
            "#{title},#{content},#{sendTime},#{senderName},#{zoneId})")
    void publish(BbsArticleTable articleTable) throws Exception;

    //帖详情
    @Select("select * from bbs_article_table where articleId = #{articleId}")
    @Results({
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "bbsCommentTables", column = "articleId", many = @Many(
                    select = "com.bbs.dao.CommentDao.findByArticleId"
            ))
    })
    BbsArticleTable getArticle(long articleId) throws Exception;
}
