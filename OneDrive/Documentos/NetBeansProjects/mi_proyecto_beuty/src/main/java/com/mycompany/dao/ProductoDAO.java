package com.mycompany.dao;

import com.mycompany.mi_proyecto_beuty.models.Producto;
import com.mycompany.mi_proyecto_beuty.Util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean agregarProducto(Producto producto) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO productos (nombre, marca, precio, color, tipo, descripcion) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getColor());
            ps.setString(5, producto.getTipo());
            ps.setString(6, producto.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
            // e.printStackTrace();
            return false; // O manejar de otra manera, como lanzar una excepción personalizada
        } finally {
            closeResources(ps, con);
        }
    }

    public Producto obtenerProductoPorId(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setColor(rs.getString("color"));
                producto.setTipo(rs.getString("tipo"));
                producto.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
            // e.printStackTrace();
        }

        return producto;
    }

    public boolean actualizarProducto(Producto producto) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE productos SET nombre=?, marca=?, precio=?, color=?, tipo=?, descripcion=? WHERE id=?";

        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getColor());
            ps.setString(5, producto.getTipo());
            ps.setString(6, producto.getDescripcion());
            ps.setInt(7, producto.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
            // e.printStackTrace();
            return false; // O manejar de otra manera, como lanzar una excepción personalizada
        } finally {
            closeResources(ps, con);
        }
    }

    public boolean eliminarProducto(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM productos WHERE id=?";

        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
            // e.printStackTrace();
            return false; // O manejar de otra manera, como lanzar una excepción personalizada
        } finally {
            closeResources(ps, con);
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM productos";

        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

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
        } catch (SQLException e) {
            // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
            // e.printStackTrace();
        } finally {
            closeResources(rs, ps, con);
        }
        return productos;
    }

    // Método para cerrar recursos
    private void closeResources(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
                // e.printStackTrace();
            }
        }
        closeResources(ps, con);
    }

    // Método para cerrar recursos
    private void closeResources(PreparedStatement ps, Connection con) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
                // e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // Puedes manejar el error de otra manera o simplemente no imprimir las trazas de error
                // e.printStackTrace();
            }
        }
    }
}
