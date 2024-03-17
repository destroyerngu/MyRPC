package com.swu.myRPCVersion3.server;

import com.swu.myRPCVersion3.service.BlogService;
import com.swu.myRPCVersion3.service.BlogServiceImpl;
import com.swu.myRPCVersion3.service.UserService;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/17 10:16
 * @since 1.0
 **/
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
