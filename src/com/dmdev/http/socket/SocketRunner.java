package com.dmdev.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = Inet4Address.getByName("google.com");
        try (Socket socket = new Socket(inetAddress, 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());) {
            outputStream.writeUTF("Hello world");
            byte[] response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
