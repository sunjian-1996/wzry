package com.bbs.dao;

import com.bbs.domain.BbsWordTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WordDao {
    @Select("select * from bbs_word_table")
    @Results({
            @Result(id = true, property = "wordId", column = "wordId"),
            @Result(property = "word", column = "word"),
            @Result(property = "status", column = "status"),

    })
    List<BbsWordTable> findAll(int page,int size);

    @Insert("insert into bbs_word_table(word,status) values(#{word},#{status})")
    void save(BbsWordTable wordId);
}
