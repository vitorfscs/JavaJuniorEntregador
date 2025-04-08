package com.sistema.entregador.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class firebaseconf {

    @PostConstruct // Chamando a inicialização de been para injeção de dependencia 
    public void inicializar() throws IOException {
        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("firebase-config.json"); 

        FirebaseOptions options = FirebaseOptions.builder() // Configuração do spring boot com construtor 
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)) 
                .setDatabaseUrl("https://sistema-entregador-default-rtdb.firebaseio.com")
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}
