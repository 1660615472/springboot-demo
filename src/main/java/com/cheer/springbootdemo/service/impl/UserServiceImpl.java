package com.cheer.springbootdemo.service.impl;

import com.cheer.springbootdemo.dao.UserDao;
import com.cheer.springbootdemo.model.User;
import com.cheer.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public int registerUser(String name,String tel,String password,int id,int role_id) {
       return userDao.registerUser ( name,tel,password,id,2 );
    }

    @Override
    public User queryUserByTel(String tel) {
       User user = userDao.queryUserByTel ( tel );
       return user;
    }

    @Override
    public List<User> getUserList() {
       return this.userDao.getUserList ();
    }
}
