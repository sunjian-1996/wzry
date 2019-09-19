package com.bbs.service;

public interface UpvoteService {
    int findDianZanStatus(String userName, long articleId) throws Exception;

    long dianZan(String userName, long articleId) throws Exception;
}
