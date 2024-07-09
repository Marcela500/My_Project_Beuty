package com.servlets;

import java.io.IOException;
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

import com.miempresa.Usuario;

@WebServlet("/editarUsuario")
public class EditarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, usuario y contraseña de MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mitienda?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "tu_usuario";
    private static final String JDBC_PASSWORD = "tu_contraseña";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetro ID del usuario a editar
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Consulta SQL para obtener datos del usuario por ID
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            // Ejecutar consulta
            rs = stmt.executeQuery();

            // Procesar resultados
            if (rs.next()) {
                // Crear objeto Usuario con datos obtenidos de la base de datos
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreoElectronico(rs.getString("correo_electronico"));

                // Setear atributo en request para pasar a la vista (editarUsuario.jsp)
                request.setAttribute("usuario", usuario);

                // Redireccionar a la vista para editar usuario
                request.getRequestDispatcher("/editarUsuario.jsp").forward(request, response);
            } else {
                response.getWriter().println("No se encontró usuario con ID: " + idUsuario);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros editados del usuario desde el formulario
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correoElectronico = request.getParameter("correoElectronico");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Consulta SQL para actualizar datos del usuario
            String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, telefono = ?, direccion = ?, correo_electronico = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, telefono);
            stmt.setString(4, direccion);
            stmt.setString(5, correoElectronico);
            stmt.setInt(6, idUsuario);

            // Ejecutar consulta
            int rowsAffected = stmt.executeUpdate();

            // Verificar si se actualizó correctamente
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
