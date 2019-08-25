package com.psalmeron.hack.ui.operaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.psalmeron.hack.R;
import com.psalmeron.hack.listas.MyListAdapter;

public class Operaciones extends AppCompatActivity {
    ListView list;

    String[] maintitle ={
            "Nomina X (Abono)","Compra de divisa (Cargo)",
            "Apertura (Abono)"
    };

    String[] subtitle ={
            "$ 25 000.00","$ 50.00",
            "$ 1.00"
    };

    Integer[] imgid={
            R.drawable.cuentab,R.drawable.cuentab,
            R.drawable.cuentab
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            showCustomDialog("Movimiento de Operacion. Ver Ticket Digital");
                                        }
                                    });
    }


    public void showCustomDialog(String texto) {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false);
        TextView txt = (TextView) dialogView.findViewById(R.id.txt_dialogo_desc);

        txt.setText(texto);

        Button btnOk = (Button) dialogView.findViewById(R.id.buttonOk);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ticket = new Intent(Operaciones.this, TIcket.class);
                startActivity(ticket);
                alertDialog.dismiss();
            }
        });
    }

}
