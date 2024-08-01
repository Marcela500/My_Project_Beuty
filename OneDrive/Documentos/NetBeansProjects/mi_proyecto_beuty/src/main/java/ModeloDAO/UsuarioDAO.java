package ModeloDAO;

import com.mycompany.mi_proyecto_beuty.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsuarioDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario obtenerUsuarioPorCorreo(String correo) {
        String sql = "SELECT * FROM usuarios WHERE correo_electronico = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{correo}, new UsuarioRowMapper());
        } catch (Exception e) {
            // Manejar el caso en que no se encuentra el usuario
            return null;
        }
    }

    public void registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo_electronico, telefono, direccion, contrasena, rol) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getTelefono(), usuario.getDireccion(), usuario.getContrasena(), usuario.getRol());
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            // Verifica el nombre de la columna
            usuario.setId(rs.getInt("id")); // Asegúrate de que 'id' es el nombre correcto
            usuario.setNombre(rs.getString("nombre"));
            usuario.setCorreoElectronico(rs.getString("correo_electronico"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setDireccion(rs.getString("direccion"));
            usuario.setContrasena(rs.getString("contrasena"));
            usuario.setRol(rs.getString("rol"));
            return usuario;
        }
    }
}
