package com.bbs.dao;

import com.bbs.domain.BbsCommentTable;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CommentDao {

    @Select("select * from bbs_comment_table where articleId = #{articleId}")
    @Results({
            @Result(id = true, property = "commentId", column = "commentId"),
            @Result(property = "bbsReplyTables", column = "commentId", many = @Many(
                    select = "com.bbs.dao.ReplyDao.findByCommentId"
            ))
    })
    public BbsCommentTable findByArticleId(int articleId);
}
