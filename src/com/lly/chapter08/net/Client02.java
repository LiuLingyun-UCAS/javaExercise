package com.lly.chapter08.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Client02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("Hello Server!");
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = br.readLine();
        System.out.println("接收到消息：" + str);
        bw.close();
        br.close();
        socket.close();
    }
}
