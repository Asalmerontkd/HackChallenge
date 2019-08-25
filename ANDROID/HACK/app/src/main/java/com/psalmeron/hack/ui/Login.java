package com.psalmeron.hack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.psalmeron.hack.R;
import com.psalmeron.hack.valores.Variables;

public class Login extends AppCompatActivity {

    EditText usuario;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Punto de acceso a operaciones de banca, inicia sesión para un servicio personalizado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        usuario = (EditText) findViewById(R.id.edt_usuario);
        pass = (EditText) findViewById(R.id.edt_pass);

    }

    public void inicioSimple(View v){
        Variables.isLoged = 0;
        Intent i = new Intent(this, MenuCompleto.class);
        startActivity(i);
        this.finish();
    }

    public void nuevoRegistro(View v){
        Intent r = new Intent(this, Registro.class);
        startActivity(r);
    }

    public void iniciaSesion(View v){
        try{
            Variables.usuario = usuario.getText().toString();
            Log.e("USUARIO", Variables.usuario);
            Log.e("pass", pass.getText().toString());
            if(Variables.usuario.equals("AsalmeTKD") && pass.getText().toString().equals("12345")){
                Variables.isLoged = 1;
                Variables.nombre = "Pedro";
                Intent m = new Intent(this, MenuCompleto.class);
                startActivity(m);
                this.finish();
            }else {
                Toast toast = Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG);
                toast.show();
            }
        }catch (Exception e){
            Toast toast = Toast.makeText(this, "Ingresa valores correctos en los campos.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
