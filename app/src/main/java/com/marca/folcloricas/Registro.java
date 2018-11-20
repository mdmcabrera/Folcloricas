package com.marca.folcloricas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends Activity {
    Usuarios bbdd;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final Button btRegistroUser = (Button) findViewById(R.id.btRegistroUser);
        final EditText etUserReg = (EditText) findViewById(R.id.etUserReg);
        final EditText etPassReg = (EditText) findViewById(R.id.etPassReg);
        final EditText etPassConf = (EditText) findViewById(R.id.etPassConfirmReg);

        bbdd = new Usuarios(this);


        btRegistroUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUserReg.getText().toString();
                String pass = etPassReg.getText().toString();
                String passConf = etPassConf.getText().toString();

                if(email.equals("") || pass.equals("") || passConf.equals("")){
                    Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(passConf)){
                        Boolean checkMail = bbdd.checkEmail(email);
                        if(checkMail==true){
                            Boolean insert = bbdd.insert(email, pass);
                            if(insert==true){
                                //AQUI HABRIA QUE VOLVER AL MAIN ACTIVITY CON UN INTENT
                                Toast.makeText(getApplicationContext(), "REGISTRO CORRECTO", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "El email ya existe", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

    }

}
