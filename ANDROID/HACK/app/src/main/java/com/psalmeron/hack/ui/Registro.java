package com.psalmeron.hack.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.psalmeron.hack.Dialogos.DatePickerFragment;
import com.psalmeron.hack.R;
import com.psalmeron.hack.Splash;
import com.psalmeron.hack.valores.Variables;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro extends AppCompatActivity {
    EditText nombre;
    EditText apPaterno;
    EditText apMaterno;
    EditText fechaNacimiento;
    EditText usuario;
    EditText contrasena;
    EditText validaContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText) findViewById(R.id.edt_nombre);
        apPaterno = (EditText) findViewById(R.id.edt_ap_paterno);
        apMaterno = (EditText) findViewById(R.id.edt_ap_materno);
        fechaNacimiento = (EditText) findViewById(R.id.edt_fecha_nac);
        usuario = (EditText) findViewById(R.id.edt_usuario);
        contrasena = (EditText) findViewById(R.id.edt_pass);
        validaContrasena = (EditText) findViewById(R.id.edt_confirm_pass);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Si necesitas ayuda, solicítala al encargado en turno.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    public void validaRegistro(View v){
        try {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Make sure user insert date into edittext in this format.

        Date dateObject = null;

            String dob_var=(fechaNacimiento.getText().toString());


            dateObject = formatter.parse(dob_var);

            Variables.nombre = nombre.getText().toString();
            Variables.apPaterno = apPaterno.getText().toString();
            Variables.apMaterno = apMaterno.getText().toString();
            Variables.fechaNac = dateObject;
            Variables.usuario = usuario.getText().toString();

            if (Variables.nombre.length()>0 && Variables.apPaterno.length()>0 && Variables.fechaNac != null && Variables.usuario.length()>0 ){
                Log.e("pass", contrasena.getText().toString());
                Log.e("validaContrasena", validaContrasena.getText().toString());
                if ( contrasena.getText().toString().equals(validaContrasena.getText().toString())  ){
                    Variables.isLoged = 1;
                    Intent m = new Intent(this, MenuCompleto.class);
                    startActivity(m);
                    this.finish();
                }else {
                    Toast t = Toast.makeText(this, "La contraseña no coincide.", Toast.LENGTH_LONG);
                    t.show();
                }
            }else {
                Toast t = Toast.makeText(this, "Ingresa la información requerida.", Toast.LENGTH_LONG);
                t.show();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + "/" + (month+1) + "/" + year;
                fechaNacimiento.setText(selectedDate);
            }
        });
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }


}
