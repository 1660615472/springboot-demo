package com.cheer.springbootdemo.web.controller;

import com.cheer.springbootdemo.model.Message;
import com.cheer.springbootdemo.model.User;
import com.cheer.springbootdemo.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 这是用户发帖类
 * */

@Log4j2
@Controller
public class MessageController {

    final static int one = 1;

    @Autowired
    MessageService messageService;

    /**
     * 主页点击发帖，跳转到发帖页面
     * @return
     */
    @RequestMapping("writeMessage")
    public String writeMessage(){
        return "writeMessage";
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam("title") String title, @RequestParam("article") String article
    , HttpSession session)throws Exception{
        User user = (User)session.getAttribute ( "user" );
       String username = user.getName ();
        int userId = user.getId ();//获取发帖者的信息
        Date writeTime = new Date (  );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" );
        String writeTime1 = simpleDateFormat.format ( writeTime );

        //把发帖人发的帖子信息保存到数据库
        int flag = messageService.addMessage (1,title,username,article,writeTime1,0,userId );
        if(one == flag){
            log.debug ( "帖子插入数据库成功+>>>>" );
            return "redirect:showAllMessage";
        }else {
            return null;
        }
    }

    //首页展示帖子的方法
    @RequestMapping("showAllMessage")
    public String showAllMessage(Model model){
        //查找数据库所有的帖子
        List<Message> allMessageList = messageService.getAllMessage ();
        model.addAttribute ( "allMessageList", allMessageList);

        return "index";
    }
}
