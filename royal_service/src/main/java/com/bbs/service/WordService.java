package com.bbs.service;

import com.bbs.domain.BbsWordTable;

import java.util.List;

public interface WordService {
    List<BbsWordTable> findAll(int page,int size);

    void save(BbsWordTable wordId);

    void update(int id, long status,int page,int size);
    List<BbsWordTable> findAllWord();
}
