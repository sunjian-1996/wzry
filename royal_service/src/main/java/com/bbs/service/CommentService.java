package com.bbs.service;

import com.bbs.domain.BbsCommentTable;

public interface CommentService {
    void addComment(BbsCommentTable bbsCommentTable) throws Exception;
}
