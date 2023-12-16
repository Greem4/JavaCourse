package edu.javacource.simplesocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClientThread  extends Thread {

    @Override
    public void run() {
        try {
            int port = 19999;
            System.out.println("Try to open connection:" + port);
//            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            Socket socket = new Socket("127.0.0.1", port);
            System.out.println("Connection is created");

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw.println("Hello from client 1");
//            pw.println("Hello from client 2");
//            pw.println("Hello from client 3");
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                Thread.sleep(1000);
                if (str.equals("bye")) {
                    break;
                }
                pw.println("bye");
            }
            System.out.println("Line is sent");
            pw.close();
            br.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
