package com.swu.myRPCVersion0.server;

import com.swu.myRPCVersion0.common.User;
import com.swu.myRPCVersion0.service.UserService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 12:43
 * @since 1.0
 **/
public class RPCServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务端启动了");
            // 以BIO的方式监听Socket
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        // 读取从客户端传来的id
                        Integer id = ois.readInt();
                        User user = userService.getUserByUserId(id);
                        // 写入User对象给客户端
                        oos.writeObject(user);
                        oos.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("从IO中读取数据异常");

                    }
                    // 读取从客户端传来的id

                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }

    }
}
