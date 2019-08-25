package com.psalmeron.hack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.psalmeron.hack.R;
import com.psalmeron.hack.listener.RecyclerItemClickListener;
import com.psalmeron.hack.menus.Menu;
import com.psalmeron.hack.menus.MenuAdapter;
import com.psalmeron.hack.ui.operaciones.EnvioDirigido;
import com.psalmeron.hack.valores.Variables;

import java.util.ArrayList;

public class MenuCompleto extends AppCompatActivity {
    private RecyclerView rvMenu;
    private GridLayoutManager glm;
    private MenuAdapter adapter;
    private TextView principal;
    private ArrayList<Menu> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_completo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facev = new Intent(MenuCompleto.this, FaceDetect.class);
                startActivity(facev);
            }
        });

        rvMenu = (RecyclerView) findViewById(R.id.rv_menu);
        principal = (TextView) findViewById(R.id.txt_titulo_inicio);


        glm = new GridLayoutManager(this, 2);
        rvMenu.setLayoutManager(glm);
        adapter = new MenuAdapter(dataSet());
        rvMenu.setAdapter(adapter);

        principal.setText("Bienvenido " + Variables.nombre);

        rvMenu.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rvMenu ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever

                        Menu men = data.get(position);
                        Log.e("listener", "okok " + men.getId());
                        Variables.banderaOper = men.getId();
                        switch (Variables.banderaOper){
                            case 5:
                                Intent env = new Intent(MenuCompleto.this, EnvioDirigido.class);
                                startActivity(env);
                                break;
                            case 8:
                                Intent envi = new Intent(MenuCompleto.this, EnvioDirigido.class);
                                startActivity(envi);
                                break;
                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        Log.e("listener", "okokok " + position);
                    }
                })
        );




    }

    private ArrayList<Menu> dataSet() {
        data = new ArrayList<>();
        if(Variables.isLoged == 1){
            data.add(new Menu(1,"Mi perfil", "Modifica tus datos de contacto.", R.drawable.perfil));
            data.add(new Menu(2,"Cuentas", "Información de cuentas bancarias.", R.drawable.cuentas));
            data.add(new Menu(3,"Consulta Operaciones", "Obten información de ti ticket digital.", R.drawable.operaciones));
            data.add(new Menu(4,"Beneficiarios", "Agrega beneficiarios para en DineroExpress.", R.drawable.beneficiarios));
            data.add(new Menu(5,"Envío Dirigido", "Genera un referencia de DineroExpress.", R.drawable.envio));
            data.add(new Menu(6,"Divisas", "Compra divisas.", R.drawable.dolar));
        }else{
            data.add(new Menu(7,"Crear perfil", "Agrega tus datos de contacto.", R.drawable.perfil));
            data.add(new Menu(8, "Envío Dirigido", "Genera un referencia de DineroExpress.", R.drawable.envio));
            data.add(new Menu(9,"Divisas", "Compra divisas.", R.drawable.dolar));
        }



        return data;
    }

}
