package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //异步验证用户名
    @Override
    public BbsUserTable findByuserName(String userName) {
        return userDao.findByuserName(userName);
    }

    //注册
    @Override
    public void save(BbsUserTable bbsUserTable) {
//        bbsUserTable.setUserPass(bCryptPasswordEncoder.encode(bbsUserTable.getUserPass()));
        userDao.save(bbsUserTable);
    }
}
