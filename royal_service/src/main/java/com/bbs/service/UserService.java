package com.bbs.service;

import com.bbs.domain.BbsUserTable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import com.bbs.domain.BbsZoneapplyTable;
public interface UserService extends UserDetailsService {

//    BbsUserTable findByUserName(BbsUserTable bbsUserTable);

    public List<BbsUserTable> findByPage(int page, int size);


    public List<BbsUserTable> findByPage();

    List<BbsUserTable> findByUserName(String userName, String role,int page,int size);

    void updateUser(int userId, int role);

    void WordAndReply(int userId, int talkStatus);

    BbsUserTable findByuserName(String userName);

    void save(BbsUserTable bbsUserTable);

    void gaibiandengluzhuangtai(String userName);

    void gaibiandengluzhuangtai2(String userName);

    Boolean addZone(BbsZoneapplyTable zoneapply);
}
