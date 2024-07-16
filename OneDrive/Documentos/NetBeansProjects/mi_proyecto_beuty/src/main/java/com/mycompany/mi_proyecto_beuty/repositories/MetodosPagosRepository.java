package com.mycompany.mi_proyecto_beuty.repositories;

import com.mycompany.mi_proyecto_beuty.models.MetodosPagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodosPagosRepository extends JpaRepository<MetodosPagos, Integer> {
}
