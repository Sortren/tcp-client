package com.company;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        Client client = new Client("localhost", 8080);
        try {
            Socket conn = client.dial();

            OutputStream outputStream = conn.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            client.send("test message", writer);

            InputStream inputStream = conn.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            client.read(bufferedReader);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
