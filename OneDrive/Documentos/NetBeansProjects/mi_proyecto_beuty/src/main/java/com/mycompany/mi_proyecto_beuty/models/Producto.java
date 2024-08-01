package com.mycompany.mi_proyecto_beuty.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String marca;
    private double precio;
    private String color;
    private String tipo;
    private String descripcion;

    // Constructor vacío
    public Producto() {}

    // Constructor con todos los campos
    public Producto(int id, String nombre, String marca, double precio, String color, String tipo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.color = color;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Constructor sin id (para inserciones)
    public Producto(String nombre, String marca, double precio, String color, String tipo, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.color = color;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
