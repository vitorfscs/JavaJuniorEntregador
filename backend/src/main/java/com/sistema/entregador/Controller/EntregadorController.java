package com.sistema.entregador.Controller;

import com.sistema.entregador.DTO.EntregadorDto;
import com.sistema.entregador.Service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregadores") // Baseadp em localhost:8080/api/entregadores
public class EntregadorController {

    @Autowired // injeção automatica de dependencias e atributos 
    private EntregadorService entregadorService; // Chamando o service 

    @GetMapping // Endpoint listagem
    public List<EntregadorDto> listar() { 
        return entregadorService.listarTodos(); // Mostrando todos os entregadores em listas
    }

    @PostMapping //Endpoint Salvar 
    public EntregadorDto salvar(@RequestBody EntregadorDto dto) { // Vai pegar a solicitação do form HTTP e enviar para o DTO tratar os dados 
        return entregadorService.salvar(dto); // salvar no banco
    }

    @GetMapping("/{id}") // endpoint id
    public EntregadorDto buscarPorId(@PathVariable Long id) {
        return entregadorService.buscarPorId(id); // Buscar por id
    }

    @DeleteMapping("/{id}") // Endpoint deletar 
    public void deletar(@PathVariable Long id) {
        entregadorService.deletar(id); // deletar
    }
}
