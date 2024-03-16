package com.swu.myRPCVersion1.server;

import com.swu.myRPCVersion1.common.RPCRequest;
import com.swu.myRPCVersion1.common.RPCResponse;
import com.swu.myRPCVersion1.service.UserService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 13:27
 * @since 1.0
 **/
public class RPCServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务端启动了");
            // 以BIO的方式监听socket
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        // 读取客户端传来的request
                        RPCRequest request = (RPCRequest) ois.readObject();
                        // 反射调用对应方法
                        Method method = userService.getClass().getMethod(request.getMethodName(), request.getParamTypes());
                        Object invoke = method.invoke(userService, request.getParams());
                        // 封装，写入response对象
                        oos.writeObject(RPCResponse.success(invoke));
                        oos.flush();

                    } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        e.printStackTrace();
                        System.out.println("从IO中读取数据错误");
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }

    }
}
