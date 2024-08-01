package interfaces;

import java.util.List;
import com.mycompany.mi_proyecto_beuty.models.Persona;

public interface CRUD {
    List<Persona> listar();
    Persona list(int id);
    boolean add(Persona per);
    boolean edit(Persona per);
    boolean eliminar(int id);
}
