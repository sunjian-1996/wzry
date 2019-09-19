package com.bbs.dao;
import com.bbs.domain.BbsUserTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("select * from bbs_user_table where userName = #{userName} and userPass = #{userPass}")
    BbsUserTable findWithLoginAndPassword(BbsUserTable bbsUserTable);

    @Select("select * from bbs_user_table")
    List<BbsUserTable> findByPage();

    @Update( "update bbs_user_table set role=#{role} where userId = #{userId}" )
    void updateUser(@Param( "userId" ) Integer userId,@Param("role") long role);


    /*模糊查询*/
    @Select( {"<script>" ,
            "select * from bbs_user_table " ,
            "<where>",
            "  <if test=\"userName != null and userName != '' \">" ,
            "  and userName=#{userName} " ,
                    "</if>",
            "  <if test=\"role != null and role != '' \">" ,
            "  and role=#{role} " ,
                    "</if>",
            "</where>",
            "</script>" })
    List<BbsUserTable> findByUserName(@Param("userName") String userName,@Param("role") String role);


    /*禁言和恢复*/
    @Update( "update bbs_user_table set talkStatus = #{talkStatus} where userId = #{userId}")
    void WordAndReply(@Param( "userId" ) int userId,@Param("talkStatus") int talkStatus);

    @Select( "select * from bbs_user_table where userName = #{userName}" )
    BbsUserTable findUserByName(String userName);



/*    @Select("select * from bbs_user_table where username = #{username}")
    public BbsUserTable findByUsername(String username) throws Exception;*/






    //异步验证用户名
    @Select("select * from bbs_user_table where userName = #{userName}")
    BbsUserTable findByuserName(String userName);

    //注册
    @Insert("insert into bbs_user_table(userName,userPass,email) values(#{userName},#{userPass},#{email})")
    void save(BbsUserTable bbsUserTable);
}
