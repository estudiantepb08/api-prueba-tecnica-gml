package com.api.prueba.tecnica.gml.controllers;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;
import com.api.prueba.tecnica.gml.services.IClientService;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("api/")
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private IClientService iClientService;
	private String mesagess;

	@PostMapping("/clients")
	public ResponseEntity<?> saveClient(@RequestBody ClientEntity clientEntity) {
		ResponseEntity<String> responseClient = null;
		try {
			mesagess = iClientService.saveClient(clientEntity);
			if(mesagess.equals("Save sucess")){
				responseClient = ResponseEntity.status(HttpStatus.CREATED).body(mesagess);
			}else{
				responseClient = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesagess);
			}
		}catch (Exception ex){
			LOGGER.error("Error metodo guardar", ex.getCause().getMessage());
			responseClient = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mesagess);
			return responseClient;

		}
		return responseClient;
	}

	@GetMapping("/clients")
	public ResponseEntity<?> getClients(){
		ResponseEntity<String> responseClient = null;
		List<ClientEntity> clients = new ArrayList<>();
		try {
			clients = iClientService.allClient();
			if(clients.size() > 1){
				responseClient = ResponseEntity.status(HttpStatus.OK).body(clients.toString());
			}else{
				mesagess = "No se encontraron registros";
				responseClient = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesagess);
			}
		}catch (Exception ex){
			LOGGER.error("Error metodo guardar", ex.getCause().getMessage());
			mesagess = "Error con el servidor";
			responseClient = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mesagess);
			return responseClient;

		}
		return responseClient;
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<?> getClientById(@PathVariable String id){
		ResponseEntity<String> responseClient = null;
		List<ClientEntity> clients = new ArrayList<>();
		try {
			clients = iClientService.findById(id);
			if(clients.size() == 1){
				responseClient = ResponseEntity.status(HttpStatus.OK).body(clients.toString());
			}else{
				mesagess = "No se encontraron registros";
				responseClient = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesagess);
			}
		}catch (Exception ex){
			LOGGER.error("Error metodo guardar", ex.getCause().getMessage());
			mesagess = "Error con el servidor";
			responseClient = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mesagess);
			return responseClient;

		}
		return responseClient;
	}

}
