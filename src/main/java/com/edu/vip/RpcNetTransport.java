package com.edu.vip;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
        Socket socket = null;
        Object obj = null;
        Object result = null;
        ObjectInputStream objectInputStream= null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(host, post);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            result = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
