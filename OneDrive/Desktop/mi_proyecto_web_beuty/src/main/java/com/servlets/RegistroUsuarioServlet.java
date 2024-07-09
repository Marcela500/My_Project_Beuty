package com.servlets;

import com.miempresa.Usuario;  // Asegúrate de importar la clase Usuario correctamente

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, usuario y contraseña de MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mitienda?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "tu_usuario";
    private static final String JDBC_PASSWORD = "tu_contraseña";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correoElectronico = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");

        // Validar si algún campo está vacío (aquí deberías hacer una validación más completa)
        if (nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || direccion.isEmpty()
                || correoElectronico.isEmpty() || contrasena.isEmpty()) {
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Todos los campos son obligatorios</h2></body></html>");
            return;
        }

        // Crear objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setDireccion(direccion);
        nuevoUsuario.setCorreoElectronico(correoElectronico);
        nuevoUsuario.setContrasena(contrasena);

        // Guardar usuario en la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Preparar consulta SQL
            String sql = "INSERT INTO usuarios (nombre, apellidos, telefono, direccion, correo_electronico, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nuevoUsuario.getNombre());
            stmt.setString(2, nuevoUsuario.getApellidos());
            stmt.setString(3, nuevoUsuario.getTelefono());
            stmt.setString(4, nuevoUsuario.getDireccion());
            stmt.setString(5, nuevoUsuario.getCorreoElectronico());
            stmt.setString(6, nuevoUsuario.getContrasena());

            // Ejecutar consulta
            int filasInsertadas = stmt.executeUpdate();

            // Verificar si se insertó correctamente
            if (filasInsertadas > 0) {
                PrintWriter out = response.getWriter();
                out.println("<html><body><h2>Registro exitoso</h2></body></html>");
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body><h2>Error en el registro</h2></body></html>");
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
