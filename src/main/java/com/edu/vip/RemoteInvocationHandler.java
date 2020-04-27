package com.edu.vip;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author naruto
 * @data 2020/4/27.
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int post;

    public RemoteInvocationHandler(String host, int post) {
        this.host = host;
        this.post = post;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 请求会进入这里
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,post);
        rpcNetTransport.send(rpcRequest);
        return null;
    }
}
