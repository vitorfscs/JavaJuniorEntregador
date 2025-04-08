package com.sistema.entregador.Entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "rotas") // ai essa aqui gera o nome da tabela no banco, ao invés do nome da classe.

public class RotasEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de valor que sua estratégia será do tipo identiti 
    private Long id;

    private String pontoinicio;

    private String pontofim;

@OneToMany
@JoinColumn(name = "entregador_id") // vai criar uma FK na tabela de Rotas
private List<RotasEntity> rotas;

}
