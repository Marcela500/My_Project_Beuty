package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.MetodosPagos;
import com.mycompany.mi_proyecto_beuty.repositories.MetodosPagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodosPagosService {

    @Autowired
    private MetodosPagosRepository metodosPagosRepository;

    public List<MetodosPagos> findAll() {
        return metodosPagosRepository.findAll();
    }

    public Optional<MetodosPagos> findById(int id) {
        return metodosPagosRepository.findById(id);
    }

    public MetodosPagos save(MetodosPagos metodosPagos) {
        return metodosPagosRepository.save(metodosPagos);
    }

    public void deleteById(int id) {
        metodosPagosRepository.deleteById(id);
    }
}
