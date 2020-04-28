package com.edu.vip;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/4/2811:06
 */
@Configuration
public class SpringConfig {
    @Bean(name="rpcProxyClient")
    public RpcProxyClient proxyClient(){
        return new RpcProxyClient();
    }
}
