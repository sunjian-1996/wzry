package com.bbs.dao;

import com.bbs.domain.BbsArticleTable;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    //查询单个版块的所有帖
    @Select("select * from bbs_article_table where zoneId = #{zoneId} ORDER BY sendTime DESC ")
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    //写帖
    @SelectKey(before = false, keyColumn = "articleId", keyProperty = "articleId", resultType = int.class, statement = "SELECT LAST_INSERT_ID()")
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

    //帖子总数
    @Select("select count(*) from bbs_article_table")
    int tiezifindAll() throws Exception;

    @Select("SELECT COUNT(*) FROM bbs_article_table WHERE sendTime LIKE #{date}")
    int jinritiezifindAll(String date);

    //单个article对象查询
    @Select("select * from bbs_article_table where articleId = #{articleId}")
    BbsArticleTable findById(long articleId) throws Exception;

    //添加评论次数
    @Update("update bbs_article_table set replyCount = #{count} where articleId = #{articleId}")
    void commentNumber(@Param("articleId") long articleId, @Param("count") long count) throws Exception;
}
