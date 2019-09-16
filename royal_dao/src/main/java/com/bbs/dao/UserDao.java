package com.bbs.dao;

import com.bbs.domain.BbsUserTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    //异步验证用户名
    @Select("select * from bbs_user_table where userName = #{userName}")
    BbsUserTable findByuserName(String userName);

    //注册
    @Insert("insert into bbs_user_table(userName,userPass,email) values(#{userName},#{userPass},#{email})")
    void save(BbsUserTable bbsUserTable);
}
