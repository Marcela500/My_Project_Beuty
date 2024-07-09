package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eliminarUsuario")
public class EliminarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, usuario y contraseña de MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mitienda?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "tu_usuario";
    private static final String JDBC_PASSWORD = "tu_contraseña";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetro ID del usuario a eliminar
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Preparar consulta SQL para eliminar usuario por ID
            String sql = "DELETE FROM usuarios WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            // Ejecutar consulta
            int rowsAffected = stmt.executeUpdate();

            // Verificar si se eliminó correctamente
            if (rowsAffected > 0) {
                // Redireccionar a lista de usuarios actualizada
                response.sendRedirect(request.getContextPath() + "/listaUsuarios");
            } else {
                response.getWriter().println("No se encontró usuario con ID: " + idUsuario);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Manejo básico de errores
        } finally {
            // Cerrar conexiones y liberar recursos
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
