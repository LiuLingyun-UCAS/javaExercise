package com.lly.chapter08.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器运行中...");
        Socket socket = serverSocket.accept();
        System.out.println("连接服务器成功, socket=" + socket);

        InputStream is = socket.getInputStream();

        byte[] msg = new byte[1024];
        int readLen = 0;
        while((readLen = is.read(msg)) != -1){
            System.out.println("接收到消息：" + new String(msg, 0, readLen));
        }

        OutputStream os = socket.getOutputStream();
        os.write("Hello, client".getBytes());
        socket.shutdownOutput();

        is.close();
        os.close();
        socket.close();
        serverSocket.close();
    }
}
