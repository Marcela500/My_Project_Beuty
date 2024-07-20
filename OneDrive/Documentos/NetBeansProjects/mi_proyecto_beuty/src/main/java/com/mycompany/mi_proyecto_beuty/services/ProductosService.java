package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.Producto;
import com.mycompany.mi_proyecto_beuty.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Producto> findAll() {
        return productosRepository.findAll();
    }

    public Optional<Producto> findById(int id) {
        return productosRepository.findById(id);
    }

    public Producto save(Producto productos) {
        return productosRepository.save(productos);
    }

    public void deleteById(int id) {
        productosRepository.deleteById(id);
    }
}
