package com.lly.chapter08.net;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接成功, socket=" + socket);
        OutputStream os = socket.getOutputStream();

        os.write("Hello, Server".getBytes());
        socket.shutdownOutput();
        System.out.println("消息发送成功");

        InputStream is = socket.getInputStream();
        byte[] msg = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(msg)) != -1){
            System.out.println(new String(msg, 0, readLen));
        }
        os.close();
        is.close();
        socket.close();
    }
}
