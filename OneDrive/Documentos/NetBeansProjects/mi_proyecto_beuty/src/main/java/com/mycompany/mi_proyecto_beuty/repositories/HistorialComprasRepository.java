package com.mycompany.mi_proyecto_beuty.repositories;

import com.mycompany.mi_proyecto_beuty.models.HistorialCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialComprasRepository extends JpaRepository<HistorialCompras, Integer> {
}
