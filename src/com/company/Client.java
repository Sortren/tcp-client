package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket dial() throws IOException {
        System.out.println("Connecting to TCP server " + this.host + " on port: " + this.port);
        return new Socket(this.host, this.port);
    }

    public void send(String message, PrintWriter writer) {
        writer.println(message);
        System.out.println("[client] " + message);
    }

    public String read(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        System.out.println("[server] " + line);
        return line;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
