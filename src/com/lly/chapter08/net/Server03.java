package com.lly.chapter08.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Server03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\a.jpg"));
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while((readLen = is.read(buffer)) != -1){
            bos.write(buffer, 0, readLen);
        }
        bos.close();
        OutputStream os = socket.getOutputStream();
        os.write("收到图片".getBytes());
        socket.shutdownOutput();

        os.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
