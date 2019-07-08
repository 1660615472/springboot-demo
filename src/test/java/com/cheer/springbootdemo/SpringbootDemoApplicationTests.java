package com.cheer.springbootdemo;

import com.cheer.springbootdemo.service.EmpService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    private EmpService empService;

    @Test
    public void getList() {
       log.debug(empService.getList());
    }

}
