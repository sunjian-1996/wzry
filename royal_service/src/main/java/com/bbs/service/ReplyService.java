package com.bbs.service;

import com.bbs.domain.BbsReplyTable;
import com.bbs.domain.BbsReportTable;
import com.bbs.domain.BbsUserTable;

import javax.servlet.http.HttpServletRequest;


public interface ReplyService {
    void addReply(BbsReplyTable bbsReplyTable) throws Exception;

    void commentNumber(Long articleId) throws Exception;



}
