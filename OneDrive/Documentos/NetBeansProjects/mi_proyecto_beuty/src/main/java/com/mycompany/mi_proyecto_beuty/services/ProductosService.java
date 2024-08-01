package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<Producto> findAll();
    Optional<Producto> findById(int id);
    Producto save(Producto producto);
    void deleteById(int id);
}
