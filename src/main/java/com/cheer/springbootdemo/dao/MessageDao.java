package com.cheer.springbootdemo.dao;

import com.cheer.springbootdemo.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface MessageDao {

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
    int addMessage(@RequestParam("mid") int mid, @RequestParam("title") String title,
                   @RequestParam("author") String author, @RequestParam("article") String article,
                   @RequestParam("time") String time, @RequestParam("reply_count") int reply_count,
                   @RequestParam("userId") int userId);

    //获得所有帖子的集合
    List<Message>  getAllMessage();
}
