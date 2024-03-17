package com.swu.myRPCVersion3.client;

import com.swu.myRPCVersion3.common.RPCRequest;
import com.swu.myRPCVersion3.common.RPCResponse;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/17 9:43
 * @since 1.0
 **/

// SimpleRPCClient实现这个接口，不同的网络方式有着不同的实现
@AllArgsConstructor
public class SimpleRPCClient implements RPCClient{

    private String host;
    private int port;
    @Override
    public RPCResponse sendRequest(RPCRequest request) {
        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);
            oos.writeObject(request);
            oos.flush();

            RPCResponse response = (RPCResponse) ois.readObject();

            return response;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            return null;
        }
    }
}
