package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.BbsWordTable;
import com.bbs.service.WordService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;
    @Override
    public List<BbsWordTable> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return wordDao.findAll(page,size);
    }

    @Override
    public void save(BbsWordTable wordId) {
        wordDao.save(wordId);
    }

    @Override
    public void update(int id, long status,int page,int size) {
        PageHelper.startPage(page, size);
        wordDao.update(id,status,page,size);
    }

}
