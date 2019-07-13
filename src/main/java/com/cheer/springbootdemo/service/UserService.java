package com.cheer.springbootdemo.service;

import com.cheer.springbootdemo.dao.UserDao;
import com.cheer.springbootdemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    /**
     *注册用户
     * @param name
     * @param tel
     * @param password
     * @param role_id
     * @return
     */
    int registerUser(String name,String tel,String password,int id ,int role_id);


    User queryUserByTel(@Param ( "tel" ) String tel);

    List<User> getUserList(); //获取所有用户的数量集合

}
