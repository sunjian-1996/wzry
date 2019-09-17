package com.bbs.dao;

import com.bbs.domain.BbsReplyTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyDao {

    //根据评论id找回复
    @Select("SELECT * FROM bbs_reply_table WHERE commentId = #{commentId}")
    public List<BbsReplyTable> findByCommentId(int commentId);
}
