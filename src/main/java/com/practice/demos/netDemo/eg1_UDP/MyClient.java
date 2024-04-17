package com.practice.demos.netDemo.eg1_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            System.out.println("欢迎， 输入quit退出。");
            while (true) {
                System.out.println("请输入要发送的消息：");
                String str = scanner.nextLine();
                if ("quit".equals(str)) {
                    clientSocket.close();
                    break;
                }
                byte[] data = str.getBytes(StandardCharsets.UTF_8);
                DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length
                        , InetAddress.getLocalHost(), 8888);
                clientSocket.send(datagramPacket);
                System.out.println("发送成功！");
            }
            System.out.println("退出成功！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
