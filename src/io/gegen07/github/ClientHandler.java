package io.gegen07.github;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    private Socket socket;
    private Client client;

    public ClientHandler(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner s = new Scanner(this.socket.getInputStream());
            PrintWriter output = new PrintWriter(this.socket.getOutputStream(), true);
            while(s.hasNextLine()) {
                output.println(client.getUsername() + "diz: " + s.nextLine());
                System.out.println(s.nextLine());
            }
            s.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
