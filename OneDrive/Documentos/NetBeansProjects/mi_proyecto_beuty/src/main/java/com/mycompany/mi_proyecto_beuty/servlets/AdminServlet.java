package com.mycompany.mi_proyecto_beuty.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.mycompany.mi_proyecto_beuty.models.Producto;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && "admin".equals(session.getAttribute("role"))) {
            List<Producto> productos = new ArrayList<>();
            try (Connection conn = dataSource.getConnection()) {
                String sql = "SELECT * FROM productos";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setMarca(rs.getString("marca"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setColor(rs.getString("color"));
                    producto.setTipo(rs.getString("tipo"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    productos.add(producto);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            response.sendRedirect("accessDenied.jsp"); // Redirigir a una página de acceso denegado si no tiene permisos
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Manejar POST igual que GET para simplificar
    }
}
