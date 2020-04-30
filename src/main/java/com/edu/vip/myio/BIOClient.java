package com.edu.vip.myio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/4/3016:55
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8080);
        OutputStream os = client.getOutputStream();
        String name = "zhangsanlisi222";
        System.out.println("发送的数据是：" + name);
        os.write(name.getBytes());
        os.close();
        client.close();
    }
}
