package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.Productos;
import com.mycompany.mi_proyecto_beuty.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    public Optional<Productos> findById(int id) {
        return productosRepository.findById(id);
    }

    public Productos save(Productos productos) {
        return productosRepository.save(productos);
    }

    public void deleteById(int id) {
        productosRepository.deleteById(id);
    }
}
