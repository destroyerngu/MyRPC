package com.swu.myRPCVersion0.service;

import com.swu.myRPCVersion0.common.User;

public interface UserService {
    /**
     * 客户端通过这个接口调用服务端的实现类
     * @param id 用户id
     * @return 用户对象
     */
    User getUserByUserId(Integer id);
}
