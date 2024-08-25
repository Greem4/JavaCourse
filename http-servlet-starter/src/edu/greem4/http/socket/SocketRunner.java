package edu.greem4.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        // http - 80
        // https - 443
        // tcp
        var inetAddress = Inet4Address.getByName("google.com");
        try (var socket = new Socket(inetAddress, 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello World");
            var response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
