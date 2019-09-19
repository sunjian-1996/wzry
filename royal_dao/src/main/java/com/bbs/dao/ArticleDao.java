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
    @Select("select * from bbs_article_table where zoneId = #{zoneId} and articleStatus = 0 ORDER BY sendTime DESC ")
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

    //分页+模糊查询
    @Select("<script>select * from bbs_article_table where 1=1 <if test=\"title !=null \">and title like '%${title}%' </if> <if test=\"senderName !=null \">and senderName like '%${senderName}%' </if></script>")
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
            @Result(property = "isReport",column = "isReport")
    })
    List<BbsArticleTable> findByPage(@Param("page") int page,@Param("size") int size,@Param("title") String title, @Param("senderName") String senderName);

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

    //用户发帖计数
    @Select("select count(*) from bbs_article_table where senderName = #{userName}")
    long publishCount(String userName) throws Exception;

    //查询点赞次数
    @Select("select upvoteCount from bbs_article_table where articleId = #{articleId}")
    Long findDianZanCount(long articleId) throws Exception;

    //修改点赞次数
    @Update("update bbs_article_table set upvoteCount = #{dianZanCount} where articleId = #{articleId}")
    void addDianZan(@Param("articleId") long articleId, @Param("dianZanCount") Long dianZanCount);

    //关键字查询功能
    @Select("select * from bbs_article_table where articleStatus = 0 and (title like #{keyword1} or content like #{keyword2})")
    List<BbsArticleTable> findByKeyword(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2);
}
