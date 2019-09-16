package com.bbs.dao;

import com.bbs.domain.BbsArticleTable;
import com.bbs.domain.BbsArticleTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    @Select("select * from bbs_article_table where zoneId = #{zoneId}")
    public List<BbsArticleTable> findAll(int zoneId) throws Exception;

}
