package com.bbs.dao;

import com.bbs.domain.BbsWordTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WordDao {

    //查询所有敏感词
    @Select("select * from bbs_word_table")
    List<BbsWordTable> findAll();
}
