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
}
