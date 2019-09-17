package com.bbs.dao;

import com.bbs.domain.BbsArticleTable;
import com.bbs.domain.BbsArticleTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    @Select("select * from bbs_article_table where zoneId = #{zoneId}")
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    @Insert("insert into bbs_article_table(title,content,sendTime,senderName,zoneId) values(" +
            "#{title},#{content},#{sendTime},#{senderName},#{zoneId})")
    void publish(BbsArticleTable articleTable) throws Exception;

    @Select("select * from bbs_article_table where id = #{articleId}")
    BbsArticleTable getArticle(long articleId) throws Exception;
}
