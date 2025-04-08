package com.sistema.entregador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.entregador.Entity.EntregadorEntity;
@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorEntity, Long>{

}
