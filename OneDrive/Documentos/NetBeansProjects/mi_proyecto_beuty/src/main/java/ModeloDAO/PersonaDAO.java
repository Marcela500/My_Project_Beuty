package ModeloDAO;

import com.mycompany.mi_proyecto_beuty.models.Persona;
import com.mycompany.mi_proyecto_beuty.config.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO implements CRUD {
    private final Conexion cn;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public PersonaDAO() {
        cn = new Conexion();
    }

    @Override
    public List<Persona> listar() {
        List<Persona> list = new ArrayList<>();
        String sql = "SELECT * FROM persona";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setDni(rs.getString("DNI"));
                per.setNom(rs.getString("Nombres"));
                list.add(per);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        Persona per = new Persona();
        String sql = "SELECT * FROM persona WHERE id=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                per.setId(rs.getInt("id"));
                per.setDni(rs.getString("DNI"));
                per.setNom(rs.getString("Nombres"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return per;
    }

    @Override
    public boolean add(Persona per) {
        String sql = "INSERT INTO persona (DNI, Nombres) VALUES (?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getDni());
            ps.setString(2, per.getNom());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql = "UPDATE persona SET DNI=?, Nombres=? WHERE id=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getDni());
            ps.setString(2, per.getNom());
            ps.setInt(3, per.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM persona WHERE id=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    private void cerrarRecursos() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
