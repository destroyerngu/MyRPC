package com.swu.myRPCVersion4.service;


import com.swu.myRPCVersion4.common.User;

public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);

    Integer insertUserId(User user);
}
