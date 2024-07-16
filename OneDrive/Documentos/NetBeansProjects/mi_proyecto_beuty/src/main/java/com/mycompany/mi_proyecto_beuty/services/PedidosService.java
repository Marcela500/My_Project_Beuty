package com.mycompany.mi_proyecto_beuty.services;

import com.mycompany.mi_proyecto_beuty.models.Pedidos;
import com.mycompany.mi_proyecto_beuty.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedidos> findAll() {
        return pedidosRepository.findAll();
    }

    public Optional<Pedidos> findById(int id) {
        return pedidosRepository.findById(id);
    }

    public Pedidos save(Pedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    public void deleteById(int id) {
        pedidosRepository.deleteById(id);
    }
}
