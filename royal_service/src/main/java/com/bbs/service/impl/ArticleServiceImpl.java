package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleTable")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<BbsArticleTable> findAll(int zoneId) throws Exception {
        return articleDao.findAll(zoneId);
    }
}
