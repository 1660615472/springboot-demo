package com.cheer.springbootdemo.model;

import lombok.Data;

import java.util.Date;
/*
* 回复/评论bean
* */
@Data
public class Reply {
    private String replier;//评论人

    private Date reply_time;//评论时间

    private String reply_content;//评论内容

    private int replyId;//评论id

}
