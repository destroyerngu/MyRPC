package com.swu.myRPCVersion5.client;


import com.swu.myRPCVersion5.common.RPCRequest;
import com.swu.myRPCVersion5.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
