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

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {

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
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String contrasena = request.getParameter("contrasena");

        if (nombre != null && correo != null && telefono != null && direccion != null && contrasena != null) {
            try (Connection conn = dataSource.getConnection()) {
                // Verificar si el correo ya está registrado
                String checkSql = "SELECT * FROM usuarios WHERE correo_electronico = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setString(1, correo);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    request.setAttribute("errorMessage", "El correo electrónico ya está registrado.");
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                } else {
                    // Insertar el nuevo usuario en la base de datos
                    String sql = "INSERT INTO usuarios (nombre, correo_electronico, telefono, direccion, contrasena) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, nombre);
                    pstmt.setString(2, correo);
                    pstmt.setString(3, telefono);
                    pstmt.setString(4, direccion);
                    pstmt.setString(5, contrasena);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        request.setAttribute("successMessage", "Usuario registrado correctamente.");
                        request.getRequestDispatcher("registro.jsp").forward(request, response);
                    } else {
                        request.setAttribute("errorMessage", "No se pudo registrar el usuario.");
                        request.getRequestDispatcher("registro.jsp").forward(request, response);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Agrega esto para depurar errores SQL
                throw new ServletException("Error SQL al intentar registrar usuario", ex);
            }
        } else {
            request.setAttribute("errorMessage", "Por favor complete todos los campos del formulario.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
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
        return "Servlet de registro de usuario";
    }
}
