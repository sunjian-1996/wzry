package com.bbs.dao;

import com.bbs.domain.BbsWordTable;
import org.apache.ibatis.annotations.*;
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
    List<BbsWordTable> findAll(int page, int size);

    @Insert("insert into bbs_word_table(word,status) values(#{word},#{status})")
    void save(BbsWordTable wordId);

    //查询所有敏感词
    @Select("select * from bbs_word_table")
    List<BbsWordTable> findAllWord();

    @Update("update bbs_word_table set status=#{status} where wordId=#{id}")
    void update(@Param("id") int id, @Param("status") long status,int page,int size);
}
