// RotaMapper.java

package com.sistema.entregador.mapper;

import com.sistema.entregador.DTO.RotaCreateDTO;
import com.sistema.entregador.DTO.RotaDTO;
import com.sistema.entregador.Entity.RotasEntity;

public class RotaMapper {

    public static RotaDTO toDTO(RotasEntity entity) {
        RotaDTO dto = new RotaDTO();
        dto.setId(entity.getId());
        dto.setPontoInicio(entity.getPontoinicio());
        dto.setPontoFim(entity.getPontofim());
        dto.setCheckpoints(entity.getCheckpoints());
        return dto;
    }

    public static RotasEntity fromCreateDTO(RotaCreateDTO dto) {
        RotasEntity entity = new RotasEntity();
        entity.setPontoinicio(dto.getPontoInicio());
        entity.setPontofim(dto.getPontoFim());
        entity.setCheckpoints(dto.getCheckpoints());
        return entity;
    }
}