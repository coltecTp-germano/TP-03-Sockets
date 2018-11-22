package br.tp.tp_03_sockets;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class SalasActivity extends Activity {

    /* Intents Extras */
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_PORT = "port";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salas);

        /* SharedPreferences */
        SharedPreferences pref = this.getSharedPreferences("QUALE", 0);

        final String name = pref.getString("name","");
        final String username = pref.getString("username", "");

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

                /* Passa como parâmetro a porta */
                intent.putExtra(EXTRA_PORT, 12000);


                startActivity(intent);
                finish();
            }
        });

        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetro a porta */
                intent.putExtra(EXTRA_PORT, 12001);

                startActivity(intent);
                finish();
            }
        });

        btnOportunidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetro a porta */
                intent.putExtra(EXTRA_PORT, 12002);

                startActivity(intent);
                finish();
            }
        });

        btnOffTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                /* Passa como parâmetro a porta */
                intent.putExtra(EXTRA_PORT, 12003);

                startActivity(intent);
                finish();
            }
        });
    }
}
