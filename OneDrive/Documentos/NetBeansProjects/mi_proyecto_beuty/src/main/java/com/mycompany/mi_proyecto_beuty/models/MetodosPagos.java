package com.mycompany.mi_proyecto_beuty.models;

import jakarta.persistence.*;

@Entity
@Table(name = "metodos_pagos")
public class MetodosPagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String metodo;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}
