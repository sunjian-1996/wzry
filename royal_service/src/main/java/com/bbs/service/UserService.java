package com.bbs.service;

import com.bbs.domain.BbsUserTable;

import java.util.List;

public interface UserService{

    BbsUserTable findByUserName(BbsUserTable bbsUserTable);

    public List<BbsUserTable> findByPage();

    List<BbsUserTable> findByUserName(String userName,Long role);

    void updateUser(int userId,int role);

    void WordAndReply(int userId,int talkStatus);
public interface UserService {


    BbsUserTable findByuserName(String userName);

    void save(BbsUserTable bbsUserTable);
}
