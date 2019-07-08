package com.cheer.springbootdemo.service;

import com.cheer.springbootdemo.model.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTest {
    @Autowired
    private EmpService empService;

    @Test
    public void getList() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void getEmp() {
    }

    @Test
    public void update() {
        Emp emp = this.empService.getEmp(7788);
        emp.setCom(20.0);
        try {
            this.empService.update(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getEmpMap() {
    }
}