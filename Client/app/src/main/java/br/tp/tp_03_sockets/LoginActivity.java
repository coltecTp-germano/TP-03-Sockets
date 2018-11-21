package br.tp.tp_03_sockets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    /* Intents Extras */
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_PORT = "port";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Name & Username */
        final EditText name = findViewById(R.id.txt_name);
        final EditText username = findViewById(R.id.txt_username);


        /* Salas */
        Button btnGeral = findViewById(R.id.btn_geral);
        Button btnEventos = findViewById(R.id.btn_eventos);
        Button btnOportunidades = findViewById(R.id.btn_oportunidades);
        Button btnOffTopic = findViewById(R.id.btn_offtopic);


        /* Listeners */

        btnGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetros name, username e porta */
                intent.putExtra(EXTRA_NAME, name.getText().toString());
                intent.putExtra(EXTRA_USERNAME, username.getText().toString());
                intent.putExtra(EXTRA_PORT, 12000);


                startActivity(intent);
                finish();
            }
        });

        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetros name, username e porta */
                intent.putExtra(EXTRA_NAME, name.getText().toString());
                intent.putExtra(EXTRA_USERNAME, username.getText().toString());
                intent.putExtra(EXTRA_PORT, 12001);

                startActivity(intent);
                finish();
            }
        });

        btnOportunidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetros name, username e porta */
                intent.putExtra(EXTRA_NAME, name.getText().toString());
                intent.putExtra(EXTRA_USERNAME, username.getText().toString());
                intent.putExtra(EXTRA_PORT, 12002);

                startActivity(intent);
                finish();
            }
        });

        btnOffTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetros name, username e porta */
                intent.putExtra(EXTRA_NAME, name.getText().toString());
                intent.putExtra(EXTRA_USERNAME, username.getText().toString());
                intent.putExtra(EXTRA_PORT, 12003);

                startActivity(intent);
                finish();
            }
        });
    }
}
