package com.api.prueba.tecnica.gml.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientRepositoryImpl implements IClientRepository{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientRepositoryImpl.class);
	
	private List<ClientEntity> listClientEntities = new ArrayList<>();

	@Override
	public String save(ClientEntity clientEntity) {

		//listClientEntities.forEach();
		boolean saveList = listClientEntities.add(clientEntity);
		String msg;

		if (saveList) {
			msg = "Save sucess";
			LOGGER.info(msg);
			return msg;
		}
		msg = "Save error";
		LOGGER.error(msg);
		return msg;
	}

	@Override
	public List<ClientEntity> allClient() {

		LOGGER.info("Imprimiendo todos los registros");
		return listClientEntities;
	}

	@Override
	public List<ClientEntity> findByIdClient(String idClinet) {

		LOGGER.info("Imprimiendo cliente por id" + idClinet);
		return listClientEntities.stream().filter(client -> client.getSharedKey().toLowerCase()
				.equals(idClinet.toLowerCase())).collect(Collectors.toList());
	}

}
