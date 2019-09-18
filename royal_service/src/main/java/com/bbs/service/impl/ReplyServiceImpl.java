package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.dao.ReplyDao;
import com.bbs.domain.BbsArticleTable;
import com.bbs.domain.BbsReplyTable;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void addReply(BbsReplyTable bbsReplyTable) throws Exception {
        replyDao.addReply(bbsReplyTable);
    }

    @Override
    public void commentNumber(Long articleId) throws Exception {
        BbsArticleTable byId = articleDao.findById(articleId);
        articleDao.commentNumber(articleId, byId.getReplyCount() + 1);
    }
}
