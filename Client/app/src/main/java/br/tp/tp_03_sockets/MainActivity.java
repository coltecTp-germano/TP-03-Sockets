package br.tp.tp_03_sockets;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* SharedPreferences */
        SharedPreferences pref = this.getSharedPreferences("QUALE", 0);

        /* Button de enviar e entrada que contém a mensagem */
        Button btnEnviar = findViewById(R.id.btn_enviar);
        final EditText txtMensagem = findViewById(R.id.txt_info);

        /* Recupera extras do Shared e Intent*/
        Intent intent = getIntent();
        final String name = pref.getString("name","");
        final String username = pref.getString("username","");
        final int port = intent.getIntExtra(SalasActivity.EXTRA_PORT, 12000);


        /* Cria o cliente e conecta ao servidor */
        Client cliente = new Client(name, username, port);
        final ClientConnection connection = new ClientConnection(cliente, this);
        Thread thread = new Thread(connection);
        thread.start();


        /* Envia mensagem */
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = txtMensagem.getText().toString();
                connection.sendMessage(message);
            }
        });

    }


    /* Recebe mensagem e adiciona ao chat */
    public void addText(final String text) {

        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() { // Para obter acesso à UI
                    @Override
                    public void run() {
                        TextView chat = findViewById(R.id.lbl_mensagens);
                        chat.append(text+"\n");
                    }
                });
            }
        }.start();
    }
}
