package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("articleTable")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<BbsArticleTable> findAll(int zoneId) throws Exception {
        return articleDao.findAll(zoneId);
    }

    @Override
    public void publish(BbsArticleTable articleTable) throws Exception {
        articleTable.setSendTime(new Date());
        articleDao.publish(articleTable);
    }

    @Override
    public BbsArticleTable getArticle(long articleId) throws Exception {
        return articleDao.getArticle(articleId);
    }
}
