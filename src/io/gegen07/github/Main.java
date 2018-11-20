package io.gegen07.github;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 12000;

        List<Server> servers = new ArrayList<>();
        servers.add(new Server(port));
        servers.add(new Server(port+1));
        servers.add(new Server(port+2));
        servers.add(new Server(port+3));

        for (Server s: servers) {
            s.startServer();
        }
    }
}
