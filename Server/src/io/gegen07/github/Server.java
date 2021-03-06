package io.gegen07.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server implements Runnable {
    private PrintWriter out;
    private BufferedReader in;
    private List<Client> clientList;
    private ServerSocket serverSocket;

    public Server (int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(port);
        clientList = new ArrayList<>();
    }

    public void startServer() throws IOException {

        while (true) {
            Client client = new Client(this.serverSocket.accept());

            out = new PrintWriter(client.getSocket().getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getSocket().getInputStream()));

            ClientHandler handler = new ClientHandler(client, this);
            this.clientList.add(client);
            handler.start();

            System.out.println("Nova conexão com o cliente " + client.getSocket().getInetAddress().getHostAddress());

        }
    }

    public void sendToClients(String text) throws IOException {
        for (Client c: clientList){
            PrintWriter output = new PrintWriter(c.getSocket().getOutputStream(), true);
            output.println(text);
        }
    }


    @Override
    public void run() {
        try {
            this.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
