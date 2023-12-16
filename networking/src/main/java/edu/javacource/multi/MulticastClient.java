package edu.javacource.multi;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");

        try (MulticastSocket socket = new MulticastSocket(4446)) {
            InetAddress address = InetAddress.getByName("225.0.0.1");
            socket.joinGroup(address);
            System.out.println("start");

            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                System.out.println("hello");
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Quote of the Moment: " + received);
            }

            socket.leaveGroup(address);
        }
    }
}
