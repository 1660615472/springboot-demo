package com.cheer.springbootdemo.dao;

import com.cheer.springbootdemo.model.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    Emp getEmp(Integer empNo);

    /**
     * @param emp
     * @return 受影响的行数
     */
    int insert(Emp emp);

    List<Emp> getPageList();

    Map<String, Object> getEmpMap(Integer empNo);

    Emp getEmpResultMap(Integer empNo);

    List<Emp> getList();

    int delete(Integer empNo);

    int update(Emp emp);
}