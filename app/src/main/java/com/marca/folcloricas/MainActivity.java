package com.marca.folcloricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Usuarios bbdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbdd = new Usuarios(this);


        final Button btLogin = (Button) findViewById(R.id.btLogin);
        final EditText etUser = (EditText) findViewById(R.id.etUser);
        final EditText etPass = (EditText) findViewById(R.id.etPass);
        final Button btRegistro = (Button) findViewById(R.id.btRegistro);
        final Button btBiografias = (Button) findViewById(R.id.btBio);

        // BOTON LOGIN
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUser.getText().toString();
                String password = etPass.getText().toString();

                if(email.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkLogin = bbdd.checkLogin(email, password);
                    if(checkLogin == true){
                        Toast.makeText(getApplicationContext(), "Login correcto", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Login incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // BOTON REGISTRO
        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, Registro.class);
                startActivity(intento);
            }
        });

        // BOTON BIOGRAFIAS
        btBiografias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, Biografias.class);
                startActivity(intento);
            }
        });

    }
}
