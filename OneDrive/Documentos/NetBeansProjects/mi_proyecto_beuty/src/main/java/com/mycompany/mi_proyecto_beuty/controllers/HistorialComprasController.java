package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.HistorialCompras;
import com.mycompany.mi_proyecto_beuty.repositories.HistorialComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historial_compras")
public class HistorialComprasController {

    @Autowired
    private HistorialComprasRepository historialComprasRepository;

    @GetMapping
    public List<HistorialCompras> getAllHistorialCompras() {
        return historialComprasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialCompras> getHistorialCompraById(@PathVariable Integer id) {
        Optional<HistorialCompras> historialCompra = historialComprasRepository.findById(id);
        if (historialCompra.isPresent()) {
            return ResponseEntity.ok(historialCompra.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public HistorialCompras createHistorialCompra(@RequestBody HistorialCompras historialCompra) {
        return historialComprasRepository.save(historialCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialCompras> updateHistorialCompra(@PathVariable Integer id, @RequestBody HistorialCompras historialCompraDetails) {
        Optional<HistorialCompras> historialCompra = historialComprasRepository.findById(id);
        if (historialCompra.isPresent()) {
            HistorialCompras updatedHistorialCompra = historialCompra.get();
            updatedHistorialCompra.setUsuarioId(historialCompraDetails.getUsuarioId());
            updatedHistorialCompra.setProductoId(historialCompraDetails.getProductoId());
            updatedHistorialCompra.setFecha(historialCompraDetails.getFecha());
            updatedHistorialCompra.setCantidad(historialCompraDetails.getCantidad());
            updatedHistorialCompra.setPrecio(historialCompraDetails.getPrecio());
            historialComprasRepository.save(updatedHistorialCompra);
            return ResponseEntity.ok(updatedHistorialCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorialCompra(@PathVariable Integer id) {
        Optional<HistorialCompras> historialCompra = historialComprasRepository.findById(id);
        if (historialCompra.isPresent()) {
            historialComprasRepository.delete(historialCompra.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
