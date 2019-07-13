package com.cheer.springbootdemo.web.controller;


import com.cheer.springbootdemo.model.User;


import com.cheer.springbootdemo.service.UserService;
import com.cheer.springbootdemo.utils.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("tologin")
    public String login() {
        return "index";
    }

    @RequestMapping("/userLogin")
    public String userLogin(){
        return "userLogin";
    }

    @PostMapping("login")
    public String login(@RequestParam(value = "tel") String tel,@RequestParam(value = "password") String password,
    HttpServletRequest request,Model model ){
        String client_tel = tel;//用户电话
        String client_password = password; //用户密码
        //根据用户输入的手机号查找数据库是否存在这个用户
        User user = userService.queryUserByTel ( tel );
        if(null == user){
            log.debug ( "账号或密码错误" );
        }

        //判断用户信息是否正确
        String client_password1 = StringUtils.encrypt ( client_password );
        if(client_tel.equals ( user.getTel ())&&client_password1.equals ( user.getPassword () ) ){
            //正确就放入域中
            HttpSession session = request.getSession ();
            session.setAttribute ( "user",user );
            log.debug ( "登陆成功>>>>>>>>>>>>>>>>>>>" );
            return "redirect:showAllMessage";

        }else {
            return "redirect:/index";
        }

    }



    @RequestMapping("/userRegister")
    public String userRegister(){
        return "userRegister";
    }

    /**
     * 执行注册判断
     * @param name
     * @param tel
     * @param password
     * @param client_code
     * @param request
     * @return
     */
    @PostMapping("/userRegister")
    public String userRegister(@RequestParam(value = "name") String name, @RequestParam(value = "tel") String tel,@RequestParam(value = "password") String
      password ,@RequestParam(value = "code") String client_code, HttpServletRequest request){
        User unCheckUser = userService.queryUserByTel ( tel );
        //String server_code = stringRedisTemplate.opsForValue().get(tel);//获取正确的验证码，根据key获取缓存中的val
        if(null !=unCheckUser){
            String jsonStr = "{\"errorCode\":\"01\",\"errorMessage\":\"用户已存在！\"}";
            throw new RuntimeException ( jsonStr );

        }else {//如果数据库没有这个用户（没注册过）
            List<User> userList = userService.getUserList ();
            int id =userList.size ()+1;
           password = StringUtils.encrypt ( password );
            int result = userService.registerUser (name,tel,password,id,2);//将用户的角色默认设置为2(普通用户)
            log.debug ( result+">>>>>>>>>>>>>>>>" );
            if(result == 1){
                log.debug ( "注册成功!" );
            }

        }

        return "redirect:/tologin";

    }
}
