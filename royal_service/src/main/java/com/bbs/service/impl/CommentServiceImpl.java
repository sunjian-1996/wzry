package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.dao.CommentDao;
import com.bbs.domain.BbsArticleTable;
import com.bbs.domain.BbsCommentTable;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ArticleDao articleDao;

    //新增评论次数
    @Override
    public void addComment(BbsCommentTable bbsCommentTable) throws Exception {
        commentDao.addComment(bbsCommentTable);
        BbsArticleTable articleTable = articleDao.findById(bbsCommentTable.getArticleId());
        articleDao.commentNumber(bbsCommentTable.getArticleId(), articleTable.getReplyCount() + 1);
    }
}
