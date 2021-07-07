package com.lly.chapter08.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Client03 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("连接成功");
        byte[] contain = new byte[1024];
        int readLen = 0;
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(
                        "C:\\Users\\liulingyun\\Desktop\\打印\\2021070212194161.jpg"));
        OutputStream os = socket.getOutputStream();
        while((readLen = bis.read(contain)) != -1){
            os.write(contain, 0, readLen);
        }
        socket.shutdownOutput();
        bis.close();

        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        readLen = 0;
        while((readLen = is.read(buffer)) != -1){
            System.out.println(new String(buffer, 0, readLen));
        }

        is.close();
        os.close();
        socket.close();
    }
}
