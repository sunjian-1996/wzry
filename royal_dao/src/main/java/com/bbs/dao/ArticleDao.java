package com.bbs.dao;

import com.bbs.domain.BbsArticleTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    @Select("select * from bbs_article_table where zoneId = #{zoneId}")
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    @Select("select * from bbs_article_table where articleId=#{articleId}")
    List<BbsArticleTable> findByPage(long articleId);

    @Select("<script>select * from bbs_article_table <if test=\"title !=null \">where title = #{title} </if></script>")

    List<BbsArticleTable> findByTitleOrSenderName(@Param("title") String title, @Param("senderName") String senderName);
    @Select("select * from bbs_article_table ")
    @Results({
            @Result(id = true,property = "articleId",column = "articleId"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "sendTime",column = "sendTime"),
            @Result(property = "senderName",column = "senderName"),
            @Result(property = "isTop",column = "isTop"),
            @Result(property = "replyCount",column = "replyCount"),
            @Result(property = "upvoteCount",column = "upvoteCount"),
            @Result(property = "browseCount",column = "browseCount"),
            @Result(property = "zoneId",column = "zoneId"),
            @Result(property = "isReport",column = "isReport"),

    })
    List<BbsArticleTable> findByPage(int page, int size);

    void publish(BbsArticleTable articleTable);

    BbsArticleTable getArticle(long articleId);
}
