package com.swu.myRPCVersion0.server;

import com.swu.myRPCVersion0.common.User;
import com.swu.myRPCVersion0.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 12:27
 * @since 1.0
 **/
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了id为" + id + "的用户");
        // 模拟从数据库中取用户的行为
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;
    }
}
