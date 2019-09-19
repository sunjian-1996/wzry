package com.bbs.service;

import com.bbs.domain.BbsUserTable;

public interface UserInfoService {

    void update(BbsUserTable bbsUserTable);

    void updateToPass(BbsUserTable loginUser);

    void upgrade(BbsUserTable loginUser);
}
