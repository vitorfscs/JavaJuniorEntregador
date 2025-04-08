package com.sistema.entregador.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.entregador.DTO.RotaCreateDTO;
import com.sistema.entregador.DTO.RotaDTO;
import com.sistema.entregador.Entity.RotasEntity;
import com.sistema.entregador.Service.RotasService;


import java.util.List;

@RestController
@RequestMapping("/api/rotas") // Aqui será baseado no Localhost:8080/api/rotas
public class RotaController {

    @Autowired // Injeção automatica de dependencias
    private RotasService rotaService;

    @GetMapping
    public List<RotaDTO> listar() {
        return rotaService.listarTodas();
    }

    @PostMapping // Endpoint de salvar 
    public RotaDTO salvar(@RequestBody RotaCreateDTO dto) { // Mandando um request body para chamar o DTO
        return rotaService.salvar(dto);  // Usando o save. 
    }

    @GetMapping("/{id}")  // Endpoint de gettong de rotas
    public RotaDTO buscarPorId(@PathVariable Long id) { // Chamando a pathvariable para a Id
        return rotaService.BuscarPorId(id); // Buscaar.
    }

    @DeleteMapping("/{id}") // Endpoint de deleção de rotas 
    public void deletar(@PathVariable Long id) { // Chamando a pathvariable para a Id
        rotaService.deletar(id); // Deletar id 
    }
}