package com.sistema.entregador.Controller;

import com.sistema.entregador.DTO.EntregadorDto;
import com.sistema.entregador.Service.EntregadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/entregadores") 
@RequiredArgsConstructor // Lombok vai gerar automaticamente o construtor com a injeção de dependência
public class EntregadorController {

    private final EntregadorService entregadorService; // A dependência do service é injetada automaticamente

    // Endpoint para listar todos os entregadores
    @GetMapping("/listagem")
    public String listar(Model model) {
        // Obtendo a lista de entregadores do serviço
        List<EntregadorDto> entregadores = entregadorService.listarTodos();
        // Adicionando a lista ao modelo para ser acessada no Thymeleaf
        model.addAttribute("entregadores", entregadores);
        // Retorna o nome da página HTML (listagem.html) para ser renderizada
        return "listagem";
    }

    // Endpoint para exibir detalhes de um entregador específico
    @GetMapping("/{id}")
    public String exibirDetalhes(@PathVariable Long id, Model model) {
        // Buscando o entregador pelo ID
        EntregadorDto entregador = entregadorService.buscarPorId(id);
        // Adicionando o entregador ao modelo
        model.addAttribute("entregador", entregador);
        // Retorna o nome da página para exibir os detalhes (detalhes.html)
        return "detalhes";
    }

    // Endpoint para adicionar um novo entregador
    @GetMapping("/novo")
    public String novaPagina(Model model) {
        model.addAttribute("entregador", new EntregadorDto()); // Passando um objeto vazio para o formulário
        return "novo"; // A página HTML para o formulário
    }

    // Endpoint para salvar um entregador
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute EntregadorDto entregadorDto) {
        entregadorService.salvar(entregadorDto);
        return "redirect:/entregadores/listagem"; // Redireciona para a página de listagem
    }

    // Endpoint para deletar um entregador
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        entregadorService.deletar(id);
        return "redirect:/entregadores/listagem"; // Redireciona após deletar
    }
}
