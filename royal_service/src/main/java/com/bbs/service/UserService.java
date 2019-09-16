package com.bbs.service;

import com.bbs.domain.BbsUserTable;

public interface UserService {


    BbsUserTable findByuserName(String userName);

    void save(BbsUserTable bbsUserTable);
}
