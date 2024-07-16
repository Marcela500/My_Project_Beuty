package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.HistorialCompras;
import com.mycompany.mi_proyecto_beuty.repositories.HistorialComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialComprasService {

    @Autowired
    private HistorialComprasRepository historialComprasRepository;

    public List<HistorialCompras> findAll() {
        return historialComprasRepository.findAll();
    }

    public Optional<HistorialCompras> findById(int id) {
        return historialComprasRepository.findById(id);
    }

    public HistorialCompras save(HistorialCompras historialCompras) {
        return historialComprasRepository.save(historialCompras);
    }

    public void deleteById(int id) {
        historialComprasRepository.deleteById(id);
    }
}
