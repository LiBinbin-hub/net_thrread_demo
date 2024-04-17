package com.practice.demos.netDemo;

import java.io.IOException;
import java.net.InetAddress;

public class DemoMain {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();

            System.out.println(hostAddress);

            String hostName = localHost.getHostName();
            System.out.println(hostName);

            InetAddress ubuntuAddress = InetAddress.getByName("www.baidu.com");
            String hostAddress1 = ubuntuAddress.getHostAddress();
            String hostName1 = ubuntuAddress.getHostName();
            boolean reachable = ubuntuAddress.isReachable(1);

            System.out.println(hostAddress1);
            System.out.println(hostName1);
            System.out.println(reachable);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
