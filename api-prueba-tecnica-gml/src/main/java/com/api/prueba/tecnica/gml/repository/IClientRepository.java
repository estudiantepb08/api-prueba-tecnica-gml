package com.api.prueba.tecnica.gml.repository;

import java.util.List;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository {
	
	String save(ClientEntity clientEntity);
	List<ClientEntity> allClient();
	List<ClientEntity> findByIdClient(String idClinet);

}
