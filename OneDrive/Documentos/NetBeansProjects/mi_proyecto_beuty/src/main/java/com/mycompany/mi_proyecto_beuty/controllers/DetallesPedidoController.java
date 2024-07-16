package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.DetallesPedido;
import com.mycompany.mi_proyecto_beuty.repositories.DetallesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles_pedido")
public class DetallesPedidoController {

    @Autowired
    private DetallesPedidoRepository detallesPedidoRepository;

    @GetMapping
    public List<DetallesPedido> getAllDetallesPedido() {
        return detallesPedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesPedido> getDetallePedidoById(@PathVariable Integer id) {
        Optional<DetallesPedido> detallePedido = detallesPedidoRepository.findById(id);
        if (detallePedido.isPresent()) {
            return ResponseEntity.ok(detallePedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DetallesPedido createDetallePedido(@RequestBody DetallesPedido detallePedido) {
        return detallesPedidoRepository.save(detallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesPedido> updateDetallePedido(@PathVariable Integer id, @RequestBody DetallesPedido detallePedidoDetails) {
        Optional<DetallesPedido> detallePedido = detallesPedidoRepository.findById(id);
        if (detallePedido.isPresent()) {
            DetallesPedido updatedDetallePedido = detallePedido.get();
            updatedDetallePedido.setPedidoId(detallePedidoDetails.getPedidoId());
            updatedDetallePedido.setProductoId(detallePedidoDetails.getProductoId());
            updatedDetallePedido.setCantidad(detallePedidoDetails.getCantidad());
            updatedDetallePedido.setPrecio(detallePedidoDetails.getPrecio());
            detallesPedidoRepository.save(updatedDetallePedido);
            return ResponseEntity.ok(updatedDetallePedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Integer id) {
        Optional<DetallesPedido> detallePedido = detallesPedidoRepository.findById(id);
        if (detallePedido.isPresent()) {
            detallesPedidoRepository.delete(detallePedido.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
