package com.api.prueba.tecnica.gml.services;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IClientService {

    String saveClient(ClientEntity clientEntity);
    List<ClientEntity> allClient();
    List<ClientEntity> findById(String idClient);
}
