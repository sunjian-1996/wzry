package com.bbs.dao;

import com.bbs.domain.BbsReplyTable;
import com.bbs.domain.BbsReportTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReplyDao {

    //根据评论id找回复
    @Select("SELECT * FROM bbs_reply_table WHERE commentId = #{commentId}")
    @Results({
            @Result(property = "replyUserName", column = "replyUserName"),
            @Result(property = "userTouXiang", column = "replyUserName", one = @One(
                    select = "com.bbs.dao.UserDao.findByTouXiang"
            ))
    })
    public List<BbsReplyTable> findByCommentId(int commentId);

    //新增回复
    @Insert("insert into bbs_reply_table(replyContent,replyUserName,commentId) values(#{replyContent},#{replyUserName},#{commentId})")
    void addReply(BbsReplyTable bbsReplyTable) throws Exception;


}
