package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText campoUsuario, campoPass;
    TextView txtUusario, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario = (EditText)findViewById(R.id.editUusario);
        campoPass = (EditText)findViewById(R.id.editClave);

        txtUusario= (TextView)findViewById(R.id.user_preferences);
        txtPass = (TextView) findViewById(R.id.pass_preferences);

        cargarPreferencias();

    }



    public void onClick(View view) {
        switch (view.getId()){
            case R.id.guardar:
                guardarPreferencias();
                break;
            case R.id.cargar:
                Intent intent=new Intent(this, ConsultaPreferencias.class);
                startActivity(intent);
                break;
            case R.id.limpiar:
                limpiarPreferencias();


        }
    }

    private void limpiarPreferencias() {
        SharedPreferences preferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

        cargarPreferencias();
    }

    private void guardarPreferencias() {
        SharedPreferences preferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String usuario = campoUsuario.getText().toString();
        String pass = campoPass.getText().toString();

        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("user",usuario);
        editor.putString("pass",pass);


        txtUusario.setText(usuario);
        txtPass.setText(pass);

        editor.commit();

        limpiarcampos();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user","No existe la informacion");
        String pass=preferences.getString("pass","No existe la informacion");

        txtUusario.setText(user);
        txtPass.setText(pass);

        limpiarcampos();

    }

    private void limpiarcampos() {
        campoUsuario.setText("");
        campoPass.setText("");
    }
}
