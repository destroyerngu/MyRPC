package com.swu.myRPCVersion4.server;


import com.swu.myRPCVersion4.service.BlogService;
import com.swu.myRPCVersion4.service.BlogServiceImpl;
import com.swu.myRPCVersion4.service.UserService;
import com.swu.myRPCVersion4.service.UserServiceImpl;

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