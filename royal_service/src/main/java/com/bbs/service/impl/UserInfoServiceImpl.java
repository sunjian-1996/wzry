package com.bbs.service.impl;

import com.bbs.dao.UserInfoDao;
import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    //修改邮箱
    @Override
    public void update(BbsUserTable bbsUserTable) {
        userInfoDao.update(bbsUserTable);
    }

    //修改密码
    @Override
    public void updateToPass(BbsUserTable loginUser) {
        userInfoDao.updateToPass(loginUser);
    }

}
