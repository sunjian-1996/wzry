package com.bbs.service;

import com.bbs.domain.BbsReplyTable;

public interface ReplyService {
    void addReply(BbsReplyTable bbsReplyTable) throws Exception;

    void commentNumber(Long articleId) throws Exception;
}
