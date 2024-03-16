package com.swu.myRPCVersion2.server;

import com.swu.myRPCVersion2.service.BlogService;
import com.swu.myRPCVersion2.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 14:49
 * @since 1.0
 **/
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
//        Map<String, Object> serviceProvide = new HashMap<>();
//        // 暴露两个服务接口，即在RPCServer中加入一个HashMap
//        serviceProvide.put("com.swu.myRPCVersion2.service.UserService", userService);
//        serviceProvide.put("com.swu.myRPCVersion2.service.BlogService", blogService);

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

//        SimpleRPCServerImpl rpcServer = new SimpleRPCServerImpl(serviceProvider);
//        rpcServer.start(8899);
        ThreadPoolRPCServer threadPoolRPCServer = new ThreadPoolRPCServer(serviceProvider);
        threadPoolRPCServer.start(8899);
    }
}
