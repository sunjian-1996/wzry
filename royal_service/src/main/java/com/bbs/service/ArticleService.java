package com.bbs.service;

import com.bbs.domain.BbsArticleTable;

import java.util.List;

public interface ArticleService {

    List<BbsArticleTable> findByPage(int page, int size,String title,String senderName);

    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

    long publish(BbsArticleTable articleTable) throws Exception;

    BbsArticleTable getArticle(long articleId) throws Exception;

    //帖子总数
    int tiezifindAll() throws Exception;

    //今日帖子
    int jinritiezifindAll(String date) throws Exception;
//用户发帖计数
    long publishCount(String userName) throws Exception;

    //关键字查询功能
    List<BbsArticleTable> findByKeyword(String keyword);


    void changeStatus(Integer articleId,Integer isTop);

    List<BbsArticleTable> findAllPage() throws Exception;

    void articleStatus(Integer articleId,Integer articleStatus);
}
