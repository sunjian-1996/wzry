package com.bbs.service;

import com.bbs.domain.BbsArticleTable;

import java.util.List;

public interface ArticleService {

    List<BbsArticleTable> findByPage(int page, int size);

    List<BbsArticleTable> findByTitleOrSenderName(String title, String senderName);

    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    long publish(BbsArticleTable articleTable) throws Exception;

    BbsArticleTable getArticle(long articleId) throws Exception;

    //帖子总数
    int  tiezifindAll() throws Exception;
    //今日帖子
    int  jinritiezifindAll(String date) throws Exception;
}
