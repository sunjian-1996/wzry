package com.bbs.service.impl;

import com.bbs.dao.DianzanDao;
import com.bbs.service.DianzanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DianzanServiceImpl implements DianzanService {
     @Autowired
    private DianzanDao dianzanDao;


}
