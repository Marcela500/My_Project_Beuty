package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.DetallesPedido;
import com.mycompany.mi_proyecto_beuty.repositories.DetallesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesPedidoService {

    @Autowired
    private DetallesPedidoRepository detallesPedidoRepository;

    public List<DetallesPedido> findAll() {
        return detallesPedidoRepository.findAll();
    }

    public Optional<DetallesPedido> findById(int id) {
        return detallesPedidoRepository.findById(id);
    }

    public DetallesPedido save(DetallesPedido detallesPedido) {
        return detallesPedidoRepository.save(detallesPedido);
    }

    public void deleteById(int id) {
        detallesPedidoRepository.deleteById(id);
    }
}
