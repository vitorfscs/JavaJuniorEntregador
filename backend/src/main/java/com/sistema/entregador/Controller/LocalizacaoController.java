package com.sistema.entregador.Controller;

import com.sistema.entregador.Service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/localizacao") // Localhost:8080/api/localizacao
public class LocalizacaoController {

    @Autowired // Injeção automaticas de atributos 
    private FirebaseService firebaseService; // Chamando o firebaseService

    @PostMapping("/{id}")
    public ResponseEntity<String> enviarLocalizacao(@PathVariable String id, // Vai extrair o valor do Id dessa localização
                                                    @RequestParam double lat, // Vai chamar e gravar os parametros da latitude
                                                    @RequestParam double lng) { // Vai chamar e gravar os parametros da longitude
        firebaseService.enviarLocalizacao(id, lat, lng); // Enviar a localização
        return ResponseEntity.ok("Localização enviada com sucesso!");
    }
}
