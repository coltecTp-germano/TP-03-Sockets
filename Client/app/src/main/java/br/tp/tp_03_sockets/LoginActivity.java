package br.tp.tp_03_sockets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // SharedPreferences
        final SharedPreferences pref = this.getSharedPreferences("QUALE", 0);

        /* Name & Username */
        final EditText name = findViewById(R.id.txt_name);
        final EditText username = findViewById(R.id.txt_username);

        Button btn = findViewById(R.id.btn_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Salvando em cache
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name", name.getText().toString());
                editor.putString("username", username.getText().toString());

                editor.commit();

                Intent intent = new Intent(LoginActivity.this, SalasActivity.class);
                startActivity(intent);

            }
        });

    }
}
