package com.sistema.entregador.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Transformou em entidade
@NoArgsConstructor // Lombook aqui 
@AllArgsConstructor // Lombook aqui 
@Builder // Lombook aqui 
@Data 
@Table(name = "entregador") // ai essa aqui gera o nome da tabela no banco, ao invés do nome da classe.
public class EntregadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de valor que sua estratégia será do tipo identiti 
    private Long Id;
    
    private String nome;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "entregador_id") // ou o nome da coluna correta no banco
    private EntregadorEntity entregador;
    
}
