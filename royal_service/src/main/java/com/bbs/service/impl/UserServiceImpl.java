package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.dao.ZoneapplyDao;
import com.bbs.domain.BbsUserTable;
import com.bbs.domain.BbsZoneapplyTable;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ZoneapplyDao zoneapplyDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();

    //异步验证用户名
    @Override
    public BbsUserTable findByuserName(String userName) {
        return userDao.findByuserName(userName);
    }

    //注册
    @Override
    public void save(BbsUserTable bbsUserTable) {
        bbsUserTable.setUserPass(bCryptPasswordEncoder.encode(bbsUserTable.getUserPass()));
        userDao.save(bbsUserTable);
    }

    //改变登录状态
    @Override
    public void gaibiandengluzhuangtai(String userName) {
        userDao.gaibiandengluzhuangtai(userName);
    }

    //注销改变登录状态
    @Override
    public void gaibiandengluzhuangtai2(String userName) {
        userDao.gaibiandengluzhuangtai2(userName);
    }

    //    添加新版块
    @Override
    public Boolean addZone(BbsZoneapplyTable zoneapply) {
        try {
            zoneapplyDao.addZone(zoneapply);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
