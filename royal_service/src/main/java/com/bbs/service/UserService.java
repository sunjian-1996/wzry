package com.bbs.service;

import com.bbs.domain.BbsUserTable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

//    BbsUserTable findByUserName(BbsUserTable bbsUserTable);

    public List<BbsUserTable> findByPage(int page, int size);

    public List<BbsUserTable> findByPage();

    List<BbsUserTable> findByUserName(String userName, String role,int page,int size);

    void updateUser(int userId, int role);

    void WordAndReply(int userId, int talkStatus);

    BbsUserTable findByUserName(String userName);

    void save(BbsUserTable bbsUserTable);
}
