package com.swu.myRPCVersion2.client;

import com.swu.myRPCVersion2.common.Blog;
import com.swu.myRPCVersion2.common.User;
import com.swu.myRPCVersion2.service.BlogService;
import com.swu.myRPCVersion2.service.UserService;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 14:04
 * @since 1.0
 **/
public class RPCClient {
    public static void main(String[] args) {
        RPCClientProxy rpcClientProxy = new RPCClientProxy("127.0.0.1", 8899);
        UserService proxy = rpcClientProxy.getProxy(UserService.class);

        // 服务1的方法
        User user1 = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + user1);

        // 服务2的方法
        User user2 = User.builder().userName("Ezra").id(100).sex(true).build();
        Integer i = proxy.insertUser(user2);
        System.out.println("向服务器插入数据" + i);

        // 新增服务的方法
        BlogService blogService = rpcClientProxy.getProxy(BlogService.class);
        Blog blog = blogService.getBlogById(222);
        System.out.println("从服务端得到的blog为：" + blog);
    }
}
