package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.MetodosPagos;
import com.mycompany.mi_proyecto_beuty.repositories.MetodosPagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodos_pagos")
public class MetodosPagosController {

    @Autowired
    private MetodosPagosRepository metodosPagosRepository;

    @GetMapping
    public List<MetodosPagos> getAllMetodosPagos() {
        return metodosPagosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodosPagos> getMetodoPagoById(@PathVariable Integer id) {
        Optional<MetodosPagos> metodoPago = metodosPagosRepository.findById(id);
        if (metodoPago.isPresent()) {
            return ResponseEntity.ok(metodoPago.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MetodosPagos createMetodoPago(@RequestBody MetodosPagos metodoPago) {
        return metodosPagosRepository.save(metodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodosPagos> updateMetodoPago(@PathVariable Integer id, @RequestBody MetodosPagos metodoPagoDetails) {
        Optional<MetodosPagos> metodoPago = metodosPagosRepository.findById(id);
        if (metodoPago.isPresent()) {
            MetodosPagos updatedMetodoPago = metodoPago.get();
            updatedMetodoPago.setMetodo(metodoPagoDetails.getMetodo());
            metodosPagosRepository.save(updatedMetodoPago);
            return ResponseEntity.ok(updatedMetodoPago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer id) {
        Optional<MetodosPagos> metodoPago = metodosPagosRepository.findById(id);
        if (metodoPago.isPresent()) {
            metodosPagosRepository.delete(metodoPago.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
