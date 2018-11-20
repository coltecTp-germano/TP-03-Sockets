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
    private static PrintWriter out;
    private static BufferedReader in;
    private static List<Client> clientList;

    public static void main(String[] args) throws IOException {
        List<ServerSocket> serverSocket = new ArrayList<>();
        serverSocket.add(new ServerSocket(12000));
        serverSocket.add(new ServerSocket(12001));
        serverSocket.add(new ServerSocket(12002));
        serverSocket.add(new ServerSocket(12003));

        for (ServerSocket s: serverSocket) {
            startServer(s);
        }
    }

    public static void startServer(ServerSocket serverSocket) throws IOException {

        List<Client> clientList = new ArrayList<>();

        while (true) {
            Client client = new Client(serverSocket.accept());

            out = new PrintWriter(client.getSocket().getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getSocket().getInputStream()));

            System.out.println("Nova conexão com o cliente " + client.getSocket().getInetAddress().getHostAddress());

            startCredentials(client);

            ClientHandler handler = new ClientHandler(client);
            clientList.add(client);
            handler.start();
        }
    }

    public static void startCredentials(Client client) throws IOException {
        out.println("Digite seu username: ");
        client.setUsername(in.readLine());
        out.println("Digite seu nome: ");
        client.setName(in.readLine());
    }
}
