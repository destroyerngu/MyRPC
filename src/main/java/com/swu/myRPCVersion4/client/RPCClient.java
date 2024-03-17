package com.swu.myRPCVersion4.client;


import com.swu.myRPCVersion4.common.RPCRequest;
import com.swu.myRPCVersion4.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
