package com.practice.demos.netDemo.eg2_tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket accept = serverSocket.accept();
            SocketAddress clientAddress = accept.getRemoteSocketAddress();
            System.out.println("客户端上线：" + clientAddress);
            new Thread(() -> {
                try (InputStream inputStream = accept.getInputStream();
                     DataInputStream dataInputStream = new DataInputStream(inputStream)) {
                    while (true) {
                        String s = dataInputStream.readUTF();
                        System.out.println(s);
                    }
                } catch (IOException e) {
                    System.out.println(clientAddress + "连接断开");
                    //e.printStackTrace();
                }
            }).start();
            //获取客户端的IP地址
            //SocketAddress clientAddress = accept.getRemoteSocketAddress();
            //System.out.println("客户端IP:" + clientAddress);
        }
        //dataInputStream.close();
        //serverSocket.close();
    }
}
