package com.bbs.dao;

import com.bbs.domain.BbsCommentTable;
import org.apache.ibatis.annotations.*;

public interface CommentDao {

    @Select("select * from bbs_comment_table where articleId = #{articleId}")
    @Results({
            @Result(id = true, property = "commentId", column = "commentId"),
            @Result(property = "bbsReplyTables", column = "commentId", many = @Many(
                    select = "com.bbs.dao.ReplyDao.findByCommentId"
            ))
    })
    public BbsCommentTable findByArticleId(int articleId) throws Exception;

    @Insert("insert into bbs_comment_table(commentContent,commentUserName,articleId) values(#{commentContent},#{commentUserName},#{articleId}) ")
    void addComment(BbsCommentTable bbsCommentTable) throws Exception;
}
