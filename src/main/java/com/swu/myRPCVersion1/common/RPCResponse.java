package com.swu.myRPCVersion1.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 13:20
 * @since 1.0
 **/

/**
 * 上个例子中response传输的是User对象，显然在一个应用中我们不可能只传输一种类型的数据
 * 由此我们将传输对象抽象成为Object
 * Rpc需要经过网络传输，有可能失败，类似于http，引入状态码和状态信息表示服务调用成功还是失败
 */
@Builder
@Data
public class RPCResponse implements Serializable {
    // 状态信息
    private int code;
    private String message;
    // 具体数据
    private Object data;

    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).data(data).build();
    }
    public static RPCResponse fail(Object data) {
        return RPCResponse.builder().code(500).data(data).build();
    }

}
