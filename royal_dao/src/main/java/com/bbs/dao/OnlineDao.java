package com.bbs.dao;

import com.bbs.domain.BbsUserTable;
import com.bbs.domain.UserOnline;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OnlineDao {

    @Select("select * from bbs_user_table where loginStatus = 1")
    List<BbsUserTable> showOnline() throws Exception;
}
