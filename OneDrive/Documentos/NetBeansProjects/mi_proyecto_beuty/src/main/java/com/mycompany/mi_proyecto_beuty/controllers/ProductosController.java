package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.Productos;
import com.mycompany.mi_proyecto_beuty.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosRepository productosRepository;

    @GetMapping
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Integer id) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Productos createProducto(@RequestBody Productos producto) {
        return productosRepository.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable Integer id, @RequestBody Productos productoDetails) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()) {
            Productos updatedProducto = producto.get();
            updatedProducto.setNombre(productoDetails.getNombre());
            updatedProducto.setMarca(productoDetails.getMarca());
            updatedProducto.setPrecio(productoDetails.getPrecio());
            updatedProducto.setColor(productoDetails.getColor());
            updatedProducto.setTipo(productoDetails.getTipo());
            updatedProducto.setDescripcion(productoDetails.getDescripcion());
            productosRepository.save(updatedProducto);
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()) {
            productosRepository.delete(producto.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
