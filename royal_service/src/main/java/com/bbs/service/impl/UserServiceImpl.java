package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //异步验证用户名
    @Override
    public BbsUserTable findByuserName(String userName) {
        return userDao.findByuserName( userName );
    }

    //注册
    @Override
    public void save(BbsUserTable bbsUserTable) {
        bbsUserTable.setUserPass( bCryptPasswordEncoder.encode( bbsUserTable.getUserPass() ) );
        userDao.save( bbsUserTable );
    }

    //改变登录状态
    @Override
    public void gaibiandengluzhuangtai(String userName) {
        userDao.gaibiandengluzhuangtai( userName );
    }

    //注销改变登录状态
    @Override
    public void gaibiandengluzhuangtai2(String userName) {
        userDao.gaibiandengluzhuangtai2( userName );
    }


    /*查询所有用户*/
    @Override
    public List<BbsUserTable> findByPage(int page, int size) {
        PageHelper.startPage( page,size );
        return userDao.findByPage();
    }

    @Override
    public List<BbsUserTable> findByPage() {
        return userDao.findByPage();
    }

    /*升级*/
    @Override
    public void updateUser(int userId, int role) {
        userDao.updateUser( userId, role );
    }


    /*条件查询*/
    @Override
    public List<BbsUserTable> findByUserName(String userName, String role, int page, int size) {
        if ("0".equals( role )){
            role=null;
        }
        PageHelper.startPage( page, size );
        return userDao.findByUserName( "%"+userName+"%", role );
    }


    /*禁言和恢复*/
    @Override
    public void WordAndReply(int userId,int talkStatus) {
        userDao.WordAndReply( userId, talkStatus );
    }


    /**/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BbsUserTable userInfo = null;
        try {
            userInfo = userDao.findUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUserName(), "{noop}"+userInfo.getUserPass(), userInfo.getLoginStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRole()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(Long roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        if(roles == 3){
            list.add( new SimpleGrantedAuthority( "ROLE_ADMIN" ) );
        }
        return list;
    }


}


