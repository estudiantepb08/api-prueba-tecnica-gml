package com.api.prueba.tecnica.gml.services;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {

    private ClientEntity clientEntity;
    @Autowired
    private IClientService iClientService;
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @BeforeEach
    void setUp() {
        clientEntity = new ClientEntity();
        clientEntity.setSharedKey("tprueba");
        clientEntity.setBusinessId("test prueba");
        clientEntity.setEmail("testprueba@gmail.com");
        clientEntity.setPhone("3156231042");
        clientEntity.setDataAdded(new Date());
        clientServiceImpl = new ClientServiceImpl();
    }

    @DisplayName("Dada la necesidad de crear un nuevo cliente")
    @Test
    void saveClient() {
        String esperado = "Save sucess";
        String resultado = clientServiceImpl.saveClient(clientEntity );
        Assertions.assertEquals(esperado, resultado);
    }

    @DisplayName("Dada la necesidad de ver los clientes")
    @Test
    void allClient() {
        iClientService.allClient();
    }

    @DisplayName("Dada la necesidad de buscar un cliente")
    @Test
    void findById() {
        iClientService.findById("tprueba");
    }
}