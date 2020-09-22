package com.example.usandorecicleviews;

public class Item {

    private int id;
    private String nome;

    public Item(final int id, final String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
