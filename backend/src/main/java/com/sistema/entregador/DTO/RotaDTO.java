// RotaDTO.java

package com.sistema.entregador.DTO;

import lombok.Data;

@Data
public class RotaDTO {
    private Long id;
    private Long entregadorId;
    private String pontoInicio;
    private String pontoFim;
    private String checkpoints;
}