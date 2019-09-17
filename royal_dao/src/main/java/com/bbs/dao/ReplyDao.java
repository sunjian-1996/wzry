package com.bbs.dao;

import com.bbs.domain.BbsReplyTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyDao {

    @Select("SELECT * FROM bbs_reply_table WHERE commentId = #{commentId}")
    public List<BbsReplyTable> findByCommentId(int commentId);
}
