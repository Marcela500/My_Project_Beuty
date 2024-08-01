package com.mycompany.mi_proyecto_beuty.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/mitienda"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    private Connection con;

    public Conexion() {
        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión con la base de datos
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    public Connection getConnection() {
        return con;
    }
}
