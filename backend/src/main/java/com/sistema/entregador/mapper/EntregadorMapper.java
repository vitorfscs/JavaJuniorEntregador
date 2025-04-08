package com.sistema.entregador.mapper;

import com.sistema.entregador.DTO.EntregadorDto;
import com.sistema.entregador.Entity.EntregadorEntity;

public class EntregadorMapper {

    public static EntregadorDto toDTO(EntregadorEntity entregador) { // Mapear o DTO 
        EntregadorDto dto = new EntregadorDto();
        dto.setId(entregador.getId());
        dto.setNome(entregador.getNome());
        dto.setAtivo(entregador.isAtivo());
        return dto;
    }

    public static EntregadorEntity fromCreateDTO(EntregadorDto dto) {
        EntregadorEntity e = new EntregadorEntity();
        e.setNome(dto.getNome());
        e.setAtivo(dto.isAtivo());
        return e;
    }
}
