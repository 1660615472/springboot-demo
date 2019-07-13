package com.cheer.springbootdemo.dao;

import com.cheer.springbootdemo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     *
     * @param name
     * @param tel
     * @param password
     * @param role_id
     */
    int registerUser(@Param("name") String name,@Param("tel") String tel,@Param("password") String password,@Param("id") int id,@Param("role_id") int role_id);

    User queryUserByTel(@Param ( "tel" ) String tel );

    List<User> getUserList(); //获取所有用户的数量集合

}
