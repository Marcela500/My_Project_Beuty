package com.mycompany.mi_proyecto_beuty.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/producto"})
public class ProductoServlet extends HttpServlet {

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mitienda");
        } catch (NamingException ex) {
            throw new ServletException("Error en la configuración del recurso JDBC", ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listProducts(request, response);
                    break;
                case "add":
                    addProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException("Error en la operación con la base de datos", ex);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM productos";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            request.setAttribute("productos", rs);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        String color = request.getParameter("color");
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));

        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO productos (nombre, marca, color, tipo, descripcion, precio) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, marca);
            pstmt.setString(3, color);
            pstmt.setString(4, tipo);
            pstmt.setString(5, descripcion);
            pstmt.setDouble(6, precio);
            pstmt.executeUpdate();
        }

        response.sendRedirect("admin.jsp");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        String color = request.getParameter("color");
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));

        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE productos SET nombre = ?, marca = ?, color = ?, tipo = ?, descripcion = ?, precio = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, marca);
            pstmt.setString(3, color);
            pstmt.setString(4, tipo);
            pstmt.setString(5, descripcion);
            pstmt.setDouble(6, precio);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
        }

        response.sendRedirect("admin.jsp");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }

        response.sendRedirect("admin.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para manejar productos";
    }
}
