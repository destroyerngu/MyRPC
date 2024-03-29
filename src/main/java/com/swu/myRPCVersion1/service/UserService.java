package com.swu.myRPCVersion1.service;


import com.swu.myRPCVersion1.common.User;

public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);
    // 给这个服务增加一个新功能
    Integer insertUser(User user);
}
