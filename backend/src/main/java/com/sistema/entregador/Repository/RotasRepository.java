package com.sistema.entregador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.entregador.Entity.RotasEntity;
@Repository
public interface RotasRepository extends JpaRepository<RotasEntity, Long> {
}
