package com.bbs.service;

import com.bbs.domain.BbsArticleTable;

import java.util.List;

public interface ArticleService {
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    void publish(BbsArticleTable articleTable) throws Exception;
}
