package com.swu.myRPCVersion3.client;

import com.swu.myRPCVersion3.common.RPCRequest;
import com.swu.myRPCVersion3.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
