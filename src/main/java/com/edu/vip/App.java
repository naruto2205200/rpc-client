package com.edu.vip;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
/*        System.out.println( "Hello World!" );
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
//        helloService.saveUser();
        helloService.sayHello("mic");
        String result = System.out.println(result);*/
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);

        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String result = helloService.sayHello("mic");
        System.out.println(result);
    }
}
