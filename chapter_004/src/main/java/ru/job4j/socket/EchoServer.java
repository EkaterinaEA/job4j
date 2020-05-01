package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean checkOut = false;
            while (!checkOut) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (str != null) {
                        String arg = str.substring(str.lastIndexOf('=') + 1, str.lastIndexOf(' '));
                        if ("Exit".equals(arg)) {
                            checkOut = true;
                        }
                        out.write("HTTP/1.1 200 OK\\r\\n\\".getBytes());
                    }
                }
            }
        }
    }
}