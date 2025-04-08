package com.sistema.entregador.Service;

import com.sistema.entregador.DTO.EntregadorDto;
import com.sistema.entregador.Entity.EntregadorEntity;
import com.sistema.entregador.Repository.EntregadorRepository;
import com.sistema.entregador.mapper.EntregadorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntregadorService {

    @Autowired // Injeção automatica de dependencias, métodos e atributos 
    private EntregadorRepository entregadorRepository; // Chamando o  repositório 

    public List<EntregadorDto> listarTodos() { 
        return entregadorRepository.findAll() // Retornar o Repositório e mandando ele listar todos os atributos dentro dela.
                .stream() // Mostrar 
                .map(EntregadorMapper::toDTO) // Mapeando
                .collect(Collectors.toList()); 
    }

    public EntregadorDto salvar(EntregadorDto dto) {  
        EntregadorEntity entregador = EntregadorMapper.fromCreateDTO(dto); // Chamando o Entity, chamando o mapper e chamando u
        entregador = entregadorRepository.save(entregador); // Falando para o EntregadorRepository salvar no banco
        return EntregadorMapper.toDTO(entregador); // Mapeando até o mapper fazer o filtro no DTO para o banco
    }

    public EntregadorDto buscarPorId(Long id) {
        return entregadorRepository.findById(id) // Pedindo para o entregador Buscar por ID no banco
                .map(EntregadorMapper::toDTO) 
                .orElse(null);
    }

    public void deletar(Long id) {
        entregadorRepository.deleteById(id); // Deletar o Entregador por ID.
    }
}