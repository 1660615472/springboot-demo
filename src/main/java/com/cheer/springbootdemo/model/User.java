package com.cheer.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;//用户名
    private String password;//用户密码
    private String tel;//用户电话
    private int id;//用户id
    private int role_id;//角色的id

    public User(String name, String password, String tel, int id, int role_id) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.id = id;
        this.role_id = role_id;
    }
}
