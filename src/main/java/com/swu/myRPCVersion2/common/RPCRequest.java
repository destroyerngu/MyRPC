package com.swu.myRPCVersion2.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 13:14
 * @since 1.0
 **/


@Builder
@Data
public class RPCRequest implements Serializable {
    // 服务类名，客户端只知道接口名，在服务端中用接口名指向实现类;
    private String interfaceName;
    // 方法名
    private String methodName;
    // 参数列表
    private Object[] params;
    // 参数类型
    private Class<?>[] paramTypes;
}
