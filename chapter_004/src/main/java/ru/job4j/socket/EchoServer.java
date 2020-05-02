package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final String EXIT = "Exit";
    private static final String HELLO = "Hello";

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean checkOut = false;
            while (!checkOut) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (str != null) {
                        String arg = str.substring(str.lastIndexOf('=') + 1).replaceAll(" HTTP/1.1", "");
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if (HELLO.equals(arg)) {
                            out.write("Hello, dear friend.".getBytes());
                        } else if (EXIT.equals(arg)) {
                            out.write("Shut down server".getBytes());
                            checkOut = true;
                        } else {
                            out.write(arg.getBytes());
                        }
                    }
                }
            }
        }
    }
}