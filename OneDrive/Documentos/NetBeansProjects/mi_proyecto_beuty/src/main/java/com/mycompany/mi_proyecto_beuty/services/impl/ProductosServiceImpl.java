package com.mycompany.mi_proyecto_beuty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.mi_proyecto_beuty.services.ProductosService;
import com.mycompany.mi_proyecto_beuty.repositories.ProductosRepository;
import com.mycompany.mi_proyecto_beuty.models.Producto; 
import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Producto> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(int id) {
        return productosRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productosRepository.save(producto);
    }

    @Override
    public void deleteById(int id) {
        productosRepository.deleteById(id);
    }
}
