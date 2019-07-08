package com.cheer.springbootdemo.service;

import com.cheer.springbootdemo.model.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
    List<Emp> getList();

    void delete(Integer empNo) throws Exception;

    void insert(Emp emp) throws Exception;

    Emp getEmp(Integer empNo);

    void update(Emp emp) throws Exception;

    Map<String, Object> getEmpMap(Integer empNo);
}
