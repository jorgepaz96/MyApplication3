package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConsultaPreferencias extends AppCompatActivity {
    TextView txtUusario, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_preferencias);

        txtUusario= (TextView)findViewById(R.id.user_preferences);
        txtPass = (TextView) findViewById(R.id.pass_preferences);

        cargarPreferencias();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user","No existe la informacion");
        String pass=preferences.getString("pass","No existe la informacion");

        txtUusario.setText(user);
        txtPass.setText(pass);
    }

    public void onClick(View view) {
        finish();
    }
}
