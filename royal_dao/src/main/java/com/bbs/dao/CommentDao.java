package com.bbs.dao;

import com.bbs.domain.BbsCommentTable;
import org.apache.ibatis.annotations.*;

public interface CommentDao {

    //根据帖id获取评论
    @Select("select * from bbs_comment_table where articleId = #{articleId}")
    @Results({
            @Result(id = true, property = "commentId", column = "commentId"),
            @Result(property = "bbsReplyTables", column = "commentId", many = @Many(
                    select = "com.bbs.dao.ReplyDao.findByCommentId"
            ))
    })
    public BbsCommentTable findByArticleId(int articleId) throws Exception;

    //新增评论
    @Insert("insert into bbs_comment_table(commentContent,commentUserName,articleId) values(#{commentContent},#{commentUserName},#{articleId}) ")
    void addComment(BbsCommentTable bbsCommentTable) throws Exception;
}
