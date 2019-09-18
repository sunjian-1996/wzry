package com.bbs.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UpvoteDao {

    //查询点赞状态
    @Select("select isUpvote from bbs_upvote_table where upvoteUserName = #{userName} " +
            "and upvoteArticleId = #{articleId}")
    public int findDianZanStatus(@Param("userName") String userName,
                                 @Param("articleId") long articleId) throws Exception;

    //点赞功能
    @Update("update bbs_upvote_table set isUpvote = #{status} where " +
            "upvoteUserName = #{userName} and upvoteArticleId = #{articleId}")
    void dianZan(@Param("userName") String userName,
                 @Param("articleId") long articleId, @Param("status") int status) throws Exception;

    //是否有过点赞记录
    @Select("select count(*) from bbs_upvote_table where upvoteUserName = #{userName} " +
            "and upvoteArticleId = #{articleId}")
    int findByUpvoteExteisExist(@Param("userName") String userName,
                                @Param("articleId") long articleId) throws Exception;

    //新增点赞用户
    @Insert("insert into bbs_upvote_table values(#{userName},#{articleId},1)")
    void save(@Param("userName") String userName,
              @Param("articleId") long articleId) throws Exception;
}
