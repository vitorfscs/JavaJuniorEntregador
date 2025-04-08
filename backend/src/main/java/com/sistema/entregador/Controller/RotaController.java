// RotaController.java

package com.sistema.entregador.Controller;

import com.sistema.entregador.DTO.RotaCreateDTO;
import com.sistema.entregador.DTO.RotaDTO;
import com.sistema.entregador.Service.RotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller 
@RequestMapping("/api/rotas") // Vai ficar baseada no localhost:8080/api/rotas 
public class RotaController {

    @Autowired // Injeção automatica de dependencias 
    private RotasService rotaService; // chamando o service. 

    @GetMapping // endpoint listagem
    public List<RotaDTO> listar() {
        return rotaService.listarTodas();
    }

    @PostMapping // Endpoint salvar
    public RotaDTO salvar(@RequestBody RotaCreateDTO dto) {
        return rotaService.salvar(dto);
    }

    @GetMapping("/{id}") //endpoint buscar por id
    public RotaDTO buscarPorId(@PathVariable Long id) {
        return rotaService.BuscarPorId(id);
    }

    @DeleteMapping("/{id}")  // endpoint deletar por id
    public void deletar(@PathVariable Long id) {
        rotaService.deletar(id);
    }

    @PostMapping("/{id}/checkpoint")
    public RotaDTO adicionarCheckpoint(@PathVariable Long id, @RequestBody String checkpoint) {
        return rotaService.adicionarCheckpoint(id, checkpoint);
    }
}