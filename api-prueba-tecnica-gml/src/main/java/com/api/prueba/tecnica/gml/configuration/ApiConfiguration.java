package com.api.prueba.tecnica.gml.configuration;

import com.api.prueba.tecnica.gml.repository.ClientRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Bean
    public ClientRepositoryImpl clientRepository(){
        return new ClientRepositoryImpl();
    }
}
