package com.cheer.springbootdemo.service.impl;

import com.cheer.springbootdemo.dao.MessageDao;
import com.cheer.springbootdemo.model.Message;
import com.cheer.springbootdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;

    //保存发帖信息

    @Override
    public int addMessage(int mid, String title, String author, String article, String time, int reply_count, int userId) {
        int i = messageDao.addMessage ( mid, title, author, article, time, reply_count, userId );
        return i;
    }

    //获得所有帖子
    @Override
    public List<Message> getAllMessage() {
       return messageDao.getAllMessage ();
    }
}
