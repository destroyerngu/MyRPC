package com.swu.myRPCVersion6.client;


import com.swu.myRPCVersion6.common.RPCRequest;
import com.swu.myRPCVersion6.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
