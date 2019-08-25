package com.psalmeron.hack.menus;

public class Menu {
    private int id;
    private String titulo;
    private String descripcion;
    private int imagen;

    public Menu(){

    }

    public Menu(int id, String titulo, String desc, int imagen){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = desc;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
