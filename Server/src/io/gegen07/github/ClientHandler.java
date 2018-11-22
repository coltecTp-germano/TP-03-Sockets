package io.gegen07.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    private Server server;
    private Client client;

    public ClientHandler(Client client, Server  server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            Scanner s = new Scanner(this.client.getSocket().getInputStream());
            while(s.hasNextLine()) {
                String line = s.nextLine();
                this.server.sendToClients(line);
                System.out.println(line);
            }
            s.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
