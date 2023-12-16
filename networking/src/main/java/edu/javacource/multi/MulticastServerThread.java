package edu.javacource.multi;

import edu.javacource.udp.QuoteServerThread;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

public class MulticastServerThread extends QuoteServerThread {
    private final long FIVE_SECONDS = 5000;
    public MulticastServerThread() throws Exception {
    }

    @Override
    public void run() {
        while (moreQuotes) {
            try {
                String dString;
                if (in == null) {
                    dString = new Date().toString();
                } else {
                    dString = getNextQuote();
                }
                byte[] buf = dString.getBytes();
                InetAddress group = InetAddress.getByName("225.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);
                System.out.println("Sent:" + dString);

                try {
                    sleep((long) (Math.random() * FIVE_SECONDS));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e) {
                e.printStackTrace(System.out);
                moreQuotes = false;
            }
        }
        socket.close();
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
        new MulticastServerThread().start();
    }
}
