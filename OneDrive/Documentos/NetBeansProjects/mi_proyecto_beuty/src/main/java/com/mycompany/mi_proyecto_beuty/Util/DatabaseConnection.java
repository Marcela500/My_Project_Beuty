package com.mycompany.mi_proyecto_beuty.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/mitienda";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("Error al cargar el controlador de MySQL.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}
