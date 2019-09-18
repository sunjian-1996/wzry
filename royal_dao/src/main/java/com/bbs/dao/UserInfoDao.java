package com.bbs.dao;

import com.bbs.domain.BbsUserTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
    //修改邮箱
    @Update("update bbs_user_table set email=#{email},picUrl=#{picUrl} where userName = #{userName}")
    void update(BbsUserTable bbsUserTable);


    //修改密码
    @Update("update bbs_user_table set userPass=#{userPass} where userName=#{userName}")
    void updateToPass(BbsUserTable loginUser);
}
