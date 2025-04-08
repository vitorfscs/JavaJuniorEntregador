package com.sistema.entregador.mapper;

import com.sistema.entregador.DTO.RotaCreateDTO;
import com.sistema.entregador.DTO.RotaDTO;
import com.sistema.entregador.Entity.RotasEntity;

public class RotaMapper {

    public static RotaDTO toDTO(RotasEntity entity) { // Mapear o DTO 
        RotaDTO dto = new RotaDTO();
        dto.setId(entity.getId());
        return dto;
    }

    public static RotasEntity fromCreateDTO(RotaCreateDTO dto) {
        RotasEntity entity = new RotasEntity();
        return entity;
    }
}
