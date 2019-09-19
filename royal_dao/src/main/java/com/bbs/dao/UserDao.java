package com.bbs.dao;

import com.bbs.domain.BbsUserTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    //异步验证用户名
    @Select("select * from bbs_user_table where userName = #{userName}")
    BbsUserTable findByuserName(String userName);

    //注册
    @Insert("insert into bbs_user_table(userName,userPass,email) values(#{userName},#{userPass},#{email})")
    void save(BbsUserTable bbsUserTable);

    //改变登录状态
    @Update("update bbs_user_table set loginStatus = 1 where userName = #{userName}")
    void gaibiandengluzhuangtai(String userName);
    //改变注销登录状态
    @Update("update bbs_user_table set loginStatus = 0 where userName = #{userName}")
    void gaibiandengluzhuangtai2(String userName);
}
