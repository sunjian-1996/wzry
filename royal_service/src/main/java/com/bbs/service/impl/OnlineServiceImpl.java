package com.bbs.service.impl;

import com.bbs.dao.OnlineDao;
import com.bbs.domain.BbsUserTable;
import com.bbs.domain.UserOnline;
import com.bbs.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineServiceImpl implements OnlineService {
    @Autowired
    private OnlineDao onlineDao;
    @Autowired
    private UserOnline userOnline;
    @Override
    public UserOnline showOnline() throws Exception {
        List<BbsUserTable> list = onlineDao.showOnline();
        userOnline.setList(list);
        return userOnline;
    }
}
