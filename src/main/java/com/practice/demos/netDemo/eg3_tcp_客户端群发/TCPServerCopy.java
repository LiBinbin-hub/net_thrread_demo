package com.practice.demos.netDemo.eg3_tcp_客户端群发;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class TCPServerCopy {
    static List<Socket> online = new ArrayList<>();
    static Set<String> onlineClient = new ConcurrentSkipListSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket accept = serverSocket.accept();

            //测试直接给网页返回信息
//

            online.add(accept);
            SocketAddress clientAddress = accept.getRemoteSocketAddress();
            String ipStr = clientAddress.toString();
            System.out.println("客户端上线：" + ipStr);
            String ip = ipStr.substring(1);
            onlineClient.add(ip);
            System.out.println("已上线客户端：" + onlineClient.toString());
            new Thread(() -> {
                try (InputStream inputStream = accept.getInputStream();
                     DataInputStream dataInputStream = new DataInputStream(inputStream)) {
                    while (true) {
                        String s = dataInputStream.readUTF();
                        System.out.println(ip + ":" + s);
                        sendMsgToAll(s, ip);
                    }
                } catch (IOException e) {
                    System.out.println(ip + "连接断开");
                    onlineClient.remove(ip);
                    online.remove(accept);
                    System.out.println("在线客户端：" + onlineClient.toString());
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

    //群发消息
    private static void sendMsgToAll(String msg, String ip) throws IOException {
        for (Socket socket : online) {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(ip + ":" + msg);
            dataOutputStream.flush();
        }
    }
}
