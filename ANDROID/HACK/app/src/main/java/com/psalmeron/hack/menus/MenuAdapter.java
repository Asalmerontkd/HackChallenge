package com.psalmeron.hack.menus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psalmeron.hack.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<Menu> data;

    public MenuAdapter(ArrayList<Menu> data){
        this.data = data;
    }



    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        return new MenuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false));
    }
    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        Menu menu = data.get(position);
        holder.imgMusica.setImageResource(menu.getImagen());
        holder.tvNombre.setText(menu.getTitulo());
        holder.tvArtista.setText(menu.getDescripcion());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public Menu getItem(int position){
        return data.get(position);
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        ImageView imgMusica;
        TextView tvNombre;
        TextView tvArtista;

        public MenuViewHolder(View itemView) {
            super(itemView);

            imgMusica = (ImageView) itemView.findViewById(R.id.img_menu);
            tvNombre = (TextView) itemView.findViewById(R.id.tv_titulo);
            tvArtista = (TextView) itemView.findViewById(R.id.tv_desc);
        }


    }
}
