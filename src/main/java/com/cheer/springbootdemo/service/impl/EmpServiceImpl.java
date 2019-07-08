package com.cheer.springbootdemo.service.impl;

import com.cheer.springbootdemo.dao.EmpMapper;
import com.cheer.springbootdemo.model.Emp;
import com.cheer.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional // 声明事务 将该类下所有的公有方法都设置为事务方法
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper; // 该错误提示可以忽略，是ide误报的，原因是找不到EmpMapper的实现类在spring容器里

    @Override
    public List<Emp> getList() {
        return this.empMapper.getList();
    }

    @Override
    public void delete(Integer empNo) throws Exception {
        this.empMapper.delete(empNo);
    }

    @Override
    public void insert(Emp emp) throws Exception {
        this.empMapper.insert(emp);
    }

    @Override
    public Emp getEmp(Integer empNo) {
        return this.empMapper.getEmp(empNo);
    }

    @Override
    public void update(Emp emp) throws Exception {
        this.empMapper.update(emp);
    }

    @Override
    public Map<String, Object> getEmpMap(Integer empNo) {
        return this.empMapper.getEmpMap(empNo);
    }
}
