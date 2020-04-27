package com.edu.vip;

import java.lang.reflect.Proxy;

/**
 * @author naruto
 * @data 2020/4/27.
 */
public class RpcProxyClient {
    public <T> T clientProxy(final Class<T> intefaceCls, final String host, final int post) {

        return (T) Proxy.newProxyInstance(intefaceCls.getClassLoader(), new Class<?>[]{intefaceCls}, new RemoteInvocationHandler(host,post));
    }
}
