package com.practice.demos.netDemo.eg2_tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket(InetAddress.getLocalHost(), 8888);
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            String s = scanner.nextLine();
            if ("quit".equals(s)) {
                break;
            }
            dataOutputStream.writeUTF(s);
            dataOutputStream.flush();
        }

        //dataOutputStream.close();
        //client.close();
    }
}
