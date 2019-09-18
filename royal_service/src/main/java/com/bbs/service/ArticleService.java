package com.bbs.service;

import com.bbs.domain.BbsArticleTable;

import java.util.List;

public interface ArticleService {
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    List<BbsArticleTable> findByPage(int page, int size);

    List<BbsArticleTable> findByTitleOrSenderName(String title, String senderName);

    void publish(BbsArticleTable articleTable) throws Exception ;

    BbsArticleTable getArticle(long articleId) throws Exception ;
}
