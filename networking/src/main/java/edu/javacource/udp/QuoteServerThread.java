package edu.javacource.udp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class QuoteServerThread extends Thread {
    protected DatagramSocket socket;
    protected BufferedReader in;
    protected boolean moreQuotes = true;

    public QuoteServerThread() throws Exception {
        socket = new DatagramSocket(4445);
        try {
            in = new BufferedReader(new FileReader("one-liners.txt"));
        }catch (FileNotFoundException e) {
            System.err.println("Not file");
        }
    }

    @Override
    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];
                DatagramPacket packet= new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String dString;
                if (in == null) {
                    dString = new Date().toString();
                }else {
                    dString = getNextQuote();
                }

                buf = dString.getBytes();

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                System.out.println("Port:" + port);
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getNextQuote() {
        String returnValue = null;
        try {
            if ((returnValue = in.readLine()) == null) {
                in.close();
                moreQuotes = false;
                returnValue = "Mo ,pre quotes. Goodbye.";
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        new QuoteServerThread().start();
    }
}
