package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.Valoraciones;
import com.mycompany.mi_proyecto_beuty.repositories.ValoracionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValoracionesService {

    @Autowired
    private ValoracionesRepository valoracionesRepository;

    public List<Valoraciones> findAll() {
        return valoracionesRepository.findAll();
    }

    public Optional<Valoraciones> findById(int id) {
        return valoracionesRepository.findById(id);
    }

    public Valoraciones save(Valoraciones valoraciones) {
        return valoracionesRepository.save(valoraciones);
    }

    public void deleteById(int id) {
        valoracionesRepository.deleteById(id);
    }
}
