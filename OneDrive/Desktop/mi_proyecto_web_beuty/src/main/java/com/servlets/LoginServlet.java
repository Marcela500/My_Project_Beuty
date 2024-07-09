package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, usuario y contraseña de MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mitienda?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "tu_usuario";
    private static final String JDBC_PASSWORD = "tu_contraseña";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String correoElectronico = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");

        // Validar si algún campo está vacío (aquí deberías hacer una validación más completa)
        if (correoElectronico.isEmpty() || contrasena.isEmpty()) {
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Correo electrónico y contraseña son obligatorios</h2></body></html>");
            return;
        }

        // Verificar credenciales en la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Preparar consulta SQL
            String sql = "SELECT * FROM usuarios WHERE correo_electronico = ? AND contrasena = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, correoElectronico);
            stmt.setString(2, contrasena);

            // Ejecutar consulta
            rs = stmt.executeQuery();

            // Verificar si se encontró un usuario válido
            if (rs.next()) {
                // Iniciar sesión (usando HttpSession)
                HttpSession session = request.getSession();
                session.setAttribute("correoElectronico", correoElectronico);

                // Redireccionar a página de inicio después del inicio de sesión exitoso
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body><h2>Correo electrónico o contraseña incorrectos</h2></body></html>");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Manejo básico de errores
        } finally {
            // Cerrar conexiones y liberar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
