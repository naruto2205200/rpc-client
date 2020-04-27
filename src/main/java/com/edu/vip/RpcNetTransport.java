package com.edu.vip;

/**
 * @author naruto
 * @data 2020/4/27.
 * 发送请求的对象
 */

public class RpcNetTransport {
    private String host;
    private int post;

    public RpcNetTransport(String host, int post) {
        this.host = host;
        this.post = post;
    }

    public Object send(RpcRequest request) {
        return null;
    }
}
