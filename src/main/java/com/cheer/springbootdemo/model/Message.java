package com.cheer.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;

/*
* 帖子bean
*
* */

@Data
public class Message implements Serializable {
    private int mid;//文章id

    private String title;//文章标题

    private String author;//文章作者

    private String article;//文章主内容

    private String time;//文章的创建时间

    private int reply_count;//文章的评论次数

    private int userId;//发帖人id
}
