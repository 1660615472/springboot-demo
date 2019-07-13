package com.cheer.springbootdemo.service;

import com.cheer.springbootdemo.model.Message;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface MessageService {


    /**
     * 保存帖子方法
     * @param mid
     * @param title
     * @param author
     * @param article
     * @param time
     * @param reply_count
     * @param userId
     * @return
     */
    int addMessage(int mid ,  String title, String author,  String article, String time,  int reply_count,
                  int userId);

    //获得所有帖子集合
    List<Message> getAllMessage();
}
