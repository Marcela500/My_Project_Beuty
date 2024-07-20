package com.mycompany.mi_proyecto_beuty.servlets;

import com.mycompany.mi_proyecto_beuty.Util.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            resp.getWriter().println("Conexión exitosa a la base de datos.");
        } else {
            resp.getWriter().println("Error al conectar a la base de datos.");
        }
    }
}
