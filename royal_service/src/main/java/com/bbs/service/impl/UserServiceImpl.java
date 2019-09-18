package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

/*    @Override
    public User login(String userName,String userPass) {
        return userDao.findWithLoginAndPassword( userName,userPass );
    }*/

    /*管理员登录*/
    @Override
    public BbsUserTable findByUserName(BbsUserTable bbsUserTable) {
        return userDao.findWithLoginAndPassword( bbsUserTable );
    }

    /*查询所有用户*/
    @Override
    public List<BbsUserTable> findByPage() {
        return userDao.findByPage();
    }

    /*升级*/
    @Override
    public void updateUser(int userId, int role) {
        userDao.updateUser( userId, role );
    }


    /*模糊查询*/
    @Override
    public List<BbsUserTable> findByUserName(String userName, Long role) {
        return userDao.findByUserName( userName, role );
    }


    /*禁言和恢复*/
    @Override
    public void WordAndReply(int userId,int talkStatus) {
        userDao.WordAndReply(userId,talkStatus);
    }


/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BbsUserTable bbsUserTable = null;
        try {
            bbsUserTable = userDao.findByUsername( username );
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(bbsUserTable.getUserName(),bbsUserTable.getUserPass(),null);
        return user;*/
}


