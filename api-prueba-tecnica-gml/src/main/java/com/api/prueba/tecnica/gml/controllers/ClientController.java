package com.api.prueba.tecnica.gml.controllers;

import com.api.prueba.tecnica.gml.entitys.ClientEntity;
import com.api.prueba.tecnica.gml.services.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	final Map<String,String> RESPONSE = new HashMap<>();

	@Autowired
	private IClientService iClientService;
	private String mesagess;

	@PostMapping("/clients")
	public ResponseEntity<?> saveClient(@RequestBody ClientEntity clientEntity) {
		ResponseEntity<Map<String,String>> responseClient = null;
		try {
			mesagess = iClientService.saveClient(clientEntity);
			RESPONSE.put("msj",mesagess);
			if(mesagess.equals("Save sucess")){
				//new ResponseEntity<Map<String,String>>(RESPONSE, HttpStatus.CREATED);
				responseClient = ResponseEntity.status(HttpStatus.CREATED).body(RESPONSE);
			}else{
				responseClient = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPONSE);
			}
		}catch (Exception ex){
			LOGGER.error("Error metodo guardar", ex.getCause().getMessage());
			responseClient = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RESPONSE);
			return responseClient;

		}
		return responseClient;
	}

	@GetMapping("/clients")
	public ResponseEntity<?> getClients(){
		ResponseEntity<List<ClientEntity>> responseClients = null;
		ResponseEntity<String> responseClient = null;
		List<ClientEntity> clients = new ArrayList<>();
		try {
			clients = iClientService.allClient();
			if(clients.size() >= 1){
				responseClients = ResponseEntity.status(HttpStatus.OK).body(clients);
			}else{
				mesagess = "No se encontraron registros";
				responseClient = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesagess);
				return responseClient;
			}
		}catch (Exception ex){
			LOGGER.error("Error metodo guardar", ex.getCause().getMessage());
			mesagess = "Error con el servidor";
			responseClient = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mesagess);
			return responseClient;

		}
		return responseClients;
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<?> getClientById(@PathVariable String id){
		ResponseEntity<List<ClientEntity>> responseClients = null;
		ResponseEntity<String> responseClient = null;
		List<ClientEntity> clients = new ArrayList<>();
		try {
			clients = iClientService.findById(id);
			if(clients.size() >= 1){
				responseClients = ResponseEntity.status(HttpStatus.OK).body(clients);
			}else{
				mesagess = "No se encontraron registros";
				responseClient = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mesagess);
				return responseClient;
			}
		}catch (Exception ex){
			LOGGER.error("Error metodo guardar", ex.getCause().getMessage());
			mesagess = "Error con el servidor";
			responseClient = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mesagess);
			return responseClient;

		}
		return responseClients;
	}

}
