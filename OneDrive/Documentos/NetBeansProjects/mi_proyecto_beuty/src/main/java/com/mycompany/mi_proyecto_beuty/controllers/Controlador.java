package com.mycompany.mi_proyecto_beuty.controllers;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    private static final String LISTAR = "vistas/listar.jsp";
    private static final String ADD = "vistas/add.jsp";
    private static final String EDIT = "vistas/edit.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action == null) {
            action = ""; // Manejo del caso cuando 'accion' es null
        }

        switch (action.toLowerCase()) {
            case "listar":
                acceso = LISTAR;
                break;
            case "add":
                acceso = ADD;
                break;
            case "edit":
                acceso = EDIT;
                break;
            default:
                acceso = LISTAR; // Redirige a la lista si la acción no es reconocida
                break;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Usa doGet para manejar POST, si se desea.
    }

    @Override
    public String getServletInfo() {
        return "Controlador Servlet para manejar vistas y acciones";
    }
}
