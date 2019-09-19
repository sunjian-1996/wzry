package com.bbs.service;

import com.bbs.domain.BbsWordTable;

import java.util.List;

public interface WordService {

    List<BbsWordTable> findAll();
}
