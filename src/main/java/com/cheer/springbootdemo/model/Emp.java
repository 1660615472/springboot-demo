package com.cheer.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.StringJoiner;

// 如果使用二级缓存 模型类必须实现序列号接口
@Data
public class Emp implements Serializable {
    private Integer empNo;
    private String empName;
    private String job;
    private Integer mgr;
    private String hireDate;
    private Double sal;
    private Double com;
    private Integer deptNo;
}
