package com.sistema.entregador.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sistema.entregador.DTO.RotaDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseService {

    private final DatabaseReference databaseRef;

    public FirebaseService() {
        this.databaseRef = FirebaseDatabase.getInstance().getReference(); // Aplicação de instancia no firebase. 
    }

    public void salvarRota(RotaDTO rotaDTO) { 
        if (rotaDTO == null) {  // Se rotaDTO for igual a nada vai gerar um print
            System.out.println(" rotaDTO é null");
            return;
        }

        Map<String, Object> rotaMap = new HashMap<>(); // Tá mapeando os robjetos, e está guardando chaves. 
        rotaMap.put("id", rotaDTO.getId()); 
        rotaMap.put("entregadorId", rotaDTO.getEntregadorId());
        rotaMap.put("pontoInicio", rotaDTO.getPontoInicio());
        rotaMap.put("pontoFim", rotaDTO.getPontoFim());
        rotaMap.put("checkpoints", rotaDTO.getCheckpoints());

        System.out.println(" Enviando para Firebase: " + rotaMap);

        databaseRef.child("rotas") // Herdando as subclasse
                   .child(String.valueOf(rotaDTO.getId()))
                   .setValueAsync(rotaMap);
    }
}
