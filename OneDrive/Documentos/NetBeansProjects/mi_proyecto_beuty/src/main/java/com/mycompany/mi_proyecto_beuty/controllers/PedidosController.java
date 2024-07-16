package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.Pedidos;
import com.mycompany.mi_proyecto_beuty.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping
    public List<Pedidos> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> getPedidoById(@PathVariable Integer id) {
        Optional<Pedidos> pedido = pedidosRepository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Pedidos createPedido(@RequestBody Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> updatePedido(@PathVariable Integer id, @RequestBody Pedidos pedidoDetails) {
        Optional<Pedidos> pedido = pedidosRepository.findById(id);
        if (pedido.isPresent()) {
            Pedidos updatedPedido = pedido.get();
            updatedPedido.setUsuarioId(pedidoDetails.getUsuarioId());
            updatedPedido.setFecha(pedidoDetails.getFecha());
            updatedPedido.setTotal(pedidoDetails.getTotal());
            updatedPedido.setMetodoPagoId(pedidoDetails.getMetodoPagoId());
            pedidosRepository.save(updatedPedido);
            return ResponseEntity.ok(updatedPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        Optional<Pedidos> pedido = pedidosRepository.findById(id);
        if (pedido.isPresent()) {
            pedidosRepository.delete(pedido.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
