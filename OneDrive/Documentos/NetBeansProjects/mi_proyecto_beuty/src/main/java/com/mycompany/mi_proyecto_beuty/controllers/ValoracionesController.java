package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.Valoraciones;
import com.mycompany.mi_proyecto_beuty.repositories.ValoracionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionesController {

    @Autowired
    private ValoracionesRepository valoracionesRepository;

    @GetMapping
    public List<Valoraciones> getAllValoraciones() {
        return valoracionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Valoraciones> getValoracionById(@PathVariable Integer id) {
        Optional<Valoraciones> valoracion = valoracionesRepository.findById(id);
        if (valoracion.isPresent()) {
            return ResponseEntity.ok(valoracion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Valoraciones createValoracion(@RequestBody Valoraciones valoracion) {
        return valoracionesRepository.save(valoracion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Valoraciones> updateValoracion(@PathVariable Integer id, @RequestBody Valoraciones valoracionDetails) {
        Optional<Valoraciones> valoracion = valoracionesRepository.findById(id);
        if (valoracion.isPresent()) {
            Valoraciones updatedValoracion = valoracion.get();
            updatedValoracion.setUsuarioId(valoracionDetails.getUsuarioId());
            updatedValoracion.setProductoId(valoracionDetails.getProductoId());
            updatedValoracion.setValoracion(valoracionDetails.getValoracion());
            updatedValoracion.setComentario(valoracionDetails.getComentario());
            updatedValoracion.setFecha(valoracionDetails.getFecha());
            valoracionesRepository.save(updatedValoracion);
            return ResponseEntity.ok(updatedValoracion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValoracion(@PathVariable Integer id) {
        Optional<Valoraciones> valoracion = valoracionesRepository.findById(id);
        if (valoracion.isPresent()) {
            valoracionesRepository.delete(valoracion.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
