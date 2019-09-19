package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.dao.UpvoteDao;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("upvoteService")
public class UpvoteServiceImpl implements UpvoteService {
    @Autowired
    private UpvoteDao upvoteDao;
    @Autowired
    private ArticleDao articleDao;

    //查询点赞状态
    @Override
    public int findDianZanStatus(String userName, long articleId) throws Exception {
        int exist = upvoteDao.findByUpvoteExteisExist(userName, articleId);
        if (exist == 0) {
            return 0;
        }
        return upvoteDao.findDianZanStatus(userName, articleId);
    }

    //点赞功能
    @Override
    public long dianZan(String userName, long articleId) throws Exception {
        int exist = upvoteDao.findByUpvoteExteisExist(userName, articleId);
        if (exist == 0) {
            upvoteDao.save(userName, articleId);
            Long dianZanCount = articleDao.findDianZanCount(articleId);
            articleDao.addDianZan(articleId, dianZanCount+1);
            return dianZanCount + 1;
        }
        int status = upvoteDao.findDianZanStatus(userName, articleId);
        Long dianZanCount = articleDao.findDianZanCount(articleId);
        if (status == 0) {
            status = 1;
            dianZanCount++;
        } else if (status == 1) {
            status = 0;
            dianZanCount--;
        }
        upvoteDao.dianZan(userName, articleId, status);
        articleDao.addDianZan(articleId, dianZanCount);
        return dianZanCount;

    }

}
