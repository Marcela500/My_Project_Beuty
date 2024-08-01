package com.mycompany.mi_proyecto_beuty.models;

public class Persona {
    private int id;
    private String dni;
    private String nom;
    
    // Constructor vacío
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Getter y Setter para nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
