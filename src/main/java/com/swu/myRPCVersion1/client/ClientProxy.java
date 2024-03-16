package com.swu.myRPCVersion1.client;

import com.swu.myRPCVersion1.common.RPCRequest;
import com.swu.myRPCVersion1.common.RPCResponse;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 13:52
 * @since 1.0
 **/
@AllArgsConstructor
public class ClientProxy implements InvocationHandler {
    // 传入参数Service接口的class对象，反射封装成一个request
    private String host;
    private int port;

    // jdk 动态代理， 每一次代理对象调用方法，会经过此方法增强（反射获取request对象，socket发送至客户端）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest request = RPCRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramTypes(method.getParameterTypes()).build();
        // 数据传输
        RPCResponse response = IOClient.sendRequest(host, port, request);
        System.out.println(response);
        return response.getData();
    }

    <T>T getProxy(Class<T> clazz) {
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }


}
