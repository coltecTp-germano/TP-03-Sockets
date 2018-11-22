package br.tp.tp_03_sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection implements Runnable{
    private Client cliente;
    private Socket socket;
    private static final String SERVER_IP = "192.168.0.16";
    private MainActivity activity;

    ClientConnection(Client cliente, MainActivity activity){
        this.cliente = cliente;
        this.activity = activity;
    }

    @Override
    public void run() {
        try{
            /* Conecta ao servidor */
            System.out.println(cliente.getPort());
            socket = new Socket(SERVER_IP, cliente.getPort());


            /* Lê mensagens do servidor */
            Scanner s = new Scanner(socket.getInputStream());
            while(s.hasNextLine()) {
                String msg = s.nextLine();
                activity.addText(msg); // Chama método da MainActivity para por mensagem no chat
            }
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /* Envia mensagem para o servidor */
    public void sendMessage(String msg) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(cliente.getUsername() + " diz: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
