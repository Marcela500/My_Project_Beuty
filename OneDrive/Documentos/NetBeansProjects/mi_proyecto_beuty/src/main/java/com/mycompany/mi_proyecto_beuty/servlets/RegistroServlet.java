package com.mycompany.mi_proyecto_beuty.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Error en el registro</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Error en el registro</h1>");
                        out.println("<p>El correo electrónico ya está registrado.</p>");
                        out.println("</body>");
                        out.println("</html>");
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
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Registro exitoso</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Registro exitoso</h1>");
                            out.println("<p>Usuario registrado correctamente.</p>");
                            out.println("</body>");
                            out.println("</html>");
                        } else {
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Error en el registro</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Error en el registro</h1>");
                            out.println("<p>No se pudo registrar el usuario.</p>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }
                } catch (SQLException ex) {
                    throw new ServletException("Error SQL al intentar registrar usuario", ex);
                }
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error en el registro</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error en el registro</h1>");
                out.println("<p>Por favor complete todos los campos del formulario.</p>");
                out.println("</body>");
                out.println("</html>");
            }
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
        return "Servlet para registrar usuarios en la base de datos";
    }
}
