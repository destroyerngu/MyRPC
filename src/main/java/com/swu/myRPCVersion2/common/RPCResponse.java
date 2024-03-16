package com.swu.myRPCVersion2.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 13:20
 * @since 1.0
 **/


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
    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).data("服务器发生错误").build();
    }

}
