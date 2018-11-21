package br.tp.tp_03_sockets;

public class Client {

    private String name;
    private String username;
    private int port;


    Client(String name, String username, int port){
        this.name = name;
        this.username = username;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public int getPort() {
        return port;
    }
}


