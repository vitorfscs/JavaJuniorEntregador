// RotasService.java

package com.sistema.entregador.Service;

import com.sistema.entregador.DTO.RotaDTO;
import com.sistema.entregador.DTO.RotaCreateDTO;
import com.sistema.entregador.Entity.RotasEntity;
import com.sistema.entregador.Repository.RotasRepository;
import com.sistema.entregador.mapper.RotaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


// Depois comentar  NAO ESQUECER !!!!!

@Service
public class RotasService {

    private static final Logger logger = LoggerFactory.getLogger(RotasService.class);

    private final RotasRepository rotaRepository;
    private final FirebaseService firebaseService;

    public RotasService(RotasRepository rotaRepository, FirebaseService firebaseService) {
        this.rotaRepository = rotaRepository;
        this.firebaseService = firebaseService;
    }

    public RotaDTO salvar(RotaCreateDTO dto) {
        RotasEntity rota = RotaMapper.fromCreateDTO(dto);
        rota = rotaRepository.save(rota);

        RotaDTO rotaDTO = RotaMapper.toDTO(rota);

        try {
            System.out.println("🚀 Salvando ROTA: " + rotaDTO);
            firebaseService.salvarRota(rotaDTO);
        } catch (Exception e) {
            logger.error("Erro ao salvar rota no Firebase: {}", e.getMessage());
        }

        return rotaDTO;
    }

    public RotaDTO buscarPorId(Long id) {
        return rotaRepository.findById(id)
                .map(RotaMapper::toDTO)
                .orElse(null);
    }

    public boolean deletar(Long id) {
        try {
            rotaRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            logger.warn("Tentativa de deletar rota com ID inexistente: {}", id);
            return false;
        }
    }

    public List<RotaDTO> listarTodas() {
        return rotaRepository.findAll()
                .stream()
                .map(RotaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RotaDTO BuscarPorId(Long id) {
        return rotaRepository.findById(id)
                .map(RotaMapper::toDTO)
                .orElse(null);
    }

    public RotaDTO adicionarCheckpoint(Long rotaId, String checkpoint) {
        RotasEntity rota = rotaRepository.findById(rotaId)
                .orElseThrow(() -> new RuntimeException("Rota não encontrada"));

        String checkpoints = rota.getCheckpoints();
        if (checkpoints == null || checkpoints.isEmpty()) {
            rota.setCheckpoints(checkpoint);
        } else {
            rota.setCheckpoints(checkpoints + ";" + checkpoint);
        }

        rotaRepository.save(rota);
        return RotaMapper.toDTO(rota);
    }
}