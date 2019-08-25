package com.psalmeron.hack.ui.operaciones;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.psalmeron.hack.R;
import com.psalmeron.hack.listas.MyListAdapter;

public class Cuentas extends AppCompatActivity {
    ListView list;

    String[] maintitle ={
            "Guardadito","Socio",
            "Inversion Socio"
    };

    String[] subtitle ={
            "$ 10 000.50","$ 150 250.00",
            "$ 10.50"
    };

    Integer[] imgid={
            R.drawable.cuentab,R.drawable.cuentab,
            R.drawable.cuentab
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);
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
    }

}
