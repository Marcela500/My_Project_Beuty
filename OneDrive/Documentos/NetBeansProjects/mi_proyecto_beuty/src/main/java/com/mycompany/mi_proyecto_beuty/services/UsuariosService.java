package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.Usuarios;
import com.mycompany.mi_proyecto_beuty.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> findById(int id) {
        return usuariosRepository.findById(id);
    }

    public Usuarios save(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public void deleteById(int id) {
        usuariosRepository.deleteById(id);
    }
}
