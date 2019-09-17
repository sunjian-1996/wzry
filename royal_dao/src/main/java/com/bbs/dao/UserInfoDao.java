package com.bbs.dao;

import com.bbs.domain.BbsUserTable;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
    //修改邮箱
    @Update("update bbs_user_table set email=#{email} where userId = #{userId}")
    void update(BbsUserTable bbsUserTable);
}
