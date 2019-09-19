package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.BbsWordTable;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wordService")
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;

    @Override
    public List<BbsWordTable> findAll() {
        return wordDao.findAll();
    }
}
