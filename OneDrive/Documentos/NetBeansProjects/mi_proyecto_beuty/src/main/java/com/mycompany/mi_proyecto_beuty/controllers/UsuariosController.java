package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.Usuarios;
import com.mycompany.mi_proyecto_beuty.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioDetails) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {
            Usuarios updatedUsuario = usuario.get();
            updatedUsuario.setNombre(usuarioDetails.getNombre());
            updatedUsuario.setApellidos(usuarioDetails.getApellidos());
            updatedUsuario.setTelefono(usuarioDetails.getTelefono());
            updatedUsuario.setDireccion(usuarioDetails.getDireccion());
            updatedUsuario.setCorreoElectronico(usuarioDetails.getCorreoElectronico());
            updatedUsuario.setContrasena(usuarioDetails.getContrasena());
            usuariosRepository.save(updatedUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {
            usuariosRepository.delete(usuario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
