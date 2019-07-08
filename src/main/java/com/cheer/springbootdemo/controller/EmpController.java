package com.cheer.springbootdemo.controller;

import com.cheer.springbootdemo.service.EmpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/listEmp")
    public String listEmp(Model model) {
       model.addAttribute("empList", empService.getList());
       return "listEmp";
    }
}
