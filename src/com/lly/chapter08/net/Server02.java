package com.lly.chapter08.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Server02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = br.readLine();
        System.out.println("接收到消息：" + str);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("Hello Client");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();
        br.close();
        bw.close();
        socket.close();
        serverSocket.close();
    }
}
