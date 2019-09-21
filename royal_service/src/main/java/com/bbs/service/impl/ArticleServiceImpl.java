package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageHelper;
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
    public long publish(BbsArticleTable articleTable) throws Exception {
        articleTable.setSendTime(new Date());
        articleDao.publish(articleTable);
        return articleTable.getArticleId();
    }

    @Override
    public BbsArticleTable getArticle(long articleId) throws Exception {
        return articleDao.getArticle(articleId);
    }

    @Override
    public List<BbsArticleTable> findByPage(int page, int size,String title, String senderName) {
        PageHelper.startPage(page, size);
        return articleDao.findByPage(page,size,title,senderName);
    }

    //帖子总数
    @Override
    public int tiezifindAll() throws Exception {
        return articleDao.tiezifindAll();
    }

    @Override
    public int jinritiezifindAll(String date) throws Exception {
        return articleDao.jinritiezifindAll(date);
    }

    @Override
    public long publishCount(String userName) throws Exception {
        return articleDao.publishCount(userName);
    }

    //关键字查询功能
    @Override
    public List<BbsArticleTable> findByKeyword(String keyword) {
        String keyword1="%"+ keyword+"%";
        String keyword2=keyword1;
        List<BbsArticleTable> byKeyword = articleDao.findByKeyword(keyword1, keyword2);
        return byKeyword;
    }

    @Override
    public void changeStatus(Integer articleId, Integer isTop) {
        articleDao.changeStatus(articleId, isTop);
    }

    @Override
    public List<BbsArticleTable> findAllPage() throws Exception {
        return articleDao.findAllPage();
    }
    @Override
    public void articleStatus(Integer articleId, Integer articleStatus) {
        articleDao.articleStatus(articleId, articleStatus);
    }
}
