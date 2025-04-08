package com.sistema.entregador.Service;

import com.sistema.entregador.DTO.RotaDTO;
import com.sistema.entregador.DTO.RotaCreateDTO;
import com.sistema.entregador.Entity.RotasEntity;
import com.sistema.entregador.Repository.RotasRepository;
import com.sistema.entregador.mapper.RotaMapper;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotasService {

    private static final Logger logger = LoggerFactory.getLogger(RotasService.class); // Chamando um Logger 

    private final RotasRepository rotaRepository;
    private final FirebaseService firebaseService;

    public RotasService(RotasRepository rotaRepository, FirebaseService firebaseService) { 
        this.rotaRepository = rotaRepository;
        this.firebaseService = firebaseService;
    }

    public RotaDTO salvar(RotaCreateDTO dto) {
        RotasEntity rota = RotaMapper.fromCreateDTO(dto); //Chamando o banco de dados para criar conexão segura passando pelos DTO
        rota = rotaRepository.save(rota); // aqui o ID vai ser gerado
    
        RotaDTO rotaDTO = RotaMapper.toDTO(rota); // Mapeando o caminho até o banco de dados via o mapper
     
        try { // Chamando exceção  
            System.out.println("🚀 Salvando ROTA: " + rotaDTO); 
            firebaseService.salvarRota(rotaDTO);  // Chamando o firebaseService para salvar 
        } catch (Exception e) { // exceção ERROR
            logger.error("Erro ao salvar rota no Firebase: {}", e.getMessage());
        }
    
        return rotaDTO;
    }

    public Optional<RotaDTO> buscarPorId(Long id) { // Vai buscar os ID no dto e não deixar retornar erro
        return rotaRepository.findById(id) // Retornando o repositório
                .map(RotaMapper::toDTO); // Mapeando
    }

    public boolean deletar(Long id) { 
        try {
            rotaRepository.deleteById(id);  // Falando que pra ir no repositorio, listar o id, e nesse ID ele pode deletar
            return true;  
        } catch (EmptyResultDataAccessException e) { 
            logger.warn("Tentativa de deletar rota com ID inexistente: {}", id);
            return false; 
        }
    }

        public List<RotaDTO> listarTodas() { // Listar todas as rotas.
        return rotaRepository.findAll() // Pesquisar todas as rotas
                             .stream() //Mostrar todas as rotas
                             .map(RotaMapper::toDTO) // Mapear elas 
                             .collect(Collectors.toList());
    }

    public RotaDTO BuscarPorId(Long id) {
        return rotaRepository.findById(id)
                             .map(RotaMapper::toDTO)
                             .orElse(null);
    }
}
