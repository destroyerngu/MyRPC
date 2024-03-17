package com.swu.myRPCVersion3.service;

import com.swu.myRPCVersion3.common.Blog;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 14:46
 * @since 1.0
 **/
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").useId(21).build();
        System.out.println("客户端查询了" + id + "博客");
        return blog;
    }
}
