package com.sistema.entregador.DTO;

import lombok.Data;

@Data
public class RotaCreateDTO {
    private Long entregadorId;
    private String pontoInicio;
    private String pontoFim;
    private String checkpoints;
}