package com.api.prueba.tecnica.gml.services;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;
import com.api.prueba.tecnica.gml.repository.IClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientServiceImpl implements IClientService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private IClientRepository iClientRepository;
    private String mesagess;
    @Override
    public String saveClient(ClientEntity clientEntity) {

        try{
            mesagess = "Los campos deben ser diligenciados";
            if(clientEntity.getSharedKey().isBlank() &&
            clientEntity.getBusinessId().isBlank() &&
            clientEntity.getEmail().isBlank() &&
            clientEntity.getPhone() == null &&
            clientEntity.getDataAdded() == null){
                return mesagess;
            }

            mesagess = iClientRepository.save(clientEntity);

        }catch (Exception ex){
            LOGGER.error("Error al guardar el cliente", ex.getCause().getMessage());
        }
        return mesagess;
    }

    @Override
    public List<ClientEntity> allClient() {
        List<ClientEntity> clients = new ArrayList<>();
        try{
            clients = iClientRepository.allClient();
        }catch (Exception ex){
            LOGGER.error("Error al mostrar los clientes", ex.getCause().getMessage());
        }
        return clients;
    }

    @Override
    public List<ClientEntity> findById(String idClient) {

        List<ClientEntity> clientById = new ArrayList<>();

        try{
            clientById = iClientRepository.findByIdClient(idClient);

        }catch (Exception ex){
            LOGGER.error("Error no se encontraron registros", ex.getCause().getMessage());
        }
        return clientById;
    }
}
