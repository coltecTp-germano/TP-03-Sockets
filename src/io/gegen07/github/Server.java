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

public class Server {
    private PrintWriter out;
    private BufferedReader in;
    private List<Client> clientList;
    private ServerSocket serverSocket;

    public Server (int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientList = new ArrayList<>();
    }
    public void startServer() throws IOException {

        while (true) {
            Client client = new Client(this.serverSocket.accept());

            out = new PrintWriter(client.getSocket().getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getSocket().getInputStream()));

            System.out.println("Nova conexão com o cliente " + client.getSocket().getInetAddress().getHostAddress());

            startCredentials(client);

            ClientHandler handler = new ClientHandler(client);
            this.clientList.add(client);
            handler.start();
        }
    }

    public void startCredentials(Client client) throws IOException {
        out.println("Digite seu username: ");
        client.setUsername(in.readLine());
        out.println("Digite seu nome: ");
        client.setName(in.readLine());
    }
}
