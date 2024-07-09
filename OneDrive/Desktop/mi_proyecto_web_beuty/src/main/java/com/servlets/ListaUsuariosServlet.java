package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miempresa.Usuario;

@WebServlet("/listaUsuarios")
public class ListaUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, usuario y contraseña de MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mitienda?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "tu_usuario";
    private static final String JDBC_PASSWORD = "tu_contraseña";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaUsuarios = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Consulta SQL
            String sql = "SELECT * FROM usuarios";
            stmt = conn.prepareStatement(sql);

            // Ejecutar consulta
            rs = stmt.executeQuery();

            // Procesar resultados
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreoElectronico(rs.getString("correo_electronico"));

                listaUsuarios.add(usuario);
            }

            // Setear atributo en request para pasar a la vista (listaUsuarios.jsp)
            request.setAttribute("listaUsuarios", listaUsuarios);

            // Redireccionar a la vista (listaUsuarios.jsp)
            request.getRequestDispatcher("/listaUsuarios.jsp").forward(request, response);

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
