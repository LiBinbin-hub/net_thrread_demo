package com.practice.demos.netDemo.eg3_tcp_客户端群发;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientCopy {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket(InetAddress.getLocalHost(), 8888);

        new Thread(() -> {
            try (InputStream inputStream = client.getInputStream();
                 DataInputStream dataInputStream = new DataInputStream(inputStream)) {
                while (true) {
                    String ss = dataInputStream.readUTF();
                    System.out.println(ss);
                }
            } catch (IOException e) {
                System.out.println("本机下线。");
                //e.printStackTrace();
            }
        }).start();

        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            String s = scanner.nextLine();
            if ("quit".equals(s)) {
                dataOutputStream.close();
                client.close();
                break;
            }
            dataOutputStream.writeUTF(s);
            dataOutputStream.flush();
        }


    }
}
