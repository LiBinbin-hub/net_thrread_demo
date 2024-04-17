package com.practice.demos.netDemo.eg1_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket serverSocket = new DatagramSocket(8888);
        byte[] data = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);

        while (true) {
            serverSocket.receive(datagramPacket);
            int length = datagramPacket.getLength();//获取本次数据包接受了多少数据
            System.out.println(new String(data, 0, length));
            System.out.println("================================");
            //serverSocket.close();
        }

    }
}
